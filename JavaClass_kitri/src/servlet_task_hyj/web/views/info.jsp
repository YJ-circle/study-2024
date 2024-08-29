<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보 보기</title>
</head>
<body>
	<table border="1">
	<c:forEach var="list" items="${list}">
		<tr>
			<td>${list.id}</td>
			<td>${list.name}</td>
			<td>${list.majorCode}</td>
			<td>${list.majorName}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>