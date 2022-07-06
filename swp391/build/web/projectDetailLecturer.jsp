<%-- 
    Document   : topicListLecturer
    Created on : 02/07/2022, 2:01:20 PM
    Author     : HLong
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Dashboard - Topic List</title>

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Lato:700%7CMontserrat:400,600" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="../css/bootstrap.min.css" />

        <!--       Bootstrap Icon -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">

        <!-- Font Awesome Icon -->
        <script src="https://kit.fontawesome.com/e7ea130b87.js" crossorigin="anonymous"></script>

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="../css/style.css" />

    </head>
    <body>

        <% String name = (String) session.getAttribute("name");
            if (name == null) { %>
        <p>
            <font color='red'>You must login to view this page</font>
        </p>
        <p>Click <a href="../Login.jsp">here</a> to login</p>
        <%} else {%>

        <!-- Header -->
        <header>
            <%@include file="headerLecturer.jsp" %>
        </header>
        <!-- /Header -->

        <!--content-->
    <section id="project">
        <div class="container">
            <div class="project-title">
                <h1 style="text-align: left">@Team Name - @Team ID</h1>
            </div>

            <div class="project-contents">
                <div class="project-left">
                    <div class="project-content">
                        <h6 class="project-name">Team information</h6>
                        <hr>
                        <ul class="project-list">
                            <li class="project-item">
                                <i class="fa fa-solid fa-bars col-sm-1"></i>
                                <span class="col-sm-4">Team name</span>
                                <span class="col-sm-7">ABCD</span>
                            </li>
                            <li class="project-item">
                                <i class="fa-solid fa-clone col-sm-1"></i>
                                <span class="col-sm-4">Joining code</span>
                                <span class="col-sm-7">2xhbx</span>
                            </li>
                            <li class="project-item">
                                <i class="fa-solid fa-clone col-sm-1"></i>
                                <span class="col-sm-4">Topic</span>
                                <span class="col-sm-7">Research And Developing Brands</span>
                            </li>
                            <li class="project-item">
                                <i class="fa fa-regular fa-building col-sm-1"></i>
                                <span class="col-sm-4">Department</span>
                                <div class="col-sm-7">
                                    <span class="blue-box">Information System</span>
                                </div>
                            </li>


                        </ul>
                        <div class="project-item" style="margin-top: 5px">
                            <i class="fa-solid fa-lock col-sm-1"></i>
                            <div class="col-sm-2">
                                <span class="green-box">Locked</span>
                            </div>
                            <span class="col-sm-2"></span>
                            <i class="fa-solid fa-shield col-sm-1"></i>
                            <div class="col-sm-2">
                                <span class="green-box">Public</span>
                            </div>
                        </div>

                    </div>
                </div>

                <div class="project-right">
                    <div class="project-content">
                        <h6 class="project-name">Team members</h6>
                        <hr>
                        <ul class="project-list">
                            <li class="project-item">
                                <div class="col-sm-2">
                                    <img class="avatar" src="../img/sample-avatar.jpg" alt="Avatar">
                                </div>
                                <span>Nguyên Văn A</span>
                            </li>
                            <li class="project-item">
                                <div class="col-sm-2">
                                    <img class="avatar" src="../img/sample-avatar.jpg" alt="Avatar">
                                </div>
                                <span>Nguyên Văn B</span>
                            </li>
                            <li class="project-item">
                                <div class="col-sm-2">
                                    <img class="avatar" src="../img/sample-avatar.jpg" alt="Avatar">
                                </div>
                                <span>Phạm Văn C</span>
                            </li>
                            <li class="project-item">
                                <div class="col-sm-2">
                                    <img class="avatar" src="../img/sample-avatar.jpg" alt="Avatar">
                                </div>
                                <span>Trần Thị D</span>
                            </li>
                        </ul>

                    </div>
                </div>
            </div>


        </div>
    </section>

    <!--/content-->

        <footer>
            <%@include file="footer.jsp" %>
        </footer>

        <% }
        %>

        <script type="text/javascript" src="../js/jquery.min.js"></script>
        <script type="text/javascript" src="../js/bootstrap.min.js"></script>
        <script type="text/javascript" src="../js/main.js"></script>
        <script src="../js/topic.js"></script>
    </body>
</html>
