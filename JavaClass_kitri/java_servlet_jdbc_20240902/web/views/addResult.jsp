<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>추가 결과</title>
<style>
body{
	margin-left: 20px;
}
.table{
	width:30%;
	margin-bottom: 20px;
}
</style>
</head>
<body>
	<h1>${result}</h1>
	<h2>추가 정보: </h2>
	<table style="text-align:center;" class="table">
	<tr>
		<td>학번</td>
		<td>이름</td>
	</tr>
	<c:forEach var="student" items="${list}">
		<tr>
			<td>${student.stu_id}</td>
			<td>${student.stu_name}</td>
		</tr>
	</c:forEach>
	</table>
	<br />
	<button onclick="location.href='addstudent'" class="btn-primary">입력 창으로 돌아가기</button >
	<button onclick="location.href='getstuinfo'"  class="btn-primary">학생 목록 조회</button >
</body>
</html>