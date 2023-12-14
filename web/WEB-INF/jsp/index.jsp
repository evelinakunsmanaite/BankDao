<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Форма авторизации</title>
        <c:url var="css" value="/resources/css/myStyle.css"></c:url>
        <link rel="stylesheet" href="${css}" type="text/css"/>
        <script type="text/javascript"  src="${js}"></script> 

    </head>
    <body>
        <h1 align="center">Выполните вход в учетную запись</h1>
        <p align="center">Пожалуйста, заполните форму, чтобы войти в учётную запись</p>
        <form action="WelcomeServlet" method="post" align="center">
            <label>логин&nbsp;&nbsp;</label>
            <input type="text" name="login"/><br/>
            <label>пароль</label>
            <input type="password" name="pass"/><br/>
            <input type="submit" value="ввод"/>
        </form>        
    </body>
</html>
