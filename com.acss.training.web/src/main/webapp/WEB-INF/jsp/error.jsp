<%-- 
    Document   : error
    Created on : 02 15, 13, 5:25:54 PM
    Author     : mpineda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">  .error {color: red;}   </style> 
    </head>
    <body>
       <stags:hasBindErrors name="name">            
              <p class="error">There is an error in the form!</p>         
          </stags:hasBindErrors> 
              <sform:form method="post" modelAttribute="name">
                    <table cellspacing="2" cellpadding="0">
                      <tr><td><strong>First Name</strong></td>
                             <td>&nbsp;</td><td><strong>Last Name</strong></td>
                      </tr>
                      <tr><td><sform:input path="firstName"/></td>
                             <td>&nbsp;</td><td><sform:input path="lastName"/></td>
                      </tr> 
                      <tr> 
                          <td><sform:errors class="error" path="firstName"/></td>
                          <td>&nbsp;</td>
                          <td><sform:errors class="error" path="lastName"/></td>
                      </tr>
                    </table>   
              </sform:form>
        <a href="registration1010.htm">Go back</a>
    </body>
</html>
