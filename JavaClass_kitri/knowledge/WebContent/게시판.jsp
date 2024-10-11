<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<jsp:include page = "head.html" flush = "false"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>QA Board</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .table-hover tbody tr:hover {
            background-color: #f5f5f5;
        }
        .table td, .table th {
            vertical-align: middle;
        }
        .qna-status {
            font-size: 0.9rem;
            padding: 0.3rem 0.5rem;
            border-radius: 5px;
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
        <div class="btn-group">
            <?php if ($rss_href) { ?>
            <a href="<?php echo $rss_href ?>" class="btn btn-outline-secondary" title="RSS">
                <i class="fa fa-rss" aria-hidden="true"></i> RSS
            </a>
            <?php } ?>
            <?php if ($write_href) { ?>
            <a href="<?php echo $write_href ?>" class="btn btn-outline-primary" title="글쓰기">
                <i class="fa fa-pencil" aria-hidden="true"></i> 글쓰기
            </a>
            <?php } ?>
        </div>
    </div>

    <table class="table table-hover">
        <thead class="table-light">
            <tr>
                <?php if ($is_checkbox) { ?>
                <th scope="col">
                    <input type="checkbox" id="chkall" onclick="all_checked(this.checked)">
                </th>
                <?php } ?>
                <th scope="col">상태</th>
                <th scope="col">제목</th>
                <th scope="col">글쓴이</th>
                <th scope="col">조회</th>
                <th scope="col">날짜</th>
            </tr>
        </thead>
        <tbody>
            <?php for ($i = 0; $i < count($list); $i++) { ?>
            <tr>
                <?php if ($is_checkbox) { ?>
                <td><input type="checkbox" name="chk_wr_id[]" value="<?php echo $list[$i]['wr_id'] ?>"></td>
                <?php } ?>
                <td>
                    <?php if ($list[$i]['is_notice']) { ?>
                    <span class="qna-status notice">공지사항</span>
                    <?php } else if ($list[$i]['comment_cnt']) { ?>
                    <span class="qna-status completed">답변완료</span>
                    <?php } else { ?>
                    <span class="qna-status in-progress">접수완료</span>
                    <?php } ?>
                </td>
                <td>
                    <?php echo $list[$i]['subject']; ?>
                    <?php if ($list[$i]['wr_good']) { ?>
                    <span class="qna-heart">❤️</span>
                    <?php } ?>
                </td>
                <td><?php echo $list[$i]['name']; ?></td>
                <td><?php echo $list[$i]['wr_hit']; ?></td>
                <td><?php echo $list[$i]['datetime2']; ?></td>
            </tr>
            <?php } ?>
            <?php if (count($list) == 0) { ?>
            <tr>
                <td colspan="6" class="text-center">게시물이 없습니다.</td>
            </tr>
            <?php } ?>
        </tbody>
    </table>

    <nav aria-label="Page navigation">
        <ul class="pagination">
            <!-- Pagination logic here -->
        </ul>
    </nav>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>