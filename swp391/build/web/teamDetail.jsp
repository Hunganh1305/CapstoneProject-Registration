<%-- 
    Document   : teamDetail
    Created on : Jun 15, 2022, 8:46:18 AM
    Author     : phamquang
--%>
<%@page import="DTO.Users"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Dashboard - TeamDetail</title>

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Lato:700%7CMontserrat:400,600" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />

        <!-- Font Awesome Icon -->
         <link rel="stylesheet" href="css/font-awesome.min.css"> 

         
         <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="../css/bootstrap.min.css" />
        <!-- cdn font awesome -->

        <script src="https://kit.fontawesome.com/e7ea130b87.js" crossorigin="anonymous"></script>
        <!-- Custom stylesheet -->
        <link type="text/css" rel="stylesheet" href="../css/style.css" />

        <!--  stylessheet -->
        <link type="text/css" rel="stylesheet" href="../css/teamDetail.css" />
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

        <!-- topic -->
        <section id="team" class="container">
            <div class="team__header">
                <h2>Team detail</h2>
                <div class="btnControl">
                    <button class="team__btn">
                        <i class="fa-solid fa-right-to-bracket"></i> Quick Join A Team</button>
                </div>
            </div>          

            <div class="teamControl">

                <div>                                            
                    <table class="table teamMember mr-2">
                        <thead>
                            <tr>
                                <th>Team members</th>
                                <th> </th>
                                <th> </th>
                                <th><span class="tdTbl__success"> 5/5</span></th>
                            </tr>
                        </thead>
                        
                       <c:forEach var="item" items="${teamMembers}" varStatus="loop">
                        <tbody class="teamMemberBody row">
                            <tr class="col-sm-12">
                        <div>
                            <td class="">
                                <a href="#"><img class="avatar" src="../img/sample-avatar.jpg"
                                                            alt="Avatar"></a>
                            </td>
                            <td>${item.user.name}<br />                                
                                <!--<span class="tdTbl__danger">Leader</span>-->
                            </td>
                        </div>

                        <div>
                            <td class="tabProgramControl">
                                <span class="tabProgram">Java</span>
                                <span class="tabProgram">Web</span>
                                <span class="tabProgram">C#</span>
                                <span class="tabProgram">Backend</span>
                            </td>
                        </div>
                        </tr>
                        </tbody>   
                        </c:forEach>
                        
                    </table>
                    
                </div>
                <!--  -->
                <div>
                    <table class="table teamInfor">
                        <thead>
                            <tr>
                                <th>Team information</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="tdControl">
                                    <div>
                                        <i class="fa  fa-bars"></i>
                                        Team name: <strong>${teamInfor.group.groupName}</strong>
                                    </div>
                                    <div class="join">
                                        <i class="fa-regular fa-copy"></i>
                                        Team ID: <strong>${teamInfor.groupId}</strong>
                                        <span class="ques_small "><i class="fa-regular fa-circle-question"></i></span>
                                        <p class="hided">Joining code for actived student in this semester to join this team
                                        </p>
                                    </div>
                                    <div>
                                        <i class="fa  fa-building"></i>
                                        Department: <span class="tabProgram">${teamInfor.department.name}</span>
                                    </div>
                                    <div>
                                        <i class="fa-solid fa-unlock-keyhole"></i>
                                        <span class="tdTbl__success">Locked</span>
                                        <span class="ques_small locked">
                                            <i class="fa-regular fa-circle-question"></i>
                                        </span>
                                        <p class="hided">This team can send application to topics in this semester</p>

                                       <i class="fa-solid fa-shield"></i>
                                        <span class="tdTbl__success">Public</span>
                                        <span class="ques_small public"><i class="fa-regular fa-circle-question"></i></span>
                                        
                                        <p class="hided">This team is visible to every actived student in this semester</p>

                                    </div>
                                </td>

                            </tr>
                            <tr>
                                <td>Description: ${teamInfor.project.description}  </td>
                            </tr>
                        </tbody>
                    </table>
                    <table class="table teamTopic">
                        <tbody>
                            <tr>
                                <td>
                                    ${teamInfor.project.name}
                                    <!--This team have not matched any topic yet-->
                                </td>
                            </tr>
                        </tbody>

                    </table>
                </div>

            </div>
        </section>
        <!-- topic -->

        <footer>
            <%@include file="footer.jsp" %>
        </footer>
        
        <% }
        %>
        
        <script src="./js/topic.js"></script>
    </body>

</html>
