/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2024-02-29 11:38:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class listQuestion_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"UTF-8\" />\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("    <link\r\n");
      out.write("      rel=\"stylesheet\"\r\n");
      out.write("      href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\"\r\n");
      out.write("    />\r\n");
      out.write("    <link href=\"\r\n");
      out.write("        https://cdn.jsdelivr.net/npm/@icon/themify-icons@1.0.1-alpha.3/themify-icons.min.css\r\n");
      out.write("        \" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("     <style>\r\n");
      out.write("\r\n");
      out.write("     body {\r\n");
      out.write("       background: linear-gradient(90deg, #c7c5f4, #776bcc);\r\n");
      out.write("       margin: 0;\r\n");
      out.write("       font-family: \"Raleway\", sans-serif;\r\n");
      out.write("       margin-top: 100px;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     html {\r\n");
      out.write("       font-size: 62.5%;\r\n");
      out.write("     }\r\n");
      out.write("        .header .home,\r\n");
      out.write("         .header .logo-user {\r\n");
      out.write("                width: 40px;\r\n");
      out.write("                height: 40px;\r\n");
      out.write("                border-radius: 50%;\r\n");
      out.write("                margin: 0 5px;\r\n");
      out.write("                cursor: pointer;\r\n");
      out.write("          }\r\n");
      out.write("\r\n");
      out.write("     .header,\r\n");
      out.write("     .body,\r\n");
      out.write("     .footer {\r\n");
      out.write("       margin: auto;\r\n");
      out.write("       padding: 20px;\r\n");
      out.write("       width: 80%;\r\n");
      out.write("       backdrop-filter: blur(5px);\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .header {\r\n");
      out.write("       display: flex;\r\n");
      out.write("       justify-content: space-between;\r\n");
      out.write("       align-items: center;\r\n");
      out.write("       background: rgba(255, 255, 255, 0.7);\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .header div {\r\n");
      out.write("       width: 40px;\r\n");
      out.write("       height: 40px;\r\n");
      out.write("       background: #bcb6eb;\r\n");
      out.write("       margin: 0 5px;\r\n");
      out.write("       border-radius: 50%;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .header .ti-search {\r\n");
      out.write("       font-size: 20px;\r\n");
      out.write("       color: #757575;\r\n");
      out.write("       border: 2px solid #757575;\r\n");
      out.write("       border-radius: 50%;\r\n");
      out.write("       padding: 10px;\r\n");
      out.write("       transition: all 0.3s ease;\r\n");
      out.write("       margin-right: 10px;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .header .ti-search:hover {\r\n");
      out.write("       background-color: #6a679e;\r\n");
      out.write("       color: #fff;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .header .icon {\r\n");
      out.write("       font-size: 20px;\r\n");
      out.write("       color: #757575;\r\n");
      out.write("       font-weight: 550;\r\n");
      out.write("       display: flex;\r\n");
      out.write("       justify-content: center;\r\n");
      out.write("       align-items: center;\r\n");
      out.write("       line-height: 40px;\r\n");
      out.write("       text-align: center;\r\n");
      out.write("       transition: transform 0.3s ease, box-shadow 0.3s ease, color 0.3s ease;\r\n");
      out.write("       border-radius: 50%;\r\n");
      out.write("       position: relative;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .header .icon:hover {\r\n");
      out.write("       box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.3);\r\n");
      out.write("       color: whitesmoke;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .header .icon:hover ~ div {\r\n");
      out.write("       filter: blur(2px);\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .header .icon[title]:hover::after {\r\n");
      out.write("       content: attr(title);\r\n");
      out.write("       position: absolute;\r\n");
      out.write("       left: 50%;\r\n");
      out.write("       transform: translateX(-50%) translateY(100%);\r\n");
      out.write("       background-color: #6a679e;\r\n");
      out.write("       color: white;\r\n");
      out.write("       font-size: 12px;\r\n");
      out.write("       z-index: 999;\r\n");
      out.write("       justify-content: center;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .header .search {\r\n");
      out.write("       flex-grow: 1;\r\n");
      out.write("       height: 60px;\r\n");
      out.write("       background: #fff;\r\n");
      out.write("       border-radius: 30px;\r\n");
      out.write("       margin: 0 5px;\r\n");
      out.write("       display: flex;\r\n");
      out.write("       align-items: center;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .header .search_input {\r\n");
      out.write("       border: none;\r\n");
      out.write("       outline: none;\r\n");
      out.write("       background: none;\r\n");
      out.write("       padding: 10px;\r\n");
      out.write("       padding-left: 24px;\r\n");
      out.write("       padding-right: 24px;\r\n");
      out.write("       font-weight: 700;\r\n");
      out.write("       width: 100%;\r\n");
      out.write("       transition: 0.2s;\r\n");
      out.write("       height: 40px;\r\n");
      out.write("       text-align: center;\r\n");
      out.write("       color: #5e5e5f;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .header .search_input:focus {\r\n");
      out.write("       border-bottom: 2px solid #6a679e;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .header .search_input::placeholder {\r\n");
      out.write("       color: #5e5e5f;\r\n");
      out.write("       font-weight: 700;\r\n");
      out.write("       opacity: 0.7;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .header .search:hover .search_input::placeholder {\r\n");
      out.write("       opacity: 1;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .header .search:hover .search_input {\r\n");
      out.write("       border-bottom: 2px solid #6a679e;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("     .body {\r\n");
      out.write("       height: auto;\r\n");
      out.write("       background: rgba(255, 255, 255, 0.7);\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .list-quiz-button {\r\n");
      out.write("       padding: 10px 20px;\r\n");
      out.write("       background-color: #6c63ac;\r\n");
      out.write("       color: #fff;\r\n");
      out.write("       border: none;\r\n");
      out.write("       border-radius: 5px;\r\n");
      out.write("       cursor: pointer;\r\n");
      out.write("       transition: background-color 0.3s, color 0.3s;\r\n");
      out.write("       display: inline-flex;\r\n");
      out.write("       align-items: center;\r\n");
      out.write("       margin-left: 20px;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .list-quiz-button:hover {\r\n");
      out.write("       background-color: #564c88;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .list-quiz-button .text-button {\r\n");
      out.write("       font-size: 1.6rem;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .add-question {\r\n");
      out.write("       padding: 12px 20px;\r\n");
      out.write("       background-color: #6c63ac;\r\n");
      out.write("       color: #fff;\r\n");
      out.write("       border: none;\r\n");
      out.write("       border-radius: 5px;\r\n");
      out.write("       cursor: pointer;\r\n");
      out.write("       transition: background-color 0.3s, color 0.3s;\r\n");
      out.write("       display: inline-flex;\r\n");
      out.write("       align-items: center;\r\n");
      out.write("       margin-left: 40px;\r\n");
      out.write("       font-size: 1.6rem;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .add-question:hover {\r\n");
      out.write("       background: #564c88;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .delete,\r\n");
      out.write("     .update {\r\n");
      out.write("       background-color: #6c63ac;\r\n");
      out.write("       color: #fff;\r\n");
      out.write("       border: none;\r\n");
      out.write("       border-radius: 5px;\r\n");
      out.write("       cursor: pointer;\r\n");
      out.write("       transition: background-color 0.3s, color 0.3s;\r\n");
      out.write("       display: inline-flex;\r\n");
      out.write("       align-items: center;\r\n");
      out.write("       padding: 12px 20px;\r\n");
      out.write("       margin-left: 20px;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .delete i,\r\n");
      out.write("     .update i {\r\n");
      out.write("       font-size: 16px;\r\n");
      out.write("       color: #fff;\r\n");
      out.write("       transition: color 0.3s ease;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .delete:hover,\r\n");
      out.write("     .update:hover {\r\n");
      out.write("       background-color: #564c88;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .start-list-button,\r\n");
      out.write("     .add-question,\r\n");
      out.write("     .delete,\r\n");
      out.write("     .update {\r\n");
      out.write("       display: inline-flex;\r\n");
      out.write("       align-items: center;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .list-quiz-button,\r\n");
      out.write("     .add-question,\r\n");
      out.write("     .delete,\r\n");
      out.write("     .update {\r\n");
      out.write("       padding: 15px 30px;\r\n");
      out.write("       background-color: #6c63ac;\r\n");
      out.write("       color: #fff;\r\n");
      out.write("       border: none;\r\n");
      out.write("       border-radius: 5px;\r\n");
      out.write("       cursor: pointer;\r\n");
      out.write("       transition: background-color 0.3s, color 0.3s;\r\n");
      out.write("       display: inline-flex;\r\n");
      out.write("       align-items: center;\r\n");
      out.write("       margin-right: 20px;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .question {\r\n");
      out.write("       margin-top: 20px;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .content-question {\r\n");
      out.write("       background-color: rgba(255, 255, 255, 0.7);\r\n");
      out.write("       padding: 20px;\r\n");
      out.write("       margin-bottom: 20px;\r\n");
      out.write("       text-align: center;\r\n");
      out.write("       border-radius: 10px;\r\n");
      out.write("       font-size: 1.8rem;\r\n");
      out.write("       transition: transform 0.3s ease;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .content-question:hover {\r\n");
      out.write("       transform: translateY(-5px);\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .answers {\r\n");
      out.write("       display: grid;\r\n");
      out.write("       grid-template-columns: repeat(2, 1fr);\r\n");
      out.write("       gap: 0.4rem;\r\n");
      out.write("       font-size: 1.8rem;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .answers div {\r\n");
      out.write("       background-color: rgba(255, 255, 255, 0.7);\r\n");
      out.write("       padding: 20px;\r\n");
      out.write("       margin-bottom: 10px;\r\n");
      out.write("       border-radius: 5px;\r\n");
      out.write("       transition: transform 0.3s ease;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .answers div:hover {\r\n");
      out.write("       background-color: #e0c2f0;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .footer {\r\n");
      out.write("       display: flex;\r\n");
      out.write("       justify-content: space-between;\r\n");
      out.write("       align-items: center;\r\n");
      out.write("       background: rgba(255, 255, 255, 0.7);\r\n");
      out.write("       padding: 15px 20px;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .text-button,\r\n");
      out.write("     .num-questions {\r\n");
      out.write("       font-size: 1.8rem;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .back-button,\r\n");
      out.write("     .next-button,\r\n");
      out.write("     .num-questions {\r\n");
      out.write("       padding: 15px 30px;\r\n");
      out.write("       background-color: #6c63ac;\r\n");
      out.write("       color: #fff;\r\n");
      out.write("       border: none;\r\n");
      out.write("       border-radius: 5px;\r\n");
      out.write("       cursor: pointer;\r\n");
      out.write("       transition: background-color 0.3s, color 0.3s;\r\n");
      out.write("       display: flex;\r\n");
      out.write("       align-items: center;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .back-button:hover,\r\n");
      out.write("     .next-button:hover,\r\n");
      out.write("     .num-questions:hover {\r\n");
      out.write("       background-color: #564c88;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("      </style>\r\n");
      out.write("\r\n");
      out.write("    <title>List Question</title>\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("    <div class=\"header\">\r\n");
      out.write("      <div class=\"home\">\r\n");
      out.write("        <i class=\"ti ti-home icon\" title=\"Home\"></i>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"search\">\r\n");
      out.write("        <input\r\n");
      out.write("          type=\"text\"\r\n");
      out.write("          class=\"search_input\"\r\n");
      out.write("          placeholder=\"Enter Name Your Subject\"\r\n");
      out.write("        />\r\n");
      out.write("        <i class=\"ti ti-search\"></i>\r\n");
      out.write("      </div>\r\n");
      out.write("       <div class=\"logo-user\">\r\n");
      out.write("              <i class=\"ti ti-user icon\"></i>\r\n");
      out.write("       </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"body\">\r\n");
      out.write("      <div class=\"list-quiz-button\">\r\n");
      out.write("        <span class=\"text-button\">List Exam</span>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"add-question\">\r\n");
      out.write("        <i class=\"ti ti-plus icon\"></i>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"delete\">\r\n");
      out.write("        <i class=\"ti ti-trash icon\" title=\"Delete\"></i>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"update\">\r\n");
      out.write("        <i class=\"ti ti-settings icon\" title=\"Update\"></i>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"question\">\r\n");
      out.write("        <div class=\"content-question\">\r\n");
      out.write("          <span class=\"text-question\"></span>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"answers\">\r\n");
      out.write("          <div class=\"answerA\" >\r\n");
      out.write("            <span class=\"text-answer\" id =\"1\"></span>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"answerB\">\r\n");
      out.write("            <span class=\"text-answer\"  id =\"2\"></span>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"answerC\">\r\n");
      out.write("            <span class=\"text-answer\"  id =\"3\"></span>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"answerD\">\r\n");
      out.write("            <span class=\"text-answer\"  id =\"4\"></span>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"footer\">\r\n");
      out.write("      <div class=\"back-button\">\r\n");
      out.write("        <span class=\"text-button\">Back</span>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"num-questions\"></div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"next-button\">\r\n");
      out.write("        <span class=\"text-button\">Next</span>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("     // homeButton\r\n");
      out.write("         document.addEventListener(\"DOMContentLoaded\", () => {\r\n");
      out.write("         const homeButton = document.querySelector(\".home\");\r\n");
      out.write("         homeButton.addEventListener(\"click\", () => {\r\n");
      out.write("         const urlHomePage = \"http://localhost:8080/QuesApp/home\";\r\n");
      out.write("         window.location.href = urlHomePage;\r\n");
      out.write("         });\r\n");
      out.write("       });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("     // listExamButton\r\n");
      out.write("   document.addEventListener(\"DOMContentLoaded\", () => {\r\n");
      out.write("   const listQuizButton = document.querySelector(\".list-quiz-button\");\r\n");
      out.write("   listQuizButton.addEventListener(\"click\",  () => {\r\n");
      out.write("    const urlListExamPage = \"http://localhost:8080/QuesApp/exams\"\r\n");
      out.write("    window.location.href = urlListExamPage;\r\n");
      out.write("   });\r\n");
      out.write(" });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("     // addButton\r\n");
      out.write("   document.addEventListener(\"DOMContentLoaded\", () => {\r\n");
      out.write("   const addQuestionButton = document.querySelector(\".add-question\");\r\n");
      out.write("   addQuestionButton.addEventListener(\"click\",  () => {\r\n");
      out.write("    const urlCreateQuestionFormPage = \"http://localhost:8080/QuesApp/createQuestionForm\"\r\n");
      out.write("    window.location.href = urlCreateQuestionFormPage;\r\n");
      out.write("   });\r\n");
      out.write(" });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("     // renderQuestion\r\n");
      out.write("    let questionsData;\r\n");
      out.write("    let indexCurrentQuestion = 0;\r\n");
      out.write("\r\n");
      out.write("         document.addEventListener(\"DOMContentLoaded\",async ()=>{\r\n");
      out.write("                 try {\r\n");
      out.write("                         questionsData = await getQuestionsData();\r\n");
      out.write("                         let data = questionsData.data\r\n");
      out.write("                         console.log(data);\r\n");
      out.write("                         renderPositionAndNumQuestions(data, indexCurrentQuestion);\r\n");
      out.write("                         renderQuestion(data,indexCurrentQuestion);\r\n");
      out.write("\r\n");
      out.write("                     } catch (error) {\r\n");
      out.write("                         alert(error.message);\r\n");
      out.write("                     }\r\n");
      out.write("         });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("     async function myFetch(url, options) {\r\n");
      out.write("           try {\r\n");
      out.write("             const response = await fetch(url, options);\r\n");
      out.write("             return response;\r\n");
      out.write("           } catch (error) {\r\n");
      out.write("             alert(error.message);\r\n");
      out.write("           }\r\n");
      out.write("         }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    // lay du lieu tat ca cac cau\r\n");
      out.write("        async function getQuestionsData() {\r\n");
      out.write("          const idSubject = localStorage.getItem(\"idSubject\")\r\n");
      out.write("          const url = `http://localhost:8080/QuesApp/auth/questions?subject=${idSubject}`;\r\n");
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
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        // render ra mot cau\r\n");
      out.write("        function renderQuestion(data, indexCurrentQuestion){\r\n");
      out.write("               // lay du lieu tu cau hoi hien tai\r\n");
      out.write("               const currentQuestion = data[indexCurrentQuestion];\r\n");
      out.write("\r\n");
      out.write("               const idQuestion = currentQuestion.idQuestion;\r\n");
      out.write("               localStorage.setItem(\"idQuestion\",idQuestion);\r\n");
      out.write("\r\n");
      out.write("               // lay ra thong tin cua cau hoi hien tai\r\n");
      out.write("               const contentQuestion = currentQuestion.content;\r\n");
      out.write("\r\n");
      out.write("               // render ra noi dung cau hoi\r\n");
      out.write("               const questionContentElement = document.querySelector(\".text-question\");\r\n");
      out.write("               questionContentElement.textContent = contentQuestion;\r\n");
      out.write("\r\n");
      out.write("               // lay thon tin cac dap an\r\n");
      out.write("               const answers = currentQuestion.answers;\r\n");
      out.write("\r\n");
      out.write("               // render ra noi dung dap an\r\n");
      out.write("               let i = 1;\r\n");
      out.write("               answers.forEach( answer => {\r\n");
      out.write("                const answerContent = answer.contentOption;\r\n");
      out.write("                const answerContentElement = document.getElementById(i.toString());\r\n");
      out.write("                answerContentElement.textContent = answerContent;\r\n");
      out.write("                i++;\r\n");
      out.write("\r\n");
      out.write("               });\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        // render ra so luong cau hoi va vi tri cau hien tai\r\n");
      out.write("        function renderPositionAndNumQuestions(data, indexCurrentQuestion){\r\n");
      out.write("            const index = indexCurrentQuestion + 1;\r\n");
      out.write("            const numQuestion = data.length;\r\n");
      out.write("            const numQuestionElement = document.querySelector(\".num-questions\");\r\n");
      out.write("            if(numQuestion === 0){\r\n");
      out.write("                numQuestionElement.textContent = `0/${numQuestion}`;\r\n");
      out.write("            }\r\n");
      out.write("        else{\r\n");
      out.write("\r\n");
      out.write("            numQuestionElement.textContent = `${index}/${numQuestion}`;\r\n");
      out.write("        }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        // click next render ra cau tiep theo an cau mot\r\n");
      out.write("        document.querySelector(\".next-button\").addEventListener(\"click\", () => {\r\n");
      out.write("            if (indexCurrentQuestion < questionsData.data.length-1) {\r\n");
      out.write("                indexCurrentQuestion++;\r\n");
      out.write("                console.log(indexCurrentQuestion);\r\n");
      out.write("                renderPositionAndNumQuestions(questionsData.data, indexCurrentQuestion);\r\n");
      out.write("                renderQuestion(questionsData.data,indexCurrentQuestion);\r\n");
      out.write("\r\n");
      out.write("                } else {\r\n");
      out.write("                    alert(\"This is the last question!\")\r\n");
      out.write("                 }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        // click back button render ra cau truoc an cau mot\r\n");
      out.write("         document.querySelector(\".back-button\").addEventListener(\"click\", () => {\r\n");
      out.write("                    if (indexCurrentQuestion > 0) {\r\n");
      out.write("                        indexCurrentQuestion--;\r\n");
      out.write("                        console.log(indexCurrentQuestion);\r\n");
      out.write("                        renderPositionAndNumQuestions(questionsData.data, indexCurrentQuestion);\r\n");
      out.write("                        renderQuestion(questionsData.data,indexCurrentQuestion);\r\n");
      out.write("\r\n");
      out.write("                        } else {\r\n");
      out.write("                            alert(\"No previous question!\")\r\n");
      out.write("                         }\r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("         // deleteButton\r\n");
      out.write("         document.addEventListener(\"DOMContentLoaded\", () => {\r\n");
      out.write("           const deleteButton = document.querySelector(\".delete\");\r\n");
      out.write("           deleteButton.addEventListener(\"click\",  async () => {\r\n");
      out.write("               await deleteQuestionById();\r\n");
      out.write("\r\n");
      out.write("           });\r\n");
      out.write("         });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        async function sendIdQuestionToDelete(idQuestion) {\r\n");
      out.write("                  const url = `http://localhost:8080/QuesApp/auth/questions?id=${idQuestion}`;\r\n");
      out.write("                  const options = {\r\n");
      out.write("                    method: \"DELETE\",\r\n");
      out.write("                    headers: {\r\n");
      out.write("                      \"Content-Type\": \"application/json\",\r\n");
      out.write("                    },\r\n");
      out.write("                  };\r\n");
      out.write("\r\n");
      out.write("                 try {\r\n");
      out.write("                               const response = await myFetch(url, options);\r\n");
      out.write("                               if (response.status === 204) {\r\n");
      out.write("                                     return { success: true, message: `Delete question with id ${idQuestion} successful`};\r\n");
      out.write("                                       }\r\n");
      out.write("                               else{\r\n");
      out.write("                               const responseData = await response.json();\r\n");
      out.write("                               return { success: false, message: responseData.message };\r\n");
      out.write("                               }\r\n");
      out.write("                               } catch (error) {\r\n");
      out.write("                               alert(error.message);\r\n");
      out.write("                               }\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                async function deleteQuestionById(){\r\n");
      out.write("                    try{\r\n");
      out.write("                        const idQuestion = localStorage.getItem(\"idQuestion\");\r\n");
      out.write("                        const messageAfterDelete = await sendIdQuestionToDelete(idQuestion);\r\n");
      out.write("                        if (messageAfterDelete.success) {\r\n");
      out.write("                            alert(messageAfterDelete.message);\r\n");
      out.write("                            location.reload();\r\n");
      out.write("                            } else {\r\n");
      out.write("                            throw new Error(messageAfterDelete.message);\r\n");
      out.write("                            }\r\n");
      out.write("                    }\r\n");
      out.write("                    catch(error){\r\n");
      out.write("                    alert(error.message)\r\n");
      out.write("                    }\r\n");
      out.write("                  }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("         // updateButton\r\n");
      out.write("        document.addEventListener(\"DOMContentLoaded\", () => {\r\n");
      out.write("        const updateButton = document.querySelector(\".update\");\r\n");
      out.write("        updateButton.addEventListener(\"click\", () => {\r\n");
      out.write("              const urlUpdateFormQuestionPage = \"http://localhost:8080/QuesApp/updateQuestionForm\";\r\n");
      out.write("              window.location.href = urlUpdateFormQuestionPage;\r\n");
      out.write("         });\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("     </script>\r\n");
      out.write("\r\n");
      out.write("  </body>\r\n");
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