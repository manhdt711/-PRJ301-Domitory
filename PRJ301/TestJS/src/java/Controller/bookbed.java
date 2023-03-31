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
import model.REGISTER;
import model.Room;
import model.Student;

/**
 *
 * @author ADMIN
 */
public class bookbed extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mess= "";
        String id = req.getParameter("id");
        REGISTER res = new REGISTER();
        Room r = new Room();
        Student s = new Student();
        s.getStudentbyId(id);
        if (res.checklogin(id)) {
            mess+="Ban da co phong";
        } else {
            mess+="Xin moi dat phong" ;
            if (s.getGenderbyId(id).equals("M")) {
                ArrayList<Room> Roomlist = r.getAllRoombyGender("M");
                req.setAttribute("Roomlist", Roomlist);
            } else {
                ArrayList<Room> Roomlist = r.getAllRoombyGender("F");
                req.setAttribute("Roomlist", Roomlist);
            }
        }
        HttpSession session=req.getSession();
        req.setAttribute("acc", session.getAttribute("account"));
        req.setAttribute("mess", mess);
        req.setAttribute("Register", res);
        req.setAttribute("Room", r);
        req.setAttribute("Student", s);
        req.getRequestDispatcher("Bookbed.jsp").forward(req, resp);
    }

}
