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
	<h1>레드향 주문하기</h1>
	<form action="/servlet0919/form2" method="post">
	<fieldset>
		
		<legend>상품 선택</legend>
		<b>주문할 상품을 선택하세요</b><br/><br/>
		<input type="checkbox" name="items" value="p3"/> 선물용 3kg
		<input type="checkbox" name="items" value="p5"/> 선물용 5kg
		<input type="checkbox" name="items" value="h3"/> 가정용 3kg
		<input type="checkbox" name="items" value="h5"/> 가정용 5kg<br/><br/>
		<b>포장 선택</b><br/><br/>
		<input type="radio" name="boxing" value="p1"/> 선물 포장
		<input type="radio" name="boxing" value="p2"/> 선물 포장 안함
	</fieldset>
	
	<fieldset>
		<legend>배송 정보</legend>
		<b>주문할 상품을 선택하세요</b><br/><br/>
		이름: <input type="text" name="name" value=""/> <br/>
		배송주소: <input type="text" name="addr" value="" /> <br/>
		이메일: <input type="text" name="email" value=""/> <br/>
		연락처: <input type="text" name="phone" value="" /> <br/>
	</fieldset>
	<input type="hidden" name="method" value="add"/>
	<input type="submit" value="저장하기" />
	</form>
	
	<c:if test="${saved != null}">
	<form action="/servlet0919/form2" method="post">
		<input type="hidden" name="method" value="remove"/>
		<input type="submit" value="삭제하기" />
	</form>
	</c:if>

</body>
</html>