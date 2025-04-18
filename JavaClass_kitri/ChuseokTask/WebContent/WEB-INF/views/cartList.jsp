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
				<form action="${servlet}/cartChange" method="POST" id="cartForm">
					<thead>
						<tr>
							<td colspan="6" style="text-align: right;"><input
								class="btn btn-dark btn-sm" type="button" onclick="del(this)"
								value="삭제" /></td>
						</tr>
						<tr>
							<th colspan="6"
								style="background: #3d3d3d; color: #fff; text-align: center;">
								장바구니</th>
						</tr>

						<tr>
							<th></th>
							<th>분류</th>
							<th colspan="2">상품</th>
							<th>수량</th>
							<th>가격</th>
						</tr>

					</thead>
					<tbody>
						<c:forEach var="product" items="${cart}">
							<tr>
								<th scope="row" style="width: 15px;"><input type="checkbox"
									id="selectItem" name="selectItem" value="${product.getGoodscode()}" /></th>
								<td style="width: 10%;">${product.getCategory()}</td>
								<td style="width: 25%;"><img
									src="${WEB_ROOT}/assert/img/${product.getImgPath()}"
									style="width: 60%;"></td>
								<td style="width: 45%; text-align: left;">
									${product.getGoodsname()} <input type="hidden" name="goodsCode"
									value="${product.getGoodscode()}" />
								</td>
								<td style="width: 10%;"><input type="number" name="qty"
									value="${product.getQty()}" oninput="calculatePrice(this)"
									data-price="${product.getCatPriceInt()}"
									style="width: 35px; text-align: right;" />개<br /> <input
									class="btn btn-dark btn-sm" type="button" value="변경"
									style="margin-left: 15px; margin-right: auto;"
									onclick="editQty(this)"></td>
								<td style="width: 10%;"><input type="text"
									value="${product.getCartTotalPrice()} 원" readonly disabled />
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</form>
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

	    function editQty(btn) {
	        const form = document.getElementById('cartForm');
	        const formData = new FormData();// new URLSearchParams();

	        formData.append('method', '1');
	        formData.append('goodsCode', btn.closest('tr').querySelector('input[name="goodsCode"]').value);
	        formData.append('qty', btn.closest('tr').querySelector('input[name="qty"]').value);
	        

	        fetch(form.action, {
	            method: 'POST',
	            //headers: {
	            //    'Content-Type': 'application/x-www-form-urlencoded'
	            //},
	            body: formData //.toString()
	        })
	        .then(response => {
	        	if (!response.ok) {
	        		throw new Error('Error');
	        	}
	            alert("변경 성공");
	        })
	        .catch(error => {
	        	alert("변경 실패");
	            console.error('Error:', error);
	        });
	    }
	    
	    function del(btn) {
	        const form = document.getElementById('cartForm');
	        const formData = new FormData();
	        formData.append('method', '2');
	        
	        const checkboxes = form.elements['selectItem'];

	  
	        if (checkboxes) {
	            for (let checkbox of checkboxes) {
	                if (checkbox.checked) {
	                    formData.append(checkbox.name, checkbox.value);
	                }
	            }
	        }

	       

	        fetch(form.action, {
	            method: 'POST',
	            body: formData
	        })
	        .then(response => {
	        	if (!response.ok) {
	        		throw new Error('Error');
	        	}
	            alert("삭제 성공");
	            console.log(data);
	            location.reload();
	        })
	        .catch(error => {
	            alert("삭제 실패");
	            console.error('Error:', error.message);
	        });
	    }

	</script>
</body>
</html>
