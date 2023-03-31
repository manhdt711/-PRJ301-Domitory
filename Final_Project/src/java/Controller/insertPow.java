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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.REGISTER;
import model.Room;
import model.Student;
import model.WaterPow;

/**
 *
 * @author ADMIN
 */
public class insertPow extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String masv = req.getParameter("masv");
        String bedid = req.getParameter("bedid");
        String date = req.getParameter("date");
        String count = req.getParameter("count");
        Student s = new Student();
        WaterPow wp = new WaterPow();
        if(req.getParameter("op").equals("Điện")){
            wp.insert(masv, bedid, "Dien", date, count);
        }else{
            wp.insert(masv, bedid, "Nuoc", date, count);
        }
        ArrayList<WaterPow> WPlist = wp.getWPbyMasv(masv);
        s.getStudentbyId(masv);
        req.setAttribute("WPlist", WPlist);
        req.setAttribute("Student", s);
        req.getRequestDispatcher("main.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Student s = new Student();
        REGISTER r = new REGISTER();
        s.getStudentbyId(id);
        r.getResbyID(id);
        req.setAttribute("REGISTER", r);
        req.setAttribute("Student", s);
        req.getRequestDispatcher("insertPow.jsp").forward(req, resp);
    }
    
}
