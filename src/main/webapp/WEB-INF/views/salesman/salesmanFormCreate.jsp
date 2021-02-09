<%-- 
    Document   : productFormCreate
    Created on : Feb 4, 2021, 12:47:52 PM
    Author     : Leyteris
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salesman Creation</title>
    </head>
    <body>
        <h1>Create your Salesman</h1>
        <form method="POST" action="${pageContext.request.contextPath}/salesman/create">
            <table>                
                <tr>
                    <th><label for="sname">Name</label></th>
                    <th><input type="text" name="sname" id="sname"></th>
                </tr> 
                <tr>
                    <th><label for="scity">City</label></th>
                    <th>
                        <select  name="scity" id="scity">
                            <c:forEach items="${listOfCities}" var="city">
                                <option value="${city}">${city}</option>
                            </c:forEach>
                        </select>
                    </th>
                </tr> 
                <tr>
                    <th><label for="scomm">Commission</label></th>
                    <th><input type="number" step="0.01" name="scomm" id="scomm"></th>
                </tr> 
                <tr>
                    <th colspan="2"><input type="submit" value="Submit salesman"></th>
                </tr> 
            </table>
        </form>

    </body>
</html>
