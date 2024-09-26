<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トップ画面</title>
</head>
<body>
	<form:form action="result" modelAttribute="index" method="post">
		<div>
			<fmt:message key="form.lbl.name" />
			<form:input path="name" />
			<form:errors path="name" cssStyle="color:red" />
		</div>
		<div>
			<fmt:message key="form.lbl.price" />
			<form:input path="price" />
			<form:errors path="price" cssStyle="color:red" />
		</div>
		<div>
			<button type="submit">
				<fmt:message key="form.lbl.select" />
			</button>
		</div>
		<div>
			<button type="submit">
				<fmt:message key="form.lbl.insert" />
			</button>
		</div>
	</form:form>
</body>
</html>
