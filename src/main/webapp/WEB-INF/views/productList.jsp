<%-- 
    Document   : productList
    Created on : Feb 4, 2021, 12:44:31 PM
    Author     : Leyteris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
    </head>
    <body>
        <div><a href="${pageContext.request.contextPath}/">Home</a></div>
        <div><a href="${pageContext.request.contextPath}/product/create">Add Product</a></div>

        <div><h3>${message}</h3></div>
        
        <h1>Product List:</h1>
        <div>
            <table>
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Description</th>              
                        <th>Price</th>              
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listOfProducts}"  var = "product">
                        <tr>
                            <td>${product.pcode}</td>
                            <td>${product.pdescr}</td>
                            <td>${product.pprice}</td>
                            <td><a data-method="delete" href="${pageContext.request.contextPath}/product/delete/${product.pcode}">Delete</a></td>
                            <td><a href="${pageContext.request.contextPath}/product/update/${product.pcode}">Update</a></td>
                        </tr>                        
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
