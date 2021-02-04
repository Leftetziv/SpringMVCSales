<%-- 
    Document   : productFormUpdate
    Created on : Feb 4, 2021, 12:49:38 PM
    Author     : Leyteris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Update</title>
    </head>
    <body>
        <h1>Update product</h1>
        <form method="POST" action="${pageContext.request.contextPath}/product/update">
            <table
                <tr>
                    <th><label for="pcode">Code:</label></th>
                    <th><input type="number" name="pcode" id="pcode" value="${productToEdit.pcode}"  readonly="true" ></th>
                </tr>               
                <tr>
                    <th><label for="pdescr">Description:</label></th>
                    <th><input type="text" name="pdescr" id="pdescr" value="${productToEdit.pdescr}"></th>
                </tr> 
                <tr>
                    <th><label for="pprice">Price:</label></th>
                    <th><input type="number" name="pprice" id="pprice" value="${productToEdit.pprice}"></th>
                </tr> 
                <tr>
                    <th colspan="2"><input type="submit" value="Update product"></th>
                </tr> 
            </table>
        </form>
            
     </body>
</html>
