<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script type = "text/javascript">
function calledFunc(num1, num2){
		/* 곱하기 함수 정의 
		mul()
		*/
		function mul(){
			return num1 * num2;
		}
		
		/* mul 호출, 원래 호출한 callFunc로 return */	
		return mul();
}

function callFunc(){
	ret = calledFunc(12, 2);
	alert(ret);
}
</script>


<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form>
	<input type="button" onclick="callFunc()" value="callFunc"/>
</form>
</body>
</html>