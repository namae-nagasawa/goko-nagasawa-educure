<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索画面</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>price</th>
		</tr>
		<c:forEach var="product" items="${resultList}">
			<tr>
				<td>${fn:escapeXml(product.id)}</td>
				<td>${fn:escapeXml(product.name)}</td>
				<td>${fn:escapeXml(product.price)}</td>
			</tr>
		</c:forEach>
	<br>
	<div>
		<a href="/index">戻る</a>
	</div>
</body>
</html>
