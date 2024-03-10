<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>List of Questions</title>
    <style>
    body {
      font-family: Arial, sans-serif;
      background: linear-gradient(90deg, #c7c5f4, #776bcc);
      margin: 0;
      padding: 0;
    }

    .container {
      max-width: 800px;
      margin: 50px auto;
      padding: 20px;
      background-color: rgba(255, 255, 255, 0.9);
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h2 {
      text-align: center;
      color: #6c63ac;
      margin-bottom: 20px;
    }

    .question-list {
      margin-bottom: 20px;
    }

    .question-item {
      display: flex;
      align-items: center;
      justify-content: space-between;
      background-color: rgba(255, 255, 255, 0.7);
      padding: 15px;
      margin-bottom: 10px;
      border-radius: 5px;
    }

    .text-question {
      font-size: 1.2rem;
    }

    .checkbox-label {
      width: 20px;
      height: 20px;
      border: 1px solid #ccc;
      border-radius: 3px;
      display: inline-block;
      cursor: pointer;
    }

    .checkbox {
      display: none;
    }

    .checkbox:checked + .checkbox-label {
      background-color: #6c63ac;
    }

    .checkbox:checked + .checkbox-label::after {
      font-size: 14px;
      color: white;
    }

    button {
      width: 100%;
      padding: 10px;
      background-color: #6c63ac;
      color: #fff;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      transition: background-color 0.3s;
      margin-top: 10px;
    }

    button:hover {
      background-color: #8e86d8;
    }


    </style>

  </head>
  <body>
    <div class="container">
      <h2>From Add Question</h2>
      <div class="question-list">

      </div>
      <button id="addAllQuestionsSelectedBtn">Add All Questions Selected</button>
      <button id="addAllQuestionsBtn">Select All Questions</button>
    </div>

    <script>

     // render ra tat ca cau hoi
     document.addEventListener("DOMContentLoaded",async ()=>{
        await renderListQuestion();
     })

     async function myFetch(url, options) {
           try {
             const response = await fetch(url, options);
             return response;
           } catch (error) {
             alert(error.message);
           }
         }


     async function getQuestionsData(idSubject) {
           const url = `http://localhost:8080/QuesApp/auth/questions?subject=${idSubject}`;

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

     async function renderListQuestion() {
         try {
             const idSubject = localStorage.getItem("idSubject");
             const questions = await getQuestionsData(idSubject);
             const data = questions.data;
             console.log("phuc", data);

             const contentContainer = document.querySelector(".question-list");
             contentContainer.innerHTML = "";

             let numQuestion = 1;

             data.forEach(question => {
                 const questionItem = document.createElement('div');
                 questionItem.classList.add('question-item');

                 const questionText = document.createElement('span');
                 questionText.classList.add('text-question');
                 questionText.textContent = `Question ${numQuestion}: ${question.content}`;

                 const checkbox = document.createElement('input');
                 checkbox.type = 'checkbox';
                 checkbox.classList.add('checkbox');
                 checkbox.id = `question${numQuestion}`;
                 checkbox.setAttribute("data",question.idQuestion);

                 const label = document.createElement('label');
                 label.htmlFor = `question${numQuestion}`;
                 label.classList.add('checkbox-label');

                 questionItem.appendChild(questionText);
                 questionItem.appendChild(checkbox);
                 questionItem.appendChild(label);

                 contentContainer.appendChild(questionItem);

                 ++numQuestion;
             });
         } catch (error) {
             alert(error.message);
         }
     }


     // addAllQuestionsSelectedBtn
     document.addEventListener("DOMContentLoaded", () => {
         // Add event listener for the button to select all questions
         const addAllQuestionsSelectedButton = document.getElementById("addAllQuestionsSelectedBtn");
         addAllQuestionsSelectedButton.addEventListener("click", addAllSelectedQuestions);
     });


    function addAllSelectedQuestions() {
         // luu tat ca id cua cau hoi duoc chon vao mot mang
        const selectedQuestionIds = [];

        const checkboxes = document.querySelectorAll('.checkbox');
        checkboxes.forEach(checkbox => {
            if (checkbox.checked) {
                selectedQuestionIds.push(checkbox.getAttribute('data'));
            }
        });


        // luu vao localStorage de khi quay tro ve trang truoc co the dua vao day de goi API
        localStorage.setItem('selectedQuestionIds', JSON.stringify(selectedQuestionIds));


        // sau khi an them thi quay tro ve trang truoc
        const createExamFormUrlPage = "http://localhost:8080/QuesApp/createExamForm";
        window.location.href = createExamFormUrlPage;
    }





     // addAllQuestionsBtn
     document.addEventListener('DOMContentLoaded', () => {
         const selectAllButton = document.getElementById('addAllQuestionsBtn');
         selectAllButton.addEventListener('click', () => {
             const checkboxes = document.querySelectorAll('.checkbox');
             checkboxes.forEach(checkbox => {
                 checkbox.checked = !checkbox.checked;
                 checkbox.dispatchEvent(new Event('change'));
             });
         });
     });






    </script>
  </body>
</html>
