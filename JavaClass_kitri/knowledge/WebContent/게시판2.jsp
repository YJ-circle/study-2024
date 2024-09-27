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
    <style>
	    .justify-content-lg-start{
			justify-content: center!important;
		}
        .table-hover tbody tr:hover {
            background-color: #f5f5f5;
        }
        .table th{
        	text-align: center;
        }
        .table td, .table th {
            vertical-align: middle;
            white-space: normal;
    		word-break: keep-all; 
        }
         
        .qna-status {
            font-size: 0.9rem;
            padding: 0.3rem 0.5rem;
            border-radius: 5px;
            margin-right: 5px;
        }
        .qna-status.completed {
            background-color: #dff0d8;
            color: #3c763d;
        }
        .qna-status.in-progress {
            background-color: #fcf8e3;
            color: #8a6d3b;
        }
        .qna-status.notice {
            background-color: #d9edf7;
            color: #31708f;
        }
        .qna-heart {
            color: red;
        }
        .pagination {
            justify-content: center;
        }

    </style>
</head>
<body>

<div class="container mt-4">
    <div class="d-flex justify-content-between align-items-center mb-3">
        <div>Total <?php echo number_format($total_count); ?>건, <?php echo $page; ?> 페이지</div>
        <div class="btn">
            <button onclick="" class="btn btn-outline-danger" disabled>
                <i class="bi bi-trash"></i> 삭제
            </button>
            <a href="" class="btn btn-outline-primary" title="글쓰기">
                <i class="bi bi-pencil"></i> 글쓰기
            </a>
        </div>
    </div>

    <table class="table table-hover">
        <thead class="table-light">
            <tr>
                <th scope="col">
                    <input type="checkbox" id="chkall" onclick="all_checked(this.checked)" value="1">
                </th>
                <th scope="col">제목</th>
                <th scope="col">작성자</th>
                <th scope="col">조회수</th>
                <th scope="col">날짜</th>

            </tr>
        </thead>
        <tbody>
        
            <tr>
                <td colspan="5" class="text-center">게시물이 없습니다.</td>
            </tr>
            <tr>
                <td class="text-center"><input type="checkbox" name="chk_wr_id[]" value="<?php echo $list[$i]['wr_id'] ?>"></td>
                <td><span class="qna-status notice">공지사항</span>
                    <span class="qna-status completed">답변완료</span>
                    <span class="qna-status in-progress">접수완료</span>게시글 제목 안녕하세요. 감사해요</td>
                <td class="text-center">홍길동</td>
                <td class="text-center">999</td>
                <td class="text-center">2024-09-26</td>
            </tr>
            <tr>
                <td class="text-center"><input type="checkbox" name="chk_wr_id[]" value="<?php echo $list[$i]['wr_id'] ?>"></td>
                <td><span class="qna-status notice">공지사항</span>
                    <span class="qna-status completed">답변완료</span>
                    <span class="qna-status in-progress">접수완료</span>게시글 제목 잘 있어요. 다시 만나요</td>
                <td class="text-center">홍길동</td>
                <td class="text-center">조회수9999</td>
                <td class="text-center">2024-09-26</td>
            </tr>
        </tbody>
    </table>

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
1
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