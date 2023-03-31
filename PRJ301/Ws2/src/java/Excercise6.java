
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class Excercise6 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try ( PrintWriter out = resp.getWriter()) {
            double x = 0;
            double a =0;
            double b=0;
            String KetQua="";
            try{
                a = Double.parseDouble(req.getParameter("a"));
            }catch (NumberFormatException numex){
                KetQua += "a is invalid";
            }
            try{
                b = Double.parseDouble(req.getParameter("b"));
            }catch (NumberFormatException numex){
                KetQua += "<br>b is invalid";
            }
            if(KetQua.isEmpty()){
            String op = req.getParameter("op");
            if (op.equals("Giải PT")) {
                if (a == 0) {
                    if (b == 0) {
                        KetQua+="Phương trình này có vô số nghiệm.";
                        req.setAttribute("KetQua", KetQua);
            req.getRequestDispatcher("Ex6.jsp").forward(req, resp);
                    } else {
                        KetQua+="Phương trình vô nghiệm.";
                        req.setAttribute("KetQua", KetQua);
            req.getRequestDispatcher("Ex6.jsp").forward(req, resp);
                    }
                } else {
                    x = (double) -b / a;
                    KetQua+="phương trình có 1 nghiệm x = " + String.valueOf(x);
                    req.setAttribute("KetQua", KetQua);
            req.getRequestDispatcher("Ex6.jsp").forward(req, resp);
                }
            }
            }else{
                req.setAttribute("KetQua", KetQua);
            req.getRequestDispatcher("Ex6.jsp").forward(req, resp);
            }

        } catch (Exception e) {
            
        }
    }

}
