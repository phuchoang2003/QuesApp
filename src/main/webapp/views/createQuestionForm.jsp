<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Question</title>
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
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            font-weight: bold;
            color: #6c63ac;
            display: block;
        }

        input[type="text"] {
            width: calc(100% - 20px);
            padding: 10px;
            margin-top: 5px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .option {
            margin-bottom: 10px;
        }

        .option input[type="text"],
        .option input[type="radio"] {
            vertical-align: middle;
        }

        .option label {
            vertical-align: middle;
            margin-left: 5px;
        }

        .button-container {
            text-align: center;
        }

        button[type="submit"], button[type="button"] {
            padding: 10px 20px;
            background-color: #6c63ac;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
            margin-left: 10px;
        }

        button[type="submit"]:hover, button[type="button"]:hover {
            background-color: #564c88;
        }

    </style>
</head>
<body>
    <div class="container">
        <h2>Create Question</h2>
        <div id="questionForm">
            <div class="form-group">
                <label for="question">Question:</label>
                <input type="text" id="question" name="question" required />
            </div>
            <div class="option">
                <label for="option1">Option 1:</label>
                <input type="text" class="option-text content-opt1" name="option" required />
                <input type="radio" id="option1" name="answer" value="Option 1" />
            </div>
            <div class="option">
                <label for="option2">Option 2:</label>
                <input type="text" class="option-text content-opt2" name="option" required />
                <input type="radio" id="option2" name="answer" value="Option 2" />
            </div>
            <div class="option">
                <label for="option3">Option 3:</label>
                <input type="text" class="option-text content-opt3" name="option" required />
                <input type="radio" id="option3" name="answer" value="Option 3" />
            </div>
            <div class="option">
                <label for="option4">Option 4:</label>
                <input type="text" class="option-text content-opt4" name="option" required />
                <input type="radio" id="option4" name="answer" value="Option 4" />
            </div>
            <div class="button-container">
                <button id = "createBtn" type="submit">Create</button>
                <button type="button" onclick="window.history.back()">Back</button>
            </div>
        </div>
    </div>


    <script>
     document.addEventListener("DOMContentLoaded",()=>{
     const createButton = document.querySelector("#createBtn");
     createButton.addEventListener("click",async ()=>{
               await createQuestion(getUserInput());


            });
     })


     async function myFetch(url, options) {
       try {
        const response = await fetch(url, options);
          return response;
          } catch (error) {
           console.log("2", error.message);
           alert(error.message);
          }
        }


           function getUserInput() {
               const contentQuestion = document.querySelector("#question");
               const isCorrectOption1 = document.querySelector("#option1");
               const contentOption1 = document.querySelector(".content-opt1");

               const isCorrectOption2 = document.querySelector("#option2");
               const contentOption2 = document.querySelector(".content-opt2");

               const isCorrectOption3 = document.querySelector("#option3");
               const contentOption3 = document.querySelector(".content-opt3");

               const isCorrectOption4 = document.querySelector("#option4"); // Corrected here
               const contentOption4 = document.querySelector(".content-opt4");

               return { contentQuestion, isCorrectOption1, isCorrectOption2, isCorrectOption3, isCorrectOption4, contentOption1, contentOption2, contentOption3, contentOption4 };
           }


        async function sendQuestionData(data) {
              const idSubject = localStorage.getItem("idSubject");
              const url = `http://localhost:8080/QuesApp/auth/questions?subject=${idSubject}`;
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


            async function createQuestion(inputUser) {


                  const contentQues = inputUser.contentQuestion;

                  const isCorrectOpt1 = inputUser.isCorrectOption1;
                  const contentOpt1 = inputUser.contentOption1;

                  const isCorrectOpt2 = inputUser.isCorrectOption2;
                  const contentOpt2 = inputUser.contentOption2;

                  const isCorrectOpt3 = inputUser.isCorrectOption3;
                  const contentOpt3 = inputUser.contentOption3;

                  const isCorrectOpt4 = inputUser.isCorrectOption4;
                  const contentOpt4 = inputUser.contentOption4;


                  if (contentQues && isCorrectOpt1 && isCorrectOpt2 && isCorrectOpt3 && isCorrectOpt4 && contentOpt1 && contentOpt2 && contentOpt3 && contentOpt4) {
                    const question = {
                          content: contentQues.value,
                          answers: [
                            { contentOption: contentOpt1.value, isCorrect: isCorrectOpt1.checked },
                            { contentOption: contentOpt2.value, isCorrect: isCorrectOpt2.checked },
                            { contentOption: contentOpt3.value, isCorrect: isCorrectOpt3.checked },
                            { contentOption: contentOpt4.value, isCorrect: isCorrectOpt4.checked },
                          ]
                    };

                    try {
                      const questionData = await sendQuestionData(question);
                      console.log("lc", questionData);
                      if (questionData.success) {
                        alert(questionData.message);
                        const urlListQuestionPage = "http://localhost:8080/QuesApp/listQuestions";
                        window.location.href = urlListQuestionPage;
                      } else {
                        throw new Error(questionData.message);
                      }
                    } catch (error) {
                      alert(error.message);
                    }
                  } else {
                    console.error("Không thể tìm thấy các phần tử input.");
                  }
                }



     </script>
</body>
</html>
