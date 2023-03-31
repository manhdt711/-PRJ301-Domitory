/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.REGISTER;
import model.Report;
import model.Room;
import model.Student;

/**
 *
 * @author ADMIN
 */
public class insReport extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String title = req.getParameter("title");
        String noiDung = req.getParameter("noiDung");
        String hinhAnh = req.getParameter("hinhAnh");
        REGISTER res = new REGISTER();
        res.getResbyID(id);
        Student s = new Student();
        s.getStudentbyId(id);
        req.setAttribute("Student", s);
        Report rp = new Report();
        ArrayList<Report> RPlist = rp.getAllReportbyStuID(id);
        ArrayList<Report> RPlistall = rp.getAllReport();
        rp.insert(id, res.getRoomID(), "2022-10-11", title, noiDung, hinhAnh, "0", RPlistall);
        req.setAttribute("rplist", RPlist);
        req.getRequestDispatcher("main.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Student s = new Student();
        REGISTER res = new REGISTER();
        res.getResbyID(id);
        s.getStudentbyId(id);
        req.setAttribute("Student", s);
        req.getRequestDispatcher("insertReport.jsp").forward(req, resp);
    }
    
}
