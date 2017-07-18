<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>join_form.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('form').submit(function(){
			var pw = $('#pw').val();
			var conPw = $('#pwConfirm').val();
			
			if(pw == conPw){
				return true; // 가입 진행
			}else{
				alert('패스워드가 일치하지 않습니다.');
				return false; // submit 취소
			}
		})
	})
</script>

</head>
<body>
	<h4>이곳은 회원가입 입력 화면입니다.</h4>
	<form action="join.do" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="memberId">
					<button>중복확인(추후 구현)</button>
				</td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td>
					<input type="password" name="memberPw" id="pw">
				</td>
			</tr>
			<tr>
				<td>패스워드 확인</td>
				<td>
					<input type="password" id="pwConfirm">
				</td>
			</tr>
			<tr>
				<td>E-MAIL</td>
				<td>
					<input type="email" name="email">
				</td>
			</tr>
			<tr>
				<td>휴대폰번호</td>
				<td>
					<input type="tel" name="phone">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="가입">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>