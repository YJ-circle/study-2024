<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<jsp:include page = "head.html" flush = "false"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Q&A Board</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css" rel="stylesheet">
</head>
<style>
.button-group{
position: absolute;
top: 5px;
right: 10px;
}
</style>
<body>

<div class="container mt-4">

	<div class="card full mb-3 center" style="max-width:800px;">
	  <div class="card-body">
	    <h5 class="card-title">Card title</h5>
	    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
	  </div>
	  	  <div class="button-group">
			<button onclick="" class="btn btn-outline-danger btn-sm border border-0">
				<i class="bi bi-trash"></i>
			</button>
			<a href="" class="btn btn-outline-primary btn-sm border border-0" title="글쓰기"> <i
				class="bi bi-pencil"></i>
			</a>
	  </div>
	</div>

	<div class="card full mb-5">
	  <div class="card-body">
	    <h5 class="card-title">Card title</h5>
	    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
	    <a href="#" class="btn btn-primary"><i class="bi bi-check-circle me-1"></i>채택하기</a>
	  </div>
	  <hr>
	  <div class="card-body">
	    <h5 class="card-title">Card title</h5>
	    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
	    <a href="#" class="btn btn-primary"><i class="bi bi-check-circle me-1"></i>채택하기</a>
	  </div>
	</div>


	<nav aria-label="...">
	  <ul class="pagination">
	    <li class="page-item disabled">
	      <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
	    </li>
	    <li class="page-item active"><a class="page-link" href="#">1</a></li>
	    <li class="page-item" aria-current="page">
	      <a class="page-link" href="#">2</a>
	    </li>
	    <li class="page-item"><a class="page-link" href="#">3</a></li>
	    <li class="page-item">
	      <a class="page-link" href="#">Next</a>
	    </li>
	  </ul>
	</nav>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script>
/* 체크박스 버튼 연동*/
    function all_checked(checked) {
        const checkboxes = document.querySelectorAll('input[name="chk_wr_id[]"]');
        checkboxes.forEach(checkbox => {
            checkbox.checked = checked;
        });
        toggleDeleteButton();
    }

    function toggleDeleteButton() {
        const checkboxes = document.querySelectorAll('input[name="chk_wr_id[]"]:checked');
        const deleteButton = document.querySelector('.btn-outline-danger');

        if (checkboxes.length > 0) {
            deleteButton.disabled = false;
        } else {
            deleteButton.disabled = true;
        }
    }

    document.querySelectorAll('input[name="chk_wr_id[]"]').forEach(checkbox => {
        checkbox.addEventListener('change', toggleDeleteButton);
    });
</script>
</body>
</html>