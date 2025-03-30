<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
<form action="/webbrowser/gettest" method="GET">
<input type="text" name="id" required/>
<input type="text" name="pwd" required/>
<input type="submit" value="GET 로그인"/>
</form>
<br/> <br/>
<form action="/webbrowser/posttest" method="POST">
<input type="text" name="id" required/>
<input type="text" name="pwd" required/>
<input type="submit" value="POST 로그인"/>
</form>
</body>
</html>