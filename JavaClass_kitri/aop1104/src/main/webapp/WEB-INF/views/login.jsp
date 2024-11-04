<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>로그인</title>
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
			<form action="" method="POST">
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
				<button class="w-100 btn btn-lg btn-primary mb-3" type="submit">로그인</button>
				<button class="w-100 btn btn-lg btn-secondary mb-3" type="button" onclick="location.href='/spring/board/'">비회원 접속하기</button>
				<button class="w-100 btn btn-lg btn-secondary mb-3" type="button" onclick="fillTestCredentials()">테스트 아이디 입력</button>
				<c:if test="${result != null && result == true}">
					<script type="text/javascript">
						location.href = '/spring/board/';
					</script>
				</c:if>
				<c:if test="${result != null && result == false}">
					<script type="text/javascript">
						alert('일치하는 회원이 없습니다.');
					</script>
				</c:if>
				
				<c:if test="${errMsg != null}">
					<script type="text/javascript">
						alert("${errMsg}");
						location.href = '/spring/login';
					</script>
				</c:if>
				<br/>
			</form>

		</div>
		<div class="col-12 mt-3 row-cols-xl-4" >

		</div>
	</div>
	<script>
		function fillTestCredentials() {
		    document.getElementById('floatingInput').value = 'id';
		    document.getElementById('floatingPassword').value = 'password';
		}
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
