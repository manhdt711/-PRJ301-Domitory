<%-- 
    Document   : Login
    Created on : Oct 21, 2022, 8:08:35 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
            <style>
        .menu a {
            float: left;
            text-decoration: none;
            color: rgb(119, 119, 119);
            padding: 10px 0px 0px 25px;
            font-size: 13px;
        }

        .menu {

            background-color: #777777;
            padding-left: 350px;
            width: 100%;
            list-style: none;
        }

        .FPT a {
            padding-top: 10px;
            font-size: 19px;
        }

        .ke {
            margin-top: 30px;
            padding-bottom: 1px;
            background-color: #777777;
        }

        .smallMenu a {
            margin-top: 2.5px;
        }

        .optionchose {
            display: flex;
        }

        input {
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
            height: 30px;
            width: 280px;
            margin-top: 12px;
        }

        select {
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
            height: 30px;
            width: 280px;
            margin-top: 12px;
        }

        .optionName ul {
            margin-top: 22px;
            text-align: right;
            margin-right: 30px;
        }

        .login{
            margin-top: 15px;
            font-weight: bold;
            color: white;
            border: none;
            border-radius: 5px;
            background-color: rgb(0, 153, 255);
            width: 60px;
            height: 35px;
        }
    </style>
    </head>
    <body style="overflow-x: hidden">
        <form action ="login" method="post">
    <ul class="menu">
        <li class="FPT"><a href="#">FPT On Campus Dormitory</a></li>
        <li class="smallMenu"><a href="#">Home</a></li>
        <li class="smallMenu"><a href="#">About</a></li>
        <li class="smallMenu"><a href="#">Contact</a></li>
    </ul>
    <br>
    <div class="ke">
    </div>
    <div class="body" style="width: 45%; height: 90%; margin-left: 20%;">
        <ul style="font-size: 30px; margin-left: -40px; ">Login</ul>
        <ul style="margin-left: -40px; margin-top: -20px;">Dormitory System</ul>
        <div class="ke">
        </div>
        <div class="optionchose">
            <div class="optionName" style="font-weight: bolder">
                <ul>UserName</ul>
                <ul>Password</ul>
                <ul>CampusCode</ul>
            </div>
            <div class="option">
                <input type="text" name="acc" value="${account}">
                <br>
                <input type="password" name="pass" value="${pass}" >
                
                <br>
<!--                <select id="CampusCode">
                    <option value="select">Select Campus</option>
                    <option value="hola">Hoa Lac</option>
                    <option value="catho">Can Tho</option>
                    <option value="danu">Da Nang</option>
                    <option value="hochi">Ho Chi Minh</option>
                    <option value="quynhon">Quy nhon</option>
                </select>-->
                <div style="display: flex;">
                    <input type="submit" name="Login" value="Login" class="login">
                    <ul style="margin-left: -30px;">
                        <a id="google_login" href="">
                            <img src="img/bt-login-gg.webp" style="border-radius: 4px;" alt="Login with Google">
                        </a>
                    </ul>
                </div>
                    <ul style="color: red">${mess}</ul>
                <ul style="margin-left: -160px; margin-top: 10px; font-size: 22px;">Failed to login? <a href="FailToLogin.jsp" style="text-decoration: none; color:rgb(0, 162, 255)">Click here for more detail</a></ul>
            </div>

        </div>


    </div>
    </form>
</body>
</html>
