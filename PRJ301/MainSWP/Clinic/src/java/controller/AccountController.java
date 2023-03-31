package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import DAO.GetSetAccount;
import DAO.GetSetDoctor;
import DAO.GetSetHuman;
import DAO.GetSetPatient;
import DAO.Login;
import DAO.MD5;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import model.Account;
import model.Doctor;
import model.Human;
import model.Patient;

/**
 *
 * @author ADMIN
 */
public class AccountController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       MD5 sec = new MD5();
       String mess="";
       String account=req.getParameter("acc");
       String pass=req.getParameter("pass");
       String SaltPass = pass + sec.saltMd5();
       String PassMD5 = sec.getMd5(SaltPass);
       //su li thong tin
       Account acc = new Account(account, PassMD5);
       Login checkLogin = new Login();
       boolean OK = checkLogin.checklogin(acc);
       GetSetAccount getsetAcc = new GetSetAccount();
       String roleCheck = getsetAcc.checkRoleAccount(account);
       // tra kq ve cho view
       if(OK){
           switch (roleCheck) {
               case "0":
                   {
                       HttpSession session=req.getSession();
                       session.setAttribute("account", account);
                       GetSetPatient getsetPatient = new GetSetPatient();
                       GetSetDoctor getsetDoctor = new GetSetDoctor();
                       ArrayList<Patient> patinentList = getsetPatient.getPatient();
                       int CountPatient = patinentList.size();
                       req.setAttribute("patinentCount", CountPatient);
                       req.setAttribute("patinentList", patinentList);
                       ArrayList<Doctor> DoctorList = getsetDoctor.geDoctor();
                       int CountDoctor = DoctorList.size();
                       req.setAttribute("CountDoctor", CountDoctor);
                       req.setAttribute("DoctorList", DoctorList);
                       req.getRequestDispatcher("admin.jsp").forward(req, resp);
                       break;
                   }
               case "1":
                   {
                       HttpSession session=req.getSession();
                       session.setAttribute("account", account);
                       req.getRequestDispatcher("TrangNayChoEmp.jsp").forward(req, resp);
                       break;
                   }
               case "2":
                   {
                       HttpSession session=req.getSession();
                       session.setAttribute("account", account);
                       req.getRequestDispatcher("TrangNayChoGuest.jsp").forward(req, resp);
                       break;
                   }
           }
       }else{
           mess += "Sai tai khoan, mat khau";
           req.setAttribute("mess", mess);
           req.getRequestDispatcher("login.jsp").forward(req, resp);
       }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    
}
