<%-- 
    Document   : Caculator
    Created on : Sep 29, 2022, 2:53:31 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script>
            function change() {
                document.getElementById("f").submit();
            }
        </script>
        <style>
            p{
                padding-left: 20px;
            }
            h1{
                text-align: center;
                color: blue;
            }
            .a{

                width: 500px;
                height: 290px;
                border: 3px solid blue;
            }
            .a1{
                padding-top: 200px;
                display: flex;
                justify-content: center;
            }
            .nhap{
                margin-left: 10px;
                background: aqua;
            }
            .op{
                margin-left: 5px;
            }
            .kq{
                display: flex;
                padding-left: 80px;
            }
            .input{
                margin-left: 10px;
            }
            .ketqua{
                background: aqua;
                }
        </style>
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
            String d="";
            if(request.getAttribute("d")!=null)
            d=(String)request.getAttribute("d");
            String strErr="";
            if(request.getAttribute("strErr")!=null)
            strErr=(String)request.getAttribute("strErr");
            %>
        <form action="ex2" method="get" id="f">
            <div class="a1">
                <div class="a">
                    <h1>Tìm Max và Min</h1>
                    <p>Nhập a:<input class="nhap" type='text' name="a" value=<%=a%>></p>
                    <p>Nhập b:<input class="nhap" type='text' name="b" value=<%=b%>></p>
                    <p>Nhập c:<input class="nhap" type='text' name="c" value=<%=c%>></p>
                    <p>Kết Quả: <input class="ketqua" type='text' value=<%=d%>></p>
                    <div class="kq" onchange="change()" >
                        <input type="radio" name="op" value="a">Tìm số lớn nhất
                        <input type="radio" name="op" value="b">Tìm số nhỏ nhất
                    </div>
                    <br>
                    <%=strErr%>
                </div>
            </div>
        </form>
    </body>
</html>