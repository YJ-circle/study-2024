<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 보기</title>
<style>
body{
margin-left:25px;
margin-top:5%;
}
</style>
</head>
<body>
	<c:choose>
		<c:when test="${resultCode == 200}">
			<table border="1" style="text-align:center;">
			<tr>
				<th colspan="4" style="background:#3d3d3d; color:#fff;">조회한 회원 정보</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>보유 쿠폰</td>
				<td>보유 마일리지</td>
				<td>연락처(ID)</td>
			</tr>
			<c:forEach var="member" items="${list}">
				<tr>
					<td>${member.name}</td>
					<td>${member.coupon}</td>
					<td>${member.mile}</td>
					<td>${member.id}</td>
				</tr>
			</c:forEach>
			</table>
		</c:when>
		
		<c:otherwise>
			<h1>${resultCode}</h1>
			<h1>MESSAGE: ${resultMsg}</h1>	
		</c:otherwise>
	</c:choose>
	<br />
	<button onclick="location.href='./'" class="btn-primary">메인으로</button >
	<button onclick="location.href='./search.html'" class="btn-primary">아이디로 회원 찾기</button >
</body>
</html>