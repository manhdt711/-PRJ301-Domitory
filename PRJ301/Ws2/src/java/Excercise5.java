
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
public class Excercise5 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try ( PrintWriter out = resp.getWriter()) {
            String op = req.getParameter("op");
            String err = "";
            String input = req.getParameter("nhap");
            if (input.isEmpty()) {
                err+="input cannot be empty<br>";
                req.setAttribute("strErr", err);
                req.getRequestDispatcher("Ex5.jsp").forward(req, resp);
            } else {
                
                int indexNo = 0;
                int startSub = 0;
                int endSub = 0;
                if (req.getParameter("indexNo").isEmpty()) {
                    err += "Cần nhập vị trí tìm kiếm<br>";
                }
                if (req.getParameter("startSub").isEmpty()) {
                    err += "Cần nhập vị trí bắt đầu tách<br>";
                }
                if (req.getParameter("endSub").isEmpty()) {
                    err += "Cần nhập vị trí kết thúc tách<br>";
                }
                if (req.getParameter("StringPos").isEmpty()) {
                    err += "Cần nhập chuỗi tìm kiếm<br>";
                    }
                    try {
                        indexNo = Integer.parseInt(req.getParameter("indexNo"));
                    } catch (NumberFormatException e) {
                        err += "Value must be Integer format<br>";
                    }
                    try {
                        startSub = Integer.parseInt(req.getParameter("startSub"));
                    } catch (NumberFormatException e) {
                        err += "Value must be Integer format<br>";
                    }
                    try {
                        endSub = Integer.parseInt(req.getParameter("endSub"));
                    } catch (NumberFormatException e) {
                        err += "Value must be Integer format<br>";
                    }
                    String StringPos = req.getParameter("StringPos");
                    if (err.isEmpty() && op.equals("enter")) {
                            req.setAttribute("spiltStart", String.valueOf(startSub));
                            req.setAttribute("spiltEnd", String.valueOf(endSub));
                            req.setAttribute("inStr", StringPos);
                            req.setAttribute("find", String.valueOf(indexNo));
                            req.setAttribute("input", input);
           req.setAttribute("index", String.valueOf(input.length()));
            req.setAttribute("reFind", String.valueOf(input.charAt(indexNo)));
            req.setAttribute("reStr", String.valueOf(input.indexOf(StringPos)));
            req.setAttribute("ReSpilt", input.substring(startSub, endSub));     
            req.getRequestDispatcher("Ex5.jsp").forward(req, resp);
            
                    } else {
                        req.setAttribute("input", input);
                        req.setAttribute("strErr", err);
                req.getRequestDispatcher("Ex5.jsp").forward(req, resp);
                    }
                }
            
        } catch (Exception e) {
        }
    }

}
