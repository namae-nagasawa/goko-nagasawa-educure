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
<title>登録画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<p>
		<c:if test="${not empty msg3}">
			<p>${msg3}</p>
			<p>${msg5}</p>
		</c:if>

	</p>

	<p class="error-message">
		<c:if test="${not empty msg6}">
				${msg6}
		</c:if>
	</p>


	<form:form action="insert" method="post" modelAttribute="insert">
		<fieldset class="label-60">
			<div>
				※
				<fmt:message key="form.lbl.loginId" />
				<form:input path="loginId" />
				<form:errors path="loginId" cssStyle="color:red" />
			</div>

			<div>
				※
				<fmt:message key="form.lbl.name" />
				<form:input path="name" />
				<form:errors path="name" cssStyle="color:red" />
			</div>

			<div>
				※
				<fmt:message key="form.lbl.telephone" />
				<form:input path="telephone" />
				<form:errors path="telephone" cssStyle="color:red" />
			</div>

			<div>
				<fmt:message key="form.lbl.grant" />
				<form:select path="roleId">
					<c:forEach var="ro" items="${sessionScope.roles}">
						<option value="${ro.roleId}">${ro.roleName}</option>
					</c:forEach>
				</form:select>
			</div>
			<div>
				※
				<fmt:message key="form.lbl.password" />
				<form:input path="password" />
				<form:errors path="password" cssStyle="color:red" />
			</div>
		</fieldset>
		<button type="submit">
			<fmt:message key="form.lbl.confirm" />
		</button>
	</form:form>


	<div>
		<br> <a href="menu"><fmt:message key="form.lbl.menuseni" /></a>
	</div>

</body>
</html>
