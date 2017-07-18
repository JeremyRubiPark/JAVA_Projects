<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>upload_result.jsp</title>
</head>
<body>
<%
	response.setCharacterEncoding("utf-8");
%>
파일 업로드 완료<br>
원본 이름 : ${originalName}<br>
저장된 이름 : ${savedName}<br>

<a href="uploadForm.do">[다시 업로드]</a>

</body>
</html>