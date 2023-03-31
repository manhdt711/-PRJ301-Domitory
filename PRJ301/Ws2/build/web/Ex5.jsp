<%-- 
    Document   : Ex5
    Created on : Oct 1, 2022, 10:28:01 PM
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
            .nd{
                padding-left: 10px;
                width: 800px;
                height: 800px;
                border: 2px solid black;
            }
            .ndd{
                padding-top: 200px;
                display: flex;
                justify-content: center;
            }
            .ndv{
                margin-left: 100px;
                width: 490px;
                height: 150px;
            }
            .gachChan{
                margin-left: 47px;
                margin-top: 30px;
                margin-bottom: 30px;
                padding-bottom: 1px;
                width: 700px;
                background-color: black;
            }
            .hang2{
                display: flex;
                justify-content: left;
            }
            input{
                margin-left: 10px;
            }
            .mauxanh{
                background-color: aqua;

            }
            .hang2 input{
                width: 95px;
                margin-right: 10px;
            }

        </style>
    </head>
    <body>
        <%String input="";
        if(request.getAttribute("input")!=null)
        input=(String)request.getAttribute("input");
        String index="";
        if(request.getAttribute("index")!=null)
        index=(String)request.getAttribute("index");
        String find="";
        if(request.getAttribute("find")!=null)
        find=(String)request.getAttribute("find");
        String reFind="";
        if(request.getAttribute("reFind")!=null)
        reFind=(String)request.getAttribute("reFind");
        String inStr="";
        if(request.getAttribute("inStr")!=null)
        inStr=(String)request.getAttribute("inStr");
        String reStr="";
        if(request.getAttribute("reStr")!=null)
        reStr=(String)request.getAttribute("reStr");
        String spiltStart="";
        if(request.getAttribute("spiltStart")!=null)
        spiltStart=(String)request.getAttribute("spiltStart");
        String spiltEnd="";
        if(request.getAttribute("spiltEnd")!=null)
        spiltEnd=(String)request.getAttribute("spiltEnd");
        String ReSpilt="";
        if(request.getAttribute("ReSpilt")!=null)
        ReSpilt=(String)request.getAttribute("ReSpilt");
        String strErr="";
            if(request.getAttribute("strErr")!=null)
            strErr=(String)request.getAttribute("strErr");
        %>
        <form action="ex5" method="get" id="f">
            <div class="ndd">
                <div class="nd">
                    <h1>ĐỐI TƯỢNG STRING</h1>
                    Nhập đoạn văn:
                    <br><textarea class="ndv" name="nhap" ><%=input%></textarea>><br><br>
                    Tổng số ký tự:<input class="mauxanh" type="text" value=<%=index%>>
                    <div class="gachChan"></div>
                    <div class="hang2">
                        Nhập vị trí<input type="text" name="indexNo" value=<%=find%>>
                        Ký tự tương ứng<input class="mauxanh" type="text" value=<%=reFind%>>
                    </div>
                    <div class="gachChan"></div>
                    <div class="hang2">
                        Nhập chuỗi<input type="text" name="StringPos" value=<%=inStr%>>
                        Vị trí tương ứng<input class="mauxanh" type="text" value=<%=reStr%>>
                    </div>
                    <div class="gachChan"></div>
                    <div class="hang2">
                        Nhập vị trí cần tách từ<input type="text" name="startSub" value=<%=spiltStart%>>
                        Đến<input type="text" name="endSub" value=<%=spiltEnd%>>
                        Kết quả<input class="mauxanh" type="text" value=<%=ReSpilt%>>
                    </div>
                    <br>
                    <div onchange="change()">
                        <input type="reset" value="Nhập lại">
                        <input class="op" type="submit" name="op" value="enter">
                    </div>
                    <br><%=strErr%><br>
                </div>
            </div>
        </form>
    </body>
</html>
