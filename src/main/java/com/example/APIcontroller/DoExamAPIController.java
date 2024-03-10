package com.example.APIcontroller;

import com.example.DTO.ExamQuestionDetailsDTO;
import com.example.DTO.SubmitExamDTO;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;


@WebServlet(urlPatterns = "/auth/do/exams")
public class DoExamAPIController extends HttpServlet {

    private final ExamService examService = new ExamService(new ExamImplDao(),new HistoryImplDao(), new ResultImplDao(),new QuestionImplDao(),new AnswerimplDao());

    private final ObjectMapper mapper = new ObjectMapper();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String idExamParam = request.getParameter("id_exam");

        try {
            if (idExamParam == null || idExamParam.isEmpty()) {
                ResponseUtility.sendJsonResponse(response, "Invalid or missing 'id_exam' parameter. Please provide a valid integer id.",null, HttpServletResponse.SC_BAD_REQUEST,false);
                return;
            }

            int idExam = Helper.parseId(idExamParam);
            if (idExam == -1) {
                ResponseUtility.sendJsonResponse(response, "Invalid 'id_exam' parameter. Please provide a valid integer id.", null,HttpServletResponse.SC_BAD_REQUEST,false);
                return;
            }

            ExamQuestionDetailsDTO examDetails = examService.takeExam(idExam);


            // set session attribute thoi gian het bai va thoi gian bat dau
            HttpSession session = request.getSession(false);
            if(session == null){
                ResponseUtility.sendJsonResponse(response, "Unauthorized. Please login.",null, HttpServletResponse.SC_UNAUTHORIZED,false);
                return;
            }


            LocalDateTime startTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
            String formattedStartTimeString = startTime.format(formatter);

            session.setAttribute("startTime", formattedStartTimeString);
            session.setAttribute("isTakeExam",true);

            if (examDetails != null) {
                ResponseUtility.sendJsonResponse(response, null,examDetails, HttpServletResponse.SC_OK,true);

            } else {
                ResponseUtility.sendJsonResponse(response, "Exam with id " + idExam + " not found.",null, HttpServletResponse.SC_NOT_FOUND,false);
            }
        } catch (Exception e) {
            ResponseUtility.sendJsonResponse(response, "Error processing exam details request.",null, HttpServletResponse.SC_INTERNAL_SERVER_ERROR,false);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession(false);
        if(session == null){
            ResponseUtility.sendJsonResponse(response, "Unauthorized. Please login.", null,HttpServletResponse.SC_UNAUTHORIZED,false);
            return;
        }

        try {
            Boolean isTakeExam = (Boolean) session.getAttribute("isTakeExam");
            if (isTakeExam != null && isTakeExam) {
                String idExam = request.getParameter("id_exam");
                int id = Integer.valueOf(idExam);

                Integer idUser = (Integer) session.getAttribute("id_user");
                SubmitExamDTO submitExamDTO = mapper.readValue(request.getReader(), SubmitExamDTO.class);


                // loi o day
                String startTimeString = (String) session.getAttribute("startTime");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
                LocalDateTime startTime = LocalDateTime.parse(startTimeString, formatter);



                examService.submitExam(id,  idUser, startTime, submitExamDTO);

                session.setAttribute("isTakeExam", false);

                ResponseUtility.sendJsonResponse(response, "Exam submitted successfully.", submitExamDTO,HttpServletResponse.SC_OK,true);
            } else {
                ResponseUtility.sendJsonResponse(response, "You must take the exam before submitting.", null, HttpServletResponse.SC_BAD_REQUEST, false);
            }
        } catch (IllegalArgumentException e) {
            ResponseUtility.sendJsonResponse(response, e.getMessage(), null, HttpServletResponse.SC_BAD_REQUEST, false);
        } catch (RuntimeException e) {
            e.printStackTrace();
            ResponseUtility.sendJsonResponse(response, e.toString(), null, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, false);
        }
    }

}
