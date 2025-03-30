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
<c:if test="${result != null}">
	<script type="text/javascript">
		alert('${result}');
		location.href = './login';
	</script>
	</c:if>
	<form action="./login" method="post">
		<input type="text" placeholder="Id" name="id" required> <input
			type="password" placeholder="Password" name="password" required>
		<input type="submit" value="로그인" />
	</form>
</body>
</html>