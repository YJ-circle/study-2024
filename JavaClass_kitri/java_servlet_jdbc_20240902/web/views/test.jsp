<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>

<%@page import="test.TestYJ" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>외부 클래스 사용</title>
</head>
<body>
	<h1>모든 문자를 소문자로</h1>
	 <%= TestYJ.toLower("Hello World") %>
</body>
</html>