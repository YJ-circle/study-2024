<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<c:if test="${errMsg != null}">
		<script type="text/javascript">
			alert("${errMsg}");
			history.back();
		</script>
	</c:if>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 작성</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css" rel="stylesheet">
</head>
<style>
.button-group {
  margin-top: 10px; 
  margin-right: 0 auto;
}

.justify-content-lg-start {
	justify-content: center !important;
}
</style>
<body>

<div class="container mt-4" style="margin: 0 auto;">
	
	<form class="card full mb-3 center" style="width:95%; margin-right: 5%;" method="post">
	  <div class="card-body">
	    <!--  h5 class="card-title">글쓰기</h5>-->
	    <textarea class="form-control mb-3" rows="1" name="title" placeholder="제목을 적어주세요" required>${title}</textarea>
	    <textarea class="form-control" rows="10" name="contents" placeholder="내용을 적어주세요" required>${contents}</textarea>
	    <input type="hidden" name=board_id value=1 />
   		<div class="button-group d-flex justify-content-end mt-3">
   		
	      <button type="reset" class="btn btn-outline-danger btn-sm border border-0">
	        <i class="bi bi-trash"></i>
	      </button>
	      <button type="submit" class="btn btn-outline-primary btn-sm border border-0" title="작성하기">
	        <i class="bi bi-pencil"></i> 작성하기
	      </button>
	    </div>
	  </div>
	</form>


</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>