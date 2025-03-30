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
<td>아이디</td>
<td>비밀번호</td>
<td>이름</td>
</tr>
<c:forEach var="m" items="${user}">
<tr>
<td>${m.id }</td>
<td>${m.pwd }</td>
<td>${m.name }</td>
</tr>
</c:forEach>
</table>
</body>
</html>