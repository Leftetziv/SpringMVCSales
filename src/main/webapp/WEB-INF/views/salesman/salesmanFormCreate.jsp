<%-- 
    Document   : productFormCreate
    Created on : Feb 4, 2021, 12:47:52 PM
    Author     : Leyteris
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salesman Creation</title>
    </head>
    <body>
        <h1>Create your Salesman</h1>      
        <form:form modelAttribute="politis" method="POST" action="${pageContext.request.contextPath}/salesman/create">
            <table>                
                <tr>
                    <th><label for="sname">Name</label></th>
                    <th>
                        <form:input path="sname"/>
                        <form:errors path="sname"/>
                    </th>
                </tr> 
                <tr>
                    <th><label for="scity">City</label></th>
                    <th>
                        <form:select path="scity" id="scity">
                            <c:forEach items="${listOfCities}" var="city">
                                <form:option value="${city}">${city}</form:option>
                            </c:forEach>
                        </form:select>
                        <form:errors path="scity"/>
                    </th>
                </tr> 
                <tr>
                    <th><label for="scomm">Commission</label></th>
                    <th><form:input path="scomm"/><form:errors path="scomm"/></th>
                </tr> 
                <tr>
                    <th colspan="2"><input type="submit" value="Submit salesman"></th>
                </tr> 
            </table>
        </form:form>

    </body>
</html>
