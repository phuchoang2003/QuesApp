/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2024-03-04 17:13:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class doExam_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\">\r\n");
      out.write("    <style>\r\n");
      out.write("    * {\r\n");
      out.write("      box-sizing: border-box;\r\n");
      out.write("      margin: 0;\r\n");
      out.write("      padding: 0;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    html {\r\n");
      out.write("      font-size: 62.5%;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    body {\r\n");
      out.write("      background: linear-gradient(90deg, #c7c5f4, #776bcc);\r\n");
      out.write("      font-family: \"Raleway\", sans-serif;\r\n");
      out.write("      width: 100%;\r\n");
      out.write("      color: #0e0101;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .header,\r\n");
      out.write("    .content,\r\n");
      out.write("    .footer {\r\n");
      out.write("      margin: auto;\r\n");
      out.write("      padding: 20px;\r\n");
      out.write("      width: 80%;\r\n");
      out.write("      backdrop-filter: blur(5px);\r\n");
      out.write("      border-radius: 10px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .header,\r\n");
      out.write("    .footer {\r\n");
      out.write("      display: flex;\r\n");
      out.write("      justify-content: space-between;\r\n");
      out.write("      align-items: center;\r\n");
      out.write("      background-color: rgba(255, 255, 255, 0.7);\r\n");
      out.write("      padding: 15px 20px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .header {\r\n");
      out.write("      margin-top: 40px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .name-exam {\r\n");
      out.write("      font-size: 1.8rem;\r\n");
      out.write("      padding: 10px 20px;\r\n");
      out.write("      background-color: #6c63ac;\r\n");
      out.write("      color: white;\r\n");
      out.write("      border-radius: 5px;\r\n");
      out.write("      transition: transform 0.3s ease;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .name-exam:hover {\r\n");
      out.write("      transform: scale(1.1); /* scale on hover */\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .content {\r\n");
      out.write("      margin-top: 20px;\r\n");
      out.write("      height: auto;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .time {\r\n");
      out.write("      display: flex;\r\n");
      out.write("      align-items: center;\r\n");
      out.write("      justify-content: center;\r\n");
      out.write("      margin-bottom: 20px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .clock {\r\n");
      out.write("      width: 100px;\r\n");
      out.write("      height: 100px;\r\n");
      out.write("      background-color: rgba(255, 255, 255, 0.7);\r\n");
      out.write("      border-radius: 50%;\r\n");
      out.write("      border: 3px solid #6c63ac;\r\n");
      out.write("      display: flex;\r\n");
      out.write("      justify-content: center;\r\n");
      out.write("      align-items: center;\r\n");
      out.write("      font-size: 2rem;\r\n");
      out.write("      font-weight: bold;\r\n");
      out.write("      color: #6c63ac;\r\n");
      out.write("      transition: transform 0.3s ease; /* add transition */\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .clock:hover {\r\n");
      out.write("      transform: rotate(360deg); /* rotate on hover */\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .content-question {\r\n");
      out.write("      background-color: rgba(255, 255, 255, 0.7);\r\n");
      out.write("      padding: 20px;\r\n");
      out.write("      margin-bottom: 20px;\r\n");
      out.write("      text-align: center;\r\n");
      out.write("      border-radius: 10px;\r\n");
      out.write("      font-size: 1.8rem;\r\n");
      out.write("      transition: transform 0.3s ease;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .content-question:hover {\r\n");
      out.write("      transform: translateY(-5px);\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .answers {\r\n");
      out.write("      display: grid;\r\n");
      out.write("      grid-template-columns: repeat(2, 1fr);\r\n");
      out.write("      gap: 0.4rem;\r\n");
      out.write("      font-size: 1.8rem;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .answers div {\r\n");
      out.write("      background-color: rgba(255, 255, 255, 0.7);\r\n");
      out.write("      padding: 20px;\r\n");
      out.write("      margin-bottom: 10px;\r\n");
      out.write("      border-radius: 5px;\r\n");
      out.write("      transition: transform 0.3s ease;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .answers div:hover {\r\n");
      out.write("      background-color: #e0c2f0;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .footer {\r\n");
      out.write("      margin-top: 20px;\r\n");
      out.write("      height: auto;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .text-button,\r\n");
      out.write("    .num-questions {\r\n");
      out.write("      font-size: 1.8rem;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .submit {\r\n");
      out.write("      font-size: 1.8rem;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .back-button,\r\n");
      out.write("    .next-button,\r\n");
      out.write("    .num-questions,\r\n");
      out.write("    .submit {\r\n");
      out.write("      padding: 15px 30px;\r\n");
      out.write("      background-color: #6c63ac;\r\n");
      out.write("      color: #fff;\r\n");
      out.write("      border: none;\r\n");
      out.write("      border-radius: 5px;\r\n");
      out.write("      cursor: pointer;\r\n");
      out.write("      transition: background-color 0.3s, color 0.3s;\r\n");
      out.write("      display: flex;\r\n");
      out.write("      align-items: center;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .back-button:hover,\r\n");
      out.write("    .next-button:hover,\r\n");
      out.write("    .num-questions:hover,\r\n");
      out.write("    .submit:hover {\r\n");
      out.write("      background-color: #564c88;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    .answer.selected {\r\n");
      out.write("      background-color: #e0c2f0;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </style>\r\n");
      out.write("\r\n");
      out.write("    <title>Exam</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"header\">\r\n");
      out.write("        <div class=\"name-exam\">\r\n");
      out.write("            <span class=\"text-name-exam\"></span>\r\n");
      out.write("        </div>\r\n");
      out.write("<button class=\"submit\" onclick=\"submitExam()\">Submit</button>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"content\">\r\n");
      out.write("        <div class=\"time\">\r\n");
      out.write("            <div class=\"clock\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"content-question\">\r\n");
      out.write("            <span class=\"text-question\"></span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"answers\">\r\n");
      out.write("            <div class=\"answer\">\r\n");
      out.write("                <span class=\"text-answer\" id =\"1\"></span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"answer\">\r\n");
      out.write("                <span class=\"text-answer\" id =\"2\"></span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"answer\">\r\n");
      out.write("                <span class=\"text-answer\" id =\"3\"></span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"answer\">\r\n");
      out.write("                <span class=\"text-answer\" id =\"4\"></span>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"footer\">\r\n");
      out.write("        <div class=\"back-button\">\r\n");
      out.write("            <span class=\"text-button\">Back</span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"num-questions\">1/20</div>\r\n");
      out.write("        <div class=\"next-button\">\r\n");
      out.write("            <span class=\"text-button\">Next</span>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("// render ra cau hoi\r\n");
      out.write("let questionsData;\r\n");
      out.write("let indexCurrentQuestion = 0;\r\n");
      out.write("let answersUser = [];\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" document.addEventListener(\"DOMContentLoaded\",async ()=>{\r\n");
      out.write("     try {\r\n");
      out.write("         let examData = await getExamData();\r\n");
      out.write("         questionsData = examData.data.questionAnswerDTOS;\r\n");
      out.write("         let dataNameExam = examData.data.nameExam;\r\n");
      out.write("         let dataTimeLimit = examData.data.timeLimit;\r\n");
      out.write("\r\n");
      out.write("         renderNameExamAndTimeLimit(dataNameExam, dataTimeLimit);\r\n");
      out.write("         renderPositionAndNumQuestions(questionsData, indexCurrentQuestion);\r\n");
      out.write("         renderQuestion(questionsData,indexCurrentQuestion);\r\n");
      out.write("\r\n");
      out.write("         let endTime;\r\n");
      out.write("         const storedEndTime = localStorage.getItem(\"endTime\");\r\n");
      out.write("         if (storedEndTime) {\r\n");
      out.write("             endTime = parseInt(storedEndTime, 10);\r\n");
      out.write("         } else {\r\n");
      out.write("             endTime = new Date().getTime() + (dataTimeLimit * 1000);\r\n");
      out.write("             console.log(dataTimeLimit * 60 * 1000);\r\n");
      out.write("             localStorage.setItem(\"endTime\", endTime.toString());\r\n");
      out.write("         }\r\n");
      out.write("          countdownTimer(endTime);\r\n");
      out.write("\r\n");
      out.write("     } catch (error) {\r\n");
      out.write("         alert(error.message);\r\n");
      out.write("     }\r\n");
      out.write(" });\r\n");
      out.write("\r\n");
      out.write("async function myFetch(url, options) {\r\n");
      out.write("   try {\r\n");
      out.write("     const response = await fetch(url, options);\r\n");
      out.write("     return response;\r\n");
      out.write("   } catch (error) {\r\n");
      out.write("     alert(error.message);\r\n");
      out.write("   }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("// render nameExam va TimeLimit\r\n");
      out.write("function renderNameExamAndTimeLimit(nameExam, timeLimit) {\r\n");
      out.write("    const nameExamElement = document.querySelector(\".text-name-exam\");\r\n");
      out.write("    nameExamElement.textContent = nameExam;\r\n");
      out.write("\r\n");
      out.write("    const timeLimitElement = document.querySelector(\".clock\");\r\n");
      out.write("    const minutes = Math.floor(timeLimit / 60) ;\r\n");
      out.write("    console.log(minutes,\"phuc\")\r\n");
      out.write("    const seconds = timeLimit % 60;\r\n");
      out.write("    timeLimitElement.textContent = `${minutes}:${formatTime(seconds)}`;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("// render ra mot cau\r\n");
      out.write("function renderQuestion(data, indexCurrentQuestion) {\r\n");
      out.write("    document.querySelectorAll('.answer').forEach(ans => ans.classList.remove('selected'));\r\n");
      out.write("\r\n");
      out.write("    const currentQuestion = data[indexCurrentQuestion];\r\n");
      out.write("\r\n");
      out.write("    const idQuestion = currentQuestion.idQuestion;\r\n");
      out.write("    localStorage.setItem(\"idQuestion\", idQuestion);\r\n");
      out.write("\r\n");
      out.write("    const contentQuestion = currentQuestion.content;\r\n");
      out.write("\r\n");
      out.write("    const questionContentElement = document.querySelector(\".text-question\");\r\n");
      out.write("    questionContentElement.textContent = contentQuestion;\r\n");
      out.write("\r\n");
      out.write("    const answers = currentQuestion.answers;\r\n");
      out.write("\r\n");
      out.write("    let i = 1;\r\n");
      out.write("    answers.forEach(answer => {\r\n");
      out.write("        const answerContent = answer.contentOption;\r\n");
      out.write("        const idAnswer = answer.idAnswer;\r\n");
      out.write("        const answerContentElement = document.getElementById(i.toString());\r\n");
      out.write("        answerContentElement.textContent = answerContent;\r\n");
      out.write("\r\n");
      out.write("        answerContentElement.setAttribute(\"data-idQuestion\", idQuestion);\r\n");
      out.write("        answerContentElement.setAttribute(\"data-selectedAnswerId\", idAnswer);\r\n");
      out.write("\r\n");
      out.write("        i++;\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    const selectedAnswerId = localStorage.getItem(`selectedAnswer_${idQuestion}`);\r\n");
      out.write("    if (selectedAnswerId) {\r\n");
      out.write("        const selectedAnswerElement = document.querySelector(`.answer .text-answer[data-idQuestion=\"${idQuestion}\"][data-selectedAnswerId=\"${selectedAnswerId}\"]`);\r\n");
      out.write("        if (selectedAnswerElement) {\r\n");
      out.write("            selectedAnswerElement.closest('.answer').classList.add('selected');\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    // Update indexCurrentQuestion and number of questions\r\n");
      out.write("    renderPositionAndNumQuestions(data, indexCurrentQuestion);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("// render ra so luong cau hoi va vi tri cau hien tai\r\n");
      out.write("function renderPositionAndNumQuestions(data, indexCurrentQuestion){\r\n");
      out.write("    const index = indexCurrentQuestion + 1;\r\n");
      out.write("    const numQuestion = data.length;\r\n");
      out.write("    const numQuestionElement = document.querySelector(\".num-questions\");\r\n");
      out.write("    if(numQuestion === 0){\r\n");
      out.write("        numQuestionElement.textContent = `0/${numQuestion}`;\r\n");
      out.write("    } else {\r\n");
      out.write("        numQuestionElement.textContent = `${index}/${numQuestion}`;\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("// click next render ra cau tiep theo an cau mot\r\n");
      out.write("document.querySelector(\".next-button\").addEventListener(\"click\", () => {\r\n");
      out.write("    if (indexCurrentQuestion < questionsData.length-1) {\r\n");
      out.write("        indexCurrentQuestion++;\r\n");
      out.write("        renderPositionAndNumQuestions(questionsData, indexCurrentQuestion);\r\n");
      out.write("        renderQuestion(questionsData,indexCurrentQuestion);\r\n");
      out.write("    } else {\r\n");
      out.write("        alert(\"This is the last question!\");\r\n");
      out.write("    }\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("// click back button render ra cau truoc an cau mot\r\n");
      out.write("document.querySelector(\".back-button\").addEventListener(\"click\", () => {\r\n");
      out.write("    if (indexCurrentQuestion > 0) {\r\n");
      out.write("        indexCurrentQuestion--;\r\n");
      out.write("        renderPositionAndNumQuestions(questionsData, indexCurrentQuestion);\r\n");
      out.write("        renderQuestion(questionsData,indexCurrentQuestion);\r\n");
      out.write("    } else {\r\n");
      out.write("        alert(\"No previous question!\");\r\n");
      out.write("    }\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("// render ra thoi gian va ten bai kiem tra\r\n");
      out.write("async function getExamData(){\r\n");
      out.write("    const idSubject = localStorage.getItem(\"idSubject\");\r\n");
      out.write("    const idExam = localStorage.getItem(\"idExam\");\r\n");
      out.write("    const url = `http://localhost:8080/QuesApp/auth/do/exams?id_subject=${idSubject}&id_exam=${idExam}`;\r\n");
      out.write("    const options = {\r\n");
      out.write("        method: \"GET\",\r\n");
      out.write("        headers: {\r\n");
      out.write("            \"Content-Type\": \"application/json\",\r\n");
      out.write("        },\r\n");
      out.write("    };\r\n");
      out.write("\r\n");
      out.write("    try {\r\n");
      out.write("        const response = await myFetch(url, options);\r\n");
      out.write("        const responseData = await response.json();\r\n");
      out.write("        return responseData;\r\n");
      out.write("    } catch (error) {\r\n");
      out.write("        alert(error.message);\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("// xu ly dong ho dem nguoc\r\n");
      out.write(" function countdownTimer(endTime) {\r\n");
      out.write("    const countDownDate = new Date(endTime).getTime();\r\n");
      out.write("    const x = setInterval(function() {\r\n");
      out.write("        const now = new Date().getTime();\r\n");
      out.write("        const distance = countDownDate - now;\r\n");
      out.write("\r\n");
      out.write("        const minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));\r\n");
      out.write("        const seconds = Math.floor((distance % (1000 * 60)) / 1000);\r\n");
      out.write("\r\n");
      out.write("        const clockElement = document.querySelector(\".clock\");\r\n");
      out.write("        clockElement.textContent = formatTime(minutes) + \":\" + formatTime(seconds);\r\n");
      out.write("\r\n");
      out.write("        if (distance < 0) {\r\n");
      out.write("            clearInterval(x);\r\n");
      out.write("            clockElement.textContent = \"00:00\";\r\n");
      out.write("\r\n");
      out.write("            // tu dong submit\r\n");
      out.write("             submitExam();\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("    }, 1000);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function formatTime(time) {\r\n");
      out.write("    return time < 10 ? \"0\" + time : time;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("// xu ly khi chon dap an\r\n");
      out.write("document.querySelectorAll('.answer').forEach(answer => {\r\n");
      out.write("    answer.addEventListener('click', () => {\r\n");
      out.write("        handleAnswerSelection(answer);\r\n");
      out.write("    });\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("function handleAnswerSelection(selectedAnswerElement) {\r\n");
      out.write("    const idQuestion = selectedAnswerElement.querySelector('.text-answer').getAttribute('data-idQuestion');\r\n");
      out.write("        const selectedAnswerId = selectedAnswerElement.querySelector('.text-answer').getAttribute('data-selectedAnswerId');\r\n");
      out.write("        console.log(idQuestion);\r\n");
      out.write("    localStorage.setItem(`selectedAnswer_${idQuestion}`, selectedAnswerId);\r\n");
      out.write("\r\n");
      out.write("    document.querySelectorAll('.answer').forEach(ans => ans.classList.remove('selected'));\r\n");
      out.write("    selectedAnswerElement.classList.add('selected');\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("// submit button\r\n");
      out.write("async function sendDataToSubmit(data){\r\n");
      out.write("const idSubject = localStorage.getItem(\"idSubject\");\r\n");
      out.write("const idExam = localStorage.getItem(\"idExam\");\r\n");
      out.write("const url = `http://localhost:8080/QuesApp/auth/do/exams?id_subject=${idSubject}&id_exam=${idExam}`;\r\n");
      out.write("\r\n");
      out.write("              const options = {\r\n");
      out.write("                method: \"POST\",\r\n");
      out.write("                headers: {\r\n");
      out.write("                  \"Content-Type\": \"application/json\",\r\n");
      out.write("                },\r\n");
      out.write("                body: JSON.stringify(data),\r\n");
      out.write("              };\r\n");
      out.write("\r\n");
      out.write("              try {\r\n");
      out.write("                const response = await myFetch(url, options);\r\n");
      out.write("                const responseData = await response.json();\r\n");
      out.write("                return responseData;\r\n");
      out.write("              } catch (error) {\r\n");
      out.write("                console.log(\"phuc\");\r\n");
      out.write("                alert(error.message);\r\n");
      out.write("              }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("async function submitExam() {\r\n");
      out.write("    let answersUser = [];\r\n");
      out.write("    for (let i = 0; i < questionsData.length; i++) {\r\n");
      out.write("        const idQuestion = questionsData[i].idQuestion;\r\n");
      out.write("        const selectedAnswerId = localStorage.getItem(`selectedAnswer_${idQuestion}`);\r\n");
      out.write("        if (selectedAnswerId) {\r\n");
      out.write("            answersUser.push({\r\n");
      out.write("                idQuestion: idQuestion,\r\n");
      out.write("                selectedAnswerId: parseInt(selectedAnswerId)\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    const data = { answersUser: answersUser };\r\n");
      out.write("    try {\r\n");
      out.write("        const response = await sendDataToSubmit(data);\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        if(response.success){\r\n");
      out.write("                //xoa localStorage\r\n");
      out.write("                // xoa het selectedAnswer_\r\n");
      out.write("                localStorage.clear();\r\n");
      out.write("\r\n");
      out.write("                alert(response.message);\r\n");
      out.write("                const urlHistoryPage = \"http://localhost:8080/QuesApp/history\";\r\n");
      out.write("                window.location.href = urlHistoryPage;\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("        else{\r\n");
      out.write("            console.log(response);\r\n");
      out.write("            throw new Error(response.message);\r\n");
      out.write("        }\r\n");
      out.write("    } catch (error) {\r\n");
      out.write("        console.log(\"phuc1\");\r\n");
      out.write("        alert(error.message);\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}