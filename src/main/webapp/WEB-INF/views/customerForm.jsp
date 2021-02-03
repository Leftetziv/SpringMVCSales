<%-- 
    Document   : customerForm
    Created on : Feb 3, 2021, 8:42:12 PM
    Author     : Leyteris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Creation</title>
    </head>
    <body>
        <h1>Create your customer</h1>
        <form method="POST" action="${pageContext.request.contextPath}/customer/create">
            <table>                
                <tr>
                    <th><label for="code">Code:</label></th>
                    <th><input type="number" name="code" id="code"></th>
                </tr>               
                <tr>
                    <th><label for="code">Name:</label></th>
                    <th><input type="text" name="name"></th>
                </tr> 
                <tr>
                    <th colspan="2"><input type="submit"></th>
                </tr> 
            </table>
        </form>
    </body>
</html>
