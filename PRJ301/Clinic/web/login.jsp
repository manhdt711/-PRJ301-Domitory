<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="included/head.jsp" %>
    <body>
        <!-- Header -->
        <%@include file="included/header.jsp" %>

        <div class="page-section">
            <div class="container">
                <h1 class="text-center wow fadeInUp text-uppercase">Login</h1>

                <form class="main-form border p-2" action ="login">
                    <div class="row">
                        <div class="col-12 py-2 wow fadeInLeft">
                            <input type="text" name="acc" value="${account}" class="form-control" placeholder="Username">
                        </div>
                        <div class="col-12 py-2 wow fadeInRight">
                            <input type="text" name="pass" value="${pass}" class="form-control" placeholder="Password">
                        </div>
                    </div>
                    <div class="d-flex flex-row justify-content-between py-2">
                        <a class="text-decoration-none" href="#">Don't have an account? Register</a>
                        <a href="#" class="text-decoration-none">Forgot password?</a>
                    </div>
                    <div class="text-center py-2">
                        <input type="submit"
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
