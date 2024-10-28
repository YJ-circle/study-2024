
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<form action="/spring/registration">
id: <input type="number" name="id"/><br/>
name: <input type="text" name="name"/><br/>
password: <input type="text" name="password"/><br/>
email: <input type="text" name="email"/><br/>
<input type="submit" value="가입"/>
</form>
</body>

</html>
