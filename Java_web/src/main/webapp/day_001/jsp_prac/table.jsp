<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		<table border="1">
<%
				
				for(int j=1;j<=5;j++) {%>
					<tr>
<%
					for(int k=1;k<=j;k++){%>
						<td><%=j%>행 <%=k%>열</td>
<%					}
%>
					</tr>
<%				}
%>
<%
				int i = 1;
				for(int j=6;j<=10;j++) {%>
					<tr>
<%					
					for(int k=1;k<=j-i;k++){%>
						<td><%=j%>행 <%=k%>열</td>
<%					}
					i += 2;
%>					</tr>
<%				}
%>
		</table>
	</body>
</html>