<%-- 
    Document   : customerFormUpdate
    Created on : Feb 4, 2021, 12:47:39 AM
    Author     : Leyteris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Update</title>
    </head>
    <body>
        <h1>Update customer</h1>
        <form method="POST" action="${pageContext.request.contextPath}/customer/update/${customerToEdit.ccode}">
            <table
                <tr>
                    <th><label for="ccode">Code:</label></th>
                    <th><input type="number" name="ccode" id="ccode" value="${customerToEdit.ccode}" disabled ></th>
                </tr>               
                <tr>
                    <th><label for="cname">Name:</label></th>
                    <th><input type="text" name="cname" id="cname" value="${customerToEdit.cname}"></th>
                </tr> 
                <tr>
                    <th colspan="2"><input type="submit" value="Update customer"></th>
                </tr> 
            </table>
        </form>
            
     </body>
</html>
