<%@ page import="java.util.List" %>
<%@ page import="ru.javawebinar.topjava.model.Meal" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<h2>Meals</h2>
    <table style="border: 1px solid black; border-collapse: collapse;">
        <thead>
            <tr style="font-weight: bold">
                <td style="border: 1px solid black; padding: 5px">Date</td>
                <td style="border: 1px solid black; padding: 5px">Description</td>
                <td style="border: 1px solid black; padding: 5px">Calories</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${mealsTo}" var="meal">
                <tr style="${meal.isExcess() ? 'color: red' : 'color: green'}">
                    <td style="border: 1px solid black; padding: 5px">${meal.getLocalDateTimeStr()}</td>
                    <td style="border: 1px solid black; padding: 5px">${meal.description}</td>
                    <td style="border: 1px solid black; padding: 5px">${meal.calories}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
