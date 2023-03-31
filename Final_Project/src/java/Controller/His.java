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
import model.History;
import model.Room;
import model.Student;

/**
 *
 * @author ADMIN
 */
public class His extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        History his = new History();
        ArrayList<History> Hislist = his.getAllHisbyGender(id);
        Student s = new Student();
        s.getStudentbyId(id);
        req.setAttribute("Student", s);
        req.setAttribute("Hislist", Hislist);
        req.getRequestDispatcher("His.jsp").forward(req, resp);
    }
    
}
