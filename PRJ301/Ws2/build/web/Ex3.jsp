<%-- 
    Document   : Ex3
    Created on : Sep 30, 2022, 6:32:07 PM
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
                color: blue;
            }
            .a{

                width: 500px;
                height: 290px;
                border: 3px solid red;
            }
            .a1{
                padding-top: 200px;
                display: flex;
                justify-content: center;
            }
            input{
                margin-top: 20px;
                margin-left: 50px;
                width:  150px;
                height: 20px;
            }
            .chuxanhcuoi{
                display: flex;
                padding-top: 67px;
                padding-left: 20px;
                color: blue;
                font-weight:bolder;
            }
            .nhapp{
                display: flex;
            }
            .chuxanh{
                padding-left: 20px;
                color: blue;
                font-weight:bolder;
                margin-top: 20px;
            }
            .kitu{
                margin-top: 24px;
                }
                .kebang{
                    color: black;
                    font-size: medium;
                    font-weight: lighter;
                    margin-left: 10px;
                    border:1px inset gray;
            width:200px;
            height:24px;
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
            String n="";
            if(request.getAttribute("n")!=null)
            n=(String)request.getAttribute("n");
            String strErr="";
            if(request.getAttribute("strErr")!=null)
            strErr=(String)request.getAttribute("strErr");
            %>
        <form action="ex3" method="get" id="f">
            <div class="a1">
                <div class="a">
                    <h1>THỰC HIỆN PHÉP TOÁN</h1>
                    <div class="nhapp"><div class="chuxanh">Nhập n</div><input class="nhap" type='text' name="n" value=<%=n%>>
                        <div class="kitu">(1&#60;n&#60;100)</div>
                    </div>
                    <div class="chuxanh">Chọn phép toán
                        <select name="op" onchange="change()">
                            <option>Tổng n số liên tiếp</option>
                            <option>Tính n!</option>
                            <option>In dãy lẻ</option>
                            <option>In dãy số chẵn</option>
                            <option>Kiểm tra số nguyên tố</option>
                        </select>
                    </div>
                        <div class="chuxanhcuoi">Kết Quả<div class="kebang">
                                <%=KetQua + strErr%>
                            </div>
                </div>
            </div>
        </form>
    </body>
</html>
