
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
<link rel="stylesheet" type="text/css" href="/static/css/style.css">


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
     .header .history,
     .header .add-subject,
     .header .logo-user {
       width: 40px;
       height: 40px;
       border-radius: 50%;
       margin: 0 5px;
       cursor: pointer;
     }

     .header .logo-user {
       overflow: hidden;
     }

     .header .logo-user img {
       width: 100%;
       height: 100%;
       object-fit: cover;
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
       z-index: 999;
     }

     </style>

    <title>Home</title>
  </head>
  <body>
    <div class="header">
      <div class="home">
        <i class="ti-home icon" title="Home"></i>
      </div>
      <div class="history">
        <i class="ti-bar-chart icon" title="History"></i>
      </div>

      <div class="search">
        <input
          type="text"
          class="search_input"
          placeholder="Enter Name Your Subject"
        />
        <i class="ti-search"></i>
      </div>

      <div class="add-subject">
        <i class="ti-plus icon" title="Create"></i>
      </div>
      <div class="logo-user">
        <img
          src="/src/assets/img/Cristiano_Ronaldo_playing_for_Al_Nassr_FC_against_Persepolis,_September_2023_(cropped).jpg"
          alt=""
        />
      </div>
    </div>
    <div class="content">
      <div class="subject">
        <div class="delete">
          <i class="ti-trash icon" title="Delete"></i>
        </div>
        <div class="name-subject">Java</div>
        <div class="update">
          <i class="ti-settings icon" title="Update"></i>
        </div>
      </div>
      <div class="subject">
        <div class="delete">
          <i class="ti-trash icon" title="Delete"></i>
        </div>
        <div class="name-subject">Java</div>
        <div class="update">
          <i class="ti-settings icon" title="Update"></i>
        </div>
      </div>
      <div class="subject">
        <div class="delete">
          <i class="ti-trash icon" title="Delete"></i>
        </div>
        <div class="name-subject">Java</div>
        <div class="update">
          <i class="ti-settings icon" title="Update"></i>
        </div>
      </div>
    </div>
    <script >
    document.addEventListener(
      "DOMContentLoaded",
      async () => await renderSubjects()
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
        console.log("phuc", responseData);
        return responseData;
      } catch (error) {
        alert(error.message);
      }
    }

    async function renderSubjects() {
      try {
        const subjects = await getSubjectsData();
        // const contentContainer = document.querySelector(".content");
        console.log(subjects);
      } catch (error) {
        console.log("phuc1");
        alert(error.message);
      }
    }
</script>
  </body>
</html>
