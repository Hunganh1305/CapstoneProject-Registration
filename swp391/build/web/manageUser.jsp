<%-- 
    Document   : manageUser
    Created on : 06/07/2022, 6:57:53 PM
    Author     : HLong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Admin - Manage Users</title>

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Lato:700%7CMontserrat:400,600" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />

        <!-- Font Awesome Icon -->
        <script src="https://kit.fontawesome.com/e7ea130b87.js" crossorigin="anonymous"></script>

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="./css/style.css" />

        <!-- user stylessheet -->
        <link type="text/css" rel="stylesheet" href="./css/manageUserStyle.css" />
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

        <!-- user -->
        <section id="user" class="container">
            <div class="teamListControl">
                <div class="user__title">
                    <h1>Manage Users</h1>

                </div>
                <div class="btnControl">

                    <button class="team__btn">+ Create New User</button>
                </div>
            </div>


            <div class="user__container">



                <div class="user__search">
                    <form action="">
                        <input placeholder=" " class="search__input" type="text">
                        <label for="search" class="search__label">Search by name</label>
                        <button type="submit" class="search-btn ">
                            <img src="img/search-interface-symbol.png" alt="">
                        </button>
                    </form>


                    <div class="user__filter">
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

                <table class="table user__table">
                    <thead>
                        <tr>
                            <th style="text-align: center">Id</th>
                            <th>Name</th>
                            <th>User status</th>
                            <th>Department</th>
                            <th style="text-align: center">Semester</th>
                            <th>Email</th>
                            <th style="text-align: center">Role</th>
                            <th style="text-align: center">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td style="text-align: center">2</td>
                            <td>Pham Cong Minh</td>
                            <td>Active</td>
                            <td>Cong nghe thong tin</td>
                            <td style="text-align: center">SU2022_SWP</td>
                            <td>phamcongminh@gmail.com</td>
                            <td style="text-align: center">Student</td>
                            <td style="text-align: center"><a href="#">Deactivate</a></td>
                        </tr>
                        <tr>
                            <td style="text-align: center">3</td>
                            <td>Ha Anh Tu</td>
                            <td>Active</td>
                            <td>Cong nghe thong tin</td>
                            <td style="text-align: center">SU2022_SWP</td>
                            <td>haanhtu@gmail.com</td>
                            <td style="text-align: center">Student</td>
                            <td style="text-align: center"><a href="#">Deactivate</a></td>
                        </tr>
                        <tr>
                            <td style="text-align: center">4</td>
                            <td>Pham Nguyen Hung Anh</td>
                            <td>Active</td>
                            <td>Cong nghe thong tin</td>
                            <td style="text-align: center">SU2022_SWP</td>
                            <td>hunganh@gmail.com</td>
                            <td style="text-align: center">Student</td>
                            <td style="text-align: center"><a href="#">Deactivate</a></td>
                        </tr>
                        <tr>
                            <td style="text-align: center">5</td>
                            <td>Pham Hong Quang</td>
                            <td>Deactivated</td>
                            <td>Cong nghe thong tin</td>
                            <td style="text-align: center">SU2022_SWP</td>
                            <td>phamhongquang@gmail.com</td>
                            <td style="text-align: center">Student</td>
                            <td style="text-align: center"><a href="#">Activate</a></td>
                        </tr>
                        <tr>
                            <td style="text-align: center">6</td>
                            <td>Lam Huu Khanh Phuong</td>
                            <td>Active</td>
                            <td>Cong nghe thong tin</td>
                            <td style="text-align: center">SU2022_SWP</td>
                            <td>phuonglhk@fe.edu.vn</td>
                            <td style="text-align: center">Lecturer</td>
                            <td style="text-align: center"><a href="#">Deactivate</a></td>
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
        <!-- user -->

        <footer>
            <%@include file="footer.jsp" %>
        </footer>
        
        <% }
        %>
        
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/main.js"></script>
        <script src="js/user.js"></script>
    </body>
</html>
