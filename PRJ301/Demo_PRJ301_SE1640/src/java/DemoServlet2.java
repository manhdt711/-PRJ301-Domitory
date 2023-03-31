
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
public class DemoServlet2 extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //đây là nơi viết code cho servlet với method=post
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //đây là nơi viết code cho servlet với method=get hoặc không chỉ định
        resp.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out=resp.getWriter()){
            
            //nhận thông tin từ client
            String err = "";
            int a;
            try{
             
            a=Integer.parseInt(req.getParameter("a"));
            }catch(NumberFormatException ex){
                err += "a is invaild";
                return;
            }
            int b;
            try{
            b=Integer.parseInt(req.getParameter("b"));
            }catch(NumberFormatException ex){
                err += "b is invaild";
                out.println(err);
                return;
            }
            String op=req.getParameter("op");
            String c="";
            if(op.equals("+")){
                c=String.valueOf(a+b);
            }else if(op.equals("-")){
                c=String.valueOf(a-b);
            }else if(op.equals("*")){
                c=String.valueOf(a*b);
            }else if(op.equals("/")){
                c=String.valueOf(a/b);
            }
            //xử lí thông tin
            //trả kết quẩ cho client
            out.println("<br>"+a+op+b+"="+c);
        } catch (Exception e) {
            
        }
    }
    
}
