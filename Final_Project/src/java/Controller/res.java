/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import model.History;
import model.REGISTER;
import model.Room;
import model.Student;

/**
 *
 * @author ADMIN
 */
public class res extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        History h = new History();
        REGISTER res = new REGISTER();
        String mess="";
        HttpSession session=req.getSession();
        String Roomid = req.getParameter("bedid");
        Room r = new Room();
        Student stu = new Student();
        stu.getin4ByMail(String.valueOf(session.getAttribute("account")));
        String StudentID = stu.getStudentId();
        String Checkin = String.valueOf("2022-05-22");
        res.getResbyID(StudentID);
        r.getRoombyID(Roomid);
        String giaPhong= r.getPrice();
        String tienTaiKHoan = stu.getBalance();
        int soDu = Integer.parseInt(tienTaiKHoan) - Integer.parseInt(giaPhong);
        if(soDu>=0){
            res.insert(Roomid, StudentID, Checkin);
            h.insert(StudentID, Roomid, Checkin, giaPhong, "2", "2022", "1");
            stu.ChangeBalance(StudentID, soDu);
            mess="Đặt Phòng Thành Công";
            req.setAttribute("Student", stu);
            req.setAttribute("Reslist", res);
            req.setAttribute("mess", mess);
            req.getRequestDispatcher("DatPhongThanhCong.jsp").forward(req, resp);
        }else{
            req.setAttribute("Student", stu);
            mess="Đặt Thất Bại: số dư trong tài khoản không đủ";
            req.setAttribute("mess", mess);
            req.getRequestDispatcher("DatPhongThanhCong.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
}
    
}
