package com.example.utility;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseUtility {
    private final String message;
    private final int statusCode;
    private static final ObjectMapper mapper = new ObjectMapper();


    public ResponseUtility(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }


    public static void sendJsonResponse(HttpServletResponse response,String message, Object data, int statusCode,Boolean isSuccess) throws IOException {
        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();

        RestAPIResponse apiResponse = new RestAPIResponse();
        apiResponse.setData(data);
        apiResponse.setIsSuccess(isSuccess);
        apiResponse.setStatus(statusCode);
        apiResponse.setMessage(message);

        String jsonResponse = mapper.writeValueAsString(apiResponse);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(statusCode);

        out.print(jsonResponse);
        out.flush();
    }



}
