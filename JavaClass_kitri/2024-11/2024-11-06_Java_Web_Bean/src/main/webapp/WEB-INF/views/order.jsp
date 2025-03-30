<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<td>주문 아이디</td>
<td>상품 아이디</td>
<td>사용자 아이디</td>
</tr>
<c:forEach var="m" items="${ord}">
<tr>
<td>${m.orderId}</td>
<td>${m.goodsId}</td>
<td>${m.userId}</td>
</tr>
</c:forEach>
</table>
</body>
</html>