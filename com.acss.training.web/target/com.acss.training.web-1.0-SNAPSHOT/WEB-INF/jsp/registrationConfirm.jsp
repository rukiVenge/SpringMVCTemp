<%-- 
    Document   : registrationConfirm
    Created on : 02 21, 13, 8:25:05 AM
    Author     : mpineda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <h4>Are you sure you want to register this record ?</h4>
        <table>
            <tr>
                <td>
                    <form name="cofirmYes" method="POST" action="/confirmRegistration.htm">
                        <input type="submit" value="Yes"/>
                    </form>
                    <form name="cofirmNo" method="POST" action="registration1010.htm">
                        <input type="submit" value="No"/>
                    </form>
                </td>
            </tr>
        </table>
        
        
    </body>
</html>
