<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Family</title>
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
        <div><a href="${pageContext.request.contextPath}/salesman">Back to Salesmen</a></div>      

        <c:if test="${listOfFamily==null}">
            <h1>No family members found for the specific salesman</h1>
        </c:if>

        <c:if test="${listOfFamily!=null}">
            <h1>Family List of Salesman:</h1>
            <div>
                <table>
                    <thead>
                        <tr>
                            <th>Code</th>
                            <th>Name</th>
                            <th>Relationship</th>
                            <th>Dob</th>                          
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listOfFamily}"  var = "familyMember">
                            <tr>
                                <td>${familyMember.fid}</td>
                                <td>${familyMember.fname}</td>
                                <td>${familyMember.frelationship}</td>
                                <td>${familyMember.dob}</td>                            
                            </tr>                        
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </body>
</html>