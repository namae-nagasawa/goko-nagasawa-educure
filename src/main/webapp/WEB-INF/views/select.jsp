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
<title>検索画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
			<fmt:message key="form.lbl.nyuuryoku" />
		<br>
		<fmt:message key="form.lbl.hissu" />
		<br>
		<c:if test="${not empty msg4}">
			<p class="error-message">${msg4}</p>
		</c:if>
		<br>
	<form:form action="list" method="get" modelAttribute="select">
		<div>
			<fmt:message key="form.lbl.name"/>
			<form:input path="name" />
		</div>
		
		<div>
			<fmt:message key="form.lbl.telephone"/>
			<form:input path="telephone" />
		
		</div>
		<div>
			<form:button>
				<fmt:message key="form.lbl.select1" />
			</form:button>
		</div>
	</form:form>
	<div>
		<form:form action="menu" method="get" modelAttribute="menu">
			<a href="menu"><fmt:message key="form.lbl.menuseni" /></a>
	</div>
	</form:form>
</body>
</html>
