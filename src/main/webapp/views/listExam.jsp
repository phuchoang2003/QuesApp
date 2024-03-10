<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
    />
    <link href="
    https://cdn.jsdelivr.net/npm/@icon/themify-icons@1.0.1-alpha.3/themify-icons.min.css
    " rel="stylesheet">

    <style>
     body {
       background: linear-gradient(90deg, #c7c5f4, #776bcc);
       margin: 0;
       font-family: "Raleway", sans-serif;
       margin-top: 100px;
     }

     html {
       font-size: 62.5%;
     }

    .header .home,
             .header .logo-user {
                    width: 40px;
                    height: 40px;
                    border-radius: 50%;
                    margin: 0 5px;
                    cursor: pointer;
              }


     .header,
     .body,
     .footer {
       margin: auto;
       padding: 20px;
       width: 80%;
       backdrop-filter: blur(5px);
     }

     .header {
       display: flex;
       justify-content: space-between;
       align-items: center;
       background: rgba(255, 255, 255, 0.7);
     }

     .header div {
       width: 40px;
       height: 40px;
       background: #bcb6eb;
       margin: 0 5px;
       border-radius: 50%;
     }

     .header .ti-search {
       font-size: 20px;
       color: #757575;
       border: 2px solid #757575;
       border-radius: 50%;
       padding: 10px;
       transition: all 0.3s ease;
       margin-right: 10px;
     }

     .header .ti-search:hover {
       background-color: #6a679e;
       color: #fff;
     }

     .header .icon {
       font-size: 20px;
       color: #757575;
       font-weight: 550;
       display: flex;
       justify-content: center;
       align-items: center;
       line-height: 40px;
       text-align: center;
       transition: transform 0.3s ease, box-shadow 0.3s ease, color 0.3s ease;
       border-radius: 50%;
       position: relative;
     }

     .header .icon:hover {
       box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.3);
       color: whitesmoke;
     }

     .header .icon:hover ~ div {
       filter: blur(2px);
     }

     .header .icon[title]:hover::after {
       content: attr(title);
       position: absolute;
       left: 50%;
       transform: translateX(-50%) translateY(100%);
       background-color: #6a679e;
       color: white;
       font-size: 12px;
       z-index: 999;
     }

     .header .search {
       flex-grow: 1;
       height: 60px;
       background: #fff;
       border-radius: 30px;
       margin: 0 5px;
       display: flex;
       align-items: center;
     }

     .header .search_input {
       border: none;
       outline: none;
       background: none;
       padding: 10px;
       padding-left: 24px;
       padding-right: 24px;
       font-weight: 700;
       width: 100%;
       transition: 0.2s;
       height: 40px;
       text-align: center;
       color: #5e5e5f;
     }

     .header .search_input:focus {
       border-bottom: 2px solid #6a679e;
     }

     .header .search_input::placeholder {
       color: #5e5e5f;
       font-weight: 700;
       opacity: 0.7;
     }

     .header .search:hover .search_input::placeholder {
       opacity: 1;
     }

     .header .search:hover .search_input {
       border-bottom: 2px solid #6a679e;
     }

     .header .logo-user {
       overflow: hidden;
     }

     .header .logo-user img {
       width: 100%;
       height: 100%;
       object-fit: cover;
     }

     .body {
       height: auto;
       background: rgba(255, 255, 255, 0.7);
     }


     .add-exam {
       padding: 12px 20px;
       background-color: #6c63ac;
       color: #fff;
       border: none;
       border-radius: 5px;
       cursor: pointer;
       transition: background-color 0.3s, color 0.3s;
       display: inline-flex;
       align-items: center;
       margin-left: 40px;
       font-size: 1.6rem;
     }

     .add-exam:hover {
       background: #564c88;
     }

     .list-exam {
       margin-top: 20px;
       font-size: 1.4rem;
     }

     .field-exam {
       width: 100%;
       border-collapse: collapse;
     }

     .field-exam th,
     .field-exam td {
       border: 1px solid #6c63ac;
       padding: 10px;
     }

     .field-exam th {
       background-color: #6c63ac;
       color: white;
       text-align: left;
     }

     .field-exam td {
       background-color: #f2f2f2;
     }

     .field-exam tr:hover {
       background-color: #e6e6e6;
     }

     .field-exam tr:hover td {
       color: #6c63ac;
     }

     .exam {
       font-size: 1.6rem;
     }

     .exam td,
     .exam th {
       padding: 12px;
     }

     .exam th {
       background-color: #6c63ac;
       color: white;
       text-align: left;
     }

     .exam td {
       background-color: #f2f2f2;
     }

     .exam tr:hover {
       background-color: #e6e6e6;
     }

     .exam tr:hover td {
       color: #6c63ac;
     }

     .action-buttons {
       text-align: center;
     }

     .start-quiz-button,
     .action-button {
       padding: 8px 16px;
       background-color: #6c63ac;
       color: #fff;
       border: none;
       border-radius: 5px;
       cursor: pointer;
       transition: background-color 0.3s, color 0.3s;
       margin-right: 5px;
     }

     .start-quiz-button:hover,
     .action-button:hover {
       background-color: #564c88;
     }


     </style>


    <title>List Exam</title>
  </head>

  <body>
    <div class="header">
      <div class="home">
        <i class="ti ti-home icon" title="Home"></i>
      </div>
      <div class="search">
        <input
          type="text"
          class="search_input"
          placeholder="Enter Name Your Subject"
        />
        <i class="ti ti-search"></i>
      </div>
      <div class="logo-user">
        <i class="ti ti-user icon"></i>
      </div>
      </div>
    </div>

    <div class="body">
      <div class="add-exam">
        <i class="ti ti-plus icon"></i>
      </div>

      <div class="list-exam">
        <table class="field-exam">
          <thead>
            <tr>
              <th>ID</th>
              <th>Name Exam</th>
              <th>Number Question</th>
              <th>Time</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody class="exam">

          </tbody>
        </table>
      </div>
    </div>
    <script>
      // home button

        document.addEventListener("DOMContentLoaded", () => {
        const homeButton = document.querySelector(".home");
        homeButton.addEventListener("click",  () => {
        const urlHomePage = "http://localhost:8080/QuesApp/home";
        window.location.href = urlHomePage;
            });
        });


      // addExam button
      document.addEventListener("DOMContentLoaded", () => {
          const addExamButton = document.querySelector(".add-exam");
          addExamButton.addEventListener("click",  () => {
          const createExamFormPage = "http://localhost:8080/QuesApp/createExamForm";
          window.location.href = createExamFormPage;
              });
          });


      // render infor exam

      document.addEventListener("DOMContentLoaded",async () => {
            await renderExams();
            await engageExam();
          });



           async function myFetch(url, options) {
             try {
               const response = await fetch(url, options);
               console.log("phuc",response);
               return response;
             } catch (error) {
               console.log("2", error.message);
               alert(error.message);
             }
           }

      async function getExamData(idSubject) {
          const url = `http://localhost:8080/QuesApp/auth/exams?id_subject=${idSubject}`;

          const options = {
            method: "GET",
            headers: {
              "Content-Type": "application/json",
            },
          };

          try {
            const response = await myFetch(url, options);
            const responseData = await response.json();
            return responseData;
          } catch (error) {
            alert(error.message);
          }
        }

        async function renderExams() {
                try {
                  const idSubject = localStorage.getItem("idSubject");
                  const exams = await getExamData(idSubject);
                  const data = exams.data;
                  const ExamContainer = document.querySelector(".exam");
                  ExamContainer.innerHTML ="";

                  // id
                  let id = 1;

                  data.forEach((exam) => {
                    // row
                    const rowElement = document.createElement("tr");
                    rowElement.classList.add("row-exam")
                    rowElement.setAttribute("data",exam.idExam);

                     rowElement.innerHTML = `
                            <td>${id++}</td>
                            <td>${exam.nameExam}</td>
                            <td>${exam.numberQuestion}</td>
                            <td>${exam.timeLimit / 60} minutes</td>
                            <td class="action-buttons">
                            <button class="action-button ti ti-trash icon delete"></button>
                            <button class="start-quiz-button">Take</button>
                            </td>
                          `;


                    // append
                    ExamContainer.appendChild(rowElement);
                  });
                   console.log(exams);
                          } catch (error) {
                            alert(error.message);
                          }
                        }


       //engange function

       async function engageExam(){
       const exams = document.querySelectorAll(".row-exam");
          exams.forEach(exam => {
              const idExam = exam.getAttribute('data');
              exam.addEventListener("click", async (event) => {
                  const clickedElement = event.target;
                  if (clickedElement.classList.contains("delete")|| clickedElement.parentElement.classList.contains("delete")) {
                      event.stopImmediatePropagation();
                      await deleteExamById(idExam);
                  } else if (clickedElement.classList.contains("update")|| clickedElement.parentElement.classList.contains("update")) {
                      event.stopImmediatePropagation();
                      console.log(idExam,"ronadlo")
                      localStorage.setItem("idExam",idExam);
                      const formUpdateExamUrlPage = "http://localhost:8080/QuesApp/updateExamForm";
                      window.location.href = formUpdateExamUrlPage;

                  } else if(clickedElement.classList.contains("start-quiz-button")|| clickedElement.parentElement.classList.contains("start-quiz-button")) {
                      localStorage.setItem("idExam",idExam);
                      const takeExamUrlPage = "http://localhost:8080/QuesApp/doExam";
                      window.location.href = takeExamUrlPage;
                  }
              });
          });


       }

    // delete button
    // send Id exam to delete
    async function sendIdExamToDelete(idExam){
            const url = `http://localhost:8080/QuesApp/auth/exams?id_exam=${idExam}`;
            const options = {
            method: "DELETE",
            headers: {
               "Content-Type": "application/json",
               },
             };

             try {
                  const response = await myFetch(url, options);
                  if (response.status === 204) {
                        return { success: true, message: `Delete exam with id ${idExam} successful`};
                          }
                  else{
                  const responseData = await response.json();
                  return { success: false, message: responseData.message };
                  }
                  } catch (error) {
                  alert(error.message);
                  }
      }

      async function deleteExamById(idExam){
        try{
            const messageAfterDelete = await sendIdExamToDelete(idExam);
            if (messageAfterDelete.success) {
                alert(messageAfterDelete.message);
                location.reload();
                } else {
                throw new Error(messageAfterDelete.message);
                }
        }
        catch(error){
        alert(error.message)
        }
      }
      </script>

  </body>


</html>
