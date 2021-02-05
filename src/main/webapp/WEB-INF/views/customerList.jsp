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
        <style>
            table, td, th {
                border: 1px solid black;
                padding: 3px;
            }

            table {              
                border-collapse: collapse;
            }
            
            table a{
                text-decoration: none;
            }
            
            
        </style>
    </head>
    <body>
        <div><a href="${pageContext.request.contextPath}/">Home</a></div>
        <div><a href="${pageContext.request.contextPath}/customer/create">Add Customer</a></div>

        <div><h3>${message}</h3></div>

        <h1>Customer List:</h1>
        <div>
            <table border="1" style="border-collapse: collapse;">
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Name</th>
                        <th>Delete</th>              
                        <th>Update</th>   
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listOfCustomers}"  var = "customer">
                        <tr>
                            <td>${customer.ccode}</td>
                            <td>${customer.cname}</td>
                            <td><a href="${pageContext.request.contextPath}/customer/delete/${customer.ccode}">Delete</a></td>
                            <td><a href="${pageContext.request.contextPath}/customer/update/${customer.ccode}">Update</a></td>
                        </tr>                        
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
