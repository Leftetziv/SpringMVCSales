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
                    <th><input type="number" name="ccode" id="ccode" readonly="true"></th>
                </tr>               
                <tr>
                    <th><label for="name">Name:</label></th>
                    <th><input type="text" name="cname" id="cname"></th>
                </tr> 
                <tr>
                    <th colspan="2"><input type="submit" value="Submit customer"></th>
                </tr> 
            </table>
        </form>
            
     </body>
</html>
