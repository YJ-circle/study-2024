<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>블럭과 인라인</title>
<!-- 내부 스타일 -->
<style>
	.box1{
    width: 350px;
    border: 3px dotted blue;
    height: 206px;
    margin-bottom: 200px;
	}
	.box2{

	}
	h1{
	

	}
	div{

	}
	p{

	}
	hr{

	}
	span{

	}
		
</style>
</head>
<body>
	<div class="box1">
		<h1 style="
    
">제목</h1>
		<div style="
    border: 2px solid orange;
    height: 137px;
">
			Lorem Ipsum is simply dummy text of the printing and<p style="
    border: 2px solid green;
"> 
			typesetting industry. Lorem Ipsum has been the industry's</p>
			<p style="
    border-top: 2px green solid;
">
		</p></div>
		<p style="
    border: 2px solid green;
">
		It is a long established fact that a reader will be distracted<br>
		by the readable content of a page when looking at its layout. 
		</p>
	</div>
	<hr style="
    margin-top: -112px;
    margin-bottom: 100px;
">
	<div class="box2" style="
    width: 350px;
    height: 200px;
    border: 3px dotted blue;
">
		<h1 style="
    border: 2px solid red;
">제목</h1>
		<div style="
    border: 2px solid orange;
">
			Lorem Ipsum is simply dummy text of the printing and<span style="
    background: #ffadc599;
"> 
			typesetting industry.</span> Lorem Ipsum has been the industry's
			<p style="
    border: 1.45px solid green;
">
		</p></div>
		<p style="
    border: 2px solid green;
">
		It is a long established fact that a reader will be distracted<br>
		by the readable content of a page when looking at its layout. 
		</p>
	</div>	

</body>
</html>