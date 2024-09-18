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
<title>= YJ Shop 구매 결과 =</title>
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="${WEB_ROOT}/assert/css/productList.css" rel="stylesheet">
<style>
th, tr {
	text-align: center;
}

tr input {
	border: none;
	width: 45px;
	text-align: center;
}
</style>
</head>
<body>
	<!-- Navigation-->
	<jsp:include page="navi.jsp" />
	<!-- Section-->
	<section class="py-5">
		<div class="container px-4 px-lg-5 mt-5">
			<form>
				<table border="1" width="100%">
					<tr>
						<th colspan="5"
							style="background: #3d3d3d; color: #fff; text-align: center;">
							장바구니
						</th>
					</tr>
					<tr>
						<th width="20%">카테고리</th>
						<th width="20%">상품이미지</th>
						<th width="20%">상품명</th>
						<th width="20%">수량</th>
						<th width="20%">단가</th>
					</tr>
					<c:forEach var="product" items="${cart}">
					<tr>
						<td><img src="/yjshop/img/${product.getImgPath()}"
							style="width: 30%;"></td>
						<td>${product.getCategory()}</td>
						<td>${product.getGoodsname()}</td>
						<td>${product.getCartPrice()}</td>
						<td><input type="number" value="1" />${buylist.qty}개</td>

					</tr>
					<!-- </c:forEach> -->

					<tr>
						<td><input type="number" value="1" /></td>
					</tr>

				</table>
			</form>
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
