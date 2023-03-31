<%-- 
    Document   : Caculator
    Created on : Sep 29, 2022, 2:53:31 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function change(){
                document.getElementById("f").submit();
            }
        </script>
    </head>
    <body>
        <%
            String c="";
            if(request.getAttribute("c")!=null)
            c=(String)request.getAttribute("c");
            String a="";
            if(request.getAttribute("a")!=null)
            a=(String)request.getAttribute("a");
            String b="";
            if(request.getAttribute("b")!=null)
            b=(String)request.getAttribute("b");
            String strErr="";
            if(request.getAttribute("strErr")!=null)
            strErr=(String)request.getAttribute("strErr");
            %>
        <form action='cal' method='get' id="f">
            Enter a:<input type='text' name='a' value=<%=a%>>
            <br>Enter b:<input type='text' name='b' value=<%=b%>>
            <br>Operator:
            <select name="op" onchange="change()">
                <option value="">All operator</option>
                <option>+</option>
                <option>-</option>
                <option>*</option>
                <option>/</option>
            </select>
            <br><input type='submit' name='OK' value='OK'>
            <br>Kết Quả<input class="keqa" type='text' value=<%=c%>>
            <br><%=strErr%>
        </form>
    </body>
</html>
