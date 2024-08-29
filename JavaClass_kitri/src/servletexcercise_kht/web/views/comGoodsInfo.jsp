<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회사-상품 정보</title>
</head>
<body>
	<table border="1">
	<c:forEach var="comgoodsdto" items="${comGoodsDtoList}">
		<tr>
			<td>${comgoodsdto.comName}</td>
			<td>${comgoodsdto.representative}</td>
			<td>${comgoodsdto.cd}</td>
			<td>${comgoodsdto.goodsName}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>