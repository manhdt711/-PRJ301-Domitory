<%-- 
    Document   : insertPow
    Created on : Nov 1, 2022, 11:36:44 PM
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

                background-color: rgb(218, 207, 207);
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
                background-color: rgba(119, 119, 119, 0.377);
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
    <body style="font-family: Arial, Helvetica, sans-serif; overflow-x: hidden">
        <ul class="menu">
            <li class="FPT"><a href="main">FPT On Campus Dormitory</a></li>
            <li class="smallMenu"><a name="mail" style="margin-left: 500px" href="#">Xin Chao ${Student.getEmail()}</a></li>
            <li class="smallMenu"><a href="#">Doi mat khau</a></li>
            <li class="smallMenu"><a href="Login.jsp">Dang xuat</a></li>
        </ul>
        <br>
        <div class="ke">
        </div>
        <br>
        <div style="width: 70%; height: 90%; margin-left: 20%; ">
            <form action="insReport?id=${Student.getStudentId()}" method="post">
                <div class="optionchose" style="border: 1px solid; width: 300px;">
                    <div class="optionName" style="font-weight: bolder">
                        <ul>Title<br><input type="text" name="title"></ul>
                        <ul>Noi Dung:<br><input type="text" name="noiDung"></ul>
                        <ul>Hình ảnh:<br><input type="text" name="hinhAnh"></ul>
                    </div>
                    <div style="margin-left: 50px; margin-top: -10px;">
                        <input type="submit" name="Confrim" value="Confrim" class="login">
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>