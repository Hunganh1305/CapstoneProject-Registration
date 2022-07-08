<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Admin - Manage Semesters</title>

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Lato:700%7CMontserrat:400,600" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="../css/bootstrap.min.css" />

        <!-- Font Awesome Icon -->
        <script src="https://kit.fontawesome.com/e7ea130b87.js" crossorigin="anonymous"></script>

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="../css/style.css" />

        <!-- sem stylessheet -->
        <link type="text/css" rel="stylesheet" href="../css/manageSemesterStyle.css" />  
    </head>
    <body>
        
        <%
            String name = (String) session.getAttribute("name");
            if (name == null) {
                response.sendRedirect("Login.jsp");
            } else {
        %>
        
        <!-- Header -->
        <header>
            <%@include file="headerAdmin.jsp" %>
        </header>
        <!-- /Header -->

        <!-- sem -->
        <section id="sem" class="container">

            <div class="sem__title">
                <h1>Manage Semesters</h1>
            </div>

            <div class="sem__container">
                <div class="semListControl">
                    <h6 class="sem__text">
                        List of semesters from database
                    </h6>
                    <div class="btnControl">
                        <button class="team__btn">+ Create New Semester</button>
                    </div>
                </div>

                <hr>

                <div class="sem__search">
                    <form action="">
                        <input placeholder=" " class="search__input" type="text">
                        <label for="search" class="search__label">Search by name</label>
                        <button type="submit" class="search-btn ">
                            <img src="img/search-interface-symbol.png" alt="">
                        </button>
                    </form>

                    <!-- <div class="sem__filter">
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
                    </div> -->

                </div>

                <table class="table sem__table">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Semester Name</th>
                            <th>Start date</th>
                            <th>End date</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>SU2022</td>
                            <td>2022-05-29</td>
                            <td>2022-09-30</td>

                        </tr>
                        <tr>
                            <td>2</td>
                            <td>FA2021</td>
                            <td>2021-07-10</td>
                            <td>2021-10-10</td>

                        </tr>
                        <tr>
                            <td>3</td>
                            <td>SU2021</td>
                            <td>2021-05-28</td>
                            <td>2021-09-28</td>

                        </tr>
                        <tr>
                            <td>4</td>
                            <td>SP2022</td>
                            <td>2022-01-10</td>
                            <td>2022-05-10</td>
                        </tr>
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
        <!-- sem -->

        <footer>
            <%@include file="footer.jsp" %>
        </footer>
        
        <% }
        %>
        
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/main.js"></script>
        <script src="js/sem.js"></script>
    </body>
</html>
