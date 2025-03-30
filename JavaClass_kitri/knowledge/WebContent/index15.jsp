<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스타일 - 목록 스타일</title>
<!-- 내부 스타일 -->
<style>
li {
	list-style: none;
	margin-bottom: 10px;
	border: 2px solid;
	padding: 15px;
}

table {
	border: 1px solid;
	border-collapse: collapse;
	text-align: center;
	caption-side: bottom;
}

th, tr, td {
	border: 1px dashed;
	border-collapse: collapse;
	padding: 10px;
}
</style>
</head>
<body>
	<div>
		<h1>상품 구성</h1>
		
		<table id="table">
		<caption>선물용과 가정용 상품 구성</caption>
			<tr>
				<th>용도</th>
				<th>중량</th>
				<th>개수</th>
				<th>가격</th>

			</tr>
			<tr>
				<td rowspan="2">선물용</td>
				<td>3kg</td>
				<td>11 ~ 16과</td>
				<td>35,000원</td>

			</tr>
			<tr>
				<td>5kg</td>
				<td>18 ~ 26과</td>
				<td>52,000원</td>
			</tr>
			<tr>
				<td rowspan="2">가정용</td>
				<td>3kg</td>
				<td>11 ~ 16과</td>
				<td>30,000원</td>

			</tr>
			<tr>
				<td>5kg</td>
				<td>18 ~ 26과</td>
				<td>47,000원</td>
			</tr>
		</table>

	</div>
</body>
</html>