<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>= YJ Shop =</title>
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="${WEB_ROOT}/assert/css/productList.css" rel="stylesheet" />
</head>
<style>
form input, button {
	margin-top: 10px;
}
</style>
<body>
	<!-- Navigation-->
	<jsp:include page="navi.jsp" />
	<!-- Section-->
	<section class="py-5">
		<div class="container px-4 px-lg-5 mt-5">
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				<form action="${servlet}/login" method="POST">
					<h2 style="text-align: cetner;">로그인</h2>
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
				</form>
			</div>

		</div>
	</section>
	<!-- Footer-->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; YJ SHOP
				2024</p>
		</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
