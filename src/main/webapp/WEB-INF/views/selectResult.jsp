<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<table>
		<caption>検索結果</caption>
		<thead>
			<tr>
				<th><fmt:message key="form.lbl.loginId" /></th>
				<th><fmt:message key="form.lbl.name" /></th>
				<th><fmt:message key="form.lbl.telephone" /></th>
				<th><fmt:message key="form.lbl.grant" /></th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${not empty resultList}">
					<c:forEach var="r" items="${resultList}">
						<tr>
							<td>${fn:escapeXml(r.loginId)}</td>
							<td>${fn:escapeXml(r.userName)}</td>
							<td>${fn:escapeXml(r.telephone)}</td>
							<td>${fn:escapeXml(r.roleName)}</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="4">${errormsg}</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	<div>
		<form:form action="menu" method="get" modelAttribute="menu">
			<a href="menu"><fmt:message key="form.lbl.menuseni" /></a>
		</form:form>
	</div>
</body>
</html>
