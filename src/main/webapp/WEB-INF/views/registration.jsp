<%--
  Created by IntelliJ IDEA.
  User: chand
  Date: 7/31/2017
  Time: 4:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Become a Member</title>
        <script>
            function checkInput() {
                var userName = document.getElementById('username').value;
                var password = document.getElementById('password').value;

                if(userName.length<5 || !userName.contains("1234567890")){
                    alert("Weak ass username");
                }
                if(password.length<5 || !password.contains("1234567890")){
                    alert("Weak ass password");
                }
            }
        </script>
</head>
<body>
<h1>Create a username and password</h1>
<form method="post" action="/function" onsubmit="return checkInput()">
    Username: <input type = "text" name="username" id="username">
    Password:<input type="password" name = "password" id = "password">
    <input type="submit" value="Register">
</form>
</body>
</html>
