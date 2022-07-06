<%-- 
    Document   : manageTopic
    Created on : 06/07/2022, 6:55:51 PM
    Author     : HLong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Admin - Manage Topics</title>

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Lato:700%7CMontserrat:400,600" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />

        <!-- Font Awesome Icon -->
        <script src="https://kit.fontawesome.com/e7ea130b87.js" crossorigin="anonymous"></script>

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="./css/style.css" />

        <!-- topic stylessheet -->
        <link type="text/css" rel="stylesheet" href="./css/topicAdminStyle.css" />
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

        <!-- topic -->
        <section id="topic" class="container">

            <div class="topic__title">
                <h1>Manage Topics</h1>
            </div>

            <div class="topic__container">
                <div class="topicListControl">
                    <h6 class="topic__text">
                        Topics waiting for approval semester SU2022_SWP
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

                </div>

                <table class="table topic__table">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>DEP.</th>
                            <th>Topic Name</th>
                            <th>Lecturer</th>
                            <th style="text-align: center">Status</th>
                            <th style="text-align: center">Action</th>
                            <th style="text-align: center">View</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>Quan tri kinh doanh</td>
                            <td>CPManagement-Review</td>
                            <td>[Phuonglhk] Lam Huu Khanh Phuong</td>
                            <td style="text-align: center">Approved</td>
                            <td style="text-align: center"><a href="#">Deny</a></td>
                            <td style="text-align: center"><a href="#"><i class="fa-solid fa-eye"></i></a></td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>Cong nghe thong tin</td>
                            <td>PetCareSystem</td>
                            <td>[Phuonglhk] Lam Huu Khanh Phuong</td>
                            <td style="text-align: center">Denied</td>
                            <td style="text-align: center"><a href="#">Approve</a></td>
                            <td style="text-align: center"><a href="#"><i class="fa-solid fa-eye"></i></a></td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>Cong nghe thong tin</td>
                            <td>PT Tranning app</td>
                            <td>[Phuonglhk] Lam Huu Khanh Phuong</td>
                            <td style="text-align: center">Not reviewed</td>
                            <td style="text-align: center"><a href="#">Approve</a><br><a href="#">Deny</a></td>
                            <td style="text-align: center"><a href="#"><i class="fa-solid fa-eye"></i></a></td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td>Cong nghe thong tin</td>
                            <td>Game Animation</td>
                            <td>[Phuonglhk] Lam Huu Khanh Phuong</td>
                            <td style="text-align: center">Not reviewed</td>
                            <td style="text-align: center"><a href="#">Approve</a><br><a href="#">Deny</a></td>
                            <td style="text-align: center"><a href="#"><i class="fa-solid fa-eye"></i></a></td>
                        </tr>
                        <tr>
                            <td>5</td>
                            <td>Cong nghe thong tin</td>
                            <td>CPManagement-Review</td>
                            <td>[Phuonglhk] Lam Huu Khanh Phuong</td>
                            <td style="text-align: center">Not reviewed</td>
                            <td style="text-align: center"><a href="#">Approve</a><br><a href="#">Deny</a></td>
                            <td style="text-align: center"><a href="#"><i class="fa-solid fa-eye"></i></a></td>
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

        <footer>
            <%@include file="footer.jsp" %>
        </footer>
        
        <% }
        %>
        
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/main.js"></script>
        <script src="js/topic.js"></script>
    </body>
</html>
