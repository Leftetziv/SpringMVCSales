<%-- 
    Document   : productFormCreate
    Created on : Feb 4, 2021, 12:47:52 PM
    Author     : Leyteris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Creation</title>
    </head>
    <body>
        <h1>Create your Product</h1>
        <form method="POST" action="${pageContext.request.contextPath}/product/create">
            <input type="number" name="pcode" id="pcode" hidden="true">
            <table>                
<!--                <tr>
                    <th><label for="pcode">Code:</label></th>
                    <th><input type="number" name="pcode" id="pcode"></th>
                </tr>               -->
                <tr>
                    <th><label for="pdescr">Description:</label></th>
                    <th><input type="text" name="pdescr" id="pdescr"></th>
                </tr> 
                <tr>
                    <th><label for="pprice">Price:</label></th>
                    <th><input type="number" name="pprice" id="pprice"></th>
                </tr> 
                <tr>
                    <th colspan="2"><input type="submit" value="Submit product"></th>
                </tr> 
            </table>
        </form>
            
     </body>
</html>
