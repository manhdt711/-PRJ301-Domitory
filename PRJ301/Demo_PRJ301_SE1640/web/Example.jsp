<%-- 
    Document   : Example
    Created on : Sep 27, 2022, 4:42:18 PM
    Author     : ADMIN
--%>

<%@page import="java.io.IOException" import="java.io.PrintWriter" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            //Scriptlet
            String message="Scriplet";
            out.println(message);
            //1. khởi tạo 2 số nguyên a, b sau đó tính tổng hiệu tích thương chia du cua a, b
            //2 xây dưng hàm tìm UCLN
            // Ap dung tim UCLN cua a, b
            //3. xay dung ham kiem tra so nguyen to
            //Ap dung hien thu n so nguyen to dau tien
            //voi n=UCLN cua a va b da tim o cau 2
//            out.println("<br>a+b = "+(a+b));
//            out.println("<br>a-b = "+(a-b));
//            out.println("<br>a*b = "+(a*b));
//            out.println("<br>a/b = "+(a/b));
//            out.println("<br>a%b = "+(a%b));
            out.println("<br>UCLN: "+gcd(a,b));
            out.println("prime number: ");
              for(int i=1; i<=gcd(a,b); i++){
            //check if current number is prime
            if(isPrime(i)) {
                out.println(i + " ");
            }
        }
            
        %>
        <%!
            int a = 8, b= 4;
            int gcd(int a, int b)
    {
        // Everything divides 0
        if (a == 0)
          return b;
        if (b == 0)
          return a;
      
        // base case
        if (a == b)
            return a;
      
        // a is greater
        if (a > b)
            return gcd(a-b, b);
        return gcd(a, b-a);
    }
    static boolean isPrime(int n){
          //since 0 and 1 is not prime return false.
          if(n==1||n==0)return false;
    
          //Run a loop from 2 to n-1
          for(int i=2; i<n; i++){
            // if the number is divisible by i, then n is not a prime number.
                if(n%i==0)return false;
          }
          //otherwise, n is prime number.
          return true;
    }
        %>
        <br>a=<%=a%>
        <br>b=<%=b%>
        <br>a+b=<%=a+b%>
        <br>a-b=<%=a-b%>
        <br>a*b=<%=a*b%>
        <br>a/b=<%=(double)a/b%>
        <br>a%b=<%=a%b%>
        

    </body>
</html>
