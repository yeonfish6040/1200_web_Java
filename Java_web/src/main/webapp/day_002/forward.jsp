<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Forward ActionTag Test</title>
	</head>
	<body>
		<form action="controller.jsp">
			������� �������� �����Ͻʽÿ�.
			<select name="site">
				<option value="naver">���̹�</option>
				<option value="daum">����</option>
				<option value="google">����</option>
			</select>
			<input type="submit" value="Trans">
		</form>
	</body>
</html>