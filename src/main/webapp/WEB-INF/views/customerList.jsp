<%-- 
    Document   : customerList
    Created on : Feb 3, 2021, 8:04:31 PM
    Author     : Leyteris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer</title>
    </head>
    <body>
        
        <div><a href="${pageContext.request.contextPath}/customer/create">Add Customer</a></div>
        
        <h1>Customer List:</h1>
        <div>
            <table>
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Name</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listOfCustomers}"  var = "customer">
                        <tr>
                            <td>${customer.ccode}</td>
                            <td>${customer.cname}</td>
                        </tr>                        
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
