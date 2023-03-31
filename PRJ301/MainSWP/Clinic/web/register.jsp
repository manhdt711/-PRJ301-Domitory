<%-- 
    Document   : register
    Created on : Jan 31, 2023, 10:20:56 PM
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
                <h1 class="text-center wow fadeInUp text-uppercase">Register</h1>

                <form action="register" method="post" class="main-form border p-3 d-flex flex-column justify-content-center">
                    <div class="row">
                        <div class="col-12 py-2 wow fadeInLeft">
                            <input name="acc" value="${account}" type="text" class="form-control" placeholder="Username">
                        </div>
                        <div class="col-12 py-2 wow fadeInRight">
                            <input name="pass" type="password" class="form-control" placeholder="Password">
                        </div>
                        <div class="col-12 py-2 wow fadeInLeft">
                            <input name="repass"  type="password" class="form-control" placeholder="Confirm password">
                        </div>
                        <!--                        <div class="col-12 py-2 wow fadeInRight">
                                                    <select name="role" class="form-control">
                                                        <option>-- Select Role --</option>
                                                        <option value="doctor">Doctor</option>
                                                        <option value="patient">Patient</option>
                                                    </select>
                                                </div>-->
                        <p style="color: red" class="col-12 py-2 wow fadeInLeft">
                            ${mess}
                        </p>
                    </div>
                    <div class="text-center py-2 mt-3">
                        <a class="text-decoration-none" href="login.jsp">Already have an account? Login now!</a>
                    </div>
                    <div class="text-center py-2">
                        <input class="btn btn-primary mt-3 wow zoomIn" value="Register" type="submit">
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
