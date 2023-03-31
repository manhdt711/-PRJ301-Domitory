<%-- 
    Document   : Ex4
    Created on : Sep 30, 2022, 7:22:45 PM
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
            h1{
                text-align: center;
            }
            .bbody{

                width: 500px;
                height: 500px;
                border: 3px solid black;
            }
            .a{
                padding-top: 200px;
                display: flex;
                justify-content: center;
            }
            .kqq{
                margin-left: 20px;
                height: 80px;
                width: 200px;
            }
            .kq{
                font-weight:bolder;
                padding-top: 10px;
                padding-left: 20px
            }
            .chon{
                display: flex;
            }
            .chu{
                padding-top: 8px;
            }
            .chuxanhcuoi{
                display: flex;
                padding-top: 67px;
                padding-left: 20px;
                font-weight:bolder;
            }
            .kebang{
                color: black;
                font-size: medium;
                font-weight: lighter;
                margin-left: 10px;
                border:1px inset gray;
                width:360px;
                height:135px;
                overflow-x:auto;
                overflow-y:scroll;
            }
            
        </style>
    </head>
    <body>
        <%
            String KetQua="";
            if(request.getAttribute("KetQua")!=null)
            KetQua=(String)request.getAttribute("KetQua");
            String input="";
            if(request.getAttribute("input")!=null)
            input=(String)request.getAttribute("input");
            %>
        <form action="ex4" method="get" id="f">
            <div class="a">
                <div class="bbody">
                    <h1>CÁC THAO TÁC VỚI MẢNG</h1>
                    <p style="margin-left: 10px">Nhập mảng(cách nhau bởi dấu '/')<input class="kqq" type="text" name="nhap" value=<%=input%>></p>
                    <div class="kq" onchange="change()" >
                        <div class="chon">
                            <h3>Chọn</h3>
                            <input type="radio" name="op" value="op2"><p class="chu">In mảng</p>
                        </div>
                        <br>
                        <input type="radio" name="op" value="op3">Tổng lẻ
                        <input type="radio" name="op" value="op4">Tích chẵn
                        <input type="radio" name="op" value="op5">Sắp xếp
                        <div class="chuxanhcuoi">Kết Quả<div class="kebang">
                                <%=KetQua%>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>
