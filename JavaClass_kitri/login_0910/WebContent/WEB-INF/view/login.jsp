<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>5초 안에 로그인 하면 60분 동안만 페이지를 볼 수 있다.</h1>
<form action="./sessiontest" method="post">
id: <input type="text" name="id" required/>
pw: <input type="text" name="pwd" required/>
<input type="submit" value="로그인"/>
${text}
</form>
</body>
</html>