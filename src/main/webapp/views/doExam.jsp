<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
    * {
      box-sizing: border-box;
      margin: 0;
      padding: 0;
    }

    html {
      font-size: 62.5%;
    }

    body {
      background: linear-gradient(90deg, #c7c5f4, #776bcc);
      font-family: "Raleway", sans-serif;
      width: 100%;
      color: #0e0101;
    }

    .header,
    .content,
    .footer {
      margin: auto;
      padding: 20px;
      width: 80%;
      backdrop-filter: blur(5px);
      border-radius: 10px;
    }

    .header,
    .footer {
      display: flex;
      justify-content: space-between;
      align-items: center;
      background-color: rgba(255, 255, 255, 0.7);
      padding: 15px 20px;
    }

    .header {
      margin-top: 40px;
    }

    .name-exam {
      font-size: 1.8rem;
      padding: 10px 20px;
      background-color: #6c63ac;
      color: white;
      border-radius: 5px;
      transition: transform 0.3s ease;
    }

    .name-exam:hover {
      transform: scale(1.1); /* scale on hover */
    }

    .content {
      margin-top: 20px;
      height: auto;
    }

    .time {
      display: flex;
      align-items: center;
      justify-content: center;
      margin-bottom: 20px;
    }

    .clock {
      width: 100px;
      height: 100px;
      background-color: rgba(255, 255, 255, 0.7);
      border-radius: 50%;
      border: 3px solid #6c63ac;
      display: flex;
      justify-content: center;
      align-items: center;
      font-size: 2rem;
      font-weight: bold;
      color: #6c63ac;
      transition: transform 0.3s ease; /* add transition */
    }

    .clock:hover {
      transform: rotate(360deg); /* rotate on hover */
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
      margin-top: 20px;
      height: auto;
    }

    .text-button,
    .num-questions {
      font-size: 1.8rem;
    }

    .submit {
      font-size: 1.8rem;
    }

    .back-button,
    .next-button,
    .num-questions,
    .submit {
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
    .num-questions:hover,
    .submit:hover {
      background-color: #564c88;
    }


    .answer.selected {
      background-color: #e0c2f0;
    }



    </style>

    <title>Exam</title>
</head>
<body>
    <div class="header">
        <div class="name-exam">
            <span class="text-name-exam"></span>
        </div>
<button class="submit" onclick="submitExam()">Submit</button>
    </div>
    <div class="content">
        <div class="time">
            <div class="clock"></div>
        </div>
        <div class="content-question">
            <span class="text-question"></span>
        </div>
        <div class="answers">
            <div class="answer">
                <span class="text-answer" id ="1"></span>
            </div>
            <div class="answer">
                <span class="text-answer" id ="2"></span>
            </div>
            <div class="answer">
                <span class="text-answer" id ="3"></span>
            </div>
            <div class="answer">
                <span class="text-answer" id ="4"></span>
            </div>
        </div>
    </div>
    <div class="footer">
        <div class="back-button">
            <span class="text-button">Back</span>
        </div>
        <div class="num-questions">1/20</div>
        <div class="next-button">
            <span class="text-button">Next</span>
        </div>
    </div>
</body>
<script>

// render ra cau hoi
let questionsData;
let indexCurrentQuestion = 0;
let answersUser = [];


 document.addEventListener("DOMContentLoaded",async ()=>{
     try {
         let examData = await getExamData();
         questionsData = examData.data.questionAnswerDTOS;
         let dataNameExam = examData.data.nameExam;
         let dataTimeLimit = examData.data.timeLimit;

         renderNameExamAndTimeLimit(dataNameExam, dataTimeLimit);
         renderPositionAndNumQuestions(questionsData, indexCurrentQuestion);
         renderQuestion(questionsData,indexCurrentQuestion);

         let endTime;
         const storedEndTime = localStorage.getItem("endTime");
         if (storedEndTime) {
             endTime = parseInt(storedEndTime, 10);
         } else {
             endTime = new Date().getTime() + (dataTimeLimit * 1000);
             console.log(dataTimeLimit * 60 * 1000);
             localStorage.setItem("endTime", endTime.toString());
         }
          countdownTimer(endTime);

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

// render nameExam va TimeLimit
function renderNameExamAndTimeLimit(nameExam, timeLimit) {
    const nameExamElement = document.querySelector(".text-name-exam");
    nameExamElement.textContent = nameExam;

    const timeLimitElement = document.querySelector(".clock");
    const minutes = Math.floor(timeLimit / 60) ;
    console.log(minutes,"phuc")
    const seconds = timeLimit % 60;
    timeLimitElement.textContent = `${minutes}:${formatTime(seconds)}`;
}

// render ra mot cau
function renderQuestion(data, indexCurrentQuestion) {
    document.querySelectorAll('.answer').forEach(ans => ans.classList.remove('selected'));

    const currentQuestion = data[indexCurrentQuestion];

    const idQuestion = currentQuestion.idQuestion;
    localStorage.setItem("idQuestion", idQuestion);

    const contentQuestion = currentQuestion.content;

    const questionContentElement = document.querySelector(".text-question");
    questionContentElement.textContent = contentQuestion;

    const answers = currentQuestion.answers;

    let i = 1;
    answers.forEach(answer => {
        const answerContent = answer.contentOption;
        const idAnswer = answer.idAnswer;
        const answerContentElement = document.getElementById(i.toString());
        answerContentElement.textContent = answerContent;

        answerContentElement.setAttribute("data-idQuestion", idQuestion);
        answerContentElement.setAttribute("data-selectedAnswerId", idAnswer);

        i++;
    });

    const selectedAnswerId = localStorage.getItem(`selectedAnswer_${idQuestion}`);
    if (selectedAnswerId) {
        const selectedAnswerElement = document.querySelector(`.answer .text-answer[data-idQuestion="${idQuestion}"][data-selectedAnswerId="${selectedAnswerId}"]`);
        if (selectedAnswerElement) {
            selectedAnswerElement.closest('.answer').classList.add('selected');
        }
    }

    // Update indexCurrentQuestion and number of questions
    renderPositionAndNumQuestions(data, indexCurrentQuestion);
}


// render ra so luong cau hoi va vi tri cau hien tai
function renderPositionAndNumQuestions(data, indexCurrentQuestion){
    const index = indexCurrentQuestion + 1;
    const numQuestion = data.length;
    const numQuestionElement = document.querySelector(".num-questions");
    if(numQuestion === 0){
        numQuestionElement.textContent = `0/${numQuestion}`;
    } else {
        numQuestionElement.textContent = `${index}/${numQuestion}`;
    }
}

// click next render ra cau tiep theo an cau mot
document.querySelector(".next-button").addEventListener("click", () => {
    if (indexCurrentQuestion < questionsData.length-1) {
        indexCurrentQuestion++;
        renderPositionAndNumQuestions(questionsData, indexCurrentQuestion);
        renderQuestion(questionsData,indexCurrentQuestion);
    } else {
        alert("This is the last question!");
    }
});

// click back button render ra cau truoc an cau mot
document.querySelector(".back-button").addEventListener("click", () => {
    if (indexCurrentQuestion > 0) {
        indexCurrentQuestion--;
        renderPositionAndNumQuestions(questionsData, indexCurrentQuestion);
        renderQuestion(questionsData,indexCurrentQuestion);
    } else {
        alert("No previous question!");
    }
});

// render ra thoi gian va ten bai kiem tra
async function getExamData(){
    const idSubject = localStorage.getItem("idSubject");
    const idExam = localStorage.getItem("idExam");
    const url = `http://localhost:8080/QuesApp/auth/do/exams?id_subject=${idSubject}&id_exam=${idExam}`;
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

// xu ly dong ho dem nguoc
 function countdownTimer(endTime) {
    const countDownDate = new Date(endTime).getTime();
    const x = setInterval(function() {
        const now = new Date().getTime();
        const distance = countDownDate - now;

        const minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
        const seconds = Math.floor((distance % (1000 * 60)) / 1000);

        const clockElement = document.querySelector(".clock");
        clockElement.textContent = formatTime(minutes) + ":" + formatTime(seconds);

        if (distance < 0) {
            clearInterval(x);
            clockElement.textContent = "00:00";

            // tu dong submit
             submitExam();

        }
    }, 1000);
}

function formatTime(time) {
    return time < 10 ? "0" + time : time;
}

// xu ly khi chon dap an
document.querySelectorAll('.answer').forEach(answer => {
    answer.addEventListener('click', () => {
        handleAnswerSelection(answer);
    });
});

function handleAnswerSelection(selectedAnswerElement) {
    const idQuestion = selectedAnswerElement.querySelector('.text-answer').getAttribute('data-idQuestion');
        const selectedAnswerId = selectedAnswerElement.querySelector('.text-answer').getAttribute('data-selectedAnswerId');
        console.log(idQuestion);
    localStorage.setItem(`selectedAnswer_${idQuestion}`, selectedAnswerId);

    document.querySelectorAll('.answer').forEach(ans => ans.classList.remove('selected'));
    selectedAnswerElement.classList.add('selected');
}

// submit button
async function sendDataToSubmit(data){
const idSubject = localStorage.getItem("idSubject");
const idExam = localStorage.getItem("idExam");
const url = `http://localhost:8080/QuesApp/auth/do/exams?id_subject=${idSubject}&id_exam=${idExam}`;

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


async function submitExam() {
    let answersUser = [];
    for (let i = 0; i < questionsData.length; i++) {
        const idQuestion = questionsData[i].idQuestion;
        const selectedAnswerId = localStorage.getItem(`selectedAnswer_${idQuestion}`);
        if (selectedAnswerId) {
            answersUser.push({
                idQuestion: idQuestion,
                selectedAnswerId: parseInt(selectedAnswerId)
            });
        }
    }

    const data = { answersUser: answersUser };
    try {
        const response = await sendDataToSubmit(data);


        if(response.success){
                //xoa localStorage
                // xoa het selectedAnswer_
                localStorage.clear();

                alert(response.message);
                const urlHistoryPage = "http://localhost:8080/QuesApp/history";
                window.location.href = urlHistoryPage;


        }
        else{
            console.log(response);
            throw new Error(response.message);
        }
    } catch (error) {
        console.log("phuc1");
        alert(error.message);
    }
}





</script>
</html>
