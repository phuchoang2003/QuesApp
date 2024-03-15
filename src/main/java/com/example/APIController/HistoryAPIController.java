package com.example.APIController;

import com.example.DTO.HistoryResultDTO;
import com.example.mySQLImplDao.*;
import com.example.service.HistoryService;
import com.example.utility.ResponseUtility;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/auth/history")
public class HistoryAPIController extends HttpServlet {
    private  final ObjectMapper mapper = new ObjectMapper();
    private final HistoryService historyService = new HistoryService(new ResultImplDao(),new HistoryImplDao(),new SubjectImplDao(),new ExamImplDao(),new QuestionImplDao());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null) {
            ResponseUtility.sendJsonResponse(response, "Unauthorized. Please login.", null,HttpServletResponse.SC_UNAUTHORIZED,false);
            return;
        }
        Integer idUser = (Integer) session.getAttribute("id_user");

        try {
            List<HistoryResultDTO> historyResultDTOS = historyService.getAllHistoriesOfUser(idUser);
            ResponseUtility.sendJsonResponse(response, null,historyResultDTOS, HttpServletResponse.SC_OK,true);

        } catch (Exception e) {
            ResponseUtility.sendJsonResponse(response, "Error retrieving user history.", null,HttpServletResponse.SC_INTERNAL_SERVER_ERROR,false);
        }
    }

}
