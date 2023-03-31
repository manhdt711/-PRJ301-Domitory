<%-- 
    Document   : FailToLogin
    Created on : Nov 1, 2022, 11:23:00 PM
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
        </style>
    </head>
    <body style="font-family: Arial, Helvetica, sans-serif; overflow-x: hidden">
         <ul class="menu">
        <li class="FPT"><a href="#">FPT On Campus Dormitory</a></li>
        <li class="smallMenu"><a href="#">Home</a></li>
        <li class="smallMenu"><a href="#">About</a></li>
        <li class="smallMenu"><a href="#">Contact</a></li>
    </ul>
    <br>
    <div class="ke">
    </div>
    <div style="width: 70%; height: 90%; margin-left: 20%; ">
        <h1>Các bước xử lý khi không login được</h1>
        <p>
            Do chính sách mới của Google, một số account có thể gặp vấn đề khi đăng nhập. Chúng tôi sẽ cập nhật lại chức năng login cho hệ thống OCD. Trong thời gian này bạn có thể login dùng cách cau đây:
        <ul>
            <li>Bước 1: Dùng trình duyệt Chrome, đăng nhập trước bằng email fpt.edu.vn và 1 gmail khác, đảm bảo có ít nhất 02 email đang đăng nhập (1 gmail, 1 email fpt.edu.vn)</li>
            <li>Bước 2: Quay lại ocd, sau đó chọn nút "Login with Google" và chọn email fpt.edu.vn để đăng nhập</li>
        </ul>
        </p>
        <a href="Login.jsp" style="color: blue; text-decoration: none">Quay lại form đăng nhập</a>
    </div>
    </body>
</html>
