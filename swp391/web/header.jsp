<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : header
    Created on : Jun 15, 2022, 9:33:22 AM
    Author     : MinhPham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Header -->
        <header id="header">
            <div class="container">

                <div class="navbar-header">
                    <!-- Logo -->
                    <div class="navbar-brand">
                        <a class="logo" href="../profile.jsp">
                            <img src="../img/logo.png" alt="logo">
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
                        <li><a class="align-nav" href="<%=request.getContextPath()%>/project/show">Project</a></li>
                        <li><a class="align-nav" href="<c:url value="/topic/index.do"/>">Topic</a></li>
                        <li><a class="align-nav" href="<c:url value="/group/index.do"/>">Team List</a></li>
                        <li><a class="align-nav" href="../contact.jsp">Contact</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                <img class="avatar" src="../img/sample-avatar.jpg" alt="Avatar">
                            </a>
                            <div class="dropdown-menu">
                                <br>
                                <a class="dropdown-item" href="../profile.jsp">
                                    <span style="margin-right: 4px;" class="fa-solid fa-user fa-md"></span>
                                    <span>Profile</span>
                                </a>
                                <hr>
                                <a class="dropdown-item" href="MainController?action=logout">
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
    </body>
</html>
