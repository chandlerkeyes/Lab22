<%--
  Created by IntelliJ IDEA.
  User: chand
  Date: 7/21/2017
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Grocery Store</title>
</head>
<body>
<h1>Item List</h1>
<table>
    <c:forEach items="${dbResult}" var="list">
        <tr>
            <td><c:out value="${list}"></c:out></td>
        </tr>
    </c:forEach>
</table>
<br>
<br>
<a href="/registration">Register Here!</a>
</body>
</html>
