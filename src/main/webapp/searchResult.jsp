<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		<b>検索結果</b>
	</p>

	<table border="1">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>price</th>
		</tr>
		<c:forEach var="product" items="${resultList}">
			<tr>
				<td>${fn:escapeXml(product.productId)}</td>
				<td>${fn:escapeXml(product.productName)}</td>
				<td>${fn:escapeXml(product.productPrice)}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>