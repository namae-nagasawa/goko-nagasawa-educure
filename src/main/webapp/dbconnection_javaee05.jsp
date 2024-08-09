<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JavaEE</title>
</head>
<body>
	<!--  検索条件の入力と検索結果の表示用のjsp-->

	<p>検索条件、または、登録情報（name,price)を入力してください</p>
	<form action="/JavaEEproject/DBConnection_JavaEE05" method="post">
		id <input type="text" name="id"><br> name<input
			type="text" name="name"><br> price<input type="text"
			name="price"> <br>
		<button type="submit" name="btn1" value="send">検索</button>
		<button type="submit" name="btn1" value="upins">登録または更新</button>
		<button type="submit" name="btn1" value="delete">削除</button>
	</form>

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