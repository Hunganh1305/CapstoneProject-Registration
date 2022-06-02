<%-- 
    Document   : student
    Created on : Jun 2, 2022, 8:36:38 AM
    Author     : SE161740 Pham Nguyen Hung Anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <c:forEach var="item" items="${student.items}" varStatus="loop">
            <form>
                    <tr>
                        <td class="text-right">${loop.count}</td>
                        <td class="text-right">${item.StudentId}</td>
                        <td class="text-right">${item.Name}</td>
                        <td class="text-right">${item.Password}</td>
                        <td class="text-right">${item.Status}</td>
                        <td class="text-right">${item.Email}</td>
                        <td class="text-right">${item.DepartmentId}</td>                        
                    </tr>
                </form>
            </c:forEach>
    </body>
</html>
