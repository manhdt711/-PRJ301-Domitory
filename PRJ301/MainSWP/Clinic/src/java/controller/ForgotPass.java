/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.ForgetPass;
import DAO.GetSetAccount;
import DAO.GetSetHuman;
import DAO.MD5;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author ADMIN
 */
public class ForgotPass extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("acc");
        String pass2 = req.getParameter("pass2");
        String mess = "";
        GetSetHuman getsetHuman = new GetSetHuman();
        GetSetAccount getsetAccount = new GetSetAccount();
        boolean ok = getsetHuman.checkPass2(account, pass2);
        ForgetPass forgetPass = new ForgetPass();
        MD5 sec = new MD5();
        if (ok) {
            String newRandomPass = forgetPass.generateRandomString();
            String SaltPass = newRandomPass + sec.saltMd5();
            String PassMD5 = sec.getMd5(SaltPass);
            getsetAccount.updatePass(account, PassMD5);
            mess += "Pass moi cua ban la: " + newRandomPass;
            req.setAttribute("mess", mess);
            req.getRequestDispatcher("forgot-pass.jsp").forward(req, resp);
        } else {
            mess += "Pass 2 khong dung hoac khong ton tai";
            req.setAttribute("mess", mess);
            req.getRequestDispatcher("forgot-pass.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
