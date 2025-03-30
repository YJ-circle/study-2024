<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>학생이름 정보</title>
<style>
input{
width:30% !important;
margin-left:5%;
margin-bottom: 20px;
}
</style>
</head>
<body>
<br />
	<form action="./addstudent" method="POST">
	<input type="number" min='0' name="stu_id" class="form-control" placeholder="학번 (ex: 202402004)" required/>
	<input type="number" min='0' max='2' name="stu_major" class="form-control" placeholder="전공코드 (1, 2 중 선택하세요)" required/>
	<input type="text" name="stu_name" class="form-control" placeholder="이름" required/>
	<input type="text" name="stu_phone" class="form-control" placeholder="휴대폰 번호 (ex: 010-1234-1234)" required/>
	<input type="submit" value="추가하기" class="btn btn-primary mr-2" >
	</form>
</body>
</html>