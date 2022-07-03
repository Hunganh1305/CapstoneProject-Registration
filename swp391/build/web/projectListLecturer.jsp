<%-- 
    Document   : projectListLecturer
    Created on : 02/07/2022, 1:56:31 PM
    Author     : HLong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Dashboard - Project List</title>

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Lato:700%7CMontserrat:400,600" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />

        <!-- Font Awesome Icon -->
        <script src="https://kit.fontawesome.com/e7ea130b87.js" crossorigin="anonymous"></script>

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="./css/style.css" />

        <!-- topic stylessheet -->
        <link type="text/css" rel="stylesheet" href="./css/projectListStyle.css" />
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

        <!-- topic -->
        <section id="topic" class="container">

            <div class="topic__title">
                <h1>Project List</h1>
            </div>

            <div class="topic__container">
                <div class="topicListControl">
                    <h6 class="topic__text">
                        All of approved topics in semester SU2022_SWP
                    </h6>
                </div>

                <hr>

                <div class="topic__search">
                    <form action="">
                        <input placeholder=" " class="search__input" type="text">
                        <label for="search" class="search__label">Search by name</label>
                        <button type="submit" class="search-btn ">
                            <img src="img/search-interface-symbol.png" alt="">
                        </button>
                    </form>

                    <!--
                    <div class="topic__filter">
                        <i class="fa-solid fa-filter"></i>Filters
                        <div class="dropdown1">
                            <ul class="filter__list">
                                <li class="filter__item">Quan tri kinh doanh</li>
                                <li class="filter__item">Cong nghe thong tin</li>
                                <li class="filter__item">Ngon ngu Anh</li>
                                <li class="filter__item">Ngon ngu Han Quoc</li>
                                <li class="filter__item">Ngon ngu Nhat</li>
                            </ul>
                        </div>
                    </div>
                    -->

                </div>

                <table class="table topic__table">
                    <thead>
                        <tr>
                            <th style="text-align: center">Group Id</th>
                            <th>Project Name</th>
                            <th>Lecturer</th>
                            <th style="text-align: center">Status</th>
                            <th style="text-align: center">View</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td style="text-align: center">1</td>
                            <td>CPManagement-Review</td>
                            <td>[Phuonglhk] Lam Huu Khanh Phuong</td>
                            <td style="text-align: center">Approved</td>
                            <td style="text-align: center"><i class="fa-solid fa-eye"></i></td>
                        </tr>
                        <tr>
                            <td style="text-align: center">2</td>
                            <td>PetCareSystem</td>
                            <td>[Phuonglhk] Lam Huu Khanh Phuong</td>
                            <td style="text-align: center">Approved</td>
                            <td style="text-align: center"><i class="fa-solid fa-eye"></i></td>
                        </tr>
                        <tr>
                            <td style="text-align: center">3</td>
                            <td>PT Tranning app</td>
                            <td>[Phuonglhk] Lam Huu Khanh Phuong</td>
                            <td style="text-align: center">Approved</td>
                            <td style="text-align: center"><i class="fa-solid fa-eye"></i></td>
                        </tr>
                        <tr>
                            <td style="text-align: center">4</td>
                            <td>Game Animation</td>
                            <td>[Phuonglhk] Lam Huu Khanh Phuong</td>
                            <td style="text-align: center">Approved</td>
                            <td style="text-align: center"><i class="fa-solid fa-eye"></i></td>
                        </tr>
                        <tr>
                            <td style="text-align: center">5</td>
                            <td>CPManagement-Review</td>
                            <td>[Phuonglhk] Lam Huu Khanh Phuong</td>
                            <td style="text-align: center">Approved</td>
                            <td style="text-align: center"><i class="fa-solid fa-eye"></i></td>
                    </tbody>
                </table>

                <hr>

                <nav aria-label="pagination Page navigation example">
                    <ul class="pagination justify-content-center">
                        <li class="page-item disabled">
                            <a class="page-link" href="#" tabindex="-1">Previous</a>
                        </li>
                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item">
                            <a class="page-link" href="#">Next</a>
                        </li>
                    </ul>
                </nav>

            </div>


        </section>
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

        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/main.js"></script>
        <script src="js/topic.js"></script>
    </body>
</html>
