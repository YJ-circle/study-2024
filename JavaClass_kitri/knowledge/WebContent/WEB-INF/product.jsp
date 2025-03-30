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
	<table border="1" style="text-align:center">
	<tr style="font-weight: bold">
	<td>용도</td>
	<td>중량</td>
	<td>개수</td>
	<td>가격</td>
	</tr>
	<c:forEach var="product" items="${list}">
		
		<tr>
			<td><a href="./click?type=${product.type}">${product.type}</a></td>
			<td>${product.weight}${product.weightUnit}</td>
			<td>${product.getCountToString()}</td>
			<td>${product.getPriceToString()}</td>
		</tr>

	</c:forEach>
	</table>
</body>
</html>