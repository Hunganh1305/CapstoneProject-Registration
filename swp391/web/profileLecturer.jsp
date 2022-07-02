<%@page import="DAO.UserDAO"%>
<%@page import="DTO.Users"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <title>Dashboard - Profile</title>

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Lato:700%7CMontserrat:400,600" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />

        <!-- Font Awesome Icon -->
        <script src="https://kit.fontawesome.com/e7ea130b87.js" crossorigin="anonymous"></script>

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="css/style.css" />

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
                  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
                  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
                <![endif]-->

    </head>

    <body>

        <%
            String name = (String) session.getAttribute("name");
            String email = (String) session.getAttribute("email");
            int userId = (int) session.getAttribute("userId");
            String department = (String) session.getAttribute("department");
            if (name == null) {
                response.sendRedirect("Login.jsp");
            } else {
        %>

        <!-- Header -->
        <header id="header">
            <div class="container">

                <div class="navbar-header">
                    <!-- Logo -->
                    <div class="navbar-brand">
                        <a class="logo" href="profileLecturer.jsp">
                            <img src="./img/logo.png" alt="logo">
                        </a>
                    </div>
                    <!-- /Logo -->

                    <!-- Mobile toggle -->
                    <button class="navbar-toggle">
                        <span></span>
                    </button>
                    <!-- /Mobile toggle -->
                </div>

                <!-- Navigation -->
                <nav id="nav">
                    <ul class="main-menu nav navbar-nav navbar-right">
                        <li><a class="align-nav" href="./profileLecturer.jsp">Profile</a></li>
                        <li><a class="align-nav" href="./projectListLecturer.jsp">Project List</a></li>
                        <li><a class="align-nav" href="./topicListLecturer.jsp">Topic List</a></li>
                        <li class="nav-item dropdown">
                            <a href="./profileLecturer.jsp" role="button" aria-haspopup="true" aria-expanded="false">
                                <img class="avatar" src="./img/sample-avatar.jpg" alt="Avatar">
                            </a>
                        </li>
                    </ul>
                </nav>
                <!-- /Navigation -->

            </div>
        </header>
        <!-- /Header -->

        <div class="container head-title">
            <h1 class="col-sm-8" style="text-align: left;">Profile</h1>
            <h4 class="col-sm-4" style="text-align: right;">
                <a href="MainController?action=logout">
                    <span class="fa-solid fa-right-from-bracket fa-md"></span>
                    <span>Logout</span>
                </a>
            </h4>
        </div>


        <!--Profile-->
        <div class="container profile">
            <div class="card text-center col-12 col-sm-5">
                <img class="profile-pic img-fluid card-image-top" src="./img/sample-avatar.jpg" alt="Profile Picture">
                <div class="card-body">
                    <h2 class="card-title text-grey"><%= name%></h2>
                    <p><%= email%></p>
                </div>
            </div>
            <div class="col-12 col-sm-7">
                <div class="card mb-4">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-sm-1">
                                <span class="fa-solid fa-user fa-lg"></span>
                            </div>
                            <div class="col-sm-3">
                                <p class="mb-0">Full Name</p>
                            </div>
                            <div class="col-sm-8">
                                <p class="text-muted mb-0"><%= name%></p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-1">
                                <span class="fa-solid fa-envelope fa-lg"></span>
                            </div>
                            <div class="col-sm-3">
                                <p class="mb-0">Email</p>
                            </div>
                            <div class="col-sm-8">
                                <p class="text-muted mb-0"><%= email%></p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-1">
                                <span class="fa-solid fa-key fa-lg"></span>
                            </div>
                            <div class="col-sm-3">
                                <p class="mb-0">Code</p>
                            </div>
                            <div class="col-sm-8">
                                <p class="text-muted mb-0"><%= userId%></p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-1">
                                <span class="fa-solid fa-building-columns fa-lg"></span>
                            </div>
                            <div class="col-sm-3">
                                <p class="mb-0">Department</p>
                            </div>
                            <div class="col-sm-8">
                                <p class="text-muted mb-0"><%= department%></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--/Profile-->


        <!-- topic -->

        <footer id="footer" class="section">

            <!-- container -->
            <div class="container">

                <!-- row -->
                <div id="bottom-footer" class="row">

                    <!-- social -->
                    <div class="col-md-4 col-md-push-8">
                        <ul class="footer-social">
                            <li><a href="https://www.facebook.com/" class="facebook"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="https://twitter.com/" class="twitter"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#" class="google-plus"><i class="fa fa-google-plus"></i></a></li>
                            <li><a href="https://www.instagram.com/" class="instagram"><i class="fa fa-instagram"></i></a></li>
                            <li><a href="https://www.youtube.com/" class="youtube"><i class="fa fa-youtube"></i></a></li>
                            <li><a href="https://www.linkedin.com/" class="linkedin"><i class="fa fa-linkedin"></i></a></li>
                        </ul>
                    </div>
                    <!-- /social -->

                    <!-- copyright -->
                    <div class="col-md-8 col-md-pull-4">
                        <div class="footer-copyright">
                            <span>&copy; Copyright 2022. All Rights Reserved. | FPT University </span>
                        </div>
                    </div>
                    <!-- /copyright -->

                </div>
                <!-- row -->

            </div>
            <!-- /container -->

        </footer>

        <% }
        %>

        <!-- preloader -->
        <div id='preloader'>
            <div class='preloader'></div>
        </div>
        <!-- /preloader -->


        <!-- jQuery Plugins -->
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/main.js"></script>

    </body>

</html>