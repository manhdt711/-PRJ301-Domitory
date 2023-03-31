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
import model.Student;
import model.WaterPow;

/**
 *
 * @author ADMIN
 */
public class Powwater extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Student s = new Student();
        s.getStudentbyId(id);
        WaterPow wp = new WaterPow();
        ArrayList<WaterPow> WPlist = wp.getWPbyMasv(id);
        s.getStudentbyId(id);
        int sumCountDien=wp.TongDien(WPlist);
        int sumCountNuoc=wp.TongNuoc(WPlist);
        int tienDien=sumCountDien*3000;
        int tienNuoc=sumCountNuoc*2000;
        int TongTien=tienDien+tienNuoc;
        req.setAttribute("TongTien", TongTien);
        req.setAttribute("tienDien", tienDien);
        req.setAttribute("tienNuoc", tienNuoc);
        req.setAttribute("sumCountDien", sumCountDien);
        req.setAttribute("sumCountNuoc", sumCountNuoc);
        req.setAttribute("WPlist", WPlist);
        req.setAttribute("Student", s);
        req.getRequestDispatcher("PowerWater.jsp").forward(req, resp);
    }
    
}
