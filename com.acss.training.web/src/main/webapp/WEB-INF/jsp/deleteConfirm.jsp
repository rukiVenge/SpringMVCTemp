<%-- 
    Document   : deleteConfirm
    Created on : 02 21, 13, 5:56:19 PM
    Author     : mpineda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="stags" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete a record</title>
    </head>
    <body bgcolor="EEEEEE">
       <h1><stags:message code='lbl.wait'/></h1>

        
        <h4><stags:message code='lbl.delete.message'/></h4>
        <table>
            <tr>
                <td>
                    <form name="cofirmYes" method="POST" action="/training/confirmDelete.htm?<c:forEach items="${ids}" var="id">&delVal=<c:out value="${id}"/></c:forEach>">
                        <input type="submit" value="<stags:message code='btn.deleteY'/>"/>
                        
                    </form>
                    <form name="cofirmNo" method="GET" action="/training/main.htm">
                        <input type="submit" value="<stags:message code='btn.deleteN'/>"/>
                    </form>
                </td>
            </tr>
        </table>
        
    </body>
</html>
