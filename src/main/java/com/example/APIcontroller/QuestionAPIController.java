package com.example.APIcontroller;


import com.example.DTO.QuestionAnswerDTO;
import com.example.CustomExceptionHandling.DuplicateSubjectException;
import com.example.mySQLImplDao.AnswerimplDao;
import com.example.mySQLImplDao.QuestionImplDao;
import com.example.service.QuestionService;
import com.example.utility.Helper;
import com.example.utility.ResponseUtility;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = "/auth/questions")
public class QuestionAPIController extends HttpServlet {

    private final QuestionService questionService = new QuestionService(new QuestionImplDao(), new AnswerimplDao());
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        int idSubject = Helper.parseId(request.getParameter("subject"));

        QuestionAnswerDTO questionAnswerDTO = mapper.readValue(request.getReader(), QuestionAnswerDTO.class);


        try {
           QuestionAnswerDTO resultQuestionAnswerDTO =  questionService.createQuestionOfSubject(idSubject,questionAnswerDTO);
            ResponseUtility.sendJsonResponse(response, "Create question successful!",resultQuestionAnswerDTO, HttpServletResponse.SC_CREATED,true);
        } catch (IllegalArgumentException e) {
            ResponseUtility.sendJsonResponse(response, "Invalid input data. " + e.getMessage(),null, HttpServletResponse.SC_BAD_REQUEST,true);
        } catch (DuplicateSubjectException e) {
            ResponseUtility.sendJsonResponse(response, "Duplicate subject error: " + e.getMessage(),null, HttpServletResponse.SC_CONFLICT,false);
        } catch (RuntimeException e) {
            ResponseUtility.sendJsonResponse(response, "Error creating question and answers: " + e.getMessage(),null, HttpServletResponse.SC_INTERNAL_SERVER_ERROR,false);
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");


        String idParameter = request.getParameter("ids");
        List<Integer> listIdQuestions = null;

        if (idParameter != null && !idParameter.isEmpty()){
            String[] idStrings = idParameter.split(",");
            listIdQuestions = Arrays.stream(idStrings)
                    .map(Integer::parseInt)
                    .toList();
        }
        try {
            List<QuestionAnswerDTO> questionAnswerDTO;

            if (listIdQuestions != null && !listIdQuestions.isEmpty()) {
                questionAnswerDTO = questionService.getAllQuestionSelectedToAddExam(listIdQuestions);
            } else {
                int idSubject = Integer.valueOf(request.getParameter("subject"));
                questionAnswerDTO = questionService.findAllQuestionsOfSubject(idSubject);
            }

            ResponseUtility.sendJsonResponse(response, null,questionAnswerDTO, HttpServletResponse.SC_OK,true);
        } catch (IllegalArgumentException e) {
            ResponseUtility.sendJsonResponse(response, "Invalid input data. " + e.getMessage(), null,HttpServletResponse.SC_BAD_REQUEST,false);
        } catch (DuplicateSubjectException e) {
            ResponseUtility.sendJsonResponse(response, "Duplicate subject error: " + e.getMessage(), null,HttpServletResponse.SC_CONFLICT,false);
        } catch (RuntimeException e) {
            e.printStackTrace();
            ResponseUtility.sendJsonResponse(response, "Error retrieving questions of subject: " + e.getMessage(),null, HttpServletResponse.SC_INTERNAL_SERVER_ERROR,false);
        }

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String idQuestion = request.getParameter("id");

        try {
            if(idQuestion == null || idQuestion.isEmpty()){
                ResponseUtility.sendJsonResponse(response, "Invalid or missing 'id' parameter. Please provide a valid integer id.",null, HttpServletResponse.SC_BAD_REQUEST,false);
                return;
            }
            int id = Helper.parseId(idQuestion);
            if(id== -1|| !questionService.deleteQuestionById(id)){
                ResponseUtility.sendJsonResponse(response, "Question with id " + id + " not found.", null,HttpServletResponse.SC_NOT_FOUND,false);
                return;
            }
            ResponseUtility.sendJsonResponse(response, "Delete question with id " + id + " successful", null,HttpServletResponse.SC_NO_CONTENT,true);

        }
        catch (Exception e){
            ResponseUtility.sendJsonResponse(response,"Error deleting question",null,HttpServletResponse.SC_INTERNAL_SERVER_ERROR,false);

        }

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String idQuestion = request.getParameter("id");
        try {
            if(idQuestion == null|| idQuestion.isEmpty()){
                ResponseUtility.sendJsonResponse(response, "Invalid or missing 'id' parameter. Please provide a valid integer id.", null,HttpServletResponse.SC_BAD_REQUEST,false);
                return;
            }
            int id = Helper.parseId(idQuestion);
            if (id == -1) {
                ResponseUtility.sendJsonResponse(response, "Invalid 'id' parameter. Please provide a valid integer id.", null,HttpServletResponse.SC_BAD_REQUEST,false);
                return;
            }

            QuestionAnswerDTO questionAnswerDTO = mapper.readValue(request.getReader(),QuestionAnswerDTO.class);
            QuestionAnswerDTO resQuestionAnswerDTO = questionService.updateQuestionById(id,questionAnswerDTO);
            if(resQuestionAnswerDTO != null){
                ResponseUtility.sendJsonResponse(response,"Update question with id " + id + " successful!",resQuestionAnswerDTO,HttpServletResponse.SC_OK,true);
            }
            else {
                ResponseUtility.sendJsonResponse(response, "Question with id " + id + " not found.",null, HttpServletResponse.SC_NOT_FOUND,false);
            }
        }
        catch (Exception e){
            ResponseUtility.sendJsonResponse(response,"Updating question failed",null,HttpServletResponse.SC_INTERNAL_SERVER_ERROR,false);
        }

    }
}
