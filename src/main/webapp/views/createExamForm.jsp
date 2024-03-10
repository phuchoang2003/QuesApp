<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Create Exam</title>
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

    .form-group {
      margin-bottom: 20px;
    }

    label {
      font-weight: bold;
      color: #6c63ac;
    }

    input[type="text"],
    input[type="number"] {
      width: calc(100% - 20px);
      padding: 10px;
      margin-top: 5px;
      margin-bottom: 10px;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
    }

    button[type="button"],
    button[type="submit"] {
      width: 100%;
      padding: 10px;
      background-color: #8e86d8;
      color: #fff;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      transition: background-color 0.3s;
      margin-top: 20px;
    }

    button#addQuestionBtn {
      background-color: #8e86d8;
    }

    button#addQuestionBtn:hover {
      background-color: #776bcc;
    }

    .content-question {
      font-weight: bold;
      color: #6c63ac;
      font-size: 1.2rem;
      margin-bottom: 10px;
    }

    .question {
      background-color: rgba(255, 255, 255, 0.7);
      padding: 20px;
      margin-bottom: 20px;
      border-radius: 10px;
      font-size: 1.4rem;
    }

    .text-question {
      font-size: 1.2rem;
    }

    .answers {
      display: grid;
      grid-template-columns: repeat(2, 1fr);
      gap: 2rem;
      font-size: 1.2rem;
    }

    .answers div {
      background-color: rgba(255, 255, 255, 0.7);
      padding: 15px;
      margin-bottom: 10px;
      border-radius: 5px;
      border: 1px solid #ccc;
    }


    </style>

</head>
<body>
    <div class="container">
        <h2>Create Exam</h2>
        <form id="examForm">
            <div class="form-group">
                <label for="exam">Name Exam:</label>
                <input type="text" id="exam" name="exam" required />
            </div>
            <div class="form-group">
                <label for="timeLimit">Time Limit (minutes):</label>
                <input type="number" id="timeLimit" name="timeLimit" min="1" required />
            </div>
            <div id="questionsContainer">

                </div>

            <button type="button" id="addQuestionBtn">Add Question</button>
            <button type="submit" class ="createBtn">Create</button>
            <button type="button" class ="backBtn">Back</button>

        </form>
    </div>



 <script>
// add question button
document.addEventListener("DOMContentLoaded",()=>{
    const addQuestionButton = document.querySelector("#addQuestionBtn");
    addQuestionButton.addEventListener("click",()=>{
        // hien ra mot trang moi de them cau hoi
        const urlAddQuestionToExamPage = "http://localhost:8080/QuesApp/addQuestionToExam";
        window.location.href = urlAddQuestionToExamPage;
    })
})


// render ra question vua tich
document.addEventListener("DOMContentLoaded",async ()=>{
    await renderQuestionSelected();
    })



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




async function getQuestionsSelectedData(listIds){
    console.log(listIds);
    const url = `http://localhost:8080/QuesApp/auth/questions?ids=${listIds}`;

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


async function renderQuestionSelected() {
    try {
        const selectedQuestionIds = JSON.parse(localStorage.getItem("selectedQuestionIds"));
        const listIds = selectedQuestionIds.join(",");


        const questions = await getQuestionsSelectedData(listIds);
        const data = questions.data;

        const questionsContainer = document.getElementById("questionsContainer");
        questionsContainer.innerHTML = "";

        data.forEach((question, index) => {
            // Create a div element for the question
            const questionDiv = document.createElement("div");
            questionDiv.classList.add("form-group", "question");

            questionDiv.innerHTML = `
                <div class="content-question">
                    <span class="text-question">Question ${index + 1}: ${question.content}</span>
                </div>
                <div class="answers">
                    <div class="answerA">
                        <span class="text-answer">${question.answers[0].contentOption}</span>
                    </div>
                    <div class="answerB">
                        <span class="text-answer">${question.answers[1].contentOption}</span>
                    </div>
                    <div class="answerC">
                        <span class="text-answer">${question.answers[2].contentOption}</span>
                    </div>
                    <div class="answerD">
                        <span class="text-answer">${question.answers[3].contentOption}</span>
                    </div>
                </div>
            `;

            questionsContainer.appendChild(questionDiv);
        });
    } catch (error) {
        if(!error.message === "Cannot read properties of null (reading 'join')")
        alert(error.message);
    }
}

// get input user
function getInputUser(){
    const examValue = document.getElementById("exam").value;
    const timeLimitValue = document.getElementById("timeLimit").value;
    return {examValue,timeLimitValue};
}



// create exam button

    async function sendExamData(data){
            const idSubject = localStorage.getItem("idSubject");
            console.log("messi",idSubject);
            const url = `http://localhost:8080/QuesApp/auth/exams?id_subject=${idSubject}`;
              const options = {
                method: "POST",
                headers: {
                  "Content-Type": "application/json",
                },

                body: JSON.stringify(data),
              };

              try {
                const response = await myFetch(url, options);
                const responseData = await response.json();
                return responseData;
              } catch (error) {
                console.log("phuc");
                alert(error.message);
              }


    }

    async function createExam(inputValue){
        const questionIds = JSON.parse(localStorage.getItem("selectedQuestionIds"));

        const nameExam = inputValue.examValue;
        const timeLimit = inputValue.timeLimitValue;

        if(nameExam && timeLimit && questionIds) {
                           const exam = {
                                nameExam: nameExam,
                                timeLimit: timeLimit * 60,
                                questionIds: questionIds
                            };
                            console.log(JSON.stringify(exam));
        try {
                const responseData = await sendExamData(exam);
                if (responseData.success) {
                alert(responseData.message);
                const urlListExamPage = "http://localhost:8080/QuesApp/exams";
                window.location.href = urlListExamPage;
                } else {
                throw new Error(responseSubject.message);
             }
            } catch (error) {
            alert(error.message);
          }
            } else {
                console.error("Không thể tìm thấy các phần tử input.");
            }
        }

document.addEventListener("DOMContentLoaded", () => {
            const createBtn = document.querySelector(".createBtn");
            createBtn.addEventListener("click", async (event) => {
                event.preventDefault();
                await createExam(getInputUser());
            });
        });



// back button
document.addEventListener("DOMContentLoaded", () => {
          const backButton = document.querySelector(".backBtn");
          backButton.addEventListener("click",  () => {
          localStorage.removeItem("selectedQuestionIds");
          const listExamUrlPage = "http://localhost:8080/QuesApp/exams";
          window.location.href = listExamUrlPage;
              });
          });


 </script>
</body>
</html>
