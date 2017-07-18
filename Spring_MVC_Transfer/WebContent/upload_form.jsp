<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>upload_form.jsp</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
%>
	<form action="upload.do" method="post" enctype="multipart/form-data">
		이름 : <input type="text" name="name" size="10"><br>
		휴대폰번호 : <input type="text" name="phone" size="20"><br>
		파일첨부 : <input type="file" name="memberFile"><br>
		<input type="submit" value="upload">
	</form>
</body>
</html>