<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
	<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
		id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown"
		aria-expanded="false"> 손님 </a>
		<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
			<li><a class="dropdown-item" href="${servlet}/login">로그인</a></li>
			<li><hr class="dropdown-divider" /></li>
			<li><a class="dropdown-item" href="#!">구매 내역</a></li>
			<li><a class="dropdown-item" href="${servlet}/cart">장바구니</a></li>
		</ul></li>
	<form class="d-flex"  action="${servlet}/cart">
		<button class="btn btn-outline-dark" >
			<i class="bi-cart-fill me-1"></i> 장바구니
		</button>
	</form>
</ul>