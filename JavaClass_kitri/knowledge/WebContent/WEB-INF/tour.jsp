<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 태그</title>
</head>
<body>
	<img width="50%" alt="그림" src="/servlet0919/img${tour.imagepath}">
	<h2>${tour.imagename}</h2>
	<p>
	${tour.description}
	</p>
	
	<a href="/servlet0919/tour?imgnum=${previous}">이전 페이지</a>
	<a href="/servlet0919/tour?imgnum=${next}">다음 페이지</a>
</body>
</html>