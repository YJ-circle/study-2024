<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script type = "text/javascript">
/*함수 리터널 정의
 변수명 = (익명 함수 정의)
 */
var mul = function(num1, num2) {
	    return num1 * num2;
	};

 
function callFunc(num1, num2){
	var resultValue = mul(2, 4)
	var result = document.getElementById("result");
	var text = document.getElementById("text");
	result.innerText = resultValue;
	text.innerText = '클릭 후';

}
</script>


<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form>
	<input type="button" onclick="callFunc()" value="callFunc"/>
</form>
<p id="text"> 클릭 전</p>
<p id="result"></p>
</body>
</html>