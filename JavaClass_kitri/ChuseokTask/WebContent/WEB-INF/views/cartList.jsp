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
	text-align: center;
	background: none;
}
</style>
</head>
<body>
	<!-- Navigation-->
	<jsp:include page="navi.jsp" />
	<!-- Section-->
	<section class="py-5">
		<div class="container px-4 px-lg-5 mt-5">
			<table border="1"
				class="table align-middle table-striped table-hover">
				<tr>
					<th colspan="6"
						style="background: #3d3d3d; color: #fff; text-align: center;">
						장바구니</th>
				</tr>
				<tr>
					<th></th>
					<th>분류</th>
					<th>상품</th>
					<th>수량</th>
					<th>단가</th>
					<th>가격</th>
				</tr>
				<c:forEach var="product" items="${cart}">
					<form action="/cartChange" method="POST">
					<tr>
						<th scope="row"><input type="checkbox" name="selectItem"
							value="${product.getGoodscode()}" /></th>
						<td>${product.getCategory()}</td>
						<td style="width: 35%;"><input type="hidden" name="goodsCode"
							value="${product.getGoodscode()}" /> <img
							src="${WEB_ROOT}/assert/img/${product.getImgPath()}"
							style="width: 70%;"><br /> ${product.getGoodsname()}</td>
						<td style="width: 100px;">${product.getCartPrice()}원</td>
						<td style="width: 100px;"><input type="num" name="qty"
							value="${product.getQty()}" oninput="calculatePrice(this)"
							data-price="${product.getCatPriceInt()}"
							style="width: 25px; margin: 0 auto;" />개<br />
						<input class="btn btn-dark btn-sm" type="submit" value="변경"></td>

						<td style="width: 100px;"><input type="text"
							value="${product.getCartTotalPrice()} 원" readonly /></td>

					</tr>
					</form>
				</c:forEach>
			</table>
			
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
	<script>
		function calculatePrice(input) {
			// 수량과 단가를 가져오기
			var quantity = input.value;
			var pricePerUnit = input.getAttribute('data-price');
			// 가격 계산
			var totalPrice = quantity * pricePerUnit;

			// 가격 입력 필드 업데이트
			var priceField = input.closest('tr').querySelector(
					'td:last-child input');
			priceField.value = totalPrice.toLocaleString() + ' 원';
		}
	</script>

</body>
</html>
