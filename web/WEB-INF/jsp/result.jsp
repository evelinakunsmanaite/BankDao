<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <c:url var="css" value="/resources/css/myStyle.css"></c:url>
        <link rel="stylesheet" href="${css}" type="text/css"/>
        <script type="text/javascript"  src="${js}"></script>        
    </head>
    <body>
        <c:choose>
            <c:when test="${not empty result}">
                <table>
                    <thead>
                    <th>id</th>
                    <th>Фамилия</th>
                    <th>Имя</th>
                    <th>Отчество</th>
                    <th>Адрес</th>
                    <th>Номер кредитной карты</th>
                    <th>Номер банковского счета</th>
                    <th>Баланс карты</th>
                </thead>
                <c:forEach var="cs" items="${result}">
                    <tr>
                        <td>${cs.id}</td>
                        <td>${cs.lastName}</td>
                        <td>${cs.firstName}</td>
                        <td>${cs.middleName}</td>
                        <td>${cs.address}</td>
                        <td>${cs.creditCardNumber}</td>
                        <td>${cs.bankAccountNumber}</td>
                        <td>${cs.cardbalance}</td>

                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <form align="center" class="e">
                <c:out value="искомые данные отсутствуют" />
            </form>
            <br>
            <c:url var="png" value="/resources/img/uh_oh.png"></c:url>
                <div style="display: flex; justify-content: center;">
                    <img src="${png}" style="width:100%; height:155%;" alt="uh_oh">
            </div>
        </c:otherwise>


    </c:choose>
    <form action="WelcomeServlet">
        <input type="hidden" name="toCab" value="true"/>
        <input type="submit" value="Назад"/>
    </form> 
</body>
</html>
