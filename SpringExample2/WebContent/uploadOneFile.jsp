<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Upload One File</title>
</head>
<body>
<jsp:include page="__menu.jsp"/>
<h1>Upload One File</h1>
<form:form modelAttribute="uploadForm" method="POST" action="uploadOneFile" enctype="multipart/form-data">
	Description:<br>
	<form:input path="description"/>
	<br><br>
	File to upload: <form:input path="files" type="file"/>
	<br>
	<input type="submit" value="Upload">
</form:form>
</body>
</html>