<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kirya
  Date: 25.02.2023
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit product</title>
</head>
<body>
<h3> Edit product</h3>
<form method="post">
    <label for="id"></label>
    <input id="id" name="id" type="hidden" value="${product.id}">
    <label for="name">Name</label>
    <input id="name" name="name" value="${product.name}"><br><br>
    <label for="price">Price</label>
    <input id="price" name="price" value="${product.price}"><br><br>
    <input type="submit" value="Edit">
    <a href="<c:url value="/show"/>" style="border-bottom: black">cancel</a>
</form>
</body>
</html>
