<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title>회원가입</title> 
<!-- 내부 스타일 --> 
<style> 
</style> 
<!-- 외부스타일 --> 
<!-- <link rel="stylesheet" href="css/style.css">  --> 
 
</head> 
<body> 
 <h1 style="color:white; background-color:black">회원 가입을 환영합니다.</h1> 
 <form action=""> 
  <fieldset> 
   <legend>사용자 정보</legend> 
   <ul> 
    <li> 
     <label for="user_id">아이디 : </label> 
     <input id="user_id" type="text" name=""  
     autofocus required placeholder="4자에서 10자까지 
공백없이"> 
    </li> 
    <li> 
     <label for="user_email">이메일 : </label> 
     <input id="user_email" type="email" name="" required> 
    </li> 
    <li> 
     <label for="user_pw">비밀번호 : </label> 
     <input id="user_pw" type="password" name=""  
     required placeholder="문자와 숫자, 특수기호 포함"> 
    </li> 
    <li> 
     <label for="user_pw1">비밀번호 확인 : </label> 
     <input id="user_pw1" type="password" name="" required>
     
    </li> 
    <li> 
     <label for="path">가입 경로 : </label> 
     <select id="path"> 
     <!-- option : value --> 
      <option value="blog">블로그</option> 
      <option value="search">검색</option> 
      <option value="sns" selected>sns</option> 
      <option value="etc">기타</option> 
     </select> 
    </li> 
    <li> 
     <label for="txtarea">메모 : </label> 
     <textarea id="txtarea" rows="5" cols="40" 
     placeholder="남길 말씀이 있다면 여기에"></textarea> 
    </li> 
</ul> 
</fieldset> 
<fieldset> 
<legend>이벤트와 새로운 소식</legend> 
<div> 
<input id="mail_y" type="radio" name="mail_chk"> 
<label for="mail_y">메일수신 </label> 
<input id="mail_n" type="radio" name="mail_chk" checked> 
<label for="mail_n">메일수신 안함 </label> 
</div>    
</fieldset> 
<div> 
<input type="submit" name="" value="가입하기"> 
<input type="reset" name="" value="취소"> 
</div>   
</form> 
</body> 
</html> 