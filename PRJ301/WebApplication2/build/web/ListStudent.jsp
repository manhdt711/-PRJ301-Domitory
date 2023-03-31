<%-- 
    Document   : Product
    Created on : Oct 20, 2022, 4:50:44 PM
    Author     : Hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.util.ArrayList"%> 
<%@page import ="Model.Student"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="add" method="post">
            Add new Student
            <br>ID: <input type="text" name="id">
            <br>Name: <input type="text" name="name"> 
            <br>Gender:<input type="radio" name="gender" value="2">Male
            <input type="radio" name="gender" value="1">FeMale
            <br>Department:
            <select name="department">
                <c:forEach items="${deli}" var="items">
                    <option value="${items.getID()}" ${department eq items.getID()? "selected" : ""}>${items.getName()}</option>
                </c:forEach>
            </select>
           <br> <input type="submit" value="add">
        </form>
      <table border = "1">
            <tr>
                <td>ID</td>    
                <td>Name</td>
                <td>Gender</td>
                <td>Department</td>
            </tr>
      
      <c:forEach items="${list}" var="item">
         <tr>
                    <td>${item.getId()}</td>
                    <td>${item.getName()}</td>
                    <td>${item.getGender()}</td>
                    <td>${item.getDepartment()}</td>
         </tr> 
    </c:forEach>
        </table>
    </body>
</html>
