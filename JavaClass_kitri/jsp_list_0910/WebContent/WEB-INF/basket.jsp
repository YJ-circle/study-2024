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
	<%
	//
	List<String> goodsList =  (List<String>)request.getAttribute("goodsList");
	int count = 1;
	
	out.println("<br/><br/>");
	out.println("원하는 상품을 담아보세요~ <br /> <br />");
	out.println("<form action=\"./basket.jsp\" method=\"GET\">");
	for(String goods : goodsList){
		out.println(goods + "<input type=\"checkbox\" name=\"checker\" value=\""+ count + "\">");
		if(count%5==0){
			out.println("<br/>");
		}
		count++;
	}
	out.println("<br/><input type=\"submit\" value=\"추가\"></form>");
	%>
	
	<br />
	<a href="./basket.jsp">장바구니 보기</a>
</body>
</html>