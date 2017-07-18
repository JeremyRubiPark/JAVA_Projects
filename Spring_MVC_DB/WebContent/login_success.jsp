<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>login_success.jsp</title>
</head>
<body>
<%
// 로그인 성공 했으면 로그인 성공 페이지 말고 메인으로 보내기
	response.sendRedirect("/Spring_MVC_DB/");
%>

</body>
</html>