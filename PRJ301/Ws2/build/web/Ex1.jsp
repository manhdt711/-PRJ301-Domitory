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
            .body2{

                width: 500px;
                height: 290px;
                border: 3px solid blue;
            }
            .body1{
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
                
                color: blue;
                font-size: 20px;
                }
                .keqa{
                    width: 100px;
                    margin-left: 10px;
                    background-color: pink;
                    }
                    .op{
                        margin-left: 10px;
                    }
                    .chuxanhcuoi{
                display: flex;
                padding-top: 10px;
                padding-left: 20px;
                font-weight:bolder;
            }
            .kebang{
                color: black;
                font-size: medium;
                font-weight: lighter;
                margin-left: 10px;
                border:1px inset gray;
                width:200px;
                height:40px;
                background-color: pink;
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
            String strErr="";
            if(request.getAttribute("strErr")!=null)
            strErr=(String)request.getAttribute("strErr");
            %>
        <form action="ex1" method="get" id="f">
            <div class="body1">
                <div class="body2">
                    <h1>THỰC HIỆN PHÉP TÍNH</h1>
                    <p>Nhập a:<input class="nhap" type='text' name="a" value=<%=a%>></p>
                    <p>Nhập b:<input class="nhap" type='text' name="b"value=<%=b%>></p>
                    <div class="kq" onchange="change()" >
                        <input class="op"  type="submit" name="op" value="a+b">
                        <input class="op" type="submit" name="op" value="a-b">
                        <input class="op" type="submit" name="op" value="a*b">
                        <input class="op" type="submit" name="op" value="a/b">
                    </div>
                    <div class="chuxanhcuoi">Kết Quả<div class="kebang">
                                <%=c + strErr%>
                            </div>
                </div>
            </div>
        </form>
    </body>
</html>
