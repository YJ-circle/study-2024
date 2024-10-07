<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script type = "text/javascript">

function over(){
	var text = document.getElementById("message");
	text.innerHTML = '<h1>블럭인</h1>';
}

function out(){
	var text = document.getElementById("message");
	text.innerHTML = '<h3>블럭 탈출</h3>';
}
</script>


<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>결과</p>
<div onmouseover="over()" onmouseout="out()">
<h2>블럭 안</h2>
</div>
<p id='message'></p>
</body>
</html>