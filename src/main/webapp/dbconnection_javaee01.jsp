<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JavaEE</title>
</head>
<body>
<!--  検索条件の入力と検索結果の表示用のjsp-->

	<p>検索条件を入力してください</p>
	<form action="DBConnection_JavaEE01" method="post">
		id <input type="text" name="id"><br>
		name<input type="text" name="name"><br>
		price<input type="text" name="price">
		<button type="submit">送信</button>
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