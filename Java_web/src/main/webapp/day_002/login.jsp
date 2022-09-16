<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
		<style type="text/css">
		
			input:-webkit-autofill,
			input:-webkit-autofill:hover, 
			input:-webkit-autofill:focus, 
			input:-webkit-autofill:active{
			    -webkit-box-shadow: 0 0 0 30px white inset !important;
			}
			body {
				background-color: skyblue;
				text-align: center;
			}
			#loginForm {
				margin: auto auto;
				border: 2px double white;
				width: 30vw;
				height: 40vh;
				border-radius: 10%;
			}
			
			#loginForm input:not(#submit) {
				position: relative;
				top: 15vh;
				border: none;
				border-bottom: 1px solid #8f8686;
				background: none;
				width: 200px;
				height: 50px;
				margin-bottom: 20px;
				
				font-size: 1em;
			}
			
			#title {
				position: relative;
				top: 10vh;
			}
			
			#submit {
				position: relative;
				top: 16vh;
				border: none;
				background-color: #4dbeff;
				font-size: 0.5em;
				border-radius: 5px;
				height: 20px;
				width: 40px;
			}
			
		</style>
	</head>
	<body>
		<h3 id="title">로그인</h3>
		<form action="login_ok.jsp" id="loginForm">
			<input type="text" placeholder="아이디를 입력하여 주세요" name="id" id="id"><br>
			<input type="password" placeholder="비밀번호를 입력하여 주세요" name="pw" id="pw"><br>
			<input type="button" id="submit" value="로그인">
		</form>
	</body>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
		var id = $('#id')
		var pw = $('#pw')
		var isOk = false
		id.change(checkOk())
		pw.change(checkOk())
		
		function checkOk() {
			
		}
	</script>
</html>