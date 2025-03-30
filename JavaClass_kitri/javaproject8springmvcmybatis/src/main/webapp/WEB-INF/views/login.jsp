<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
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

form, table {
	margin-top: 20px;
}

h1, h2, h3 {
	text-align: center;
}

input, button {
	display: block;
	width: auto;
	min-width: 100px;
	max-width: 300px;
	margin: 10px auto;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
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

a {
	display: block;
	margin: 10px auto;
	text-align: center;
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
	<h1>로그인</h1>
	<span style="color: red;">${message}</span>
	<br>
	<form action="${pageContext.request.contextPath}/login" method="post">
		<input type="text" name="id" placeholder="아이디" required><br>
		<br> <input type="password" name="pwd" placeholder="비밀번호"
			required><br>
		<br>
		<button type="submit">로그인</button>
	</form>


</body>
</html>