
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class Exercise4 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    int[] StrToInt(String str) {
        String[] splitArray = str.split("/");
        int[] array = new int[splitArray.length];
        for (int i = 0; i < splitArray.length; i++) {
            array[i] = Integer.parseInt(splitArray[i]);
        }
        return array;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = resp.getWriter()) {
            String input = req.getParameter("nhap");
            if (input.isEmpty()) {
                out.println("input cannot be empty");
            } else {
                boolean check = false;
                String[] splitArray = input.split("/");
                int[] array = new int[splitArray.length];
                for (int i = 0; i < splitArray.length; i++) {
                    try {
                        array[i] = Integer.parseInt(splitArray[i]);
                        check = true;
                    } catch (NumberFormatException e) {
                        check = false;
                    }
                }
                if (check) {
                    String op = req.getParameter("op");
                    int temp = 0;
                    switch (op) {
                        case "op2":
                            for (int i = 0; i < array.length; i++) {
                                out.println(array[i]);
                            }
                            break;
                        case "op3":
                            for (int i = 0; i < array.length; i++) {
                                if (array[i] % 2 != 0) {
                                    temp = array[i] + temp;
                                }
                            }
                            out.println("tổng lẻ: " + temp);
                            break;
                        case "op4":
                            for (int i = 0; i < array.length; i++) {
                                if (array[i] % 2 == 0) {
                                    temp = array[i] + temp;
                                }
                            }
                            out.println("Tích chẵn: " + temp);
                            break;
                        case "op5":
                            Arrays.sort(array);
                            for (int i = 0; i < array.length; i++) {
                                out.println(array[i]);
                            }
                            break;
                        default:
                            break;
                    }
                } else {
                    out.println("array must be int array");
                }
            }
        } catch (Exception e) {
        }
    }

}
