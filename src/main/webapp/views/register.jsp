<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOC TYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <title>Sign Up</title>

    <style>* {
             box-sizing: border-box;
             margin: 0;
             padding: 0;
             font-family: "Raleway", sans-serif;
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

</head>
<body>
<div class="container">
    <div class="screen">
        <div class="screen__content">
            <form class="register" action="your-servlet-url" method="post">
                <div class="register__field">
                    <i class="register__icon fas fa-user"></i>
                    <input type="text" class="register__input" name="name" placeholder="What's your name ?">
                </div>
                <div class="register__field">
                    <i class="register__icon fas fa-envelope"></i>
                    <input type="email" class="register__input" name="email" placeholder="What's your email ?">
                </div>
                <div class="register__field">
                    <i class="register__icon fas fa-lock"></i>
                    <input type="password" class="register__input" name="password" placeholder="Password">
                </div>
                <button class="button register__submit" type="submit">
                    <span class="button__text">Register</span>
                    <i class="button__icon fas fa-chevron-right"></i>
                </button>
            </form>
        </div>
        <div class="screen__background">
            <span class="screen__background__shape screen__background__shape4"></span>
            <span class="screen__background__shape screen__background__shape3"></span>
            <span class="screen__background__shape screen__background__shape2"></span>
            <span class="screen__background__shape screen__background__shape1"></span>
        </div>
    </div>
</div>
<script> document.addEventListener("DOMContentLoaded", () => {
           const registerButton = document.querySelector(".register__submit");

           registerButton.addEventListener("click", function (event) {
             event.preventDefault();
             registerUser(getUserInput());
           });
         });

         function getUserInput() {
           const nameInput = document.querySelector(
             '.register__input[placeholder="What\'s your name ?"]'
           );
           const emailInput = document.querySelector(
             '.register__input[placeholder="What\'s your email ?"]'
           );
           const passwordInput = document.querySelector(
             '.register__input[placeholder="Password"]'
           );

           return { nameInput, emailInput, passwordInput };
         }

         async function myFetch(url, options) {
           try {
             const response = await fetch(url, options);
             return response;
           } catch (error) {
             console.log(error.message);
             alert(error.message);
           }
         }

         async function sendUserInput(data) {
           const url = "http://localhost:8080/QuesApp/register";

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
             // alert(responseData.message);
           } catch (error) {
             alert(error.message);
           }
         }

         async function registerUser(inputUser) {
           const name = inputUser.nameInput;
           const email = inputUser.emailInput;
           const password = inputUser.passwordInput;

           if (name && email && password) {
             const user = {
               email: email.value,
               userName: name.value,
               password: password.value,
             };

             try {
               const registerSuccessfully = await sendUserInput(user);
               if (registerSuccessfully.success) {
               alert(registerSuccessfully.message);
                const urlLoginPage = "http://localhost:8080/QuesApp/signIn";
                window.location.href = urlLoginPage;

               } else {
                 throw new Error(registerSuccessfully.message);
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
