<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Q&A Board</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .card {
            margin-top: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        .button-group {
            position: absolute;
            top: 15px;
            right: 15px;
        }
        .btn-custom {
            margin-right: 5px;
        }
    </style>
</head>
<body>
	<c:if test="${result != null}">
		<script type="text/javascript">
			alert("${result}");
			location.href = '/spring/board/view?post_id=${post_id}';
		</script>
	</c:if>
<div class="container mt-4">

    <div class="card">
        <div class="card-body">
            <div class="d-flex justify-content-between align-items-center">
                <h5 class="card-title">${post.title}</h5>
                <div class="button-group">
                    <button onclick="location.href='/spring/board/delete?post_id=${post.postId}'" class="btn btn-outline-danger btn-sm btn-custom">
                        <i class="bi bi-trash"></i>
                    </button>
                    <a href="/spring/board/modify?post_id=${post.postId}" class="btn btn-outline-primary btn-sm btn-custom" title="수정하기">
                        <i class="bi bi-pencil"></i>
                    </a>
                </div>
            </div>
            <p class="card-text mt-3">${post.contents}</p>
            <div class="mt-3">
                <small class="text-muted">작성일: ${post.writeDate}</small><br>
                <small class="text-muted">작성자: ${post.writer}</small>
            </div>
        </div>
            <a href="./" class="btn btn-secondary mt-3" style="position: absolute; right: 100px; bottom: -60px;">
            	게시글 목록으로
            </a>
            <a href="/spring/logout" class="btn btn-secondary mt-3" style="position: absolute; right: 0px; bottom: -60px;">
            	로그아웃
            </a>

    </div>
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

        deleteButton.disabled = checkboxes.length === 0;
    }

    document.querySelectorAll('input[name="chk_wr_id[]"]').forEach(checkbox => {
        checkbox.addEventListener('change', toggleDeleteButton);
    });
</script>
</body>
</html>
