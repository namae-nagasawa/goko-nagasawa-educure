<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String error = (String) request.getAttribute("error");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java応用課題</title>
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<h1>ペット情報管理</h1>

	<div class="info">
		<h2>トップページ</h2>
		<form action="StartServlet" method="post">
			<p class="error">${requestScope.error}</p>

			暗証番号： <input type="password" name="pass"> <br />
			<button class="btn" type="submit">始める</button>
		</form>
	</div>
</body>
</html>

