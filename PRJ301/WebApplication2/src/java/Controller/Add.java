/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.De;
import Model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class Add extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String department = req.getParameter("department");
        Student s= new Student();
        if(gender.equals("1")){
           s.add(id, name, "1", department); 
        }else{
            s.add(id, name, "0", department); 
        }
        
        resp.sendRedirect("add");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        De d = new De();
         Student s =new Student();
       ArrayList<Student> list = s.getAll();
       ArrayList<De> deli = d.getAll();
       req.setAttribute("deli", deli);
       req.setAttribute("list", list);
       req.getRequestDispatcher("ListStudent.jsp").forward(req, resp);
    }
    
}
