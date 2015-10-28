<%-- 
    Document   : registration
    Created on : 02 15, 13, 4:06:43 PM
    Author     : mpineda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="stags" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
        <style type="text/css"> 
            .error {color: red;}
        </style> 
    </head>
    <body bgcolor="EEEEEE">
    <center>
        <h1><stags:message code='lbl.greeting'/></h1>
        <h4><stags:message code='lbl.instruction'/></h4>
    </center>

        <sform:form method="POST" modelAttribute="customerpost"  >
            <table bgcolor="0A84CA" align="center">
                <tr><td><font color="red">*</font><strong><font color="white"><stags:message code='lbl.first.name'/></font></strong></td><td><sform:input path="firstName"/></td><td><sform:errors cssClass="error" path="firstName"/></td></tr>
                <tr><td><strong><font color="white"><stags:message code='lbl.middle.initial'/></font></strong></td><td><sform:input path="middleInitial"/></td></tr>
                <tr><td><font color="red">*</font><strong><font color="white"><stags:message code='lbl.last.name'/></font></strong></td><td><sform:input path="lastName"/></td><td><sform:errors cssClass="error" path="lastName"/></td></tr>
                <tr><td><font color="red">*</font><strong><font color="white"><stags:message code='lbl.age'/></font></strong></td><td><sform:input path="age"/></td><td><sform:errors cssClass="error" path="age"/></td></tr>
                <tr><td><font color="red">*</font><strong><font color="white"><stags:message code='lbl.birth.date'/></font></strong></td><td><sform:input path="bDate"/></td></tr> 
                <tr><td><strong><font color="white"><stags:message code='lbl.gender'/></font></strong></td><td><font color="white"><sform:radiobutton path="gender" value="M"/><stags:message code='lbl.gender.m'/></font></td></tr>
                <tr><td></td><td><font color="white"><sform:radiobutton path="gender" value="F"/><stags:message code='lbl.gender.f'/></font></td></tr>
                <tr><td><strong><font color="white"><stags:message code='lbl.mstatus'/></font></strong></td><td><font color="white"><sform:radiobutton path="status" value="S"/><stags:message code='lbl.mstatus.single'/></font></td></tr> 
                <tr><td></td><td><font color="white"><sform:radiobutton path="status" value="M"/><stags:message code='lbl.mstatus.married'/></font></td></tr>
                <tr><td></td><td><font color="white"><sform:radiobutton path="status" value="W"/><stags:message code='lbl.mstatus.widowed'/></font></td></tr>
                <tr><td><strong><font color="white"><stags:message code='lbl.address'/></font></strong></td><td><sform:input path="address"/></td></tr>
                <tr><td><strong><font color="white"><stags:message code='lbl.contact.number'/></font></strong></td><td><sform:input path="contactNumber"/></td></tr> 
                <tr><td><strong><font color="white"><stags:message code='lbl.email.address'/></font></strong></td><td><sform:input path="emailAddress"/></td></tr>  
                <tr><td><input type="Submit" value="<stags:message code='btn.save'/>"/></td></tr>
            </table>
                   
        </sform:form>

    </body>
</html>




