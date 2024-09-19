<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>== 상품 상세 페이지 ==</title>
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="${WEB_ROOT}/assert/css/productList.css" rel="stylesheet" />
</head>
<body>
	<!-- Navigation-->
	<jsp:include page="navi.jsp" />
	<!-- Product section-->
	<section class="py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="row gx-4 gx-lg-5 align-items-center">
				<div class="col-md-6">
					<img class="card-img-top mb-5 mb-md-0"
						src="${WEB_ROOT}/assert/img/${item.getImgPath()}" alt="..." />
				</div>
				<div class="col-md-6">
					<div class="small mb-1">${item.getCategory()}</div>
					<h1 class="display-5 fw-bolder">${item.nameTwoLine()}</h1>
					<div class="fs-5 mb-5">
						<span>${item.priceToString()} 원</span>
					</div>
					<p class="lead">${item.getDetail()}</p>
					<div class="d-flex">
						<form action="${servlet}/addCart" method="POST" id = "addCart">
							<div class="form-group row">
								<div class="col">
									<input class="form-control text-center me-3" id="qty"
										type="num" value="1" style="max-width: 3rem" name = "qty" />
									<input type="hidden" name="items" value="${item.getCode()}" />
									<input type="hidden" name="return" value="${requrl}" />
								</div>
								<div class="col"
									style="min-width: 300px !important; margin-left: -25px">
									<button class="btn btn-outline-dark flex-shrink-0"
										onclick="document.getElementById('addCart').submit(); return false;"
										type="button">
										<i class="bi-cart-fill me-1"></i> Add to cart
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Footer-->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2023</p>
		</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
