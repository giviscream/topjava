<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://example.com/functions" prefix="f" %>
<html>
<head>
    <title>Meals</title>
    <style>
        <%@include file="/WEB-INF/css/meals.css"%>
    </style>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<h2>Meals</h2>
    <table>
        <thead>
            <tr style="font-weight: bold">
                <td>Date</td>
                <td>Description</td>
                <td>Calories</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${mealsTo}" var="meal">
                <tr style="color:${meal.excess ? 'red' : 'green'}">
                    <td>${f:formatLocalDateTime(meal.dateTime)}</td>
                    <td>${meal.description}</td>
                    <td>${meal.calories}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
