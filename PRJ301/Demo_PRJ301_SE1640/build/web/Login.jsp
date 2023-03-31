<%-- 
    Document   : Login
    Created on : Oct 11, 2022, 4:57:58 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="post">
            Account<input type="text" name="acc">
            <br>Password<input type="text" name="pass">
            <br><input type="submit" name="LOGIN" value="LOGIN">
        </form>
    </body>
</html>
