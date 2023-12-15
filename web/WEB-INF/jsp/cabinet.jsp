<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <fmt:setLocale value='${pageContext.response.locale}' scope="session"/>
    <fmt:bundle basename="com.localization.messages.msg">
        <c:url var="css" value="/resources/css/myStyle.css"></c:url>
        <link rel="stylesheet" href="${css}" type="text/css"/>
        <script type="text/javascript" src="${js}"></script>
        <style>
            <%@include file="/resources/css/myStyle.css"%>
        </style>
    
</head>
<body>
    <h1 align="center"><fmt:message key="welcome.message"/><%= session.getAttribute("name")%></h1>
    
    <form action="ListServlet" method="get" align="center">
        <h2 align="center"><fmt:message key="label.fullCustomerList" /></h2>
        <button class="b" type="submit"><fmt:message key="button.find" /></button>
    </form>

    <form action="CreditCardNumberServlet" method="post" align="center">
        <h2 align="center"><fmt:message key="label.searchByCreditCardNumber" /></h2>
        <label><fmt:message key="label.from" />: <input type="number" name="start"></label>
        <label><fmt:message key="label.to" />: <input type="number" name="end"></label>
        <button class="b" type="submit"><fmt:message key="button.find" /></button>
    </form>
    
    <form action="IdServlet" method="post" align="center">
        <h2 align="center"><fmt:message key="label.searchById" /></h2>
        <label><input type="number" name="id"></label>
        <button class="b" type="submit"><fmt:message key="button.find" /></button>
    </form>

    <form action="CardbalanceServlet" method="post" align="center">
        <h2 align="center"><fmt:message key="label.searchByCardBalance" /></h2>
        <label><input type="number" name="cardbalance" max="9"></label>
        <button class="b" type="submit"><fmt:message key="button.find" /></button>
    </form>

    <form action="page" method="post">
        <input type="hidden" name="page" value="toLogin">
        <input type="submit" value="<fmt:message key="toHomepage" />">
    </form>  
</body></fmt:bundle>
</html>
