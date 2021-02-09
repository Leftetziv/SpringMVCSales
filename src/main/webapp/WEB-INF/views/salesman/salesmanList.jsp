<%-- 
    Document   : customerList
    Created on : Feb 3, 2021, 8:04:31 PM
    Author     : Leyteris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salesman</title>
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
        <div><a href="${pageContext.request.contextPath}/salesman/create">Add Salesman</a></div>

        <div><h3>${message}</h3></div>

        <h1>Salesmen List:</h1>
        <div>
            <table>
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Name</th>
                        <th>City</th>
                        <th>Commission</th>
                        <th>Delete</th>              
                        <th>Update</th>   
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listOfSalesmen}"  var = "salesman">
                        <tr>
                            <td>${salesman.scode}</td>
                            <td>${salesman.sname}</td>
                            <td>${salesman.scity}</td>
                            <td>${salesman.scomm}</td>
                            <td><a href="${pageContext.request.contextPath}/salesman/delete/${salesman.scode}">Delete</a></td>
                            <td><a href="${pageContext.request.contextPath}/salesman/update/${salesman.scode}">Update</a></td>
                        </tr>                        
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
