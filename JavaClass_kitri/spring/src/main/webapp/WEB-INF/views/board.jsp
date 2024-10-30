<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css" rel="stylesheet">
    <style>
.justify-content-lg-start {
	justify-content: center !important;
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
            text-align: center;
        }
        .qna-status.notice {
            background-color: #d9edf7;
            color: #31708f;
        }
        .qna-status.no-answer {
		    background-color: #d5d5d5;
		    color: #737373;
		    text-align: center;
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
<c:if test="${result != null}">
	<script type="text/javascript">
		alert('${result}');
		location.href = '/spring/board';
	</script>
</c:if>

<div class="container mt-4">

    <table class="table table-hover">
        <thead class="table-light">
            <tr>
                <th scope="col">
                    <input type="checkbox" id="chkall" onclick="all_checked(this.checked)" value="1">
                </th>
                <th scope="col">번호</th>
                <th scope="col" style="width:65%">제목</th>
                <th scope="col">작성자</th>
                <th scope="col">작성일</th>

            </tr>
        </thead>
        <tbody>
        
        	<c:choose>
        	<c:when test="${postList == null}">
	            <tr>
	                <td colspan="7" class="text-center">게시물이 없습니다.</td>
	            </tr>
            </c:when>
            <c:otherwise>
            <c:forEach var="post" items="${postList}" varStatus="status">
	            <tr onclick="location.href='/spring/board/view?post_id=${post.postId}'">
	                <td class="text-center"><input type="checkbox" name="chk_wr_id[]" value="<?php echo $list[$i]['wr_id'] ?>"></td>
	                <td>${status.index + 1}</td>
	                <td>${post.postTitle}</td>
	                <td class="text-center">${post.writerName}</td>
	                <td class="text-center">${post.writeDate}</td>
	            </tr>
			</c:forEach>
            </c:otherwise>
            
        	</c:choose>

        </tbody>
    </table>
    <div class="d-flex justify-content-end align-items-center mb-3">
        <!-- 
        <div>Total <?php echo number_format($total_count); ?>건, <?php echo $page; ?> 페이지</div>
        -->
        <div class="btn">
            <!--  <button onclick="" class="btn btn-outline-danger btn-sm" disabled>
                <i class="bi bi-trash"></i> 삭제
            </button>-->
            <a href="/spring/board/write" class="btn btn-outline-primary btn-sm" title="글쓰기">
                <i class="bi bi-pencil"></i> 글쓰기
            </a>
            <a href="/spring/login" class="btn btn-outline-primary btn-sm" title="로그인">
                 로그인
            </a>
            <a href="/spring/logout" class="btn btn-outline-primary btn-sm" title="로그아웃">
                로그아웃
            </a>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>