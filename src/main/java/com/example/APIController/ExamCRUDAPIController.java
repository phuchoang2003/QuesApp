package com.example.APIController;

import com.example.DTO.ExamDTO;
import com.example.DTO.ExamQuestionIdsDTO;
import com.example.CustomExceptionHandling.DuplicateSubjectException;
import com.example.mySQLImplDao.*;
import com.example.service.ExamService;
import com.example.utility.Helper;
import com.example.utility.ResponseUtility;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/auth/exams")
public class ExamCRUDAPIController extends HttpServlet {
    private final ExamService examService = new ExamService(new ExamImplDao(),new HistoryImplDao(), new ResultImplDao(),new QuestionImplDao(),new AnswerimplDao());

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int idSubject = Integer.valueOf(request.getParameter("id_subject"));
                ExamQuestionIdsDTO examQuestionDTO = mapper.readValue(request.getReader(), ExamQuestionIdsDTO.class);

                ExamQuestionIdsDTO resultExam = examService.createExamOfSubject(idSubject, examQuestionDTO);

                if (resultExam != null) {
                    ResponseUtility.sendJsonResponse(response, "Create exam successful!",resultExam, HttpServletResponse.SC_CREATED,true);
                } else {
                    ResponseUtility.sendJsonResponse(response, "Failed to create exam.", null,HttpServletResponse.SC_BAD_REQUEST,false);
                }
        } catch (IllegalArgumentException e) {
            ResponseUtility.sendJsonResponse(response, e.getMessage(), null,HttpServletResponse.SC_BAD_REQUEST,false);
        } catch (RuntimeException e) {
            ResponseUtility.sendJsonResponse(response, "Failed to create exam: " + e.getMessage(), null,HttpServletResponse.SC_INTERNAL_SERVER_ERROR,false);
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idSubject = Integer.valueOf(request.getParameter("id_subject"));


        try {
            List<ExamDTO> examDTOS = examService.getAllExamsOfSubject(idSubject);

            ResponseUtility.sendJsonResponse(response, null,examDTOS, HttpServletResponse.SC_OK,true);
        } catch (IllegalArgumentException e) {
            ResponseUtility.sendJsonResponse(response, "Invalid input data. " + e.getMessage(), null,HttpServletResponse.SC_BAD_REQUEST,false);
        } catch (DuplicateSubjectException e) {
            ResponseUtility.sendJsonResponse(response, "Duplicate subject error: " + e.getMessage(), null,HttpServletResponse.SC_CONFLICT,false);
        } catch (RuntimeException e) {
            e.printStackTrace();
            ResponseUtility.sendJsonResponse(response, "Error retrieving exams of subject: " + e.getMessage(),null, HttpServletResponse.SC_INTERNAL_SERVER_ERROR,false);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idExam = request.getParameter("id_exam");

        try {
            if(idExam == null || idExam.isEmpty()){
                ResponseUtility.sendJsonResponse(response, "Invalid or missing 'id' parameter. Please provide a valid integer id.",null, HttpServletResponse.SC_BAD_REQUEST,false);
                return;
            }
            int id = Helper.parseId(idExam);
            if(id== -1|| !examService.deleteExamById(id)){
                ResponseUtility.sendJsonResponse(response, "Exam with id " + id + " not found.", null,HttpServletResponse.SC_NOT_FOUND,false);
                return;
            }
            ResponseUtility.sendJsonResponse(response, "Delete Exam with id " + id + " successful", null,HttpServletResponse.SC_NO_CONTENT,true);

        }
        catch (Exception e){
            ResponseUtility.sendJsonResponse(response,"Error deleting exam",null,HttpServletResponse.SC_INTERNAL_SERVER_ERROR,false);

        }







    }
}
