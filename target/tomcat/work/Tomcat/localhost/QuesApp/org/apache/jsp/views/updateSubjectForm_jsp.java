/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2024-03-06 07:07:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class updateSubjectForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Subject</title>\r\n");
      out.write("    <style>\r\n");
      out.write("\r\n");
      out.write("     body {\r\n");
      out.write("         font-family: \"Arial\", sans-serif;\r\n");
      out.write("         background: linear-gradient(90deg, #c7c5f4, #776bcc);\r\n");
      out.write("         margin: 0;\r\n");
      out.write("         padding: 0;\r\n");
      out.write("       }\r\n");
      out.write("\r\n");
      out.write("       .container {\r\n");
      out.write("         max-width: 800px;\r\n");
      out.write("         margin: 50px auto;\r\n");
      out.write("         padding: 20px;\r\n");
      out.write("         background-color: rgba(255, 255, 255, 0.9);\r\n");
      out.write("         border-radius: 8px;\r\n");
      out.write("         box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\r\n");
      out.write("       }\r\n");
      out.write("\r\n");
      out.write("       h2 {\r\n");
      out.write("         text-align: center;\r\n");
      out.write("         color: #6c63ac;\r\n");
      out.write("       }\r\n");
      out.write("\r\n");
      out.write("       .form-group {\r\n");
      out.write("         margin-bottom: 20px;\r\n");
      out.write("       }\r\n");
      out.write("\r\n");
      out.write("       label {\r\n");
      out.write("         font-weight: bold;\r\n");
      out.write("         color: #6c63ac;\r\n");
      out.write("         display: block;\r\n");
      out.write("       }\r\n");
      out.write("\r\n");
      out.write("       input[type=\"text\"] {\r\n");
      out.write("         width: calc(100% - 20px);\r\n");
      out.write("         padding: 10px;\r\n");
      out.write("         margin-top: 5px;\r\n");
      out.write("         margin-bottom: 10px;\r\n");
      out.write("         border: 1px solid #ccc;\r\n");
      out.write("         border-radius: 4px;\r\n");
      out.write("         box-sizing: border-box;\r\n");
      out.write("       }\r\n");
      out.write("\r\n");
      out.write("       button[type=\"submit\"],\r\n");
      out.write("        {\r\n");
      out.write("         padding: 12px 24px; /* Điều chỉnh kích thước nút */\r\n");
      out.write("         background-color: #6c63ac;\r\n");
      out.write("         color: #fff;\r\n");
      out.write("         border: none;\r\n");
      out.write("         border-radius: 5px;\r\n");
      out.write("         font-size: 16px; /* Đặt kích thước chữ cho nút */\r\n");
      out.write("         cursor: pointer;\r\n");
      out.write("         transition: background-color 0.3s;\r\n");
      out.write("         display: block;\r\n");
      out.write("         margin: 0 auto; /* Canh giữa nút */\r\n");
      out.write("       }\r\n");
      out.write("\r\n");
      out.write("       button[type=\"submit\"]:hover {\r\n");
      out.write("         background-color: #564c88;\r\n");
      out.write("       }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        button[type=\"button\"] {\r\n");
      out.write("            padding: 12px 24px;\r\n");
      out.write("            background-color: #6c63ac;\r\n");
      out.write("            color: #fff;\r\n");
      out.write("            border: none;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("            font-size: 16px;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            transition: background-color 0.3s;\r\n");
      out.write("            display: block;\r\n");
      out.write("            margin: 10px auto; /* Canh giữa nút và thêm khoảng cách dưới */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        button[type=\"button\"]:hover {\r\n");
      out.write("            background-color: #564c88;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("     </style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <h2>Subject</h2>\r\n");
      out.write("        <div id=\"subjectForm\">\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <label for=\"subject\">Name Subject:</label>\r\n");
      out.write("                <input type=\"text\" id=\"subject\" name=\"subject\" required />\r\n");
      out.write("            </div>\r\n");
      out.write("            <button type=\"button\"  id=\"updateBtn\">Update</button>\r\n");
      out.write("            <button type=\"button\" onclick=\"window.history.back()\">Back</button>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    function getUserInput() {\r\n");
      out.write("            const subjectInput = document.getElementById(\"subject\");\r\n");
      out.write("            return subjectInput ;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("        document.addEventListener(\"DOMContentLoaded\", () => {\r\n");
      out.write("            const createBtn = document.getElementById(\"updateBtn\");\r\n");
      out.write("            const idSubject = localStorage.getItem(\"idSubject\");\r\n");
      out.write("            console.log(\"test\",idSubject);\r\n");
      out.write("            createBtn.addEventListener(\"click\", async (event) => {\r\n");
      out.write("                event.preventDefault();\r\n");
      out.write("                await updateSubject(getUserInput(),idSubject);\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        async function myFetch(url, options) {\r\n");
      out.write("          try {\r\n");
      out.write("            const response = await fetch(url, options);\r\n");
      out.write("            return response;\r\n");
      out.write("          } catch (error) {\r\n");
      out.write("            console.log(\"2\", error.message);\r\n");
      out.write("            alert(error.message);\r\n");
      out.write("          }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        async function sendUserDataForUpdate(idSubject,data){\r\n");
      out.write("                    const url = `http://localhost:8080/QuesApp/auth/subjects?id=${idSubject}`;\r\n");
      out.write("                      const options = {\r\n");
      out.write("                        method: \"PUT\",\r\n");
      out.write("                        headers: {\r\n");
      out.write("                          \"Content-Type\": \"application/json\",\r\n");
      out.write("                        },\r\n");
      out.write("                        body: JSON.stringify(data),\r\n");
      out.write("                      };\r\n");
      out.write("\r\n");
      out.write("                      try {\r\n");
      out.write("                        const response = await myFetch(url, options);\r\n");
      out.write("                        const responseData = await response.json();\r\n");
      out.write("                        return responseData;\r\n");
      out.write("                      } catch (error) {\r\n");
      out.write("                        console.log(\"phuc\");\r\n");
      out.write("                        alert(error.message);\r\n");
      out.write("                      }\r\n");
      out.write("                    }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                     async function updateSubject(subjectInput,idSubject) {\r\n");
      out.write("                          const name = subjectInput;\r\n");
      out.write("\r\n");
      out.write("                          if(name) {\r\n");
      out.write("                            const subject = {\r\n");
      out.write("                              nameSubject : name.value\r\n");
      out.write("                            };\r\n");
      out.write("\r\n");
      out.write("                            try {\r\n");
      out.write("                              const responseSubject = await sendUserDataForUpdate(idSubject,subject);\r\n");
      out.write("                              console.log(\"lc\", responseSubject);\r\n");
      out.write("                              localStorage.removeItem(\"idSubject\");\r\n");
      out.write("                              if (responseSubject.success) {\r\n");
      out.write("                              alert(responseSubject.message);\r\n");
      out.write("                                const urlHomePage = \"http://localhost:8080/QuesApp/home\";\r\n");
      out.write("                                window.location.href = urlHomePage;\r\n");
      out.write("                              } else {\r\n");
      out.write("                                throw new Error(responseSubject.message);\r\n");
      out.write("                              }\r\n");
      out.write("                            } catch (error) {\r\n");
      out.write("                              console.log(\"phuc1\");\r\n");
      out.write("                              alert(error.message);\r\n");
      out.write("                            }\r\n");
      out.write("                          } else {\r\n");
      out.write("                            console.error(\"Không thể tìm thấy các phần tử input.\");\r\n");
      out.write("                          }\r\n");
      out.write("                        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("     </script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
