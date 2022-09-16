<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		<p>아이디: <%=request.getParameter("id")%></p>
		<p>이이름: <%=request.getParameter("name")%></p>
	</body>
</html>