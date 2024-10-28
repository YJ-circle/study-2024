
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<form action="/spring/registrationpage">
id: <input type="number" name=id value="${user.id}" disabled="disabled"/><br/>
name: <input type="text" name=name  value="${user.name}" disabled="disabled"/><br/>
password: <input type="text" name=password  value="${user.password}" disabled="disabled"/><br/>
email: <input type="text" name=email  value="${user.email}" disabled="disabled"/><br/>
<input type="submit" value="초기화"/>
</form>
</body>

</html>
