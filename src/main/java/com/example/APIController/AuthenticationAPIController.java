package com.example.APIController;

import com.example.CustomExceptionHandling.DuplicateUserException;
import com.example.utility.ResponseUtility;
import com.example.utility.Validate;
import com.example.entity.User;
import com.example.mySQLImplDao.UserImplDao;
import com.example.service.AuthService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login","/register"})
public class AuthenticationAPIController extends HttpServlet {
    private final AuthService authService = new AuthService(new UserImplDao());
    private final ObjectMapper mapper = new ObjectMapper();


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String servletPath = request.getServletPath();

        if ("/login".equals(servletPath)) handleLogin(request, response);
         else if ("/register".equals(servletPath)) handleRegister(request, response);
         else ResponseUtility.sendJsonResponse(response, "Invalid endpoint",null,HttpServletResponse.SC_BAD_REQUEST,false);
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = mapper.readValue(request.getReader(), User.class);

        if (Validate.isInvalidLoginUserData(user)) {
            ResponseUtility.sendJsonResponse(response, "Invalid Input User!", null,HttpServletResponse.SC_BAD_REQUEST,false);
            return;
        }

        try {
            int idUser = authService.loginAndGetIdUser(user.getEmail(), user.getPassword());
            if (idUser != -1) {
                HttpSession session = request.getSession();
                session.setAttribute("id_user", idUser);
                ResponseUtility.sendJsonResponse(response, "Login successful", null, HttpServletResponse.SC_OK,true);



            } else {
                ResponseUtility.sendJsonResponse(response, "Login failed. Invalid email or password.",null, HttpServletResponse.SC_UNAUTHORIZED,false);
            }
        } catch (Exception e) {
            ResponseUtility.sendJsonResponse(response, "Login failed",null, HttpServletResponse.SC_INTERNAL_SERVER_ERROR,false);
        }
    }


    private void handleRegister(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // test
        User user = mapper.readValue(request.getReader(), User.class);
        if (Validate.isInvalidRegisterUserData(user)) {
            ResponseUtility.sendJsonResponse(response, "Invalid Input User!", null, HttpServletResponse.SC_BAD_REQUEST,false);
            return;
        }

        try {
            authService.register(user);
            ResponseUtility.sendJsonResponse(response, "Registration successful", null,HttpServletResponse.SC_CREATED,true);
        } catch (DuplicateUserException e) {
            ResponseUtility.sendJsonResponse(response, "Duplicate key error. This user already exists.", null,HttpServletResponse.SC_CONFLICT,false);
        } catch (Exception e) {
            ResponseUtility.sendJsonResponse(response, "Registration failed", null,HttpServletResponse.SC_INTERNAL_SERVER_ERROR,false);
        }
    }
}
