
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
public class Caculator extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
                strErr += "<br>b is invalid<br>";
            }
            String op = req.getParameter("op");
//            if("All operator".equals(op)){
//                strErr += "<br>ban can dien phep tinh";
//            }
if(op.equals("")){
    // nếu param đặt trong context-param(web.xml)
    //thì tât cả servlet đều có thể gọi theo cú pháp sau
//    strErr += getServletContext().getInitParameter("err");
    //nếu param đặt trong init-param trong 1 servlet nào đó (web.xml)
    // thì chỉ servlet đó có thể thể gọi theo cú pháp sau
    strErr += getInitParameter("err");
}
            if(strErr.isEmpty()){
            double c=0;
            switch (op) {
                case "+":
                    c = a+b;
                    out.println(a+"+"+b+"="+c);
                    break;
                case "-":
                    c = a-b;
                    out.println(a+"-"+b+"="+c);
                    break;
                case "*":
                    c = a*b;
                    out.println(a+"*"+b+"="+c);
                    break;
                case "/":
                    c = a/b;
                    out.println(a+"/"+b+"="+c);
                    break;
                default:
                    break;
            }
            req.setAttribute("a", String.valueOf(a));
            req.setAttribute("b", String.valueOf(b));
            req.setAttribute("c", String.valueOf(c));
            req.getRequestDispatcher("Caculator.jsp").forward(req, resp);
            }else{
                req.setAttribute("strErr", strErr);
                req.getRequestDispatcher("Caculator.jsp").forward(req, resp);
            }
        } catch (Exception e) {

        }
    }
    }
        
    
