<%-- 
    Document   : updatecustomerrecord
    Created on : 02 19, 13, 3:05:14 PM
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
        <title>Update Record</title>
    </head>
    <body bgcolor="EEEEEE">
    <center><h1><stags:message code='lbl.update'/></h1></center>
       <center>
            <f:form method="POST" modelAttribute="updrecord">

                <table bgcolor="0A84CA">

                    <tr><td><font color="red">*</font><strong><stags:message code='lbl.first.name'/></strong></td><td><f:input path="firstName"/></td></tr>
                    <tr><td><strong><stags:message code='lbl.middle.initial'/></strong></td><td><f:input path="middleInitial"/></td></tr>

                    <tr><td><font color="red">*</font><strong><stags:message code='lbl.last.name'/></strong></td><td><f:input path="lastName"/></td></tr>
                    <tr><td><strong><stags:message code='lbl.age'/> </strong></td><td><f:input path="age"/></td></tr>
                    <tr><td><strong><stags:message code='lbl.birth.date'/></strong></td><td><f:input path="bDate"/></td></tr> 
                    <tr><td><strong><stags:message code='lbl.gender'/></strong></td><td><f:radiobutton path="gender" value="M"/><stags:message code='lbl.gender.m'/></td></tr>
                    <tr><td></td><td><f:radiobutton path="gender" value="F"/><stags:message code='lbl.gender.f'/></td></tr>
                    <tr><td><strong><stags:message code='lbl.mstatus'/></strong></td><td><f:radiobutton path="status" value="S"/><stags:message code='lbl.mstatus.single'/></td></tr> 
                    <tr><td></td><td><f:radiobutton path="status" value="M"/><stags:message code='lbl.mstatus.married'/></td></tr>
                    <tr><td></td><td><f:radiobutton path="status" value="W"/><stags:message code='lbl.mstatus.widowed'/></td></tr>
                    <tr><td><strong><stags:message code='lbl.address'/></strong></td><td><f:input path="address"/></td></tr>

                    <tr><td><font color="red">*</font><strong><stags:message code='lbl.contact.number'/></strong></td><td><f:input path="contactNumber"/></td></tr> 
                    <tr><td><strong><stags:message code='lbl.email.address'/></strong></td><td><f:input path="emailAddress"/></td></tr>  

                    <tr><td><input type="submit" value="<stags:message code='btn.save'/>"/></td></tr>
                </table>
          </f:form>
       </center>
    </body>
</html>
