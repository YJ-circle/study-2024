<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function isNull(id, pwd){
		return id.trim() === ""||pwd.trim() === "";
	}
	
	function trylogin(id, pwd){
		let saveid = '나의아이디';
		let savepwd = 'mypwd';
		if(id == saveid){
			if(pwd == savepwd){	return true;}
			else { alert("비밀번호가 틀렸습니다");
				   return false;}
		}
		else { alert("등록되지 않은 사용자 입니다.");}
		
	}
	
	function cookieSave(id){
		cookieValue = escape(id)+";";
		document.cookie = "userId=" + cookieValue;
	}
	
	
	function login(){	
		let id = document.getElementById("id").value;
		let pwd = document.getElementById("pwd").value;
		
		if(isNull(id, pwd)){ return alert("아이디, 패스워드를 모두 입력해주세요"); }
		
		if(trylogin(id, pwd)){
			cookieSave(id);
			alert("로그인 성공!");
		}
	}
	
	function logout(){
		document.cookie = "userId=;expires=Thu, 01 Jan 1970 00:00:00 GMT;";
		alert("로그아웃");
	}

</script>

</head>
<body>
<input type="text" id="id"/><br />
<input type="password" id="pwd"/><br />
<input type="button" value="로그인" onclick="login()" />
<input type="button" value="로그아웃" onclick="logout()" required/>

</body>
</html>