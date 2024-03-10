/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2024-03-02 18:06:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOC TYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"UTF-8\" />\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("    <link\r\n");
      out.write("      rel=\"stylesheet\"\r\n");
      out.write("      href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\"/>\r\n");
      out.write("<link href=\"\r\n");
      out.write("https://cdn.jsdelivr.net/npm/@icon/themify-icons@1.0.1-alpha.3/themify-icons.min.css\r\n");
      out.write("\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("     body {\r\n");
      out.write("       background: linear-gradient(90deg, #c7c5f4, #776bcc);\r\n");
      out.write("       margin: 0;\r\n");
      out.write("       font-family: \"Raleway\", sans-serif;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .header,\r\n");
      out.write("     .content {\r\n");
      out.write("       margin: auto;\r\n");
      out.write("       padding: 20px;\r\n");
      out.write("       width: 80%;\r\n");
      out.write("       box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.1);\r\n");
      out.write("       backdrop-filter: blur(5px); /* Apply blur effect */\r\n");
      out.write("       border: 3px solid #a69ced; /* Lighter shade border color */\r\n");
      out.write("       border-radius: 10px; /* Adjust border radius as needed */\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .header {\r\n");
      out.write("       display: flex;\r\n");
      out.write("       justify-content: space-around;\r\n");
      out.write("       align-items: center;\r\n");
      out.write("       background: rgba(255, 255, 255, 0.2); /* White with 20% opacity */\r\n");
      out.write("       margin-bottom: 20px;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .header div {\r\n");
      out.write("       width: 40px;\r\n");
      out.write("       height: 40px;\r\n");
      out.write("       background: #bcb6eb;\r\n");
      out.write("       margin: 0 5px;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .header .home,\r\n");
      out.write("     .header .historyButton,\r\n");
      out.write("     .header .add-subject,\r\n");
      out.write("     .header .logo-user {\r\n");
      out.write("       width: 40px;\r\n");
      out.write("       height: 40px;\r\n");
      out.write("       border-radius: 50%;\r\n");
      out.write("       margin: 0 5px;\r\n");
      out.write("       cursor: pointer;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
      out.write("       padding: 3px 6px;\r\n");
      out.write("       border-radius: 5px;\r\n");
      out.write("       font-size: 12px;\r\n");
      out.write("       z-index: 999;\r\n");
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
      out.write("     .content {\r\n");
      out.write("       height: 640px;\r\n");
      out.write("       background: rgba(255, 255, 255, 0.2);\r\n");
      out.write("       position: relative;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .content .subject {\r\n");
      out.write("       display: flex;\r\n");
      out.write("       justify-content: space-between;\r\n");
      out.write("       align-items: center;\r\n");
      out.write("       background: rgba(255, 255, 255, 0.7);\r\n");
      out.write("       padding: 10px 20px;\r\n");
      out.write("       border-radius: 8px;\r\n");
      out.write("       margin-bottom: 10px;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .content .subject {\r\n");
      out.write("       cursor: pointer;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .content .subject .delete,\r\n");
      out.write("     .content .subject .update {\r\n");
      out.write("       padding: 5px 10px;\r\n");
      out.write("       background: #bcb6eb;\r\n");
      out.write("       color: white;\r\n");
      out.write("       border-radius: 5px;\r\n");
      out.write("       transition: background 0.3s ease;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .delete i,\r\n");
      out.write("     .update i {\r\n");
      out.write("       font-size: 16px;\r\n");
      out.write("       color: #757575;\r\n");
      out.write("       transition: color 0.3s ease;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .content .subject .delete:hover i,\r\n");
      out.write("     .content .subject .update:hover i {\r\n");
      out.write("       color: white;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .content .subject:hover {\r\n");
      out.write("       background-color: #6b4d7e;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .subject .icon {\r\n");
      out.write("       font-size: 20px;\r\n");
      out.write("       color: #757575;\r\n");
      out.write("       position: relative;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .subject .icon:hover {\r\n");
      out.write("       color: whitesmoke;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .subject .icon:hover ~ div {\r\n");
      out.write("       filter: blur(2px);\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .subject .icon[title]:hover::after {\r\n");
      out.write("       content: attr(title);\r\n");
      out.write("       position: absolute;\r\n");
      out.write("       left: 50%;\r\n");
      out.write("       top: 10px;\r\n");
      out.write("       transform: translateX(-50%) translateY(100%);\r\n");
      out.write("       background-color: #6a679e;\r\n");
      out.write("       color: white;\r\n");
      out.write("       padding: 3px 6px;\r\n");
      out.write("       border-radius: 5px;\r\n");
      out.write("       font-size: 12px;\r\n");
      out.write("\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     </style>\r\n");
      out.write("\r\n");
      out.write("    <title>Home</title>\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("    <div class=\"header\">\r\n");
      out.write("      <div class=\"home\">\r\n");
      out.write("        <i class=\"ti ti-home icon\" title=\"Home\"></i>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"historyButton\">\r\n");
      out.write("        <i class=\"ti ti-bar-chart icon\" title=\"History\"></i>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"search\">\r\n");
      out.write("        <input\r\n");
      out.write("          type=\"text\"\r\n");
      out.write("          class=\"search_input\"\r\n");
      out.write("          placeholder=\"Enter Name Your Subject\"\r\n");
      out.write("        />\r\n");
      out.write("        <i class=\"ti ti-search\"></i>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"add-subject\">\r\n");
      out.write("        <i class=\"ti ti-plus icon\" title=\"Create\"></i>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"logo-user\">\r\n");
      out.write("        <i class=\"ti ti-user icon\"></i>\r\n");
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"content\">\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <script >\r\n");
      out.write("    document.addEventListener(\r\n");
      out.write("      \"DOMContentLoaded\",\r\n");
      out.write("      async () => {\r\n");
      out.write("      await renderSubjects();\r\n");
      out.write("      await engageSubject();\r\n");
      out.write("  });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    async function myFetch(url, options) {\r\n");
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
      out.write("    async function getSubjectsData() {\r\n");
      out.write("      const url = \"http://localhost:8080/QuesApp/auth/subjects\";\r\n");
      out.write("\r\n");
      out.write("      const options = {\r\n");
      out.write("        method: \"GET\",\r\n");
      out.write("        headers: {\r\n");
      out.write("          \"Content-Type\": \"application/json\",\r\n");
      out.write("        },\r\n");
      out.write("      };\r\n");
      out.write("\r\n");
      out.write("      try {\r\n");
      out.write("        const response = await myFetch(url, options);\r\n");
      out.write("        const responseData = await response.json();\r\n");
      out.write("        return responseData;\r\n");
      out.write("      } catch (error) {\r\n");
      out.write("        alert(error.message);\r\n");
      out.write("      }\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write(" async function renderSubjects() {\r\n");
      out.write("     try {\r\n");
      out.write("         const subjects = await getSubjectsData();\r\n");
      out.write("         const data = subjects.data;\r\n");
      out.write("         console.log(\"phuc\",data)\r\n");
      out.write("\r\n");
      out.write("         const contentContainer = document.querySelector(\".content\");\r\n");
      out.write("         contentContainer.innerHTML = \"\";\r\n");
      out.write("\r\n");
      out.write("         data.forEach(subject => {\r\n");
      out.write("             const subjectElement = document.createElement('div');\r\n");
      out.write("             subjectElement.classList.add('subject');\r\n");
      out.write("             subjectElement.setAttribute('data', subject.id);\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("             const deleteElement = document.createElement('div');\r\n");
      out.write("             deleteElement.classList.add('delete');\r\n");
      out.write("             deleteElement.innerHTML = '<i class=\"ti ti-trash icon\" title=\"Delete\"></i>';\r\n");
      out.write("\r\n");
      out.write("             const nameElement = document.createElement('div');\r\n");
      out.write("             nameElement.classList.add('name-subject');\r\n");
      out.write("             nameElement.textContent = subject.nameSubject;\r\n");
      out.write("\r\n");
      out.write("             const updateElement = document.createElement('div');\r\n");
      out.write("             updateElement.classList.add('update');\r\n");
      out.write("\r\n");
      out.write("             updateElement.innerHTML = '<i class=\"ti ti-settings icon\" title=\"Update\"></i>';\r\n");
      out.write("\r\n");
      out.write("             subjectElement.appendChild(deleteElement);\r\n");
      out.write("             subjectElement.appendChild(nameElement);\r\n");
      out.write("             subjectElement.appendChild(updateElement);\r\n");
      out.write("\r\n");
      out.write("             contentContainer.appendChild(subjectElement);\r\n");
      out.write("         });\r\n");
      out.write("     } catch (error) {\r\n");
      out.write("         console.log(\"phuc1\");\r\n");
      out.write("         alert(error.message);\r\n");
      out.write("     }\r\n");
      out.write(" }\r\n");
      out.write("\r\n");
      out.write(" // history\r\n");
      out.write("\r\n");
      out.write(" document.addEventListener(\"DOMContentLoaded\", () => {\r\n");
      out.write("   const historyButton = document.querySelector(\".historyButton\");\r\n");
      out.write("   historyButton.addEventListener(\"click\",  () => {\r\n");
      out.write("   const urlHistoryPage = \"http://localhost:8080/QuesApp/history\";\r\n");
      out.write("   window.location.href = urlHistoryPage;\r\n");
      out.write("   });\r\n");
      out.write(" });\r\n");
      out.write("\r\n");
      out.write("// home\r\n");
      out.write("document.addEventListener(\"DOMContentLoaded\", () => {\r\n");
      out.write("   const homeButton = document.querySelector(\".home\");\r\n");
      out.write("   homeButton.addEventListener(\"click\",  () => {\r\n");
      out.write("   location.reload();\r\n");
      out.write("   });\r\n");
      out.write(" });\r\n");
      out.write("\r\n");
      out.write(" //add subject\r\n");
      out.write(" document.addEventListener(\"DOMContentLoaded\", () => {\r\n");
      out.write("    const addSubjectButton = document.querySelector(\".add-subject\");\r\n");
      out.write("    addSubjectButton.addEventListener(\"click\",  () => {\r\n");
      out.write("    const urlSubjectPage =  \"http://localhost:8080/QuesApp/subjects\";\r\n");
      out.write("    window.location.href = urlSubjectPage;\r\n");
      out.write("\r\n");
      out.write("    });\r\n");
      out.write("  });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  // deleteButton\r\n");
      out.write("  // sau su kien render ra mon hoc\r\n");
      out.write("\r\n");
      out.write("  async function sendIdSubject(idSubject){\r\n");
      out.write("        const url = `http://localhost:8080/QuesApp/auth/subjects?id=${idSubject}`;\r\n");
      out.write("        const options = {\r\n");
      out.write("        method: \"DELETE\",\r\n");
      out.write("        headers: {\r\n");
      out.write("           \"Content-Type\": \"application/json\",\r\n");
      out.write("           },\r\n");
      out.write("         };\r\n");
      out.write("\r\n");
      out.write("         try {\r\n");
      out.write("              const response = await myFetch(url, options);\r\n");
      out.write("              if (response.status === 204) {\r\n");
      out.write("                    return { success: true, message: `Delete subject with id ${idSubject} successful`};\r\n");
      out.write("                      }\r\n");
      out.write("              else{\r\n");
      out.write("              const responseData = await response.json();\r\n");
      out.write("              return { success: false, message: responseData.message };\r\n");
      out.write("              }\r\n");
      out.write("              } catch (error) {\r\n");
      out.write("              alert(error.message);\r\n");
      out.write("              }\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  async function deleteSubjectById(idSubject){\r\n");
      out.write("    try{\r\n");
      out.write("        const messageAfterDelete = await sendIdSubject(idSubject);\r\n");
      out.write("        if (messageAfterDelete.success) {\r\n");
      out.write("            alert(messageAfterDelete.message);\r\n");
      out.write("            location.reload();\r\n");
      out.write("            } else {\r\n");
      out.write("            throw new Error(messageAfterDelete.message);\r\n");
      out.write("            }\r\n");
      out.write("    }\r\n");
      out.write("    catch(error){\r\n");
      out.write("    alert(error.message)\r\n");
      out.write("    }\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  // update\r\n");
      out.write("  // direct forward update form\r\n");
      out.write("\r\n");
      out.write("async function directForwardUpdateForm(){\r\n");
      out.write("    const urlUpdateSubjectForm = \"http://localhost:8080/QuesApp/formUpdateSubject\";\r\n");
      out.write("    window.location.href = urlUpdateSubjectForm;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("// listQuestion\r\n");
      out.write("async function engageSubject(){\r\n");
      out.write("   const subjects = document.querySelectorAll(\".subject\");\r\n");
      out.write("   subjects.forEach(subject => {\r\n");
      out.write("       const idSubject = subject.getAttribute('data');\r\n");
      out.write("       subject.addEventListener(\"click\", async (event) => {\r\n");
      out.write("           const clickedElement = event.target;\r\n");
      out.write("           if (clickedElement.classList.contains(\"delete\")|| clickedElement.parentElement.classList.contains(\"delete\")) {\r\n");
      out.write("               event.stopImmediatePropagation();\r\n");
      out.write("               await deleteSubjectById(idSubject);\r\n");
      out.write("           } else if (clickedElement.classList.contains(\"update\")|| clickedElement.parentElement.classList.contains(\"update\")) {\r\n");
      out.write("               event.stopImmediatePropagation();\r\n");
      out.write("               localStorage.setItem(\"idSubject\",idSubject);\r\n");
      out.write("               await directForwardUpdateForm();\r\n");
      out.write("           } else {\r\n");
      out.write("               localStorage.setItem(\"idSubject\",idSubject);\r\n");
      out.write("               const urlListQuestionPage = \"http://localhost:8080/QuesApp/listQuestions\";\r\n");
      out.write("               window.location.href = urlListQuestionPage;\r\n");
      out.write("           }\r\n");
      out.write("       });\r\n");
      out.write("   });\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
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
