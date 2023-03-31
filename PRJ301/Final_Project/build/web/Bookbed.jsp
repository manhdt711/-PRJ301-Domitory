<%-- 
    Document   : Bookbed
    Created on : Oct 26, 2022, 1:51:16 PM
    Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            table.greyGridTable {
                width: 100%;
                text-align: center;
            }
            table.greyGridTable td, table.greyGridTable th {
                border: 1px solid #FFFFFF;
            }
            table.greyGridTable tbody td {
                font-size: 13px;
            }
            table.greyGridTable tr:nth-child(even) {
                background: #D0E4F5;
            }
            table.greyGridTable thead {
                background: #FFFFFF;
                border-bottom: 2px solid #333333;
            }
            table.greyGridTable thead th {
                font-size: 15px;
                font-weight: bold;
                color: #000000;
                text-align: center;
                border-left: 2px solid #333333;
            }
            table.greyGridTable thead th:first-child {
                border-left: none;
            }

            table.greyGridTable tfoot td {
                font-size: 14px;
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
        <div class="body" style="width: 70%; height: 90%; margin-left: 20%; ">
        <h1>${mess}</h1>
        <c:if test="${mess eq 'Xin moi dat phong'}">
            <table class="greyGridTable">
            <thead>
                <tr>
                    <td>Mã giường</td>
                    <td>Mã phòng</td>
                    <td>Tên Dom</td>
                    <td>Block</td>
                    <td>Giá</td>      
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${Roomlist}" var="item">
                    <tr>
                        <td>${item.getBedId()}</td>
                        <td>${item.getRoomId()}</td>
                        <td>${item.getNameDom()}</td>
                        <td>${item.getLocation()}</td>
                        <td>${item.getPrice()}</td>
                        <td><a href="confirmbook?id=${item.getBedId()}">Book</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
            <select>
            <c:forEach items="${Roomlist}" var="item">
                        <option>${item.getBedId()}</option>
                </c:forEach>
                </select>
        </c:if>
        
        </div>
    </body>
</html>
