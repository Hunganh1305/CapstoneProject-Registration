<%-- Document : teamList Created on : Jun 15, 2022, 8:45:26 AM Author : phamquang --%>
<%@page import="DTO.Users"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Dashboard - Team List</title>

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Lato:700%7CMontserrat:400,600" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="../css/bootstrap.min.css" />

        <!-- Bootstrap Icon -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">

        <!-- Font Awesome Icon -->
        <!--        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />-->
        <script src="https://kit.fontawesome.com/e7ea130b87.js" crossorigin="anonymous"></script>

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="../css/style.css" />

        <!-- topic stylessheet -->
        <link type="text/css" rel="stylesheet" href="../css/topicTeamListStyle.css" />
    </head>

    <body>
        <% String name = (String) session.getAttribute("name");
            if (name == null) { %>
        <p>
            <font color='red'>You must login to view this page</font>
        </p>
        <p>Click <a href="Login.jsp">here</a> to login</p>
        <%} else {%>


        <!-- Header -->
        <header>
            <%@include file="header.jsp" %>
        </header>
        <!-- /Header -->



        <!-- topic -->
        <section id="topic" class="container">

            <div class="teamListControl">
                <div class="topic__title">
                    <h1>Team List</h1>
                </div>
                <div class="semester">
                    ${currentSem.name}
                    <div class="dropdown2">
                        <ul class="semester__list">
                            <c:forEach var="item" items="${semList}" varStatus="loop"> 
                                <li name="semester" class="semester__item" ><a  href="${root}/group/semester.do?semester=${item.name}">${item.name}</a></li>             
                                </c:forEach>
                        </ul>
                    </div>
                </div>


            </div>
            <div class="topic__container">

                <div class="teamListControl">
                    <h6 class="topic__text ">
                        All of public and unlocked teams in semester ${currentSem.name}_SWP
                    </h6>
                    <div class="btnControl">
                        <button class="team__btn"><a href="${root}/group/create.do?id=${userId}">+ Create A New Team</a> </button>
                    </div>
                </div>

                <hr>

                <div class="topic__search">
                    <form action="<c:url value="/group/search.do"/>">
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
                                <li class="filter__item" name="filter"><a
                                        href="${root}/group/filter.do?filter=Quan tri kinh doanh">Quan
                                        tri kinh doanh</a></li>
                                <li class="filter__item" name="filter"><a
                                        href="${root}/group/filter.do?filter=Cong nghe thong tin">Cong
                                        nghe thong tin</a></li>
                                <li class="filter__item" name="filter"><a
                                        href="${root}/group/filter.do?filter=Ngon ngu Anh">Ngon ngu
                                        Anh</a></li>
                                <li class="filter__item" name="filter"><a
                                        href="${root}/group/filter.do?filter=Ngon ngu Han Quoc">Ngon ngu
                                        Han Quoc</a></li>
                                <li class="filter__item" name="filter"><a
                                        href="${root}/group/filter.do?filter=Ngon ngu Nhat">Ngon ngu
                                        Nhat</a></li>
                            </ul>
                        </div>
                    </div>

                </div>

                <c:if test="${!empty list}">
                    <table class="table topic__table">
                        <thead>
                            <tr>
                                <th>DEP.</th>
                                <th>TeamName</th>
                                <th>Leader</th>
                                <th style="padding-left: 18px">Status</th>
                                <th>Detail</th>
                            </tr>
                        </thead>

                        <c:forEach var="list" items="${list}" varStatus="loop">

                            <tbody>
                                <tr>
                                    <td>${list.department.name}</td>
                                    <td>${list.group.groupName}</td>
                                    <td>${list.user.name}</td>
                                    <td><span
                                            class="tdTbl__warning">${list.project.status==1?"unlocked":"locked"}</span>
                                    </td>
                                    <td><a href="${root}/group/detail.do?id=${list.groupId}"><i class="fa fa-solid fa-eye"></i></a></td>
                                </tr>
                            </tbody>

                        </c:forEach>

                    </table>

                </c:if>


                <c:if test="${empty list}">
                    <div class="search-empty">
                        <img src="../img/search-empty.png" class="search-empty-icon" />
                        <div class="search-empty-title">Cannot find any group</div>
                        <div class="search-empty-hint">Try using more general keywords</div>
                    </div>
                </c:if>
                <hr>
                <c:if test="${!empty list}">
                    <c:if test="${action=='index'}">
                        <div class="row pageBtn">
                            <div class="col" style="text-align: right;">
                                <br/>
                                <form action="<c:url value="/group/index.do" />">
                                    <button type="submit" class="btn btn-warning  btn-info" name="op" value="FirstPage" title="First Page" <c:if test="${page==1}">disabled</c:if>><i class="bi bi-chevron-bar-left"></i></button>
                                    <button type="submit" class="btn btn-warning  btn-info" name="op" value="PreviousPage" title="Previous Page" <c:if test="${page==1}">disabled</c:if>><i class="bi bi-chevron-left"></i></button>
                                    <button type="submit" class="btn btn-warning  btn-info" name="op" value="NextPage" title="Next Page" <c:if test="${page==totalPage}">disabled</c:if>><i class="bi bi-chevron-right"></i></button>
                                    <button type="submit" class="btn btn-warning  btn-info" name="op" value="LastPage" title="Last Page" <c:if test="${page==totalPage}">disabled</c:if>><i class="bi bi-chevron-bar-right"></i></button>
                                    <input type="text" name="gotoPage" value="${page}" class="btn-warning btn-outline-info" style="padding:12px;text-align:left;color:#000;width:40px;" title="Enter page number"/>
                                    <button type="submit" class="btn btn-warning  btn-info" name="op" value="GotoPage" title="Goto Page"><i class="bi bi-arrow-up-right-circle"></i></button>
                                </form>
                                Page ${page}/${totalPage}
                            </div>
                        </div>
                    </c:if>

                    <c:if test="${action=='search'}">
                        <div class="row pageBtn">
                            <div class="col" style="text-align: right;">
                                <br/>
                                <form action="<c:url value="/group/search.do" />">
                                    <button type="submit" class="btn btn-warning  btn-info" name="op" value="FirstPage" title="First Page" <c:if test="${pageSearch==1}">disabled</c:if>><i class="bi bi-chevron-bar-left"></i></button>
                                    <button type="submit" class="btn btn-warning  btn-info" name="op" value="PreviousPage" title="Previous Page" <c:if test="${pageSearch==1}">disabled</c:if>><i class="bi bi-chevron-left"></i></button>
                                    <button type="submit" class="btn btn-warning  btn-info" name="op" value="NextPage" title="Next Page" <c:if test="${pageSearch==totalPageSearch}">disabled</c:if>><i class="bi bi-chevron-right"></i></button>
                                    <button type="submit" class="btn btn-warning  btn-info" name="op" value="LastPage" title="Last Page" <c:if test="${pageSearch==totalPageSearch}">disabled</c:if>><i class="bi bi-chevron-bar-right"></i></button>
                                    <input type="text" name="gotoPage" value="${pageSearch}" class="btn-warning btn-outline-info" style="padding:12px;text-align:left;color:#000;width:40px;" title="Enter page number"/>
                                    <button type="submit" class="btn btn-warning  btn-info" name="op" value="GotoPage" title="Goto Page"><i class="bi bi-arrow-up-right-circle"></i></button>
                                </form>
                                Page ${pageSearch}/${totalPageSearch}
                            </div>
                        </div>
                    </c:if>

                    <c:if test="${action=='filter'||action=='filter1'}">
                        <c:if test="${filter=='Quan tri kinh doanh'}">
                            <div class="row pageBtn">
                                <div class="col" style="text-align: right;">
                                    <br/>
                                    <form action="<c:url value="/group/filter1.do" />">
                                        <button type="submit" class="btn btn-warning  btn-info" name="op" value="FirstPage" title="First Page" <c:if test="${pageQTKD==1}">disabled</c:if>><i class="bi bi-chevron-bar-left"></i></button>
                                        <button type="submit" class="btn btn-warning  btn-info" name="op" value="PreviousPage" title="Previous Page" <c:if test="${pageQTKD==1}">disabled</c:if>><i class="bi bi-chevron-left"></i></button>
                                        <button type="submit" class="btn btn-warning  btn-info" name="op" value="NextPage" title="Next Page" <c:if test="${pageQTKD==totalPageQTKD}">disabled</c:if>><i class="bi bi-chevron-right"></i></button>
                                        <button type="submit" class="btn btn-warning  btn-info" name="op" value="LastPage" title="Last Page" <c:if test="${pageQTKD==totalPageQTKD}">disabled</c:if>><i class="bi bi-chevron-bar-right"></i></button>
                                        <input type="text" name="gotoPage" value="${pageQTKD}" class="btn-warning btn-outline-info" style="padding:12px;text-align:left;color:#000;width:40px;" title="Enter page number"/>
                                        <button type="submit" class="btn btn-warning  btn-info" name="op" value="GotoPage" title="Goto Page"><i class="bi bi-arrow-up-right-circle"></i></button>
                                    </form>
                                    Page ${pageQTKD}/${totalPageQTKD}
                                </div>
                            </div>
                        </c:if> 
                    </c:if>

                    <c:if test="${action=='filter'||action=='filter1'}">
                        <c:if test="${filter=='Cong nghe thong tin'}">
                            <div class="row pageBtn">
                                <div class="col" style="text-align: right;">
                                    <br/>
                                    <form action="<c:url value="/group/filter1.do" />">
                                        <button type="submit" class="btn btn-warning  btn-info" name="op" value="FirstPage" title="First Page" <c:if test="${pageCNTT==1}">disabled</c:if>><i class="bi bi-chevron-bar-left"></i></button>
                                        <button type="submit" class="btn btn-warning  btn-info" name="op" value="PreviousPage" title="Previous Page" <c:if test="${pageCNTT==1}">disabled</c:if>><i class="bi bi-chevron-left"></i></button>
                                        <button type="submit" class="btn btn-warning  btn-info" name="op" value="NextPage" title="Next Page" <c:if test="${pageCNTT==totalPageCNTT}">disabled</c:if>><i class="bi bi-chevron-right"></i></button>
                                        <button type="submit" class="btn btn-warning  btn-info" name="op" value="LastPage" title="Last Page" <c:if test="${pageCNTT==totalPageCNTT}">disabled</c:if>><i class="bi bi-chevron-bar-right"></i></button>
                                        <input type="text" name="gotoPage" value="${pageCNTT}" class="btn-warning btn-outline-info" style="padding:12px;text-align:left;color:#000;width:40px;" title="Enter page number"/>
                                        <button type="submit" class="btn btn-warning  btn-info" name="op" value="GotoPage" title="Goto Page"><i class="bi bi-arrow-up-right-circle"></i></button>
                                    </form>
                                    Page ${pageCNTT}/${totalPageCNTT}
                                </div>
                            </div>
                        </c:if> 
                    </c:if>

                    <c:if test="${action=='filter'||action=='filter1'}">
                        <c:if test="${filter=='Ngon ngu Anh'}">
                            <div class="row pageBtn">
                                <div class="col" style="text-align: right;">
                                    <br/>
                                    <form action="<c:url value="/group/filter1.do" />">
                                        <button type="submit" class="btn btn-warning  btn-info" name="op" value="FirstPage" title="First Page" <c:if test="${pageNNA==1}">disabled</c:if>><i class="bi bi-chevron-bar-left"></i></button>
                                        <button type="submit" class="btn btn-warning  btn-info" name="op" value="PreviousPage" title="Previous Page" <c:if test="${pageNNA==1}">disabled</c:if>><i class="bi bi-chevron-left"></i></button>
                                        <button type="submit" class="btn btn-warning  btn-info" name="op" value="NextPage" title="Next Page" <c:if test="${pageNNA==totalPageNNA}">disabled</c:if>><i class="bi bi-chevron-right"></i></button>
                                        <button type="submit" class="btn btn-warning  btn-info" name="op" value="LastPage" title="Last Page" <c:if test="${pageNNA==totalPageNNA}">disabled</c:if>><i class="bi bi-chevron-bar-right"></i></button>
                                        <input type="text" name="gotoPage" value="${pageNNA}" class="btn-warning btn-outline-info" style="padding:12px;text-align:left;color:#000;width:40px;" title="Enter page number"/>
                                        <button type="submit" class="btn btn-warning  btn-info" name="op" value="GotoPage" title="Goto Page"><i class="bi bi-arrow-up-right-circle"></i></button>
                                    </form>
                                    Page ${pageNNA}/${totalPageNNA}
                                </div>
                            </div>
                        </c:if> 
                    </c:if>

                    <c:if test="${action=='filter'||action=='filter1'}">
                        <c:if test="${filter=='Ngon ngu Han Quoc'}">
                            <div class="row pageBtn">
                                <div class="col" style="text-align: right;">
                                    <br/>
                                    <form action="<c:url value="/group/filter1.do" />">
                                        <button type="submit" class="btn btn-warning  btn-info" name="op" value="FirstPage" title="First Page" <c:if test="${pageNNH==1}">disabled</c:if>><i class="bi bi-chevron-bar-left"></i></button>
                                        <button type="submit" class="btn btn-warning  btn-info" name="op" value="PreviousPage" title="Previous Page" <c:if test="${pageNNH==1}">disabled</c:if>><i class="bi bi-chevron-left"></i></button>
                                        <button type="submit" class="btn btn-warning  btn-info" name="op" value="NextPage" title="Next Page" <c:if test="${pageNNH==totalPageNNH}">disabled</c:if>><i class="bi bi-chevron-right"></i></button>
                                        <button type="submit" class="btn btn-warning  btn-info" name="op" value="LastPage" title="Last Page" <c:if test="${pageNNH==totalPageNNH}">disabled</c:if>><i class="bi bi-chevron-bar-right"></i></button>
                                        <input type="text" name="gotoPage" value="${pageNNH}" class="btn-warning btn-outline-info" style="padding:12px;text-align:left;color:#000;width:40px;" title="Enter page number"/>
                                        <button type="submit" class="btn btn-warning  btn-info" name="op" value="GotoPage" title="Goto Page"><i class="bi bi-arrow-up-right-circle"></i></button>
                                    </form>
                                    Page ${pageNNH}/${totalPageNNH}
                                </div>
                            </div>
                        </c:if> 
                    </c:if>

                    <c:if test="${action=='filter'||action=='filter1'}">
                        <c:if test="${filter=='Ngon ngu Nhat'}">
                            <div class="row pageBtn">
                                <div class="col" style="text-align: right;">
                                    <br/>
                                    <form action="<c:url value="/group/filter1.do" />">
                                        <button type="submit" class="btn btn-warning  btn-info" name="op" value="FirstPage" title="First Page" <c:if test="${pageNNN==1}">disabled</c:if>><i class="bi bi-chevron-bar-left"></i></button>
                                        <button type="submit" class="btn btn-warning  btn-info" name="op" value="PreviousPage" title="Previous Page" <c:if test="${pageNNN==1}">disabled</c:if>><i class="bi bi-chevron-left"></i></button>
                                        <button type="submit" class="btn btn-warning  btn-info" name="op" value="NextPage" title="Next Page" <c:if test="${pageNNN==totalPageNNN}">disabled</c:if>><i class="bi bi-chevron-right"></i></button>
                                        <button type="submit" class="btn btn-warning  btn-info" name="op" value="LastPage" title="Last Page" <c:if test="${pageNNN==totalPageNNN}">disabled</c:if>><i class="bi bi-chevron-bar-right"></i></button>
                                        <input type="text" name="gotoPage" value="${pageNNN}" class="btn-warning btn-outline-info" style="padding:12px;text-align:left;color:#000;width:40px;" title="Enter page number"/>
                                        <button type="submit" class="btn btn-warning  btn-info" name="op" value="GotoPage" title="Goto Page"><i class="bi bi-arrow-up-right-circle"></i></button>
                                    </form>
                                    Page ${pageNNN}/${totalPageNNN}
                                </div>
                            </div>
                        </c:if> 

                    </c:if>
                </c:if>


        </section>
        <!-- topic -->

        <footer>
            <%@include file="footer.jsp" %>
        </footer>
        <% }%>
        <script type="text/javascript" src="../js/jquery.min.js"></script>
        <script type="text/javascript" src="../js/bootstrap.min.js"></script>
        <script type="text/javascript" src="../js/main.js"></script>
        <script src="../js/topic.js"></script>
    </body>