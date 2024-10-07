<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script type = "text/javascript">
	function add(a,b){
		return a+b;
	}
	
	function sub(a,b){
		return a-b;
	}
	function mul(a,b){
		return a*b;
	}
	function div(a,b){
		if(b==0){
			return '0으로 나눌 수 없습니다.'
		}
		return a/b;
	}
	
	function parseNumById(numId){
		return parseFloat(document.getElementById(numId).value);
	}
	function main(oper){
		var a = parseNumById('num1');
		var b = parseNumById('num2');
		if (typeof oper == 'string'){
			if(isNaN(a) || isNaN(b)){
				return alert("계산하려는 값이 숫자가 아닙니다.");
			}
			
			switch (oper){
				case 'add' :
					alert(a + ' + ' + b + ' = ' + add(a, b)); break;
				case 'sub' :
					alert(a + ' - ' + b + ' = ' +sub(a, b)); break;
				case 'mul' :
					alert(a + ' * ' + b + ' = ' +mul(a, b)); break;
				case 'div' :
					alert(a + ' / ' + b + ' = ' +div(a, b)); break;
					
			}
		}
	}
</script>


<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form>
	숫자1: <input type="number" id="num1"/> <br />
	숫자2: <input type="number" id="num2"/> <br /><br/>
	<input type="button" onclick="main('add')" value="add"/>
	<input type="button" onclick="main('sub')" value="sub"/>
	<input type="button" onclick="main('mul')" value="mul"/>
	<input type="button" onclick="main('div')" value="div1"/>
	<input type="button" onclick="main('div')" value="div2"/>
</form>
</body>
</html>