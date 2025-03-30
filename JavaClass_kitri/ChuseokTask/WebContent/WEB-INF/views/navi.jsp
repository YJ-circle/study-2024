<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container px-4 px-lg-5">
		<a class="navbar-brand" href="${servlet}/product">YJShop</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="./product">Home</a></li>
				<li class="nav-item"><a class="nav-link"
					href="./product?category=1">Outer</a></li>
				<li class="nav-item"><a class="nav-link"
					href="./product?category=2">TOP</a></li>
				<li class="nav-item"><a class="nav-link"
					href="./product?category=3">BOTTOM</a></li>
				<li class="nav-item"><a class="nav-link" href="#">구매
						내역</a></li>
			</ul>
			<div class="d-flex">

				<c:choose>
					<c:when test="${userName eq '손님'}">
						<jsp:include page="mypage_login.jsp" />
					</c:when>
					<c:otherwise>
						<jsp:include page="mypage_logout.jsp" />
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</nav>