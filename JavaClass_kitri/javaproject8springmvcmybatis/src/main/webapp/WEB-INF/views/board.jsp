<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록 보기</title>
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

a {
	color: blue;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}

.message {
	color: red;
	text-align: center;
}
</style>
</head>
<body>
	<h1>게시글 목록</h1>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="post" items="${postList}">
				<tr>
					<td>${post.seq}</td>
					<td>
					<a href="${pageContext.request.contextPath}/PostDetail?seq=${post.seq}">${post.title} </a>
					</td>
					<td>${post.id}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form action="${pageContext.request.contextPath}/logout" method="post">
		<button type="submit">로그아웃</button>
	</form>
</body>
</html>