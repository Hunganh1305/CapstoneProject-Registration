<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Dashboard - Topic</title>

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Lato:700%7CMontserrat:400,600" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="../css/bootstrap.min.css" />

        <!-- Font Awesome Icon -->
<!--        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />-->
        <script src="https://kit.fontawesome.com/e7ea130b87.js" crossorigin="anonymous"></script>

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="../css/style.css" />

        <!-- topic stylessheet -->
        <link type="text/css" rel="stylesheet" href="../css/topicTeamListStyle.css" />
    </head>

    <body>
        <%
            String name = (String) session.getAttribute("name");
            if (name == null) { %>
                <p><font color='red'>You must login to view this page</font></p> 
                <p>Click <a href="Login.jsp">here</a> to login</p> 
        <%} else {%>
        <!-- Header -->
        <header>
            <%@include file="header.jsp" %>
        </header>
        <!-- /Header -->

        <!-- topic -->
        <section id="topic" class="container">

            <div class="topic__title">
                <h1>Topic List</h1>
            </div>

            <div class="topic__container">

                <h6 class="topic__text">
                    All of approved topics in semester SU2022_SWP
                </h6>

                <hr>

                <div class="topic__search">
                    <form action="<c:url value="/topic/search.do"/>">
                        <input placeholder=" " value="${searchText==null?"":searchText}" name="searchText" class="search__input" type="text">
                        <label for="search" class="search__label">Search by name</label>
                        <button type="submit" class="search-btn ">
                            <img src="../img/search-interface-symbol.png" alt="">
                        </button>
                    </form>

                    <div class="topic__filter">
                       <i class="fa fa-solid fa-sort"></i>Filters
                        <div class="dropdown1">
                            <ul class="filter__list">
                                <li class="filter__item" name="filter"><a href="${root}/topic/filter.do?filter=Quan tri kinh doanh">Quan tri kinh doanh</a></li>
                                <li class="filter__item" name="filter"><a href="${root}/topic/filter.do?filter=Cong nghe thong tin">Cong nghe thong tin</a></li>
                                <li class="filter__item" name="filter"><a href="${root}/topic/filter.do?filter=Ngon ngu Anh">Ngon ngu Anh</a></li>
                                <li class="filter__item" name="filter"><a href="${root}/topic/filter.do?filter=Ngon ngu Han Quoc">Ngon ngu Han Quoc</a></li>
                                <li class="filter__item" name="filter"><a href="${root}/topic/filter.do?filter=Ngon ngu Nhat">Ngon ngu Nhat</a></li>
                            </ul>
                        </div>
                    </div>

                </div>


                <c:if test="${!empty list}">
                    <table class="table topic__table">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>DEP.</th>
                                <th>Name</th>
                                <th>Lecturer</th>
                                <th>Detail</th>
                            </tr>
                        </thead>

                        <c:forEach var="item" items="${list}" varStatus="loop">                                                        
                                    <tbody>
                                        <tr> 
                                            <td>${item.topicId}</td>
                                            <td>${item.department.name}</td>
                                            <td>${item.name}</td>
                                            <td>${item.user.name}</td>
                                            <td><a href="./topicdetail.html"><i class="fa fa-solid fa-eye"></i></a></td>
                                        </tr>

                                    </tbody>                              
                        </c:forEach>
                    </table>

                </c:if>

                <c:if test="${empty list}">
                    <div class="search-empty">
                        <img src="../img/search-empty.png" class="search-empty-icon"/>
                        <div class="search-empty-title">Cannot find any group</div>
                        <div class="search-empty-hint">Try using more general keywords</div>
                    </div>
                </c:if>

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
        
        <% } %>
        
        <script type="text/javascript" src="../js/jquery.min.js"></script>
        <script type="text/javascript" src="../js/bootstrap.min.js"></script>
        <script type="text/javascript" src="../js/main.js"></script>
        <script src="../js/topic.js"></script>
    </body>

</html>