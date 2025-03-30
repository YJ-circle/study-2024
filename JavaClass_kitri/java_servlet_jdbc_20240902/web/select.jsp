<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="./select.jsp">
<select name="hello" required>
	<option value="" disabled selected hidden >== 선택하세요 ==</option>
	<option value="hello1">hello1</option>
	<option value="hello2">hello2</option>
</select>
<br/>
<input type=radio name="yourSkill" value="Java" required>자바
<input type=radio name="yourSkill" value="c" required> C언어
<br />
<input type=checkbox name="checker" value="1" > 체크1
<input type=checkbox name="checker" value="2"> 체크2
<input type=checkbox name="checker" value="3"> 체크3
<br/><br/><br/>
<input type=checkbox name="right" required> 처리 약관에 동의합니다.
<br/>
<input type="submit" value="전송" style="margin: 15px 0 0 80px"/>
<br /><br />
전송받은 값은: ${param.hello} ${param.yourSkill}
<br>당신의 선택값: 
<% 
String[] select = request.getParameterValues("checker");
for(String s : select){
	out.println("<li>" + s + "</li>" );
}
%>
</form>
</body>
</html>