<%-- 
    Document   : recordDelete
    Created on : 02 20, 13, 6:26:07 PM
    Author     : mpineda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="stags" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete record</title>
    </head>
    <body bgcolor="EEEEEE">
        <center>
        <h1><stags:message code='lbl.delete'/></h1>
        </center>
        
       <center>
       <font color="white">
       <form action ="/training/deleteRecord.htm" method ="post">     
                <table bgcolor="0A84CA">
                
                    <tr>
                        <td>          </td>
                        <td><strong><stags:message code='lbl.first.name'/></strong></td>
                        <td><strong><stags:message code='lbl.middle.initial'/></strong></td>
                        <td><strong><stags:message code='lbl.last.name'/></strong></td>
                        <td><strong><stags:message code='lbl.age'/></strong></td>
                        <td><strong><stags:message code='lbl.address'/></strong></td>
                        <td><strong><stags:message code='lbl.birth.date'/></strong></td>
                    </tr>
                    <tr>
                        
                    <c:forEach items="${delrecord}" var="res">
                        <tr>
                            <td><input type="checkbox" name="checks" value ="<c:out value="${res.profileId}" />"</td>
                            <td><c:out value="${res.firstName}"/></td>
                            <td><c:out value="${res.middleInitial}"/></td>
                            <td><c:out value="${res.lastName}"/></td>
                            <td><c:out value="${res.age}"/></td>
                            <td><c:out value="${res.getAddress()}"/></td>
                            <td><c:out value="${res.getbDate().getTime()}"/></td>
                        </tr>
      
                    </c:forEach> 
                    </tr>
                    <tr>
                            <td><input type="submit" name="profileId" value="<stags:message code='btn.delete'/>"/> </td>
                    </tr>
            </table>
        </form>
        </font>
        </center>
    </body>
</html>
