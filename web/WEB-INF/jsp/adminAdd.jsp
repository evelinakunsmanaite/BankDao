<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <fmt:setLocale value='${pageContext.response.locale}' scope="session"/>
    <fmt:bundle basename="com.localization.messages.msg">
     <style>
            <%@include file="/resources/css/myStyle.css"%>
        </style>
</head>
<body>

    <!-- Форма добавления -->
    <h2><fmt:message key="label.adding" /></h2>
    <form action="AddServlet" method="post">

  <label for="lastName"><fmt:message key="label.lastName" /></label>
        <input type="text" name="lastName" required><br>

        <label for="firstName"><fmt:message key="label.firstName" /></label>
        <input type="text" name="firstName" required><br>

        <label for="middleName"><fmt:message key="label.middleName" /></label>
        <input type="text" name="middleName" required><br>

        <label for="address"><fmt:message key="label.address" /></label>
        <input type="text" name="address" required><br>

        <label for="creditCardNumber"><fmt:message key="label.creditCardNumber" /></label>
        <input type="number" name="creditCardNumber" required><br>

        <label for="bankAccountNumber"><fmt:message key="label.bankAccountNumber" /></label>
        <input type="number" name="bankAccountNumber" required><br>

        <label for="cardbalance"><fmt:message key="label.cardBalance" /></label>
        <input type="number" name="cardbalance" required><br>

        <input type="submit" value="<fmt:message key="button.submit" />">
    </form>

    <form action="page" method="post">
        <input type="hidden" name="page" value="toAdmin">
        <input type="submit" value="<fmt:message key="toHomepage" />">
    </form>  
</body>
    </fmt:bundle>

</html>
