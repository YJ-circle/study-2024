<%@page import="java.util.List"%>
<%@page import="controller.TestGetAttr.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<%
for(User user: (List<User>) request.getAttribute("userList")){
	out.print("<h1> 아이디: " +user.getId()+ "</h1>");
	out.print("<h1> 이름: " +user.getName()+ "</h1>");
	out.print("<h1> 별명: " +user.getAlias()+ "</h1>");
}
%>
</body>


</html>
