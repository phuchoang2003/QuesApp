<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Subject</title>
    <style>

     body {
         font-family: "Arial", sans-serif;
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

       button[type="submit"] {
         padding: 12px 24px; /* Điều chỉnh kích thước nút */
         background-color: #6c63ac;
         color: #fff;
         border: none;
         border-radius: 5px;
         font-size: 16px; /* Đặt kích thước chữ cho nút */
         cursor: pointer;
         transition: background-color 0.3s;
         display: block;
         margin: 0 auto; /* Canh giữa nút */
       }

       button[type="submit"]:hover {
         background-color: #564c88;
       }


     </style>

</head>
<body>
    <div class="container">
        <h2>Subject</h2>
        <div id="subjectForm">
            <div class="form-group">
                <label for="subject">Name Subject:</label>
                <input type="text" id="subject" name="subject" required />
            </div>
            <button type="submit"  id="createBtn">Create</button>
        </div>
    </div>

    <script>


    function getUserInput() {
            const subjectInput = document.getElementById("subject");
            return subjectInput ;
            }

        document.addEventListener("DOMContentLoaded", () => {
            const createBtn = document.getElementById("createBtn");
            createBtn.addEventListener("click", async (event) => {
                event.preventDefault();
                await createSubject(getUserInput());
            });
        });


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
              const url = "http://localhost:8080/QuesApp/auth/subjects";

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


             async function createSubject(subjectInput) {
                  const name = subjectInput;

                  if(name) {
                    const subject = {
                      nameSubject : name.value
                    };


                    try {
                      const responseSubject = await sendUserData(subject);
                      console.log("lc", responseSubject);
                      if (responseSubject.success) {
                        const urlHomePage = "http://localhost:8080/QuesApp/home";
                        window.location.href = urlHomePage;
                      } else {
                        throw new Error(responseSubject.message);
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
