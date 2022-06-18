<%-- 
    Document   : topicDetail
    Created on : Jun 15, 2022, 8:47:17 AM
    Author     : phamquang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Dashboard - Profile</title>
        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Lato:700%7CMontserrat:400,600" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />

        <!-- Font Awesome Icon -->
        <script src="https://kit.fontawesome.com/e7ea130b87.js" crossorigin="anonymous"></script>


        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="./css/style.css" />

        <!-- topic stylessheet -->
        <link type="text/css" rel="stylesheet" href="./css/topicdetail.css" />
    </head>

    <body>
        
        <%
            String name = (String) session.getAttribute("name");
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
                        <li><a class="align-nav" href="./topic.html">Topic</a></li>
                        <li><a class="align-nav" href="./teamList.html">Team List</a></li>
                        <li><a class="align-nav" href="./contact.html">Contact</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                <img class="avatar" src="./img/sample-avatar.jpg" alt="Avatar">
                            </a>
                            <div class="dropdown-menu">
                                <br>
                                <a class="dropdown-item" href="./profile.html">
                                    <span style="margin-right: 4px;" class="fa-solid fa-user fa-md"></span>
                                    <span>Profile</span>
                                </a>
                                <hr>
                                <a class="'dropdown-item" href="#">
                                    <span style="margin-right: 3px;" class="fa-solid fa-right-from-bracket fa-md"></span>
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


        <!-- topic detail -->

        <section id="topicdetail">
            <div class="container">
                <div class="topicdetail__title">
                    <h1>Topic detail</h1>
                </div>

                <div class="topicdetail__contents ">
                    <div class="topicdetail__left">
                        <div class="topicdetail__content">
                            <h6 class="topicdetail__name">Register content of Capstone Project</h6>
                            <hr>

                            <div class="topicdetail__doc">
                                <h6>Context</h6>
                                <textarea name="" id="" cols="30" rows="10"></textarea>
                            </div>

                            <div class="topicdetail__doc">
                                <h6>Problem</h6>
                                <textarea name="" id="" cols="30" rows="10"></textarea>
                            </div>

                            <div class="topicdetail__doc">
                                <h6>Proposed Solution</h6>
                                <textarea name="" id="" cols="30" rows="10"></textarea>
                            </div>
                        </div>



                    </div>
                    <div class="topicdetail__right">
                        <div class="topicdetail__content">
                            <h6 class="topicdetail__name">Topic information</h6>
                            <hr>
                            <ul class="topicdetail__list">
                                <li class="topicdetail__item">
                                    <i class="fa fa-solid fa-bars col-sm-1"></i> 
                                    <span class="col-sm-3">Topic name</span> 
                                    <span class="col-sm-8">CPManagement-Review</span>
                                </li>
                                <li class="topicdetail__item">
                                    <i class="fa fa-regular fa-id-badge col-sm-1"></i>
                                    <span class="col-sm-3">Topic ID</span>
                                    <span class="col-sm-8">1</span>
                                </li>
                                <li class="topicdetail__item">
                                    <i class="fa fa-regular fa-building col-sm-1"></i>
                                    <span class="col-sm-3">Department</span>
                                    <span class="col-sm-8">Cong nghe thong tin</span>
                                </li>
                                <li class="topicdetail__item">
                                    <i class="fa fa-solid fa-users col-sm-1"></i>
                                    <span class="col-sm-3">Members</span>
                                    <span class="col-sm-8">From 2 to 7 student</span>
                                </li>
                                <li class="topicdetail__item">
                                    <i class="fa fa-solid fa-user-plus col-sm-1"></i>
                                    <span class="col-sm-3">Lecturer</span>
                                    <span class="col-sm-8">Lam Huu Khanh Phuong</span>
                                </li>
                                <li class="topicdetail__item">
                                    <i class="fa fa-solid fa-graduation-cap col-sm-1"></i>
                                    <span class="col-sm-3">Category:</span>
                                    <span class="col-sm-8">Ky thuat phan mem</span>
                                </li>
                                <li class="topicdetail__item">
                                    <i class="fa fa-regular fa-clipboard col-sm-1"></i> 
                                    <span class="col-sm-3">Description:</span>
                                    <span class="col-sm-8">Manage and review on this web</span>
                                </li>
                            </ul>

                        </div>

                        <div class="topicdetail__content">
                            <h6 class="topicdetail__name">Proposed Tasks for student</h6>
                            <hr>

                            <div class="topicdetail__doc">
                                <h6>Task Package 1</h6>
                                <textarea name="" id="" cols="30" rows="10"></textarea>
                            </div>

                            <div class="topicdetail__doc">
                                <h6>Task Package 2</h6>
                                <textarea name="" id="" cols="30" rows="10"></textarea>
                            </div>

                            <div class="topicdetail__doc">
                                <h6>Task Package 3</h6>
                                <textarea name="" id="" cols="30" rows="10"></textarea>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- topic detail -->

        <!-- topic -->

        <footer>
            <%@include file="footer.jsp" %>
        </footer>
        
        <% }
        %>

        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/main.js"></script>
    </body>

</html>
