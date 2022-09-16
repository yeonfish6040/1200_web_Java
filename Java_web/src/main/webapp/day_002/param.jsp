<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>param</title>
	</head>
	<body>
		<h3>Parameter Action Tag</h3>
		<jsp:forward page="param_process.jsp">
			<jsp:param value="admin" name="id"/>
			<jsp:param value="AdMiN" name="name"/>
		</jsp:forward>
	</body>
</html>