<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<jsp:include page="head.html" flush="false" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Q&A Board</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.justify-content-lg-start {
	justify-content: center !important;
}

input {
	margin-bottom: 10px;
}
</style>
</head>
<body>

	<div class="container mt-4">
		<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
			<form action="${servlet}/login" method="POST">
				<div class="form-floating">
					<input type="text" class="form-control" id="floatingInput"
						placeholder="Id" name="id" required> <label
						for="floatingInput">아이디 입력</label>
				</div>
				<div class="form-floating">
					<input type="password" class="form-control" id="floatingPassword"
						placeholder="Password" name="password" required> <label
						for="floatingPassword">비밀번호 입력</label>
				</div>
				<button class="w-100 btn btn-lg btn-primary" type="submit">로그인</button>
				<c:if test="${loginResult != null}">
					<h1>${loginResult}</h1>
					<script type="text/javascript">
						alert('${loginResult}');
						location.href = '${servlet}/login';
					</script>
				</c:if>
				<br/>
			<a href="${servlet}/signup" class="text-reset" style="text-decoration: none;">회원가입</a> <span>|</span>
			<a href="${servlet}/find-id" class="text-reset" style="text-decoration: none;">ID 찾기</a> <span>|</span>
			<a href="${servlet}/find-password" class="text-reset" style="text-decoration: none;" >PW 찾기</a>
			</form>

		</div>
		<div class="col-12 mt-3 row-cols-xl-4" >

		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
