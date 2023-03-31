<%-- 
    Document   : main
    Created on : Oct 21, 2022, 10:12:59 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
            .maintable{
                width: 60%;
                border: 1px solid;
                border-collapse: collapse;
            }
            .maintable td, .maintable th{
                border: 1px solid gray;
            }
            .maintable thead{
                background: gray;
            }
            .maintable thead th{
                padding-bottom: 5px;
                padding-top:  5px;
                text-align: left;
                padding-left: 10px;
                }
                .i4table{
                    width: 30%;
                border: 1px solid;
                border-collapse: collapse;
            }
            .i4table td, .i4table th{
                border: 1px solid gray;
            }
            .i4table thead{
                background: gray;
            }
            .i4table thead th{
                padding-bottom: 5px;
                padding-top:  5px;
                text-align: left;
                padding-left: 10px;
                }
        </style>
    </head>
    <body style="font-family: Arial, Helvetica, sans-serif; overflow-x: hidden">
        <ul class="menu">
            <li class="FPT"><a href="#">FPT On Campus Dormitory</a></li>
            <li class="smallMenu"><a name="${account}" style="margin-left: 500px" href="#">Xin Chao ${account}</a></li>
            <li class="smallMenu"><a href="#">Doi mat khau</a></li>
            <li class="smallMenu"><a href="Login.jsp">Dang xuat</a></li>

        </ul>
        <br>
        <div class="ke">
        </div>
        <div class="body" style="width: 70%; height: 90%; margin-left: 20%; ">
            <ul style="font-size: 30px; margin-left: -40px; ">Student Board</ul>
            <ul style="font-size: 14px; margin-left: -40px; margin-top: -24px; color: green;">Mọi thắc mắc hoặc góp ý xin gửi về ktx@fpt.edu.vn (Please contact us at ktx@fpt.edu.vn if you have any question)</ul>
            <div style="display: flex">
                
                <table class="maintable">
                    <thead>
                        <tr>
                            <th>Actions (Hành động)</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                    <li style="list-style: none; padding-left: 10px; padding-bottom: 10px; padding-top: 10px"><a href="his?id=${Student.getStudentId()}" style="text-decoration: none; color: blue">Resident History(Lịch sử ở Ký Túc Xá)</a></li>
                    <li style="list-style: none; padding-left: 10px; padding-bottom: 10px; padding-top: 10px"><a href="bookbed?id=${Student.getStudentId()}" style="text-decoration: none; color: blue">Book a bed (Đặt chỗ)</a></li>
                    <li style="list-style: none; padding-left: 10px; padding-bottom: 10px; padding-top: 10px"><a href="PowWater?id=${Student.getStudentId()}" style="text-decoration: none; color: blue">View Monthly Electric / Water Usage (Xem mức sử dụng điện / nước)</a></li>
                    <li style="list-style: none; padding-left: 10px; padding-bottom: 10px; padding-top: 10px"><a href="report?id=${Student.getStudentId()}" style="text-decoration: none; color: blue">Request (Yêu cầu)</a></li>
                    </td>
                    </tr>
                    </tbody>
                </table>
                
                <div style="padding-left: 100px"></div>
                <table class="i4table">
                    <thead>
                        <tr>
                            <th>Useful information (Thông tin hữu ích)</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                    <li style="list-style: none; padding-left: 10px; padding-bottom: 10px; padding-top: 10px">Your FAP Balance (Tổng số tiền trong tài khoản:): ${Student.getBalance()} VND</li>
                    <li style="list-style: none; padding-left: 10px; padding-bottom: 10px; padding-top: 10px">Your gender information at FAP system: ${Student.getGender()}, if this information is not correct, please contact Academic staff.( Thông tin giới tính của bạn ghi nhận tại FAP: ${Student.getGender()}. Nếu thông tin không chính xác bạn hãy yêu cầu sửa lại tại phòng Dịch Vụ Sinh Viên)</li>
                    </td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="ke">
            </div>
        </div>
                    <div>
                        
                    </div>
    </body>
    <footer>

    </footer>
</html>
