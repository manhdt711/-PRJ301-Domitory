
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class Exercise5 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = resp.getWriter()) {
            String op = req.getParameter("op");
            String input = req.getParameter("nhap");
            if (input.isEmpty()) {
                out.println("input cannot be empty");
            } else {
                String err = "";
                int indexNo = 0;
                int startSub = 0;
                int endSub = 0;
                try{
                indexNo = Integer.parseInt(req.getParameter("indexNo"));
                startSub = Integer.parseInt(req.getParameter("startSub"));
                endSub = Integer.parseInt(req.getParameter("endSub"));
                }catch(NumberFormatException e){
                    err+="Cần nhập tất cả các giá trị bên dưới";
                }
                String StringPos = req.getParameter("StringPos");
                if(!StringPos.isEmpty() && err.isEmpty()){
                if (op.equals("enter")) {
                    out.println("Tổng số kí tự: " + input.length() + "<br>");
                    out.println("Ký tự tương ứng: " + input.charAt(indexNo) + "<br>");
                    out.println("Vị trí tương ứng: " + input.indexOf(StringPos) + "<br>");
                    out.println("kết quả " + input.substring(startSub, endSub));

                }

            }else{
                    out.print(err);
                }
            }
        } catch (Exception e) {
        }
    }

}
