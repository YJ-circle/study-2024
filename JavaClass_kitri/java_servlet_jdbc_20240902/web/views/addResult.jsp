<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추가 결과</title>
</head>
<body>
	<h1>${result}</h1>
	<h2>추가 정보: </h2>
	<table border="1" style="text-align:center;">
	<tr>
		<td>학번</td>
		<td>전공 코드</td>
		<td>이름</td>
		<td>연락처</td>
	</tr>
	<c:forEach var="student" items="${list}">
		<tr>
			<td>${student.stu_id}</td>
			<td>${student.stu_major}</td>
			<td>${student.stu_name}</td>
			<td>${student.stu_phone}</td>
		</tr>
	</c:forEach>
	</table>
	<br />
	<button onclick="location.href='addstudent'">입력 창으로 돌아가기</button >
</body>
</html>