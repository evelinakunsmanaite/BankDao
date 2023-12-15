<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
            <!-- Таблица с абитуриентами -->
            <table>
                <thead>
                <th><fmt:message key="read" /></th>
                <table>
                    <thead>
                        <tr>
                            <th><fmt:message key="label.lastName" /></th>
                            <th><fmt:message key="label.firstName" /></th>
                            <th><fmt:message key="label.middleName" /></th>
                            <th><fmt:message key="label.address" /></th>
                            <th><fmt:message key="label.creditCardNumber" /></th>
                            <th><fmt:message key="label.bankAccountNumber" /></th>
                            <th><fmt:message key="label.cardBalance" /></th>
                            <th><fmt:message key="delete" /></th>
                            <th><fmt:message key="edit" /></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="customer" items="${customer}">
                            <tr>
                                <td>${customer.lastName}</td>
                                <td>${customer.firstName}</td>
                                <td>${customer.middleName}</td>
                                <td>${customer.address}</td>
                                <td>${customer.creditCardNumber}</td>
                                <td>${customer.bankAccountNumber}</td>
                                <td>${customer.cardbalance}</td>
                          
                        <td>
                            <form action="DeleteServlet" method="post">
                                <input type="hidden" name="id" value="${customer.id}"/>
                                <input type="submit" value="<fmt:message key="delete" />"/>
                            </form>
                        </td>
                        <td>
                            <form action="UpdateServlet">
                                <input type="hidden" name="id" value="${customer.id}"/>
                                <input type="submit" value="<fmt:message key="edit" />"/>
                            </form>
                        </td>
                          </tr>
                    </c:forEach>
                </table>
                <form action="page" method="post">
                    <input type="hidden" name="page" value="toAdmin">
                    <input type="submit" value="<fmt:message key="toHomepage" />">
                </form>
        </body>
    </fmt:bundle>
</html>
