/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author nguye
 */
public class Register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("acc");
        String pass = req.getParameter("pass");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String dob = req.getParameter("dob");
        String address = req.getParameter("address");

        User u = new User(account, pass, name, gender, dob, address);

        if (u.checkUser(account, dob)) {
            //Cos ton tai
            //Tao 1 pass moi
            String newpass = "";
            Random r = new Random();
            newpass = r.nextInt(100) + "";
            //Update pass moi cho account tuong ung
            u.update(account, newpass);

            //Tra pass moi ve cho view
            req.setAttribute("account", account);
            req.setAttribute("pass", newpass);
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        } else {

            req.getRequestDispatcher("Forgotpass.jsp").forward(req, resp);
        }

    }

}
