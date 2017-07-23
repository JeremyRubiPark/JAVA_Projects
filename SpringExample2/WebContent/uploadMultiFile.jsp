<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Upload Multi Files</title>
</head>
<body>
<jsp:include page="__menu.jsp"/>
<h1>Upload Multiple Files:</h1>
<form:form modelAttribute="uploadForm" method="POST" action="uploadMultiFile" enctype="multipart/form-data">
	Description:
	<br>
	<form:input path="description"/>
	<br><br>
	File to upload (1): <form:input path="files" type="file"/><br />      
    File to upload (2): <form:input path="files" type="file"/><br />    
    File to upload (3): <form:input path="files" type="file"/><br />    
    File to upload (4): <form:input path="files" type="file"/><br />    
    File to upload (5): <form:input path="files" type="file"/><br />
    
    <input type="submit" value="Upload">
</form:form>
</body>
</html>