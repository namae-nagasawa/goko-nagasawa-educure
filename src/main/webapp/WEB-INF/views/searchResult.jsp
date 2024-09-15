<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索画面</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>name</th>
			<th>price</th>
		</tr>
		<c:forEach var="product" items="${resultList}">
			<tr>
				<td>${fn:escapeXml(product.productName)}</td>
				<td>${fn:escapeXml(product.productPrice)}</td>
			</tr>
		</c:forEach>
</body>
</html>