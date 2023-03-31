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
 * @author ADMIN
 */
public class UserController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //nhận thông tin
        String account=req.getParameter("acc");
        String pass=req.getParameter("pass");
        //xử lí thông tin
        User u =new User(account, pass);
        boolean OK=u.checklogin();
        
        //trả kết quả cho view
        if(OK){
            req.getRequestDispatcher("ListUser.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                   String account=req.getParameter("acc");
           String dob=req.getParameter("dob");
           
           User u=new User();
           
           if(u.checkUser(account,dob)){
             //Cos ton tai
             //Tao 1 pass moi
             String newpass="";
             Random r=new Random();
             newpass=r.nextInt(100)+"";
             //Update pass moi cho account tuong ung
             u.update(account,newpass);
             
             //Tra pass moi ve cho view
             req.setAttribute("account", account);
             req.setAttribute("pass", newpass);
               req.getRequestDispatcher("Login.jsp").forward(req, resp);
            }else{
                    
                    req.getRequestDispatcher("Forgotpass.jsp").forward(req, resp);
                    }
    }

    
}
