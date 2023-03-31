<%-- 
    Document   : Ex6
    Created on : Sep 30, 2022, 11:03:53 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        .hh1{
            margin-top: -25px;
        }
        .a{

            width: 500px;
            height: 500px;
            border: 3px solid blue;
        }
        .a1{
            padding-top: 200px;
            display: flex;
            justify-content: center;
        }
        .nhap{
            margin-left: 10px;
        }
        .op{
            margin-left: 5px;
        }
        .kq{
            display: flex;
            padding-left: 80px;
            padding-bottom: 20px;
        }
        .input{
            margin-left: 10px;
        }
        .ketqua{
            margin-left: 70px;
            width: 300px;
        }
        .kln{
            margin-left: 50px;
        }
        .chuxanhcuoi{
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
    <%String a="";
        if(request.getAttribute("a")!=null)
        a=(String)request.getAttribute("a");
        String b="";
        if(request.getAttribute("b")!=null)
        b=(String)request.getAttribute("b");
        String KetQua="";
        if(request.getAttribute("KetQua")!=null)
        KetQua=(String)request.getAttribute("KetQua");
    %>
    <form action="ex6" method="get" id="f">
        <div class="a1">
            <div class="a">
                <h1>GIẢI PHƯƠNG TRÌNH</h1>
                <h1 class="hh1">BẬC NHẤT</h1>
                <p>Nhập a:<input class="nhap" type='text' name="a" value=<%=a%>></p>
                <p>Nhập b:<input class="nhap" type='text' name="b" value=<%=b%>></p>
                <div class="kq" onchange="change()" >
                    <input class="op"  type="submit" name="op" value="Giải PT">
                    <input class="op" type="submit" name="op" value="Thoát">
                </div>
                <br><div class="chuxanhcuoi">Kết luận nghiệm:<div class="kebang">
                        <%=KetQua%>
                    </div>
                </div>
            </div>
        </div>
    </form>
</body>
</html>
