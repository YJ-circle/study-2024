<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>== YJ SHOP LOGIN ==</title>
  
	<link href="${WEB_ROOT}/assert/css/bootstrap.min.css" rel="stylesheet">
	<link href="${WEB_ROOT}/assert/css/signin.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    
    <!-- Custom styles for this template -->

    <script src="${WEB_ROOT}/assert/js/login.js"></script>
  </head>
  <body class="text-center">
    
<main class="form-signin">
  <form action="${servlet}/login" method="POST">
    <img class="mb-4" src="${WEB_ROOT}/assert/img/logo.png" alt="" width="70%" style="margin-bottom:0!important">
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="Id" name="id" required>
      <label for="floatingInput">아이디 입력</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password" required>
      <label for="floatingPassword">비밀번호 입력</label>
    </div>
    <button class="w-100 btn btn-lg btn-primary" type="submit">로그인</button>
	<c:if test="${loginResult != null}">
	    <h1>${loginResult}</h1>
	    <script type="text/javascript">
	        alert('${loginResult}');
	        location.href='${servlet}/login';
	    </script>
	</c:if>


    <p class="mt-5 mb-3 text-muted">&copy; 2024</p>
  </form>
</main>


    
  </body>
</html>