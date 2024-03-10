/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2024-03-01 17:37:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class createExamForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <meta charset=\"UTF-8\" />\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("    <title>Create Exam</title>\r\n");
      out.write("    <style>\r\n");
      out.write("\r\n");
      out.write("    body {\r\n");
      out.write("      font-family: Arial, sans-serif;\r\n");
      out.write("      background: linear-gradient(90deg, #c7c5f4, #776bcc);\r\n");
      out.write("      margin: 0;\r\n");
      out.write("      padding: 0;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .container {\r\n");
      out.write("      max-width: 800px;\r\n");
      out.write("      margin: 50px auto;\r\n");
      out.write("      padding: 20px;\r\n");
      out.write("      background-color: rgba(255, 255, 255, 0.9);\r\n");
      out.write("      border-radius: 8px;\r\n");
      out.write("      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    h2 {\r\n");
      out.write("      text-align: center;\r\n");
      out.write("      color: #6c63ac;\r\n");
      out.write("      margin-bottom: 20px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .form-group {\r\n");
      out.write("      margin-bottom: 20px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    label {\r\n");
      out.write("      font-weight: bold;\r\n");
      out.write("      color: #6c63ac;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    input[type=\"text\"],\r\n");
      out.write("    input[type=\"number\"] {\r\n");
      out.write("      width: calc(100% - 20px);\r\n");
      out.write("      padding: 10px;\r\n");
      out.write("      margin-top: 5px;\r\n");
      out.write("      margin-bottom: 10px;\r\n");
      out.write("      border: 1px solid #ccc;\r\n");
      out.write("      border-radius: 4px;\r\n");
      out.write("      box-sizing: border-box;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    button[type=\"button\"],\r\n");
      out.write("    button[type=\"submit\"] {\r\n");
      out.write("      width: 100%;\r\n");
      out.write("      padding: 10px;\r\n");
      out.write("      background-color: #8e86d8;\r\n");
      out.write("      color: #fff;\r\n");
      out.write("      border: none;\r\n");
      out.write("      border-radius: 4px;\r\n");
      out.write("      cursor: pointer;\r\n");
      out.write("      transition: background-color 0.3s;\r\n");
      out.write("      margin-top: 20px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    button#addQuestionBtn {\r\n");
      out.write("      background-color: #8e86d8;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    button#addQuestionBtn:hover {\r\n");
      out.write("      background-color: #776bcc;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .content-question {\r\n");
      out.write("      font-weight: bold;\r\n");
      out.write("      color: #6c63ac;\r\n");
      out.write("      font-size: 1.2rem;\r\n");
      out.write("      margin-bottom: 10px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .question {\r\n");
      out.write("      background-color: rgba(255, 255, 255, 0.7);\r\n");
      out.write("      padding: 20px;\r\n");
      out.write("      margin-bottom: 20px;\r\n");
      out.write("      border-radius: 10px;\r\n");
      out.write("      font-size: 1.4rem;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .text-question {\r\n");
      out.write("      font-size: 1.2rem;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .answers {\r\n");
      out.write("      display: grid;\r\n");
      out.write("      grid-template-columns: repeat(2, 1fr);\r\n");
      out.write("      gap: 2rem;\r\n");
      out.write("      font-size: 1.2rem;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .answers div {\r\n");
      out.write("      background-color: rgba(255, 255, 255, 0.7);\r\n");
      out.write("      padding: 15px;\r\n");
      out.write("      margin-bottom: 10px;\r\n");
      out.write("      border-radius: 5px;\r\n");
      out.write("      border: 1px solid #ccc;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <h2>Create Exam</h2>\r\n");
      out.write("        <form id=\"examForm\">\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <label for=\"exam\">Name Exam:</label>\r\n");
      out.write("                <input type=\"text\" id=\"exam\" name=\"exam\" required />\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <label for=\"timeLimit\">Time Limit (minutes):</label>\r\n");
      out.write("                <input type=\"number\" id=\"timeLimit\" name=\"timeLimit\" min=\"1\" required />\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"questionsContainer\">\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            <button type=\"button\" id=\"addQuestionBtn\">Add Question</button>\r\n");
      out.write("            <button type=\"submit\" class =\"createBtn\">Create</button>\r\n");
      out.write("            <button type=\"button\" class =\"backBtn\">Back</button>\r\n");
      out.write("\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" <script>\r\n");
      out.write("// add question button\r\n");
      out.write("document.addEventListener(\"DOMContentLoaded\",()=>{\r\n");
      out.write("    const addQuestionButton = document.querySelector(\"#addQuestionBtn\");\r\n");
      out.write("    addQuestionButton.addEventListener(\"click\",()=>{\r\n");
      out.write("        // hien ra mot trang moi de them cau hoi\r\n");
      out.write("        const urlAddQuestionToExamPage = \"http://localhost:8080/QuesApp/addQuestionToExam\";\r\n");
      out.write("        window.location.href = urlAddQuestionToExamPage;\r\n");
      out.write("    })\r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("// render ra question vua tich\r\n");
      out.write("document.addEventListener(\"DOMContentLoaded\",async ()=>{\r\n");
      out.write("    await renderQuestionSelected();\r\n");
      out.write("    })\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("async function myFetch(url, options) {\r\n");
      out.write("      try {\r\n");
      out.write("        const response = await fetch(url, options);\r\n");
      out.write("        console.log(\"phuc\",response);\r\n");
      out.write("        return response;\r\n");
      out.write("      } catch (error) {\r\n");
      out.write("        console.log(\"2\", error.message);\r\n");
      out.write("        alert(error.message);\r\n");
      out.write("      }\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("async function getQuestionsSelectedData(listIds){\r\n");
      out.write("    console.log(listIds);\r\n");
      out.write("    const url = `http://localhost:8080/QuesApp/auth/questions?ids=${listIds}`;\r\n");
      out.write("\r\n");
      out.write("          const options = {\r\n");
      out.write("            method: \"GET\",\r\n");
      out.write("            headers: {\r\n");
      out.write("              \"Content-Type\": \"application/json\",\r\n");
      out.write("            },\r\n");
      out.write("          };\r\n");
      out.write("\r\n");
      out.write("          try {\r\n");
      out.write("            const response = await myFetch(url, options);\r\n");
      out.write("            const responseData = await response.json();\r\n");
      out.write("            return responseData;\r\n");
      out.write("          } catch (error) {\r\n");
      out.write("            alert(error.message);\r\n");
      out.write("          }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("async function renderQuestionSelected() {\r\n");
      out.write("    try {\r\n");
      out.write("        const selectedQuestionIds = JSON.parse(localStorage.getItem(\"selectedQuestionIds\"));\r\n");
      out.write("        const listIds = selectedQuestionIds.join(\",\");\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        const questions = await getQuestionsSelectedData(listIds);\r\n");
      out.write("        const data = questions.data;\r\n");
      out.write("\r\n");
      out.write("        const questionsContainer = document.getElementById(\"questionsContainer\");\r\n");
      out.write("        questionsContainer.innerHTML = \"\";\r\n");
      out.write("\r\n");
      out.write("        data.forEach((question, index) => {\r\n");
      out.write("            // Create a div element for the question\r\n");
      out.write("            const questionDiv = document.createElement(\"div\");\r\n");
      out.write("            questionDiv.classList.add(\"form-group\", \"question\");\r\n");
      out.write("\r\n");
      out.write("            questionDiv.innerHTML = `\r\n");
      out.write("                <div class=\"content-question\">\r\n");
      out.write("                    <span class=\"text-question\">Question ${index + 1}: ${question.content}</span>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"answers\">\r\n");
      out.write("                    <div class=\"answerA\">\r\n");
      out.write("                        <span class=\"text-answer\">${question.answers[0].contentOption}</span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"answerB\">\r\n");
      out.write("                        <span class=\"text-answer\">${question.answers[1].contentOption}</span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"answerC\">\r\n");
      out.write("                        <span class=\"text-answer\">${question.answers[2].contentOption}</span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"answerD\">\r\n");
      out.write("                        <span class=\"text-answer\">${question.answers[3].contentOption}</span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            `;\r\n");
      out.write("\r\n");
      out.write("            questionsContainer.appendChild(questionDiv);\r\n");
      out.write("        });\r\n");
      out.write("    } catch (error) {\r\n");
      out.write("        if(!error.message === \"Cannot read properties of null (reading 'join')\")\r\n");
      out.write("        alert(error.message);\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("// get input user\r\n");
      out.write("function getInputUser(){\r\n");
      out.write("    const examValue = document.getElementById(\"exam\").value;\r\n");
      out.write("    const timeLimitValue = document.getElementById(\"timeLimit\").value;\r\n");
      out.write("    return {examValue,timeLimitValue};\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("// create exam button\r\n");
      out.write("\r\n");
      out.write("    async function sendExamData(data){\r\n");
      out.write("            const idSubject = localStorage.getItem(\"idSubject\");\r\n");
      out.write("            console.log(\"messi\",idSubject);\r\n");
      out.write("            const url = `http://localhost:8080/QuesApp/auth/exams?id_subject=${idSubject}`;\r\n");
      out.write("              const options = {\r\n");
      out.write("                method: \"POST\",\r\n");
      out.write("                headers: {\r\n");
      out.write("                  \"Content-Type\": \"application/json\",\r\n");
      out.write("                },\r\n");
      out.write("\r\n");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    async function createExam(inputValue){\r\n");
      out.write("        const questionIds = JSON.parse(localStorage.getItem(\"selectedQuestionIds\"));\r\n");
      out.write("\r\n");
      out.write("        const nameExam = inputValue.examValue;\r\n");
      out.write("        const timeLimit = inputValue.timeLimitValue;\r\n");
      out.write("\r\n");
      out.write("        if(nameExam && timeLimit && questionIds) {\r\n");
      out.write("                           const exam = {\r\n");
      out.write("                                nameExam: nameExam,\r\n");
      out.write("                                timeLimit: timeLimit * 60,\r\n");
      out.write("                                questionIds: questionIds\r\n");
      out.write("                            };\r\n");
      out.write("                            console.log(JSON.stringify(exam));\r\n");
      out.write("        try {\r\n");
      out.write("                const responseData = await sendExamData(exam);\r\n");
      out.write("                if (responseData.success) {\r\n");
      out.write("                alert(responseData.message);\r\n");
      out.write("                const urlListExamPage = \"http://localhost:8080/QuesApp/exams\";\r\n");
      out.write("                window.location.href = urlListExamPage;\r\n");
      out.write("                } else {\r\n");
      out.write("                throw new Error(responseSubject.message);\r\n");
      out.write("             }\r\n");
      out.write("            } catch (error) {\r\n");
      out.write("            alert(error.message);\r\n");
      out.write("          }\r\n");
      out.write("            } else {\r\n");
      out.write("                console.error(\"Không thể tìm thấy các phần tử input.\");\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("document.addEventListener(\"DOMContentLoaded\", () => {\r\n");
      out.write("            const createBtn = document.querySelector(\".createBtn\");\r\n");
      out.write("            createBtn.addEventListener(\"click\", async (event) => {\r\n");
      out.write("                event.preventDefault();\r\n");
      out.write("                await createExam(getInputUser());\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("// back button\r\n");
      out.write("document.addEventListener(\"DOMContentLoaded\", () => {\r\n");
      out.write("          const backButton = document.querySelector(\".backBtn\");\r\n");
      out.write("          backButton.addEventListener(\"click\",  () => {\r\n");
      out.write("          localStorage.removeItem(\"selectedQuestionIds\");\r\n");
      out.write("          const listExamUrlPage = \"http://localhost:8080/QuesApp/exams\";\r\n");
      out.write("          window.location.href = listExamUrlPage;\r\n");
      out.write("              });\r\n");
      out.write("          });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" </script>\r\n");
      out.write("</body>\r\n");
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
