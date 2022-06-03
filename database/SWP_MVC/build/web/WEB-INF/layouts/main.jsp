<%-- 
    Document   : main
    Created on : May 29, 2022, 9:02:28 PM
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
        <div class="container body-contain">
            <div class="row content py-3">
                <div class="col">                    
                    <jsp:include page="/WEB-INF/views/${controller}/${action}.jsp" />
                </div>
            </div>
        </div>
        
    </body>
</html>
