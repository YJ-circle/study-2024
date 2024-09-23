<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title>스타일 - 선택자 우선순위</title> 
<!-- 내부 스타일 --> 
<style> 
*{ 
} 
p{ 
} 
.p1{ 
} 
#txt1{ 
color: blue; 
color: red; 
color: green; 
color: orange; 
} 
h1{ 
color: red !important; 
} 
</style> 

<!-- 외부스타일 --> 
<!-- <link rel="stylesheet" href="css/style.css">  --> 
</head> 
<body> 
<div> 
<h1 style="color: pink;">레드향</h1> 
<!-- 클래스는 한 개 이상 가능 --> 
<p class="p1" id="txt1" style="color: brown;">일본에서 한라봉과 교배해 만든 신품종 
감귤. 당도가 높고 과즙이 풍부하며 껍질이 얇고 붉은빛을 띤다.</p> 
<p> 
14일 OO 백화점 본점에 환절기 감기 예방에 좋은 비타민 시가 풍부한 이색 과일 
레드향이  선보여 고객들의 눈길을 끌고 있다. 레드향은 2008년 일본에서 도입된 이후 재배 면적이  
급속히 증가하고 있는 품종이다. 
</p> 
<p> 
예쁘게 익어가는 레드향 입니다. 만감류 중에 여왕이라고도 합니다. 
</p> 
</div> 
</body> 
</html>