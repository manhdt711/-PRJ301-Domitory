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
import model.Account;
import model.Student;

/**
 *
 * @author ADMIN
 */
public class AccountController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mess ="";
        String account=req.getParameter("acc");
       String pass=req.getParameter("pass");
       //su li thong tin
       
       Account acc = new Account(account, pass);
       boolean OK = acc.checklogin();
       Student s= new Student();
       s.getin4ByMail(account);
       // tra kq ve cho view
       if(OK){
           HttpSession session=req.getSession();
           session.setAttribute("account", account);
           req.setAttribute("Student", s);
           req.setAttribute("account", account);
           req.getRequestDispatcher("main.jsp").forward(req, resp);
       }else{
           mess = "Sai tai khoan, mat khau";
           req.setAttribute("mess", mess);
           req.getRequestDispatcher("Login.jsp").forward(req, resp);
       }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
}
