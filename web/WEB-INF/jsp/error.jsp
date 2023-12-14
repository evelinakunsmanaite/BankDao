<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ошибка</title>
        <c:url var="css" value="/resources/css/myStyle.css"></c:url>
        <link rel="stylesheet" href="${css}" type="text/css"/>
    </head>
    <body>
        <h1 style='color:red;'>${error}</h1>
        <form action="WelcomeServlet">
            <input type="submit" value="Назад"/>
        </form> 
    </body>
</html>
