<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="kelvin" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to the Dead House</title>
    </head>

    <body bgcolor="black">
       
      <font color="white">
       <marquee> <h1>WELCOME !  Wuahahahahahahahahahahahahahahahahahaahahahahahahahahahahahahahahahahahahahahahahahahahahahahhahahahahahahahahahahahahahahaahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahaahahahahahahahahahahahahahahahahahahahahahaha</h1></marquee><br>
        <p>Hello <kelvin:out value="${name.firstName}"/>
            <br>
            <kelvin:out value="${name.lastName}"/>
            <br>
            <kelvin:out value="${name.age}"/>
            <br>
            <kelvin:out value="${name.fear}"/>
            
                ⌠                                                                   
            <br> This is the Dead house. May you find the right room to scare you ! 
                                                                                   ⌡
        </p>
      </font>  
    </body>
</html>
