<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="./sessiontest" method="post">
id: <input type="text" name="id" required/>
pw: <input type="text" name="pwd" required/>
<input type="submit" value="로그인"/>
${text}
</form>
</body>
</html>