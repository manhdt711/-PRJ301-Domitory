<%-- 
    Document   : add
    Created on : Oct 27, 2022, 5:37:05 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="add">
            Add new Student
            <br>
            ID: <input type="text" name="id">
            <br>
            Name: <input type="text" name="name">
            <br>
            Gender: <input type="radio" name="sex" value="Male">Male
            <input type="radio" name="sex" value="Female">Female
            <br>
            Department:
            <select>
            <c:forEach items="${Delist}" var="item">
                <option>${item.getDep()}</option>
            </c:forEach>
                </select>
            <br>
            <input type="submit" value="Add">
        </form>
        <table border="1">
            <tr>
                <td>ID</td>
                <td>NAME</td>
                <td>Gender</td>
                <td>Dep</td>
            </tr>
            <c:forEach items="${list}" var="item">
                <tr>
                    <td>${item.getId()}</a></td>
                    <td>${item.getName()}</td>
                    <td>${item.getGender()}</td>
                    <td></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
