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
	
	//세션 아이템 가져오기
	List<String> basket = (List<String>)session.getAttribute("basket");
	
	
//장바구니 비우기 로직 시작
	if("remove".equals((String)request.getParameter("mode")))
	{
		session.invalidate();
		response.sendRedirect("./basket.jsp");
	}
//장바구니 비우기 로직 끝


//장바구니 담기 로직 시작

	/*
	세션에 담아둔게 없으면 NullPointException오류!
	리스트를 만들어서 오류 방지
	*/
	
	if(basket == null){
		basket = new ArrayList<String>();
	}
	
	//요청 파라미터에서 선택한 값 가져오기
	String[] addList = request.getParameterValues("checker");
	
	/* 
	요청 파라미터가 있으면~
	세션에서 가져온 리스트에 값 추가
	List이므로 add만 하면 리스트에 값이 추가됨.
	*/
	
	if(addList != null) {
		for(String s : addList){
			basket.add("상품" + s);
		}
		session.setAttribute("basket", basket);
		response.sendRedirect("./basket.jsp");
	}
//장바구니 담기 로직 끝
	
//화면 출력 로직
%>
	<br/><br/>
	<a href="./basket">전체 상품 보기</a><br/><br/>
	당신의 장바구니에 담긴 상품<br/>
	===========================
<%
	if(basket.size() == 0){
		out.print("<br/> 담긴 상품이 없습니다. <br />");
	}
	for(String b : basket){
		out.print("<li>" + b + "</li>");
	}
	%>
<br/><a href="./basket.jsp?mode=remove">장바구니 비우기!</a><br/>	
</body>
</html>