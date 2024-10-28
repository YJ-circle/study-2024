<%@page import="java.awt.print.Printable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<!-- jsp scriptlet -->
<body>

<% 

String id = (String) request.getAttribute("id");
String pwd = (String) request.getAttribute("pwd");
String username = (String) request.getAttribute("userName");
   out.print("<h1> " + id + "</h1>");
   out.print("<h1>" + pwd + "</h1>");
   out.print("<h1>" + username + "</h1>");
%>


</body>
<!-- jsp expression -->
<h1><%=id%></h1>
<h1><%=pwd%></h1>
<h1><%=username%></h1>

<h1>${id}</h1>
<h1>${pwd}</h1>
<h1>${username}</h1>
</html>
