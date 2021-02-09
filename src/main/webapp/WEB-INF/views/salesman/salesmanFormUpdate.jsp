<%-- 
    Document   : productFormUpdate
    Created on : Feb 4, 2021, 12:49:38 PM
    Author     : Leyteris
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Update</title>
    </head>
    <body>
        <h1>Update product</h1>
        <form method="POST" action="${pageContext.request.contextPath}/salesman/update">
            <input type="number" name="scode" id="scode" value="${salesmanToEdit.scode}" hidden="true">
            <table>
                <tr>
                    <th><label for="sname">Name</label></th>
                    <th><input type="text" name="sname" id="sname" value="${salesmanToEdit.sname}"></th>
                </tr> 
                <tr>
                    <th><label for="scity">City</label></th>
                    <th>
                        <select name="scity" id="scity">
                            <option value="${salesmanToEdit.scity}" selected="true">${salesmanToEdit.scity}</option>
                            <c:forEach items="${listOfCities}"  var = "city">
                                <c:if test="${salesmanToEdit.scity!=city}">
                                    <option value="${city}">${city}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </th>
                </tr> 
                <tr>
                    <th><label for="scomm">Commission</label></th>
                    <th><input type="number" step="0.01" name="scomm" id="scomm" value="${salesmanToEdit.scomm}"></th>
                </tr>
                <tr>
                    <th colspan="2"><input type="submit" value="Update salesman"></th>
                </tr> 
            </table>
        </form>

    </body>
</html>
