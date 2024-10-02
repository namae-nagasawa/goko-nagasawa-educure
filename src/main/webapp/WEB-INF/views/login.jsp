<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>

	<p>
		<c:if test="${not empty msg}">
			<p><p class="error-message">${msg}</p>
		</c:if>
	</p>

	<form:form action="login" modelAttribute="login">
		<div>
			<fmt:message key="form.lbl.loginId"/>
			<form:input path="loginId" />
			<form:errors path="loginId" cssStyle="color:red" />
		</div>
		<div>
			<fmt:message key="form.lbl.password"/>
			<form:input path="password" />
			<form:errors path="password" cssStyle="color:red" />
		</div>
		<div>
			<form:button>
				<fmt:message key="form.lbl.login" />
			</form:button>
		</div>
	</form:form>
	<div>
		<form:form action="index" modelAttribute="index">
			<a href="index"><fmt:message key="form.lbl.top" /></a>
	</div>
	</form:form>
</body>
</html>
