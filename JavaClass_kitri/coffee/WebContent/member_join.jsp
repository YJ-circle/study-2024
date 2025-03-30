<%@page import="java.time.Instant"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
<h1>HELLO WORLD</h1>
<h3>서버시간: <%= new Date() %></h3>
<%response.sendRedirect("/yjtime"); %>
</body>
</html>