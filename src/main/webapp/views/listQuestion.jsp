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
       justify-content: center;
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



     .body {
       height: auto;
       background: rgba(255, 255, 255, 0.7);
     }

     .list-quiz-button {
       padding: 10px 20px;
       background-color: #6c63ac;
       color: #fff;
       border: none;
       border-radius: 5px;
       cursor: pointer;
       transition: background-color 0.3s, color 0.3s;
       display: inline-flex;
       align-items: center;
       margin-left: 20px;
     }

     .list-quiz-button:hover {
       background-color: #564c88;
     }

     .list-quiz-button .text-button {
       font-size: 1.6rem;
     }

     .add-question {
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

     .add-question:hover {
       background: #564c88;
     }

     .delete,
     .update {
       background-color: #6c63ac;
       color: #fff;
       border: none;
       border-radius: 5px;
       cursor: pointer;
       transition: background-color 0.3s, color 0.3s;
       display: inline-flex;
       align-items: center;
       padding: 12px 20px;
       margin-left: 20px;
     }

     .delete i,
     .update i {
       font-size: 16px;
       color: #fff;
       transition: color 0.3s ease;
     }

     .delete:hover,
     .update:hover {
       background-color: #564c88;
     }

     .start-list-button,
     .add-question,
     .delete,
     .update {
       display: inline-flex;
       align-items: center;
     }

     .list-quiz-button,
     .add-question,
     .delete,
     .update {
       padding: 15px 30px;
       background-color: #6c63ac;
       color: #fff;
       border: none;
       border-radius: 5px;
       cursor: pointer;
       transition: background-color 0.3s, color 0.3s;
       display: inline-flex;
       align-items: center;
       margin-right: 20px;
     }

     .question {
       margin-top: 20px;
     }

     .content-question {
       background-color: rgba(255, 255, 255, 0.7);
       padding: 20px;
       margin-bottom: 20px;
       text-align: center;
       border-radius: 10px;
       font-size: 1.8rem;
       transition: transform 0.3s ease;
     }

     .content-question:hover {
       transform: translateY(-5px);
     }

     .answers {
       display: grid;
       grid-template-columns: repeat(2, 1fr);
       gap: 0.4rem;
       font-size: 1.8rem;
     }

     .answers div {
       background-color: rgba(255, 255, 255, 0.7);
       padding: 20px;
       margin-bottom: 10px;
       border-radius: 5px;
       transition: transform 0.3s ease;
     }

     .answers div:hover {
       background-color: #e0c2f0;
     }

     .footer {
       display: flex;
       justify-content: space-between;
       align-items: center;
       background: rgba(255, 255, 255, 0.7);
       padding: 15px 20px;
     }

     .text-button,
     .num-questions {
       font-size: 1.8rem;
     }

     .back-button,
     .next-button,
     .num-questions {
       padding: 15px 30px;
       background-color: #6c63ac;
       color: #fff;
       border: none;
       border-radius: 5px;
       cursor: pointer;
       transition: background-color 0.3s, color 0.3s;
       display: flex;
       align-items: center;
     }

     .back-button:hover,
     .next-button:hover,
     .num-questions:hover {
       background-color: #564c88;
     }


      </style>

    <title>List Question</title>
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

    <div class="body">
      <div class="list-quiz-button">
        <span class="text-button">List Exam</span>
      </div>

      <div class="add-question">
        <i class="ti ti-plus icon"></i>
      </div>

      <div class="delete">
        <i class="ti ti-trash icon" title="Delete"></i>
      </div>

      <div class="update">
        <i class="ti ti-settings icon" title="Update"></i>
      </div>

      <div class="question">
        <div class="content-question">
          <span class="text-question"></span>
        </div>

        <div class="answers">
          <div class="answerA" >
            <span class="text-answer" id ="1"></span>
          </div>
          <div class="answerB">
            <span class="text-answer"  id ="2"></span>
          </div>
          <div class="answerC">
            <span class="text-answer"  id ="3"></span>
          </div>
          <div class="answerD">
            <span class="text-answer"  id ="4"></span>
          </div>
        </div>
      </div>
    </div>
    <div class="footer">
      <div class="back-button">
        <span class="text-button">Back</span>
      </div>
      <div class="num-questions"></div>

      <div class="next-button">
        <span class="text-button">Next</span>
      </div>
    </div>

    <script>
     // homeButton
         document.addEventListener("DOMContentLoaded", () => {
         const homeButton = document.querySelector(".home");
         homeButton.addEventListener("click", () => {
         const urlHomePage = "http://localhost:8080/QuesApp/home";
         window.location.href = urlHomePage;
         });
       });


     // listExamButton
   document.addEventListener("DOMContentLoaded", () => {
   const listQuizButton = document.querySelector(".list-quiz-button");
   listQuizButton.addEventListener("click",  () => {
    const urlListExamPage = "http://localhost:8080/QuesApp/exams"
    window.location.href = urlListExamPage;
   });
 });


     // addButton
   document.addEventListener("DOMContentLoaded", () => {
   const addQuestionButton = document.querySelector(".add-question");
   addQuestionButton.addEventListener("click",  () => {
    const urlCreateQuestionFormPage = "http://localhost:8080/QuesApp/createQuestionForm"
    window.location.href = urlCreateQuestionFormPage;
   });
 });





     // renderQuestion
    let questionsData;
    let indexCurrentQuestion = 0;

         document.addEventListener("DOMContentLoaded",async ()=>{
                 try {
                         questionsData = await getQuestionsData();
                         let data = questionsData.data
                         console.log(data);
                         renderPositionAndNumQuestions(data, indexCurrentQuestion);
                         renderQuestion(data,indexCurrentQuestion);

                     } catch (error) {
                         alert(error.message);
                     }
         });




     async function myFetch(url, options) {
           try {
             const response = await fetch(url, options);
             return response;
           } catch (error) {
             alert(error.message);
           }
         }




    // lay du lieu tat ca cac cau
        async function getQuestionsData() {
          const idSubject = localStorage.getItem("idSubject")
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



        // render ra mot cau
        function renderQuestion(data, indexCurrentQuestion){
        try{
               // lay du lieu tu cau hoi hien tai
               const currentQuestion = data[indexCurrentQuestion];

               const idQuestion = currentQuestion.idQuestion;
               localStorage.setItem("idQuestion",idQuestion);

               // lay ra thong tin cua cau hoi hien tai
               const contentQuestion = currentQuestion.content;

               // render ra noi dung cau hoi
               const questionContentElement = document.querySelector(".text-question");
               questionContentElement.textContent = contentQuestion;

               // lay thon tin cac dap an
               const answers = currentQuestion.answers;

               // render ra noi dung dap an
               let i = 1;
               answers.forEach( answer => {
                const answerContent = answer.contentOption;
                const answerContentElement = document.getElementById(i.toString());
                answerContentElement.textContent = answerContent;
                i++;

               });
               }
               catch(error){
               if(error.message === "Cannot read properties of undefined (reading 'idQuestion')"){
                alert("Your list question is empty! Let's create some questions!");
               }
               }
        }



        // render ra so luong cau hoi va vi tri cau hien tai
        function renderPositionAndNumQuestions(data, indexCurrentQuestion){
            const index = indexCurrentQuestion + 1;
            const numQuestion = data.length;
            const numQuestionElement = document.querySelector(".num-questions");
            if(numQuestion === 0){
                numQuestionElement.textContent = `0/${numQuestion}`;
            }
        else{

            numQuestionElement.textContent = `${index}/${numQuestion}`;
        }
        }


        // click next render ra cau tiep theo an cau mot
        document.querySelector(".next-button").addEventListener("click", () => {
            if (indexCurrentQuestion < questionsData.data.length-1) {
                indexCurrentQuestion++;
                console.log(indexCurrentQuestion);
                renderPositionAndNumQuestions(questionsData.data, indexCurrentQuestion);
                renderQuestion(questionsData.data,indexCurrentQuestion);

                } else {
                    alert("This is the last question!")
                 }
        });

        // click back button render ra cau truoc an cau mot
         document.querySelector(".back-button").addEventListener("click", () => {
                    if (indexCurrentQuestion > 0) {
                        indexCurrentQuestion--;
                        console.log(indexCurrentQuestion);
                        renderPositionAndNumQuestions(questionsData.data, indexCurrentQuestion);
                        renderQuestion(questionsData.data,indexCurrentQuestion);

                        } else {
                            alert("No previous question!")
                         }
                });






         // deleteButton
         document.addEventListener("DOMContentLoaded", () => {
           const deleteButton = document.querySelector(".delete");
           deleteButton.addEventListener("click",  async () => {
               await deleteQuestionById();

           });
         });


        async function sendIdQuestionToDelete(idQuestion) {
                  const url = `http://localhost:8080/QuesApp/auth/questions?id=${idQuestion}`;
                  const options = {
                    method: "DELETE",
                    headers: {
                      "Content-Type": "application/json",
                    },
                  };

                 try {
                               const response = await myFetch(url, options);
                               if (response.status === 204) {
                                     return { success: true, message: `Delete question with id ${idQuestion} successful`};
                                       }
                               else{
                               const responseData = await response.json();
                               return { success: false, message: responseData.message };
                               }
                               } catch (error) {
                               alert(error.message);
                               }
                }

                async function deleteQuestionById(){
                    try{
                        const idQuestion = localStorage.getItem("idQuestion");
                        const messageAfterDelete = await sendIdQuestionToDelete(idQuestion);
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


         // updateButton
        document.addEventListener("DOMContentLoaded", () => {
        const updateButton = document.querySelector(".update");
        updateButton.addEventListener("click", () => {
              const urlUpdateFormQuestionPage = "http://localhost:8080/QuesApp/updateQuestionForm";
              window.location.href = urlUpdateFormQuestionPage;
         });
        });


     </script>

  </body>
</html>
