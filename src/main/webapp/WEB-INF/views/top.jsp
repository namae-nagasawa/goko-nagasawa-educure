<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トップ画面</title>
</head>
<body>
	<form:form action="result" modelAttribute="index">
		<c:if test="${not empty msg}">
			<h2>${msg}</h2>
		</c:if>
		<div>
			name:
			<form:input path="name" />
			<br> price:
			<form:input path="price" />
		</div>
		<br>
		<form:button name="search">検索</form:button>
		<form:button name="register">登録</form:button>
	</form:form>

</body>
</html> 