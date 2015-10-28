<%-- 
    Document   : updateConfirm
    Created on : 02 21, 13, 12:09:51 PM
    Author     : mpineda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="stags" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete</title>
    </head>
    <body bgcolor="EEEEEE">
        <h1><stags:message code='lbl.wait'/></h1>

        
        <h4><stags:message code='lbl.update.message'/></h4>
        <table>
            <tr>
                <td>
                    <form name="cofirmYes" method="POST" action="/training/confirmUpdate.htm">
                        <input type="submit" value="<stags:message code='btn.updateY'/>"/>
                    </form>
                    <form name="cofirmNo" method="GET" action="/training/main.htm">
                        <input type="submit" value="<stags:message code='btn.updateN'/>"/>
                    </form>
                </td>
            </tr>
        </table>
        
        
        
    </body>
</html>
