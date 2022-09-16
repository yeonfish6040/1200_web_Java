<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>redirecting...</title>
	</head>
	<body>
		<%
			String site = request.getParameter("site");
			String url = "";
			if(site.equals("naver"))
				url = "forward_naver.jsp";
			else if(site.equals("daum"))
				url = "forward_daum.jsp";
			else if(site.equals("google"))
				url = "forward_google.jsp";
		%>
		<jsp:forward page="<%=url%>" />
	</body>
</html>