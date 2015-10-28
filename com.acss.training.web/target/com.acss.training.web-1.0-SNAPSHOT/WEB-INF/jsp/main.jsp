<%-- 
    Document   : main
    Created on : 02 21, 13, 4:21:35 PM
    Author     : mpineda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="stags" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main</title>
    </head>
    <body bgcolor="F4F4F4">
    <center>
        <h2><stags:message code='lbl.greeting'/></h2>
        
        <c:out value="${successReg}"/><br>
        <c:out value="${success}"/><br>
        <c:out value="${successdelete}"/><br>
        
        <table bgcolor="0A84CA">
            <tr><td><font color="white"><stags:message code='lbl.ins'/></font></td></tr>

            <tr><td><h2><a href="/training/registration1010.htm"><stags:message code='lbl.new'/></a></h2></td></tr>

            <tr><td><h2><a href="/training/showresult.htm"><stags:message code='lbl.search'/></a></h2></td></tr>

            <tr><td><h2><a href="/training/showresult.htm"><stags:message code='lbl.update'/></a></h2></td></tr>

            <tr><td><h2><a href="/training/deleteRecord.htm"><stags:message code='lbl.delete'/></a></h2></td></tr>
        </table>
        
         <br><br><br>
        
        <table>
            <tr>
                <td>
                    <a href="/training/locale.htm?lang=en&redpage=<c:out value="${redpage}"/>">English</a>
                    <a href="/training/locale.htm?lang=en&cn=PH&redpage=<c:out value="${redpage}"/>">Filipino</a>
                </td>
            </tr>
        </table>
                
    </center>
    </body>
</html>
