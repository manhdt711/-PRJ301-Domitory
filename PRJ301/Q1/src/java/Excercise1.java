
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
public class Excercise1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String strErr="";
        double a=0;
        double b=0;
        try ( PrintWriter out = resp.getWriter()) {
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
            double c=0;
            switch (op) {
                case "a+b":
                    c = a+b;
                    out.println(a+"+"+b+"="+c);
                    break;
                case "a-b":
                    c = a-b;
                    out.println(a+"-"+b+"="+c);
                    break;
                case "a*b":
                    c = a*b;
                    out.println(a+"*"+b+"="+c);
                    break;
                case "a/b":
                    c = a/b;
                    out.println(a+"/"+b+"="+c);
                    break;
                default:
                    break;
            }
            }else{
                out.print(strErr);
            }
        } catch (Exception e) {

        }
    }

}
