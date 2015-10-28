<%-- 
    Document   : showResult
    Created on : 02 19, 13, 9:50:38 AM
    Author     : mpineda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="stags" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Result</title>
    </head>
    <body bgcolor="EEEEEE">
        <center><h1><stags:message code='lbl.search'/></h1></center>
    <center>
        <f:form method="POST" modelAttribute="search">
            
            <stags:message code='lbl.search.key'/><f:input path="searchKey"/>
            <input type="submit" value="<stags:message code='lbl.search'/>"/>
            <br><br><br>
           <center>
               <font color="white">
           <table bgcolor="0A84CA" style="border:double">
               
                <tr>
                        <td><strong>Id:</strong></td>
                        <td><strong><stags:message code='lbl.first.name'/></strong></td>
                        <td><strong><stags:message code='lbl.middle.initial'/></strong></td>
                        <td><strong><stags:message code='lbl.last.name'/></strong></td>
                        <td><strong><stags:message code='lbl.age'/></strong></td>
                        <td><strong><stags:message code='lbl.address'/></strong></td>
                        <td><strong><stags:message code='lbl.birth.date'/></strong></td>
               </tr>
                <c:forEach items="${result}" var="res">
                    
                    <tr>
                        <td><a href="/training/updateRecord.htm?profileId=<c:out value="${res.getProfileId()}"/>"><c:out value="${res.getProfileId()}"/></a></td>
                        <td><c:out value="${res.getFirstName()}"/></td>
                        <td><c:out value="${res.getMiddleInitial()}"/></td>
                        <td><c:out value="${res.getLastName()}"/></td>
                        <td><c:out value="${res.getAge()}"/></td>
                        <td><c:out value="${res.getAddress()}"/></td>
                        <td><c:out value="${res.getbDate().getTime()}"/></td>
                    </tr>
                    
                </c:forEach> 
          </table>
               </font>  
           </center>
      </f:form>      
   </center>
   

    </body>
</html>
