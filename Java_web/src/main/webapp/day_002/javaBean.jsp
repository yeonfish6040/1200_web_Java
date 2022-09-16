<%@page import="day_002.MemberDAO"%>
<%@page import="MyUtil.sql.sqlResults"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="member" class="day_002.MemberVO"></jsp:useBean>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
	<!-- 
		<jsp:setProperty property="name" name="member" value="크루즈"/>
		<jsp:setProperty property="birthDay" name="member" value="123"/>-->
		<jsp:getProperty property="name" name="member"/>
		<jsp:getProperty property="birthDay" name="member"/>
		<%=new MemberDAO().select("son").getTable(true)%>
		<%System.out.print(new MemberDAO().select("son").getTable(false)); %>
		<style>
			.sql_td {
				background-color: #eee2e2;
				border-radius: 10%;
				cursor: pointer;
				width: auto;
				text-align: center;
				margin: auto auto;
			}
			
			tr:not(.sql_tr_0) .sql_td:hover {
				font-size: smaller;
				color: #4f4f4f;
			}
			
			.sql_tr_0 .sql_td {
				background-color: #ababab;
			}
		</style>
	</body>
</html>