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
<body>
	<!-- Navigation-->
	<jsp:include page="navi.jsp" />
	<!-- Section-->
	<section class="py-5">
		<div class="container px-4 px-lg-5 mt-5">
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				<c:forEach var="product" items="${list}">
					<div class="col mb-5"  onclick="location.href='/items=${product.getCode()}}';">
						<div class="card h-100">
							<!-- Product image-->
							<img class="card-img-top"
								src="${WEB_ROOT}/assert/img/${product.getImgPath()}" />
							<!-- Product details-->
							<div class="card-body p-4">
								<div class="text-center">
									<!-- Product name-->
									<h6 class="fw-bolder">${product.getName()}</h6>
									<%

									%>
									${product.priceToString()} 원
								</div>
							</div>
							<!-- Product actions-->
							<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
								<div class="text-center">
									<form action="/yjshop/shop/purchase" method="POST"
										id="purchaseForm">
										<input type="hidden" name="price"
											value="${product.getPrice()}"> <input type="hidden"
											name="code" value="${product.getCode()}"> <input
											type="hidden" name="userId"
											value="<%=session.getAttribute("userId")%>"> <input
											type="hidden" name="sessionId" value="<%=session.getId()%>">
										<a class="btn btn-outline-dark mt-auto" href="#"
											onclick="document.getElementById('purchaseForm').submit(); return false;">자세히
											보기</a>
									</form>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>
	<!-- Footer-->
	<jsp:include page="footer.jsp" />
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
