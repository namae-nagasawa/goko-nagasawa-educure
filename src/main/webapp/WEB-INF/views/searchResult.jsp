<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索画面</title>
</head>
<body>
	<table border="1">
		<tr>
			<th><fmt:message key="form.lbl.userId" /></th>
			<th><fmt:message key="result.lbl.userName" /></th>
			<th><fmt:message key="result.lbl.userPrice" /></th>
		</tr>

		<c:forEach var="user" items="${resultList}">
			<tr>
				<td>${fn:escapeXml(user.id)}</td>
				<td>${fn:escapeXml(user.name)}</td>
				<td>${fn:escapeXml(user.price)}</td>
			</tr>
		</c:forEach>
		<br>
		<div>
			<a href="/index"><fmt:message key="form.lbl.back" /></a>
		</div>
</body>
</html>
