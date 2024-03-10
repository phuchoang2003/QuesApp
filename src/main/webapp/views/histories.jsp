<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOC TYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
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

 .list-history {
   margin-top: 20px;
   font-size: 1.4rem;
 }

 .field-history {
   width: 100%;
   border-collapse: collapse;
 }

 .field-history th,
 .field-history td {
   border: 1px solid #6c63ac;
   padding: 10px;
 }

 .field-history th {
   background-color: #6c63ac;
   color: white;
   text-align: left;
 }

 .field-history td {
   background-color: #f2f2f2;
 }

 .field-history tr:hover {
   background-color: #e6e6e6;
 }

 .field-history tr:hover td {
   color: #6c63ac;
 }

 .history {
   font-size: 1.4rem;
 }



     </style>
    <title>History</title>
</head>
<body>
    <div class="header">
        <div class="home">
            <i class="ti ti-home icon" title="Home"></i>
        </div>
        <div class="search">
            <input type="text" class="search_input" placeholder="Enter Name Your Subject">
            <i class="ti ti-search"></i>
        </div>
        <div class="logo-user">
                <i class="ti ti-user icon"></i>
        </div>
    </div>

    <div class="body">
        <div class="list-history">
            <table class="field-history">
                <thead class= "column-history">
                    <tr>
                        <th>ID</th>
                        <th>Subject</th>
                        <th>Name Exam</th>
                        <th>Time</th>
                        <th>Result</th>
                        <th>Start Time</th>
                        <th>End Time</th>
                    </tr>
                    <tbody class= "history">

                   </tbody>
                </thead>
            </table>
        </div>
    </div>
    <script>


 document.addEventListener(
      "DOMContentLoaded",
      async () => await renderHistories()
    );


        async function myFetch(url, options) {
          try {
            const response = await fetch(url, options);
            return response;
          } catch (error) {
            console.log("2", error.message);
            alert(error.message);
          }
        }

     async function getHistoryData() {
        const url = "http://localhost:8080/QuesApp/auth/history";
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

      async function renderHistories() {
        try {
          const histories = await getHistoryData();
          const data = histories.data;
          const historiesContainer = document.querySelector(".history");
          historiesContainer.innerHTML ="";

          // id
          let id = 1;

          data.forEach((history) => {
            // row
            const rowElement = document.createElement("tr");

             rowElement.innerHTML = `
                    <td>${id++}</td>
                    <td>${history.nameSubject}</td>
                    <td>${history.nameExam}</td>
                    <td>${history.timeLimit / 60} minutes</td>
                    <td>${history.score}/10</td>
                    <td>${history.startTime}</td>
                    <td>${history.endTime}</td>
                  `;


            // append
            historiesContainer.appendChild(rowElement);
          });


          console.log(histories);
        } catch (error) {
          alert(error.message);
        }
      }

      // home
      document.addEventListener("DOMContentLoaded", () => {
         const homeButton = document.querySelector(".home");
         homeButton.addEventListener("click", async () => {
         const urlHomePage = "http://localhost:8080/QuesApp/home";
         window.location.href = urlHomePage;
         });
       });



     </script>
</body>
</html>
