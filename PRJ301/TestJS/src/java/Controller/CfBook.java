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
import java.util.ArrayList;
import model.Room;
import model.Student;

/**
 *
 * @author ADMIN
 */
public class CfBook extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id =req.getParameter("id");
        HttpSession session=req.getSession();
        Room r = new Room();
        Student s = new Student();
        s.getStudentbyId(id);
        req.setAttribute("Student", s);
        r.getRoombyID(id);
        req.setAttribute("Roomlist", r);
        req.setAttribute("acc", session.getAttribute("account"));
        req.getRequestDispatcher("detalPhong.jsp").forward(req, resp);
    }
    
}
