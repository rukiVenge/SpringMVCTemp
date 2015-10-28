

<%-- 
    Document   : postjsp
    Created on : 02 15, 13, 2:00:14 PM
    Author     : mpineda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="stags" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Name Registration</title>
    </head>
    <body>
        <marquee behavior="alternate"><h1>Hello !</h1></marquee>
        
        <center>
          <form name="name" method="post" action="/training/postsample1.htm"> 

              <strong>First name:</strong><input type="text" name="firstName"/> <br>  
    
              <strong>Last name:</strong> <input type="text" name="lastName"/>  <br> 
              &nbsp;                                                         &nbsp;
              <input type="submit" value="Submit"/>                               
          </form>
        </center>
    </body>
</html>
