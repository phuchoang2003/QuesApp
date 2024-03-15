package com.example.APIController;


import com.example.CustomExceptionHandling.DuplicateSubjectException;
import com.example.mySQLImplDao.ExamImplDao;
import com.example.utility.Helper;
import com.example.utility.ResponseUtility;
import com.example.utility.Validate;
import com.example.entity.Subject;
import com.example.mySQLImplDao.SubjectImplDao;
import com.example.service.SubjectService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/auth/subjects")
public class SubjectAPIController extends HttpServlet {

    private final SubjectService subjectService = new SubjectService(new SubjectImplDao(), new ExamImplDao());
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session == null){
            ResponseUtility.sendJsonResponse(response, "Unauthorized. Please login.", null,HttpServletResponse.SC_UNAUTHORIZED,false);
            return;
        }
        Integer idUser = (Integer) session.getAttribute("id_user");

        Subject subject = mapper.readValue(request.getReader(), Subject.class);
        subject.setIdUser(idUser);

        if (Validate.isInvalidSubjectUserData(subject)) {
            ResponseUtility.sendJsonResponse(response, "Invalid Input User!", null,HttpServletResponse.SC_BAD_REQUEST,false);
            return;
        }

        try {
            Subject resultSubject  = subjectService.createSubjectOfUser(subject);
            ResponseUtility.sendJsonResponse(response,null,resultSubject, HttpServletResponse.SC_CREATED,true);
        }
        catch (DuplicateSubjectException e){
            ResponseUtility.sendJsonResponse(response, "Subject already exists for user " + subject.getIdUser(),null, HttpServletResponse.SC_INTERNAL_SERVER_ERROR,false);

        }
        catch (Exception e) {
            ResponseUtility.sendJsonResponse(response, e.toString(), null,HttpServletResponse.SC_INTERNAL_SERVER_ERROR,false);
        }
    }





    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);

        Integer idUser = (Integer) session.getAttribute("id_user");

        String nameParameter = request.getParameter("name");
        try {
            if (nameParameter != null) {
                Subject subject = subjectService.getSubjectUserByName(nameParameter, idUser);
                if (subject == null) {
                    ResponseUtility.sendJsonResponse(response, "Subject not found", null,HttpServletResponse.SC_NOT_FOUND,false);
                    return;
                }
                ResponseUtility.sendJsonResponse(response, null,subject, HttpServletResponse.SC_OK,true);

            } else {
                List<Subject> subjects = subjectService.getAllSubjectsByUser(idUser);
                ResponseUtility.sendJsonResponse(response, null,subjects, HttpServletResponse.SC_OK,true);

            }
        } catch (Exception e) {
            ResponseUtility.sendJsonResponse(response, e.toString(),null, HttpServletResponse.SC_INTERNAL_SERVER_ERROR,false);
        }
    }



    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idParameter = request.getParameter("id");

        try {
            if (idParameter == null || idParameter.isEmpty()) {
                ResponseUtility.sendJsonResponse(response, "Invalid or missing 'id' parameter. Please provide a valid integer id.", null,HttpServletResponse.SC_BAD_REQUEST,false);
                return;
            }

            int id = Helper.parseId(idParameter);
            if (id == -1 || !subjectService.deleteSubjectById(id)) {
                ResponseUtility.sendJsonResponse(response, "Subject with id " + id + " not found.", null,HttpServletResponse.SC_NOT_FOUND,false);
                return;
            }

            ResponseUtility.sendJsonResponse(response, "Delete subject witd id " + id + " successful", null,HttpServletResponse.SC_NO_CONTENT,true);

        } catch (Exception e) {
            e.printStackTrace();

            ResponseUtility.sendJsonResponse(response, "Error deleting subjects", null,HttpServletResponse.SC_INTERNAL_SERVER_ERROR,false);
        }
    }




    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String idParameter = request.getParameter("id");
        Subject updatedSubject = mapper.readValue(request.getReader(), Subject.class);

        try {
            if (idParameter == null || idParameter.isEmpty()) {
                ResponseUtility.sendJsonResponse(response, "Invalid or missing 'id' parameter. Please provide a valid integer id.", null,HttpServletResponse.SC_BAD_REQUEST,false);
                return;
            }

            int id = Helper.parseId(idParameter);
            if (id == -1) {
                ResponseUtility.sendJsonResponse(response, "Invalid 'id' parameter. Please provide a valid integer id.", null,HttpServletResponse.SC_BAD_REQUEST,false);
                return;
            }
            Subject newSubject = subjectService.updateSubjectById(id, updatedSubject);

            if (newSubject != null) {
                ResponseUtility.sendJsonResponse(response, "Subject with id " + id +" updated successful",newSubject, HttpServletResponse.SC_OK,true);

            } else {
                ResponseUtility.sendJsonResponse(response, "Subject with id " + id + " not found.", null,HttpServletResponse.SC_NOT_FOUND,false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ResponseUtility.sendJsonResponse(response, "Error updating subjects", null,HttpServletResponse.SC_INTERNAL_SERVER_ERROR,false);
        }
    }
}


