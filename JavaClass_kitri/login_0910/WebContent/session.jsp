<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력폼1</title>
</head>
<body>
	<form action="./session.jsp">
		<input type="text" name="item" />
		<input type="submit" value="추가">
	</form>
	<%
		List<String> items = (List<String>)session.getAttribute("tolist");
		if(items == null) {
			items = new ArrayList<String>();
			session.setAttribute("tolist", items);
		}
		String sInputItem = request.getParameter("item");
		if(sInputItem != null) {
			items.add(sInputItem);
		}
	%>
	
	<%
		for(String item : items) {
			out.println("<li>" + item + "</li>");
		}
	%>
	
	<br />
</body>
</html>