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
import model.Student;
import model.WaterPow;

/**
 *
 * @author ADMIN
 */
public class report extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Student s = new Student();
        REGISTER res = new REGISTER();
        s.getStudentbyId(id);
        Report rp = new Report();
        res.getResbyID(id);
        ArrayList<Report> RPlist = rp.getAllReportbyStuID(id);
        req.setAttribute("rplist", RPlist);
        req.setAttribute("Student", s);
        req.getRequestDispatcher("report.jsp").forward(req, resp);
    }
    
}
