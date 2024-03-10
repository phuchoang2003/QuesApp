<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOC TYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
<link href="
https://cdn.jsdelivr.net/npm/@icon/themify-icons@1.0.1-alpha.3/themify-icons.min.css
" rel="stylesheet">

    <style>


     body {
       background: linear-gradient(90deg, #c7c5f4, #776bcc);
       margin: 0;
       font-family: "Raleway", sans-serif;
     }

     .header,
     .content {
       margin: auto;
       padding: 20px;
       width: 80%;
       box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.1);
       backdrop-filter: blur(5px); /* Apply blur effect */
       border: 3px solid #a69ced; /* Lighter shade border color */
       border-radius: 10px; /* Adjust border radius as needed */
     }

     .header {
       display: flex;
       justify-content: space-around;
       align-items: center;
       background: rgba(255, 255, 255, 0.2); /* White with 20% opacity */
       margin-bottom: 20px;
     }

     .header div {
       width: 40px;
       height: 40px;
       background: #bcb6eb;
       margin: 0 5px;
     }

     .header .home,
     .header .historyButton,
     .header .add-subject,
     .header .logo-user {
       width: 40px;
       height: 40px;
       border-radius: 50%;
       margin: 0 5px;
       cursor: pointer;
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
       padding: 3px 6px;
       border-radius: 5px;
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

     .content {
       height: 640px;
       background: rgba(255, 255, 255, 0.2);
       position: relative;
     }

     .content .subject {
       display: flex;
       justify-content: space-between;
       align-items: center;
       background: rgba(255, 255, 255, 0.7);
       padding: 10px 20px;
       border-radius: 8px;
       margin-bottom: 10px;
     }

     .content .subject {
       cursor: pointer;
     }

     .content .subject .delete,
     .content .subject .update {
       padding: 5px 10px;
       background: #bcb6eb;
       color: white;
       border-radius: 5px;
       transition: background 0.3s ease;
     }

     .delete i,
     .update i {
       font-size: 16px;
       color: #757575;
       transition: color 0.3s ease;
     }

     .content .subject .delete:hover i,
     .content .subject .update:hover i {
       color: white;
     }

     .content .subject:hover {
       background-color: #6b4d7e;
     }

     .subject .icon {
       font-size: 20px;
       color: #757575;
       position: relative;
     }

     .subject .icon:hover {
       color: whitesmoke;
     }

     .subject .icon:hover ~ div {
       filter: blur(2px);
     }

     .subject .icon[title]:hover::after {
       content: attr(title);
       position: absolute;
       left: 50%;
       top: 10px;
       transform: translateX(-50%) translateY(100%);
       background-color: #6a679e;
       color: white;
       padding: 3px 6px;
       border-radius: 5px;
       font-size: 12px;

     }

     </style>

    <title>Home</title>
  </head>
  <body>
    <div class="header">
      <div class="home">
        <i class="ti ti-home icon" title="Home"></i>
      </div>
      <div class="historyButton">
        <i class="ti ti-bar-chart icon" title="History"></i>
      </div>

      <div class="search">
        <input
          type="text"
          class="search_input"
          placeholder="Enter Name Your Subject"
        />
        <i class="ti ti-search"></i>
      </div>

      <div class="add-subject">
        <i class="ti ti-plus icon" title="Create"></i>
      </div>
      <div class="logo-user">
        <i class="ti ti-user icon"></i>

      </div>
    </div>
    <div class="content">

    </div>
    <script >
    document.addEventListener(
      "DOMContentLoaded",
      async () => {
      await renderSubjects();
      await engageSubject();
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

    async function getSubjectsData() {
      const url = "http://localhost:8080/QuesApp/auth/subjects";

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

 async function renderSubjects() {
     try {
         const subjects = await getSubjectsData();
         const data = subjects.data;
         console.log("phuc",data)

         const contentContainer = document.querySelector(".content");
         contentContainer.innerHTML = "";

         data.forEach(subject => {
             const subjectElement = document.createElement('div');
             subjectElement.classList.add('subject');
             subjectElement.setAttribute('data', subject.id);


             const deleteElement = document.createElement('div');
             deleteElement.classList.add('delete');
             deleteElement.innerHTML = '<i class="ti ti-trash icon" title="Delete"></i>';

             const nameElement = document.createElement('div');
             nameElement.classList.add('name-subject');
             nameElement.textContent = subject.nameSubject;

             const updateElement = document.createElement('div');
             updateElement.classList.add('update');

             updateElement.innerHTML = '<i class="ti ti-settings icon" title="Update"></i>';

             subjectElement.appendChild(deleteElement);
             subjectElement.appendChild(nameElement);
             subjectElement.appendChild(updateElement);

             contentContainer.appendChild(subjectElement);
         });
     } catch (error) {
         console.log("phuc1");
         alert(error.message);
     }
 }

 // history

 document.addEventListener("DOMContentLoaded", () => {
   const historyButton = document.querySelector(".historyButton");
   historyButton.addEventListener("click",  () => {
   const urlHistoryPage = "http://localhost:8080/QuesApp/history";
   window.location.href = urlHistoryPage;
   });
 });

// home
document.addEventListener("DOMContentLoaded", () => {
   const homeButton = document.querySelector(".home");
   homeButton.addEventListener("click",  () => {
   location.reload();
   });
 });

 //add subject
 document.addEventListener("DOMContentLoaded", () => {
    const addSubjectButton = document.querySelector(".add-subject");
    addSubjectButton.addEventListener("click",  () => {
    const urlSubjectPage =  "http://localhost:8080/QuesApp/subjects";
    window.location.href = urlSubjectPage;

    });
  });






  // deleteButton
  // sau su kien render ra mon hoc

  async function sendIdSubject(idSubject){
        const url = `http://localhost:8080/QuesApp/auth/subjects?id=${idSubject}`;
        const options = {
        method: "DELETE",
        headers: {
           "Content-Type": "application/json",
           },
         };

         try {
              const response = await myFetch(url, options);
              if (response.status === 204) {
                    return { success: true, message: `Delete subject with id ${idSubject} successful`};
                      }
              else{
              const responseData = await response.json();
              return { success: false, message: responseData.message };
              }
              } catch (error) {
              alert(error.message);
              }
  }

  async function deleteSubjectById(idSubject){
    try{
        const messageAfterDelete = await sendIdSubject(idSubject);
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



  // update
  // direct forward update form

async function directForwardUpdateForm(){
    const urlUpdateSubjectForm = "http://localhost:8080/QuesApp/formUpdateSubject";
    window.location.href = urlUpdateSubjectForm;
}


// listQuestion
async function engageSubject(){
   const subjects = document.querySelectorAll(".subject");
   subjects.forEach(subject => {
       const idSubject = subject.getAttribute('data');
       subject.addEventListener("click", async (event) => {
           const clickedElement = event.target;
           if (clickedElement.classList.contains("delete")|| clickedElement.parentElement.classList.contains("delete")) {
               event.stopImmediatePropagation();
               await deleteSubjectById(idSubject);
           } else if (clickedElement.classList.contains("update")|| clickedElement.parentElement.classList.contains("update")) {
               event.stopImmediatePropagation();
               localStorage.setItem("idSubject",idSubject);
               await directForwardUpdateForm();
           } else {
               localStorage.setItem("idSubject",idSubject);
               const urlListQuestionPage = "http://localhost:8080/QuesApp/listQuestions";
               window.location.href = urlListQuestionPage;
           }
       });
   });
}



</script>
  </body>
</html>
