package com.example.middleware;

import com.example.utility.ResponseUtility;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;


@WebFilter("/*")
public class HandleNotFound404 implements Filter {
    private Pattern validURLPattern;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String regexPattern = "^/QuesApp(/auth/do/exams\\?id_subject=\\d+&id_exam=\\d+|/auth/do/exams|/auth/exams|/exams|/auth/exams\\?id_subject=\\d+|/auth/history|/auth/questions|/auth/questions\\?id=\\d+|/auth/questions\\?subject=\\d+|/auth/questions\\?ids=\\d+(,\\d+)*|/auth/subjects|/auth/subjects(\\?id=\\d+|=\\d+)?|/login|/register" +
                "|/|/signIn|/signUp|/home|/history|/subjects|/listQuestions|/formUpdateSubject|/exams|/addQuestionToExam|/createQuestionForm|/updateQuestionForm|/createExamForm|/doExam|/updateExamForm)$";


        validURLPattern = Pattern.compile(regexPattern);

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;


        String requestedURI = httpServletRequest.getServletContext().getContextPath() + httpServletRequest.getServletPath();
        boolean isValidURL = validURLPattern.matcher(requestedURI).matches();

        if (isValidURL) {
            chain.doFilter(request, response);
        } else {
            httpServletResponse.setContentType("application/json");
            httpServletResponse.setCharacterEncoding("UTF-8");
            ResponseUtility.sendJsonResponse(httpServletResponse,"URL not found: " + requestedURI , null,HttpServletResponse.SC_NOT_FOUND,false);
        }
    }

    @Override
    public void destroy() {
    }
}

