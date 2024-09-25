<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>가정용 꿀사과</title>

<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
}

/* Container for the image and overlay text */
#back {
	position: relative;
	height: 450px;
	margin: 0 auto;
}

/* Image styling */
img {
	width: 100%;
	height: auto;
}

/* Overlay text styling */
#desc {
	position: absolute;
	bottom: 0;
	width: 100%;
	background-color: rgba(0, 0, 0, 0.6);
	color: white;
	padding: 15px;
	box-sizing: border-box;
	text-align: left;
}

#desc b {
	font-size: 24px;
}

#desc p {
	margin: 5px 0;
	line-height: 1.5em;
	color: #ffc107;
}

.table-container {
	width: 600px;
	text-align: center;
}

table {
	width: 100%;
	text-align: left;
	border-collapse: collapse;
}

th, td {
	border: 0px;
	padding: 10px;
	text-align: center;
}

td {
	border-top: 1px solid #ddd;
	border-bottom: 1px solid #ddd;
}

th {
	background-color: #3d3d3d;
	border: 0px;
	font-weight: bold;
	text-align: left;
}

td {
	font-size: 14px;
}

strong {
	color: red;
}


table th:first-child,
table tr:first-child {
	border: 0;
}
table th:last-child,
table tr:last-child {
	border:0;
}

</style>
</head>
<body>
	<div id="content"
		style="width: 600px; border: 1px solid; margin: 0 auto; margin-top: 20px;">
		<!-- Image with overlay text -->
		<div id="back">
			<img src="./apple.jpg" alt="Apple Orchard">
			<div id="desc">
				<b>가정용 꿀사과</b>
				<p>장미과 사과나무 속에 속하는 속씨식물.</p>
				<p>남, 북반구 온대지역이 원산지이며, 2000년 전부터 여러 품종들이 알려졌다.</p>
			</div>
		</div>

		<!-- Table section for order, refund, and contact information -->
		<div class="table-container">
			<table>
				<tr id="blackback">
					<th>확인하세요</th>
				</tr>
				<tr>
					<td class="order-info"><strong>주문 및 배송</strong><br> 오후 2시
						이전 주문건은 당일 발송합니다.<br> 2시 이후 주문건은 다음날 발송합니다 (주말 제외).<br>
						<br> <strong>교환 및 환불</strong><br> 불만족 100% 환불해 드립니다.<br>
						고객센터로 전화주세요.</td>
				</tr>
				<tr>
					<td class="contact-info"><strong>고객센터</strong><br>
						0000-0000<br> 상담시간: 오전 9시 ~ 오후 6시 (토,일요일, 공휴일 휴무)</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>
