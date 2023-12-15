<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>

<fmt:setLocale value='${pageContext.response.locale}' scope="session"/>
<fmt:bundle basename="com.localization.messages.msg">  
<c:url var="css" value="/resources/css/myStyle.css"></c:url>
        <link rel="stylesheet" href="${css}" type="text/css"/>
         <style>
            <%@include file="/resources/css/myStyle.css"%>
        </style>
    </head>
    <body>
        <h1 style='color:red;'>${error2}</h1>
        <form action="page" method="post">
            <input type="hidden" name="page" value="toLogin">
            <input type="submit" value="<fmt:message key="toHomepage" />">
        </form>  
    </body></fmt:bundle> 
</html>
