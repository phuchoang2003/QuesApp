package com.example.middleware;

import com.example.utility.ResponseUtility;
import com.example.utility.TokenBucketAlgorithm;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


@WebFilter("/*")
public class RateLimiter implements Filter {
    private TokenBucketAlgorithm tokenBucketAlgorithm;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Gia su he thong phuc vu 100_000 users va trong luc cao diem la 5000 users truy cap cung luc
        // So luon request moi user thuc hien cao nhat khoang 5 request/s
        // Do do vao gio cao diem bucketSize toi da la 5000 * 5 = 25_000 RPS
        // RefillRate se duoc dat gia tri sao cho moi nguoi dung co the co the thuc hien 5 request tren s
        int bucketSize = 30_000;
        int refillRate = 25_000;
        tokenBucketAlgorithm = new TokenBucketAlgorithm(bucketSize, refillRate);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (tokenBucketAlgorithm.tryConsumeToken()) {
            chain.doFilter(request, response);
        } else {
            // khi bucket khong con token thi lam cham request cua nguoi dung lai chu khong reject
            try {
                // lam cham di 1 giay
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            chain.doFilter(request, response);


//            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//
//            ((HttpServletResponse) response).setStatus(429);
//            ResponseUtility.sendJsonResponse(httpServletResponse, "Request rate exceeded. Please try again later.",429);
        }
    }

    @Override
    public void destroy() {
//        scheduledExecutorService.shutdown();

    }
}
