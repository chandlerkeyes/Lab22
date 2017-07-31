<%--
  Created by IntelliJ IDEA.
  User: chand
  Date: 7/31/2017
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Welcome!</title>
</head>
<body>
<h1> Hello ${username}</h1>
<h2>Welcome to my store!</h2>
<c:forEach items="${dbResult}" var="list">
    <tr>
        <td><c:out value="${list}"></c:out></td>
    </tr>
</c:forEach>
</body>
</html>
