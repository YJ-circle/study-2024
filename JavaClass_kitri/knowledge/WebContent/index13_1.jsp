<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>스타일 - 2단 레이아웃</title>
	<!-- 내부 스타일 -->
	<style>
		*{
		}
		#wrap{/* margin-top: 30px; */margin: 0 auto;width: 600px;}
		h3{
		}
		.container{display: grid;grid-template-columns: 285px 285px;grid-template-rows: 150px 150px;gap: 5px;margin-left: 15px;er: 1px solid black;}
		.bborder: 1px solid black;margin-top: -15px;padding: 10px;gin-left: 5px;}
		.box3{}	
		.box4{}
		footer{
    background-color: #333333;
    color: #fff;
    text-align: center;
    width: 600px;
    margin: 0 auto;
}
	</style>
</head>
<body>
	<div id="wrap">
		<main>
			<h3>강아지 용품 준비하기</h3>
			<div class="container">
				<p class="box1">
					<strong>페페 중형견용 펫드라이룸</strong><br><br>
					목욕? 이제는 웃어보자꾸나    
					더 큰! 아이들을 위한 더 넓은 ! 펫드라이룸
				</p>
				<p class="box2">
					<strong>페페 업그레이드 펫드라이룸</strong><br><br>
					털은 뽀송! 눈,코는 촉촉 ! 
					안면무풍 내집같은 편안한 펫드라이룸		
				</p>
				<p class="box3">
					<strong>페페 업그레이드 펫드라이룸 DR-100PRO(블랙)</strong><br><br>
					털은 뽀송! 눈,코는 촉촉 ! 
					안면무풍 내집같은 편안한 펫드라이룸		
				</p>
				<p class="box4">
					<strong>페페 스마트 자동 간식기 SF-300</strong><br><br>
					6가지 다양한 간식을 시간에 맞춰 자동으로! 
					페페 스마트 간식기 			
				</p>
			</div>
		</main>
		<footer>박스 모델 연습하기</footer>
	</div>	
</body>
</html>