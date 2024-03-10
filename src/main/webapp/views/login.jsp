<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
    />

    <style>
    * {
             box-sizing: border-box;
             margin: 0;
             padding: 0;
             font-family: "Raleway", sans-serif;
           }

        a {
        text-decoration: none;
         }

           body {
             background: linear-gradient(90deg, #c7c5f4, #776bcc);
             margin: 0;
           }

           .container {
             display: flex;
             align-items: center;
             justify-content: center;
             min-height: 100vh;
           }

           .screen {
             background: linear-gradient(90deg, #5d54a4, #7c78b8);
             position: relative;
             height: 600px;
             width: 360px;
             box-shadow: 0px 0px 24px #5c5696;
           }

           .screen__content {
             z-index: 1;
             position: relative;
             height: 100%;
           }

           .screen__background {
             position: absolute;
             top: 0;
             left: 0;
             right: 0;
             bottom: 0;
             z-index: 0;
             -webkit-clip-path: inset(0 0 0 0);
             clip-path: inset(0 0 0 0);
           }

           .screen__background__shape {
             transform: rotate(45deg);
             position: absolute;
           }

           .screen__background__shape1 {
             height: 520px;
             width: 520px;
             background: #fff;
             top: -50px;
             right: 120px;
             border-radius: 0 72px 0 0;
           }

           .screen__background__shape2 {
             height: 220px;
             width: 220px;
             background: #6c63ac;
             top: -172px;
             right: 0;
             border-radius: 32px;
           }

           .screen__background__shape3 {
             height: 540px;
             width: 190px;
             background: linear-gradient(270deg, #5d54a4, #6a679e);
             top: -24px;
             right: 0;
             border-radius: 32px;
           }

           .screen__background__shape4 {
             height: 400px;
             width: 200px;
             background: #7e7bb9;
             top: 420px;
             right: 50px;
             border-radius: 60px;
           }

           .login,
           .register {
             width: 320px;
             padding: 30px;
             padding-top: 156px;
           }

           .login__field,
           .register__field {
             padding: 20px 0px;
             position: relative;
           }

           .login__icon {
             position: absolute;
             top: 30px;
             color: #7875b5;
           }

           .login__input,
           .register__input {
             border: none;
             border-bottom: 2px solid #d1d1d4;
             background: none;
             padding: 10px;
             padding-left: 24px;
             font-weight: 700;
             width: 75%;
             transition: 0.2s;
             color: #5e5e5f;
           }

           .login__input:active,
           .login__input:focus,
           .login__input:hover,
           .register__input:active,
           .register__input:focus,
           .register__input:hover {
             outline: none;
             border-bottom-color: #6a679e;
           }

           .login__submit,
           .register__submit {
             background: #fff;
             font-size: 14px;
             margin-top: 30px;
             padding: 16px 20px;
             border-radius: 26px;
             border: 1px solid #d4d3e8;
             text-transform: uppercase;
             font-weight: 700;
             display: flex;
             align-items: center;
             width: 100%;
             color: #4c489d;
             box-shadow: 0px 2px 2px #5c5696;
             cursor: pointer;
             transition: 0.2s;
           }

           .login__submit:active,
           .login__submit:focus,
           .login__submit:hover,
           .register__submit:active,
           .register__submit:focus,
           .register__submit:hover {
             border-color: #6a679e;
             outline: none;
           }

           .button__icon {
             font-size: 24px;
             margin-left: auto;
             color: #7875b5;
           }

           .social-login {
             position: absolute;
             height: 140px;
             width: 160px;
             text-align: center;
             bottom: 0px;
             right: 0px;
             color: #fff;
           }

           .social-icons {
             display: flex;
             align-items: center;
             justify-content: center;
           }

           .social-login__icon {
             padding: 20px 10px;
             color: #fff;
             text-decoration: none;
             text-shadow: 0px 0px 8px #7875b5;
           }

           .social-login__icon:hover {
             transform: scale(1.5);
           }
 </style>
    <title>Login</title>
  </head>
  <body>
    <div class="container">
      <div class="screen">
        <div class="screen__content">
          <form class="login">
            <div class="login__field">
              <i class="login__icon fas fa-user"></i>
              <input type="email" class="login__input" placeholder="Email" />
            </div>
            <div class="login__field">
              <i class="login__icon fas fa-lock"></i>
              <input
                type="password"
                class="login__input"
                placeholder="Password"
              />
            </div>
            <button class="button login__submit">
              <span class="button__text">Log In</span>
              <i class="button__icon fas fa-chevron-right"></i>
            </button>

            <a href="/src/views/register.jsp" class="button register__submit">
              <span class="button__text">Register</span>
              <i class="button__icon fas fa-chevron-right"></i>
            </a>
          </form>
        </div>
        <div class="screen__background">
          <span
            class="screen__background__shape screen__background__shape4"
          ></span>
          <span
            class="screen__background__shape screen__background__shape3"
          ></span>
          <span
            class="screen__background__shape screen__background__shape2"
          ></span>
          <span
            class="screen__background__shape screen__background__shape1"
          ></span>
        </div>
      </div>
    </div>
    <script>
    document.addEventListener("DOMContentLoaded", () => {
      const loginButton = document.querySelector(".login__submit");
      loginButton.addEventListener("click", function (event) {
        event.preventDefault();
        loginUser(getUserInput());
      });
    });

    document.addEventListener("DOMContentLoaded", () => {
      const registerButton = document.querySelector(".register__submit");

      registerButton.addEventListener("click", function (event) {
        event.preventDefault();
        const urlSignUpPage = "http://localhost:8080/QuesApp/signUp";
        window.location.href = urlSignUpPage;
      });
    });

    function getUserInput() {
      const emailInput = document.querySelector(
        '.login__input[placeholder="Email"]'
      );
      const passwordInput = document.querySelector(
        '.login__input[placeholder="Password"]'
      );

      return { emailInput, passwordInput };
    }

    async function myFetch(url, options) {
      try {
        const response = await fetch(url, options);
        return response;
      } catch (error) {
        console.log("2", error.message);
        alert(error.message);
      }
    }

    async function sendUserData(data) {
      const url = "http://localhost:8080/QuesApp/login";

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

    async function loginUser(inputUser) {
      const email = inputUser.emailInput;
      const password = inputUser.passwordInput;

      if (email && password) {
        const user = {
          email: email.value,
          password: password.value,
        };

        try {
          const authenticated = await sendUserData(user);
          console.log("lc", authenticated);
          if (authenticated.success) {
            alert(authenticated.message);
            const urlHomePage = "http://localhost:8080/QuesApp/home";
            window.location.href = urlHomePage;
          } else {
            throw new Error(authenticated.message);
          }
        } catch (error) {
          console.log("phuc1");
          alert(error.message);
        }
      } else {
        console.error("Không thể tìm thấy các phần tử input.");
      }
    }

    </script>
  </body>
</html>
