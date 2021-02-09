<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--<h1>Hello from my first Spring MVC App!</h1>-->
        <h2>${mymessage}</h2>
        <div><a href="${pageContext.request.contextPath}/customer">Customers</a></div>
        <div><a href="${pageContext.request.contextPath}/product">Products</a></div>
        <div><a href="${pageContext.request.contextPath}/salesman">Salesman</a></div>
        
    </body>
</html>
