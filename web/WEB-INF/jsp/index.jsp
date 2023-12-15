<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="err" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>
    <fmt:setLocale value='${pageContext.response.locale}' scope="session"/>
    <fmt:bundle basename="com.localization.messages.msg">
        <c:url var="css" value="/resources/css/myStyle.css"></c:url>
        <link rel="stylesheet" href="${css}" type="text/css"/>
        <script type="text/javascript"  src="${js}"></script> 
        <style>
            <%@include file="/resources/css/myStyle.css"%>
        </style>
    </head>
    <body>
        <h1 align="center"><fmt:message key="login.page.title" /></h1>
        <p align="center"><fmt:message key="login.page.instructions" /></p>
        <err:error />
        <form action="LoginServlet" method="post" align="center">
            <label><fmt:message key="login.form.label.login" />&nbsp;&nbsp;</label>
            <input type="text" name="login"/><br/>
            <label><fmt:message key="login.form.label.password" /></label>
            <input type="password" name="pass"/><br/>
            <input type="submit" value="<fmt:message key='login.form.submit' />"/>
        </form>     
        
          
                    <form action="LocalServlet"> 
                        <div class="form-group form-button">
                            <input type="hidden" name="locale" value="en"/>
                            <input class="form-submit" type="submit" value='<fmt:message key="locale.button.en" />'/>
                        </div>
                    </form> 
                    <form action="LocalServlet"> 
                        <div class="form-group form-button">
                            <input type="hidden" name="locale" value="ru"/>
                            <input class="form-submit"  type="submit" name="locale" value='<fmt:message key="locale.button.ru" />'/>
                        </div>
                    </form>
    </body></fmt:bundle>
</html>
