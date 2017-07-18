<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
<title>update_book.jsp</title>
</head>
<body>

	<c:if test="${empty bookList}">
	저장된 책이 없습니다.<br>
	</c:if>
<form action="updateBook.do" method="get">	
	<c:if test="${not empty bookList}">
	
		<table border="1">
		
			<tr>
				<th>책번호</th>
				<th>제목</th>
				<th>출판사</th>
				<th>출판연도</th>
				<th>가격</th>
			</tr>	
			<c:forEach items="${bookList}" var="book">
				<tr>
					<td align="center"><input type="radio" name="bookNum" value="${book.bookNum}" required></td>
					<td>${book.bookNum}</td>
					<td>${book.bookTitle}</td>
					<td>${book.bookPub}</td>
					<td>${book.pubYear}</td>
					<td>${book.bookPrice}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
		<table>
			<tr>
				<td>New bookTitle : <input type="text" name="bookTitle"></td>
			</tr>
			<tr>
				<td>New bookPub : <input type="text" name="bookPub"></td>
			</tr>
			<tr>
				<td>New bookYear : <input type="text" name="pubYear"></td>
			</tr>
			<tr>
				<td>New bookPrice : <input type="text" name="bookPrice"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit"></td>
				<td><input type="reset"></td>
			</tr>
			
			
		</table>
	</form>


	<a href="http://localhost:8888/Spring_MVC_DB/">
		[메인 화면으로]
	</a>
</body>
</html>