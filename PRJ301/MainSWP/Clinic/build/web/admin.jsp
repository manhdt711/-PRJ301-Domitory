<%-- 
    Document   : admin
    Created on : Feb 1, 2023, 8:32:24 AM
    Author     : thanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="included/head.jsp" %>
        <link rel="stylesheet" href="assets/css/admin.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css	">
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-light justify-content-between mb-0">
                <a class="navbar-brand text-uppercase" href="home.jsp"><span style="color: #00D9A5!important">G4</span>-Clinic</a>
                <a href="#" style="width:20%!important">
                    <img src="assets/img/avatar.jpg" class="bg-dark rounded-circle w-25" style="float: right">
                </a>
            </nav>
        </header>

        <!-- Sidebar -->
        <div class="wrapper d-flex align-items-stretch">
            <nav id="sidebar" class="active">
                <div class="custom-menu">
                    <button type="button" id="sidebarCollapse" class="btn btn-primary mr-1">
                        <i class="fa fa-bars"></i>
                        <span class="sr-only">Toggle Menu</span>
                    </button>
                </div>
                <div class="p-4">
                    <h1><a href="#" class="logo">Dashboard</a></h1>
                    <ul class="list-unstyled components mb-5">
                        <li class="active">
                            <a href="#" class="dashboard"><span class="fa fa-home mr-3 mt-3"></span> Dashboard</a>
                        </li>
                        <li>
                            <a href="#" class="doctor"><span class="fa fa-user mr-3 mt-3"></span> Doctor management</a>
                        </li>
                        <li>
                            <a href="#" class="patient"><span class="fa fa-user mr-3 mt-3"></span> Patient management</a>
                        </li>
                        <li>
                            <a href="#" class="job"><span class="fa fa-briefcase mr-3 mt-3"></span> Job requests</a>
                        </li>
                        <!--                        <li>
                                                    <a href="#"><span class="fa fa-paper-plane mr-3"></span> Contact</a>
                                                </li>-->
                        <li>
                            <a href="#"><span class="fa fa-sign-out mr-3 mt-5"></span> Logout</a>
                        </li>
                    </ul>
                </div>
            </nav>

            <div id="content" class="p-5 p-md-5 pt-5" style="background-color: #f6f6f6 !important;">
                <section id="dashboard" class="content-section">
                    <h2 class="mb-4 text-uppercase pl-5">Dashboard</h2>
                    <div class="d-flex flex-row justify-content-between flex-wrap">
                        <div class="card mb-5 p-5 wow fadeInLeft" style="width: 40rem;">
                            <div class="card-body rounded text-center text-uppercase">
                                <h5 class="card-title pb-5" style="font-size: 32px;"><i class="fa fa-user mr-3"></i>Total doctor</h5>
                                <p class="card-text" style="font-size: 48px">${CountDoctor}</p>
                            </div>
                        </div>
                        <div class="card mb-5 p-5 wow fadeInRight" style="width: 40rem;">
                            <div class="card-body rounded text-center text-uppercase">
                                <h5 class="card-title pb-5" style="font-size: 32px;"><i class="fa fa-user mr-3"></i>Total patient</h5>
                                <p class="card-text" style="font-size: 48px">${patinentCount}</p>
                            </div>
                        </div>
                        <div class="card mb-5 p-5 wow fadeInLeft" style="width: 40rem;">
                            <div class="card-body rounded text-center text-uppercase">
                                <h5 class="card-title pb-5" style="font-size: 32px;"><i class="fa fa-briefcase mr-3"></i>Total job request</h5>
                                <p class="card-text" style="font-size: 48px">10</p>
                            </div>
                        </div>
                        <div class="card mb-5 p-5 wow fadeInRight" style="width: 40rem;">
                            <div class="card-body rounded text-center text-uppercase">
                                <h5 class="card-title pb-5" style="font-size: 32px;">Total ABC</h5>
                                <p class="card-text" style="font-size: 48px">10</p>
                            </div>
                        </div>
                    </div>
                </section>
                <section id="doctor" class="content-section d-none">
                    <h2 class="mb-4 text-uppercase pl-5">Doctor</h2>
                    <table class="table table-striped wow fadeInDown text-center">
                        <thead>
                          <tr>
                            <th scope="col">#ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">Mail</th>
                            <th scope="col">Action</th>
                          </tr>
                        </thead>
                        <tbody>
                         <c:forEach items="${DoctorList}" var="people">
                          <tr>
                            <th scope="row">${people.getIdD()}</th>
                            <td>${people.getFullname()}</td>
                            <td>${people.getEmail()}</td>
                            <td>
                                <a href="#" class="btn"><i class="fa fa-pencil"></i></a>
                                <a href="#" class="btn"><i class="fa fa-trash"></i></a>
                            </td>
                          </tr>
                          </c:forEach>
                        </tbody>
                      </table>
                </section>
                <section id="patient" class="content-section d-none">
                    <h2 class="mb-4 text-uppercase pl-5">Patient</h2>
                    <table class="table table-striped wow fadeInDown text-center">
                        <thead>
                          <tr>
                            <th scope="col">#ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">Mail</th>
                            <th scope="col">Action</th>
                          </tr>
                        </thead>
                        <tbody>
                        
                          <c:forEach items="${patinentList}" var="people">
                          <tr>
                            <th scope="row">${people.getIdP()}</th>
                            <td>${people.getFullname()}</td>
                            <td>${people.getEmail()}</td>
                            <td>
                                <a href="#" class="btn"><i class="fa fa-pencil"></i></a>
                                <a href="#" class="btn"><i class="fa fa-trash"></i></a>
                            </td>
                          </tr>
                          </c:forEach>
                        </tbody>
                      </table>
                </section>
                <section id="job" class="content-section d-none">
                    <h2 class="mb-4 text-uppercase pl-5">Job</h2>
                    <table class="table table-striped wow fadeInDown text-center">
                        <thead>
                          <tr>
                            <th scope="col">#ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">Mail</th>
                            <th scope="col">Action</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>example@mail.com</td>
                            <td>
                                <a href="#" class="btn"><i class="fa fa-pencil"></i></a>
                                <a href="#" class="btn"><i class="fa fa-trash"></i></a>
                            </td>
                          </tr>
                        </tbody>
                      </table>
                </section>
            </div>
        </div>

        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

        <script src="./assets/js/bootstrap.bundle.min.js"></script>

        <script src="./assets/vendor/owl-carousel/js/owl.carousel.min.js"></script>

        <script src="./assets/vendor/wow/wow.min.js"></script>

        <script src="./assets/js/theme.js"></script>

        <script>
            (function ($) {

                "use strict";

                var fullHeight = function () {

                    $('.js-fullheight').css('height', $(window).height());
                    $(window).resize(function () {
                        $('.js-fullheight').css('height', $(window).height());
                    });

                };
                fullHeight();

                $('#sidebarCollapse').on('click', function () {
                    $('#sidebar').toggleClass('active');
                });


                $("a").click(function () {
                    var sections = document.querySelectorAll('.content-section');
                    var classClicked = $(this).attr('class').split(/\s+/);
                    // console.log(classClicked);
                    if (classClicked.indexOf("btn") === -1) {
                        sections.forEach(section => {
                            if (classClicked.indexOf(section.id) != -1) {
                                if (section.classList.contains("d-none")) {
                                    section.classList.remove("d-none");
                                }
                            } else {
                                if (!section.classList.contains("d-none")) {
                                    section.classList.add("d-none");
                                }
                            }
                        }
                        );
                    }

                });

            })(jQuery);
        </script>

        <script>

        </script>
    </body>
</html>
