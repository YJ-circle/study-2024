<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title> = YJ Shop 구매 결과 = </title>
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="../css/productList.css" rel="stylesheet" />
        <style>
        th, tr{
        text-align: center;
        }
        </style>
    </head>
    <body>
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="./">YJShop</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="./product">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="./product?category=1">Outer</a></li>
                        <li class="nav-item"><a class="nav-link" href="./product?category=2">TOP</a></li>
                        <li class="nav-item"><a class="nav-link" href="./product?category=3">BOTTOM</a></li>
                        <li class="nav-item"><a class="nav-link" href="./purchaseList">구매 내역</a></li>
                    </ul>
                    <form class="d-flex" action="./logout" method="POST">
                        <button class="btn btn-outline-dark" type="submit">
                        	<input type="hidden" name="userId" value="${userId}">
                            <i class="bi-box-arrow-right me-1"></i>
                            로그아웃
                        </button>
                    </form>
                    
                </div>
            </div>
        </nav>
        <!-- Section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
					<table border="1" width="100%">
						<tr>
							<th colspan="5" style="background:#3d3d3d; color:#fff; text-align:center;">구매 내역</td>
						</tr>
						<tr>
							<th width="20%">구매일자</th>
							<th width="20%">상품이미지</th>
							<th width="20%">카테고리</th>
							<th width="20%">상품명</th>
							<th width="20%">수량</th>
						</tr>
						<c:forEach var="buylist" items="${history}">
							<tr>
								<td>${buylist.buyDate}</td>
								<td><img src="/yjshop/img/${buylist.imgpath}" style="width:30%;"></td>
								<td>${buylist.category}</td>
								<td>${buylist.name}</td>
								<td>${buylist.qty} 개</td>
								
							</tr>
					</c:forEach>
					</table>
            </div>
        </section>
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; YJ SHOP 2024</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="../js/product.js"></script>
    </body>
</html>
