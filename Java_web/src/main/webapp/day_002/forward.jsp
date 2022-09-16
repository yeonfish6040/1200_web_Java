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
			보고싶은 페이지를 선택하십시오.
			<select name="site">
				<option value="naver">네이버</option>
				<option value="daum">다음</option>
				<option value="google">구글</option>
			</select>
			<input type="submit" value="Trans">
		</form>
	</body>
</html>