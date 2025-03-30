<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마일리지 추가: 결과 페이지</title>
<style>
body{
margin-left:25px;
margin-top:5%;
}
</style>
</head>
<body>
<c:choose>
	<c:when test="${afterList != null}">	
	<h1>추가 성공</h1>
	<h2>변경 전</h2>
		<table border="1" style="text-align:center;">
		<tr>
			<td>이름</td>
			<td>보유 쿠폰</td>
			<td>보유 마일리지</td>
			<td>연락처(ID)</td>
		</tr>
		<c:forEach var="before" items="${beforeList}">
			<tr>
				<td>${before.name}</td>
				<td>${before.coupon}</td>
				<td>${before.mile}</td>
				<td>${before.id}</td>
			</tr>
		</c:forEach>
		</table>
	<h2>변경 후</h2>
		<table border="1" style="text-align:center;">
		<tr>
			<td>이름</td>
			<td>보유 쿠폰</td>
			<td>보유 마일리지</td>
			<td>연락처(ID)</td>
		</tr>
		<c:forEach var="after" items="${afterList}">
			<tr>
				<td>${after.name}</td>
				<td>${after.coupon}</td>
				<td>${after.mile}</td>
				<td>${after.id}</td>
			</tr>
		</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
	<h1>${resultCode}</h1>
	<h2>${resultMsg}</h2>
	</c:otherwise>
</c:choose>
<br />
<button onclick="location.href='./'" class="btn-primary">메인으로</button >
<button onclick="location.href='./addCoupon.html'" class="btn-primary">쿠폰 등록으로</button >
</body>
</html>