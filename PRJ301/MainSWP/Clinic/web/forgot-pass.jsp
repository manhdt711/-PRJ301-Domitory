<%-- 
    Document   : forgot-pass
    Created on : Jan 31, 2023, 10:28:43 PM
    Author     : thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="included/head.jsp" %>
    <body>
        <!-- Header -->
        <%@include file="included/header.jsp" %>

        <div class="page-section">
            <div class="container">
                <h1 class="text-center wow fadeInUp text-uppercase">Forgot password</h1>

                <form action="forgotpass" method="post" class="main-form border p-2">
                    <div class="row">
                        <div class="col-12 py-2 wow fadeInLeft">
                            <input name="acc" type="text" class="form-control" placeholder="Enter your username...">
                        </div>
                        <div class="col-12 py-2 wow fadeInRight">
                            <input type="password" name="pass2"  class="form-control" placeholder="Enter your Pass2...">
                        </div>
                        <p style="color: red" class="col-12 py-2 wow fadeInLeft">
                            ${mess}
                        </p>
                    </div>
                    <div class="d-flex flex-row justify-content-between py-2">
                        <a class="text-decoration-none" href="register.jsp">Don't have an account? Register</a>
                        <a class="text-decoration-none" href="login.jsp">Already have an account? Login now!</a>
                    </div>
                    <div class="text-center py-2">
                        <input class="btn btn-primary mt-3 wow zoomIn" value="Change" type="submit">
                    </div>
                </form>
            </div>
        </div> <!-- .page-section -->


        <%@include file="included/footer.jsp" %>

        <script src="./assets/js/jquery-3.5.1.min.js"></script>

        <script src="./assets/js/bootstrap.bundle.min.js"></script>

        <script src="./assets/vendor/owl-carousel/js/owl.carousel.min.js"></script>

        <script src="./assets/vendor/wow/wow.min.js"></script>

        <script src="./assets/js/theme.js"></script>
    </body>
</html>
