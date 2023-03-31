
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
        resp.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = resp.getWriter()) {
            double x = 0;
            double a =0;
            double b=0;
            String strErr="";
            try{
                a = Double.parseDouble(req.getParameter("a"));
            }catch (NumberFormatException numex){
                strErr += "a is invalid";
            }
            try{
                b = Double.parseDouble(req.getParameter("b"));
            }catch (NumberFormatException numex){
                strErr += "\nb is invalid";
            }
            if(strErr.isEmpty()){
            String op = req.getParameter("op");
            if (op.equals("Giải PT")) {
                if (a == 0) {
                    if (b == 0) {
                        out.println("Phương trình này có vô số nghiệm.");
                    } else {
                        out.println("Phương trình vô nghiệm.");
                    }
                } else {
                    x = (double) -b / a;
                    out.println("phương trình có 1 nghiệm x = " + x);
                }
            }
            }else{
                out.println(strErr);
            }

        } catch (Exception e) {
            
        }
    }

}
