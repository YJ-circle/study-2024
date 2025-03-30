<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 보기</title>
<style>
body {
	font-family: Arial, sans-serif;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	min-height: 100vh;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

table {
	width: 50%;
	border-collapse: collapse;
	margin: 20px 0;
}

th, td {
	padding: 10px;
	border: 1px solid #ddd;
	text-align: center;
}

h1 {
	text-align: center;
}

.message {
	color: red;
	text-align: center;
}
</style>
</head>
<body>
	<h1>게시글 제목: ${title}</h1>
	<table>
		<tbody>
			<tr>
				<td>${contents}</td>
			</tr>
		</tbody>
	</table>
	<form action="${pageContext.request.contextPath}/board" method="post">
		<button type="submit">뒤로가기</button>
	</form>
</body>
</html>