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
<title>= YJ Shop = 장바구니 추가 결과</title>
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
	<script type="text/javascript">
		alert('${addResult}');
		location.href = '${returnPage}';
	</script>
</body>
</html>
