
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
public class Excercise2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    double MinOfThree(double a, double b, double c) {
        double min = a;
        if (b < min) {
            min = b;
        }
        if (c < min) {
            min = c;
        }
        return min;
    }

    double MaxOfThree(double a, double b, double c) {
        double max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try ( PrintWriter out = resp.getWriter()) {
            double a = 0;
            double b = 0;
            double c = 0;
            double d=0;
            String strErr = "";
            try {
                a = Double.parseDouble(req.getParameter("a"));
            } catch (NumberFormatException numex) {
                strErr += "a is invalid";
            }
            try {
                b = Double.parseDouble(req.getParameter("b"));
            } catch (NumberFormatException numex) {
                strErr += "\nb is invalid";
            }
            try {
                c = Double.parseDouble(req.getParameter("c"));
            } catch (NumberFormatException numex) {
                strErr += "\nc is invalid";
            }if(strErr.isEmpty()){
            String op = req.getParameter("op");
            if (op.equals("a")) {
                d=MaxOfThree(a, b, c);
            } else {
                d=MinOfThree(a, b, c);
            }
            req.setAttribute("a", String.valueOf(a));
            req.setAttribute("b", String.valueOf(b));
            req.setAttribute("c", String.valueOf(c));
            req.setAttribute("d", String.valueOf(d));
            req.getRequestDispatcher("Ex2.jsp").forward(req, resp);
            }else{
                req.setAttribute("strErr", strErr);
                req.getRequestDispatcher("Ex2.jsp").forward(req, resp);
            }
        } catch (Exception e) {

        }
    }

}
