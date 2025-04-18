<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<jsp:include page="head.html" flush="false" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Q&A Board</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.justify-content-lg-start {
	justify-content: center !important;
}
</style>
</head>
<body>

	<div class="container mt-4">

	<div class="input-group mb-3">
	  <span class="input-group-text" id="basic-addon1">사용할 아이디</span>
	  <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
	</div>
	
	<div class="input-group mb-3">
	  <input type="text" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="basic-addon2">
	  <span class="input-group-text" id="basic-addon2">@example.com</span>
	</div>
	
	<label for="basic-url" class="form-label">Your vanity URL</label>
	<div class="input-group mb-3">
	  <span class="input-group-text" id="basic-addon3">https://example.com/users/</span>
	  <input type="text" class="form-control" id="basic-url" aria-describedby="basic-addon3">
	</div>
	
	<div class="input-group mb-3">
	  <span class="input-group-text">$</span>
	  <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)">
	  <span class="input-group-text">.00</span>
	</div>
	
	<div class="input-group mb-3">
	  <input type="text" class="form-control" placeholder="Username" aria-label="Username">
	  <span class="input-group-text">@</span>
	  <input type="text" class="form-control" placeholder="Server" aria-label="Server">
	</div>
	
	<div class="input-group">
	  <span class="input-group-text">With textarea</span>
	  <textarea class="form-control" aria-label="With textarea"></textarea>
	</div>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
