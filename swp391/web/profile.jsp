<%@page import="DAO.UserDAO" %>
    <%@page import="DTO.Users" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                <%@page contentType="text/html" pageEncoding="UTF-8" %>

                    <!DOCTYPE html>
                    <html lang="en">

                    <head>
                        <meta charset="utf-8">
                        <meta http-equiv="X-UA-Compatible" content="IE=edge">
                        <meta name="viewport" content="width=device-width, initial-scale=1">
                        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

                        <title>Dashboard - Profile</title>

                        <!-- Google font -->
                        <link href="https://fonts.googleapis.com/css?family=Lato:700%7CMontserrat:400,600"
                            rel="stylesheet">

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
                        <% String name=(String) session.getAttribute("name"); if (name==null) { %>
                            <p>
                                <font color='red'>You must login to view this page</font>
                            </p>
                            <p>Click <a href="Login.jsp">here</a> to login</p>
                            <%} else { String email=(String) session.getAttribute("email"); int userId=(int)
                                session.getAttribute("userId"); String department=(String)
                                session.getAttribute("department"); Cookie[] c=request.getCookies(); boolean
                                login=false; if (name==null) { String token="" ; for (Cookie cookie : c) { if
                                (cookie.getName().equals("selector")) { token=cookie.getValue(); Users
                                user=UserDAO.readByToken(token); if (user !=null) { name=user.getName();
                                email=user.getEmail(); login=true; } } } } else { login=true; } //show content if
                                login=true if (login) { %>
                                <!-- Header -->
                                <header>
                                    <%@include file="header_profile.jsp" %>
                                </header>
                                <!-- /Header -->

                                <<<<<<< HEAD <div class="navbar-header">
                                    <!-- Logo -->
                                    <div class="navbar-brand">
                                        <a class="logo" href="index.html">
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
                                            <li><a class="align-nav" href="./project.html">Project</a></li>
                                            <li><a class="align-nav" href="<c:url value=" /topic/index.do" />"
                                                >Topic</a></li>
                                            <li><a class="align-nav" href="<c:url value=" /group/index.do" />"">Team
                                                List</a></li>
                                            <li><a class="align-nav" href="./contact.html">Contact</a></li>
                                            <li class="nav-item dropdown">
                                                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
                                                    role="button" aria-haspopup="true" aria-expanded="false">
                                                    <img class="avatar" src="./img/sample-avatar.jpg" alt="Avatar">
                                                </a>
                                                <div class="dropdown-menu">
                                                    <br>
                                                    <a class="dropdown-item" href="./profile.html">
                                                        <span style="margin-right: 4px;"
                                                            class="fa-solid fa-user fa-md"></span>
                                                        <span>Profile</span>
                                                    </a>
                                                    <hr>
                                                    <a class="'dropdown-item" href="#">
                                                        <span style="margin-right: 3px;"
                                                            class="fa-solid fa-right-from-bracket fa-md"></span>
                                                        <span>Logout</span>
                                                    </a>
                                                    <br>
                                                </div>
                                            </li>
                                        </ul>
                                    </nav>
                                    <!-- /Navigation -->

                                    </div>
                                    </header>
                                    <!-- /Header -->

                                    <div class="container head-title">
                                        <h1 style="text-align: left;">Profile</h1>
                                    </div>



                                    <!--Profile-->
                                    <div class="container profile">
                                        <div class="card text-center col-12 col-sm-5">
                                            <img class="profile-pic img-fluid card-image-top"
                                                src="./img/sample-avatar.jpg" alt="Profile Picture">
                                            <div class="card-body">
                                                <h2 class="card-title text-grey">
                                                    <%= name %>
                                                </h2>
                                                <p>
                                                    <%= email %>
                                                </p>
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
                                                            <p class="text-muted mb-0">
                                                                <%= name %>
                                                            </p>
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
                                                            <p class="text-muted mb-0">
                                                                <%= email %>
                                                            </p>
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
                                                            <p class="text-muted mb-0">
                                                                <%= userId %>
                                                            </p>
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
                                                            <p class="text-muted mb-0">
                                                                <%= department %>
                                                            </p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <!--/Profile-->


                                    <!-- topic -->

                                    <footer>
                                        <%@include file="footer.jsp" %>
                                    </footer>
                                    <% } } %>
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