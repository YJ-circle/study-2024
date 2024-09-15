<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
	<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
		id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown"
		aria-expanded="false"> ${userName} 님 </a>
		<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
			<li><a class="dropdown-item" href="#!">마이페이지</a></li>
			<li><a class="dropdown-item" href="${servlet}/logout?requri=${requrl}">로그아웃</a></li>
			<li><hr class="dropdown-divider" /></li>
			<li><a class="dropdown-item" href="#!">구매 내역</a></li>
			<li><a class="dropdown-item" href="#!">장바구니</a></li>
		</ul></li>
</ul>