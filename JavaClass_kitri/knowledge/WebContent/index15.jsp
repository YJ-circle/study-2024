<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>��Ÿ�� - ��� ��Ÿ��</title>
<!-- ���� ��Ÿ�� -->
<style>
li {
	list-style: none;
	margin-bottom: 10px;
	border: 2px solid;
	padding: 15px;
}

table {
	border: 1px solid;
	border-collapse: collapse;
	text-align: center;
	caption-side: bottom;
}

th, tr, td {
	border: 1px dashed;
	border-collapse: collapse;
	padding: 10px;
}
</style>
</head>
<body>
	<div>
		<h1>��ǰ ����</h1>
		
		<table id="table">
		<caption>������� ������ ��ǰ ����</caption>
			<tr>
				<th>�뵵</th>
				<th>�߷�</th>
				<th>����</th>
				<th>����</th>

			</tr>
			<tr>
				<td rowspan="2">������</td>
				<td>3kg</td>
				<td>11 ~ 16��</td>
				<td>35,000��</td>

			</tr>
			<tr>
				<td>5kg</td>
				<td>18 ~ 26��</td>
				<td>52,000��</td>
			</tr>
			<tr>
				<td rowspan="2">������</td>
				<td>3kg</td>
				<td>11 ~ 16��</td>
				<td>30,000��</td>

			</tr>
			<tr>
				<td>5kg</td>
				<td>18 ~ 26��</td>
				<td>47,000��</td>
			</tr>
		</table>

	</div>
</body>
</html>