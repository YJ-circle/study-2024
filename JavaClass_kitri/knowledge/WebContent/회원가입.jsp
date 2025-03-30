<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <jsp:include page="head.html" flush="false" />
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입 약관 동의</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .agreement-section {
            border: 1px solid #dee2e6;
            padding: 10px;
            border-radius: 8px;
            margin-bottom: 15px;
            background-color: #f8f9fa;
        }
        .agreement-header {
            font-weight: bold;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .agreement-header .optional {
            font-size: 0.85rem;
            color: #6c757d;
        }
        .form-check {
            margin-top: 10px;
        }
        .scroll-content {
            max-height: 150px;
            overflow-y: auto;
            background-color: #ffffff;
            padding: 10px;
            border: 1px solid #dee2e6;
            border-radius: 5px;
        }
        .btn-next {
            width: 100%;
            padding: 12px;
        }
    </style>
</head>
<body>

<div class="container mt-4">
    <h2>회원가입 약관 동의</h2>
    
    <div class="agreement-section">
        <div class="agreement-header">
            <span>전체 동의하기</span>
            <div class="form-check form-switch">
                <input class="form-check-input" type="checkbox" id="agreeAll" onclick="toggleAll()">
                <label class="form-check-label" for="agreeAll"></label>
            </div>
        </div>
    </div>

    <div class="agreement-section">
        <div class="agreement-header">
            <span>네이버 이용약관</span>
            <span class="optional">(필수)</span>
        </div>
        <div class="scroll-content">
            <p>네이버 서비스 약관 내용이 여기에 표시됩니다...</p>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" id="termsAgree">
            <label class="form-check-label" for="termsAgree">이용 약관에 동의합니다.</label>
        </div>
    </div>

    <div class="agreement-section">
        <div class="agreement-header">
            <span>개인정보 수집 및 이용</span>
            <span class="optional">(필수)</span>
        </div>
        <div class="scroll-content">
            <p>개인정보 수집 및 이용에 대한 내용이 여기에 표시됩니다...</p>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" id="privacyAgree">
            <label class="form-check-label" for="privacyAgree">개인정보 처리방침에 동의합니다.</label>
        </div>
    </div>

    <div class="agreement-section">
        <div class="agreement-header">
            <span>실명 인증된 아이디로 가입</span>
            <span class="optional">(선택)</span>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" id="realNameAgree">
            <label class="form-check-label" for="realNameAgree">실명 인증된 아이디로 가입에 동의합니다.</label>
        </div>
    </div>

    <div class="agreement-section">
        <div class="agreement-header">
            <span>위치기반서비스 이용약관</span>
            <span class="optional">(선택)</span>
        </div>
        <div class="scroll-content">
            <p>위치기반서비스 이용약관 내용이 여기에 표시됩니다...</p>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" id="locationAgree">
            <label class="form-check-label" for="locationAgree">위치기반서비스 이용약관에 동의합니다.</label>
        </div>
    </div>

    <div class="agreement-section">
        <div class="agreement-header">
            <span>개인정보 수집 및 이용</span>
            <span class="optional">(선택)</span>
        </div>
        <div class="scroll-content">
            <p>이벤트 및 혜택 정보 수신에 대한 내용이 여기에 표시됩니다...</p>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" id="eventAgree">
            <label class="form-check-label" for="eventAgree">이벤트 및 혜택 정보 수신에 동의합니다.</label>
        </div>
    </div>

    <div class="mt-3">
        <button class="btn btn-primary btn-next" onclick="return validateAgreements();">다음</button>
    </div>
</div>

<script>
    function validateAgreements() {
        var termsAgree = document.getElementById('termsAgree').checked;
        var privacyAgree = document.getElementById('privacyAgree').checked;

        if (!termsAgree || !privacyAgree) {
            alert('필수 약관에 동의해야 다음 단계로 진행할 수 있습니다.');
            return false;
        }
        return true;
    }

    function toggleAll() {
        var allChecked = document.getElementById('agreeAll').checked;
        document.getElementById('termsAgree').checked = allChecked;
        document.getElementById('privacyAgree').checked = allChecked;
        document.getElementById('realNameAgree').checked = allChecked;
        document.getElementById('locationAgree').checked = allChecked;
        document.getElementById('eventAgree').checked = allChecked;
    }
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
