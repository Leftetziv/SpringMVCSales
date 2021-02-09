<%-- 
    Document   : productFormUpdate
    Created on : Feb 4, 2021, 12:49:38 PM
    Author     : Leyteris
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Update</title>
    </head>
    <body>
        <h1>Update product</h1>
        <form:form modelAttribute="politis" method="POST" action="${pageContext.request.contextPath}/salesman/update">
            <form:hidden path="scode"/>
            <table>
                <tr>
                    <th><form:label path="sname">Name</form:label></th>
                    <th><form:input path="sname"/></th>
                </tr> 
                <tr>
                    <th><form:label path="scity">City</form:label></th>
                        <th>
                        <form:select path="scity">
                            <form:option  value="${politis.scity}" selected="true">${politis.scity}</form:option>
                            <c:forEach items="${listOfCities}"  var = "city">
                                <c:if test="${politis.scity!=city}">
                                    <form:option value="${city}">${city}</form:option>
                                </c:if>
                            </c:forEach>
                        </form:select>
                    </th>
                </tr> 
                <tr>
                    <th><form:label path="scomm">Commission</form:label></th>
                    <th><form:input step="0.01" path="scomm"/></th>
                </tr>
                <tr>
                    <th colspan="2"><input type="submit" value="Update salesman"></th>
                </tr> 
            </table>
        </form:form>
    </body>
</html>
