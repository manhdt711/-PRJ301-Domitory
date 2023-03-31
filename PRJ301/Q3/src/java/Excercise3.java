
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
public class Excercise3 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    int SumN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; ++i) {
            sum += i;
        }
        return sum;
    }

    double giaiThua(int n) {
        if (n == 1) {
            return 1;
        }
        return n * giaiThua(n - 1);
    }

    int soNguyenTo(int n) {
        //1, 0 ko phải số nguyen tố
        if (n < 2) {
            return 1;
        }
        //đếm ước
        int count = 0;
        //ố nguyên >= 2 bất kỳ sẽ luôn có số ước ở nửa đầu căn bậc 2 của nó bằng số ước ở nửa sau căn bậc 2 của nó.<= sqrt(n) chính phương như 4, 9 là số nguyên tố
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                count++;
            }
        }
        if (count == 0) {
            return 2;
        } else {
            return 1;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = resp.getWriter()) {
            int n=0;
            String strErr="";
            try{
                n = Integer.parseInt(req.getParameter("n"));
            }catch (NumberFormatException numex){
                strErr += "\nb is invalid";
            }
            if(strErr.isEmpty()){
            if (n < 0) {
                out.println("0<n<100");
            } else if (n > 100) {
                out.println("0<n<100");
            }
            String op = req.getParameter("op");
            switch (op) {
                case "Tổng n số liên tiếp":
                    out.println(SumN(n));
                    break;
                case "Tính n!":
                    out.println(giaiThua(n));
                    break;
                case "In dãy lẻ":
                    for (int i = 0; i <= n; ++i) {
                        if (i % 2 != 0) {
                            out.print(i + " ");
                        }
                    }   break;
                case "In dãy số chẵn":
                    for (int i = 0; i <= n; ++i) {
                        if (i % 2 == 0) {
                            out.print(i + " ");
                        }
                    }   break;
                case "Kiểm tra số nguyên tố":
                    if (soNguyenTo(n) == 1) {
                        out.print(n + " khong phai so nguyen to");
                    } else {
                        out.print(n + " la so nguyen to");
                    }   break;
                default:
                    break;
            }
            }else{
                out.println("n is invaild");
            }

        } catch (Exception e) {

        }
    }

}
