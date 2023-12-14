<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>кабинет пользователя</title>
        <c:url var="css" value="/resources/css/myStyle.css"></c:url>
        <link rel="stylesheet" href="${css}" type="text/css"/>
        <script type="text/javascript"  src="${js}"></script>         
    </head>
    <body>
        <h1 align="center">Добро пожаловать, ${name}!</h1>
        <form action="ListServlet" method="get" align="center">
            <h2 align="center">Вывод полного списка клиентов</h2>
            <button class="b" type="submit">Найти</button>
        </form>

        <form action="CreditCardNumberServlet" method="post" align="center">
            <h2 align="center">Поиск клиента по номеру кредитной карты</h2>
            <label>От: <input type="number" name="start"></label>
            <label>До: <input type="number" name="end"></label>
            <button class="b" type="submit">Найти</button>
        </form>
        <form action="IdServlet" method="post" align="center">
            <h2 align="center">Поиск клиента по id</h2>
            <label><input type="number" name="id"></label>
            <button class="b" type="submit">Найти</button>
        </form>

        <form action="CardbalanceServlet" method="post" align="center">
            <h2 align="center">Поиск клиентов с балансом карты больше указанного значения</h2>
            <label><input type="number" name="cardbalance"></label>
            <button class="b" type="submit">Найти</button>
        </form>
        <form action="WelcomeServlet" align="center">
            <input type="hidden" name="logout" value="true"/>
            <input type="submit" value="Назад"/>
        </form>        
    </body>
</html>
