package com.example.middleware;

import com.example.utility.ResponseUtility;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/auth/*")
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setContentType("application/json");
        httpResponse.setCharacterEncoding("UTF-8");


        HttpSession session = httpRequest.getSession(false);

        if (session != null && session.getAttribute("id_user") != null) {
            chain.doFilter(request, response);
        } else {
            ResponseUtility.sendJsonResponse(httpResponse, "Unauthorized. Please login.", null,HttpServletResponse.SC_UNAUTHORIZED,false);
        }
    }

    @Override
    public void destroy() {
    }
}
