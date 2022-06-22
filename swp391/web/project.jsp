<%-- 
    Document   : project
    Created on : Jun 13, 2022, 9:10:55 PM
    Author     : phamquang
--%>

<%@page import="DTO.Users"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <title>Dashboard - Project</title>

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Lato:700%7CMontserrat:400,600" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />

        <!-- Font Awesome Icon -->
        <script src="https://kit.fontawesome.com/e7ea130b87.js" crossorigin="anonymous"></script>

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
        <link type="text/css" rel="stylesheet" href="../css/projectStyle.css" />

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
            if (name == null) {
                response.sendRedirect("Login.jsp");
            } else {
        %>

        <!-- Header -->
        <header>
            <%@include file="header.jsp" %>
        </header>
        <!-- /Header -->

        <!--content-->
        <section id="project">
            <div class="container">
                <div class="project-title">
                    <h1 style="text-align: left">Project</h1>
                </div>
                <c:if test="${empty Group}">
                    <div class="search-empty">
                        <img src="../img/search-empty.png" class="search-empty-icon"/>
                        <div class="search-empty-title">You don't have any project yet!</div>
                        <div class="search-empty-hint">Join team and pick project</div>
                    </div>
                </c:if>
                <c:if test="${!empty Group}">
                    <div class="project-contents">
                        <div class="project-left">
                            <div class="project-content">
                                <h6 class="project-name">Team information</h6>
                                <hr>
                                <ul class="project-list">
                                    <li class="project-item">
                                        <i class="fa fa-solid fa-bars col-sm-1"></i>
                                        <span class="col-sm-4">Team name</span>
                                        <span class="col-sm-7">${Group.groupName}</span>
                                    </li>
                                    <li class="project-item">
                                        <i class="fa-solid fa-clone col-sm-1"></i>
                                        <span class="col-sm-4">Team ID</span>
                                        <span class="col-sm-7">${Group.groupId}</span>
                                    </li>
                                    <li class="project-item">
                                        <i class="fa fa-regular fa-building col-sm-1"></i>
                                        <span class="col-sm-4">Department</span>
                                        <div class="col-sm-7">
                                            <span class="blue-box">${DepName}</span>
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
                                    <%!  List<Users> list;%>
                                    <%
                                        list = (List<Users>) request.getAttribute("list");
                                        for (Users s : list) {
                                            out.print("<li class='project-item'>"
                                                    + "<div class='col-sm-2'>"
                                                    + "<img class=\"avatar\" src=\"../img/sample-avatar.jpg\" alt=\"Avatar\">"
                                                    + "</div>"
                                                    + "<span>" + s.getName() + "</span>"
                                                    + "</li>");
                                        }

                                    %>
                                </ul>

                            </div>
                        </div>
                    </div>
                </c:if>

            </div>
        </section>

        <!--/content-->

        <!-- topic -->

        <footer>
            <%@include file="footer.jsp" %>
        </footer>

        <% }
        %>

        <script src="./js/topic.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/main.js"></script>
    </body>

</html>
