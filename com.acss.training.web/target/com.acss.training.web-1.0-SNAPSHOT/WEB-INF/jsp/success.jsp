<%-- 
    Document   : success
    Created on : 02 15, 13, 2:23:50 PM
    Author     : mpineda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="kelvin" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p>First name: <kelvin:out value="${name.firstName}"/></p><br>
        <p>Last name:  <kelvin:out value="${name.lastName}"/></p>
    </body>
</html>
