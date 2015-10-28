<%-- 
    Document   : successRecord
    Created on : 02 15, 13, 4:44:15 PM
    Author     : mpineda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="kelvin" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="stags" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success</title>
    </head>
    <body bgcolor="000000">
        <h1><stags:message code='lbl.success'/></h1>
        <h3><stags:message code='lbl.success.message'/></h3>
        
        <a href="/training/main.htm"><stags:message code='lbl.success.redirect'/></a>
 
    </body>
</html>
