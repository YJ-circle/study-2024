<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>레드향 주문하기</h1>
	<form action="/servlet0919/form" method="post">
	<fieldset>
		
		<legend>상품 선택</legend>
		<b>주문할 상품을 선택하세요</b><br/><br/>
		<input type="checkbox" name="items" value="p3" ${p3} ${saved}/> 선물용 3kg
		<input type="checkbox" name="items" value="p5" ${p5} ${saved}/> 선물용 5kg
		<input type="checkbox" name="items" value="h3" ${h3} ${saved}/> 가정용 3kg
		<input type="checkbox" name="items" value="h5" ${h5} ${saved}/> 가정용 5kg<br/><br/>
		<b>포장 선택</b><br/><br/>
		<input type="radio" name="boxing" value="p1" ${p1} ${saved}/> 선물 포장
		<input type="radio" name="boxing" value="p2" ${p2} ${saved}/> 선물 포장 안함
	</fieldset>
	
	<fieldset>
		<legend>배송 정보</legend>
		<b>주문할 상품을 선택하세요</b><br/><br/>
		이름: <input type="text" name="name" value="${name}" ${saved} /> <br/>
		배송주소: <input type="text" name="addr" value="${addr}" ${saved} /> <br/>
		이메일: <input type="text" name="email" value="${email}" ${saved}/> <br/>
		연락처: <input type="text" name="phone" value="${phone}" ${saved}/> <br/>
	</fieldset>
	<input type="submit" value="전송" />
	</form>
</body>
</html>