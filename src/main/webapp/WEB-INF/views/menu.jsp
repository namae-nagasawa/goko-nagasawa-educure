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
<title>メニュー画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<p>${sessionScope.user_name}さん、こんにちは</p>


	<c:choose>

		<c:when test="${role_id==1}">
			<p>
				<form:form action="select" modelAttribute="select">
					<div>
						<a href="select"><fmt:message key="form.lbl.select1" /></a>
						

					</div>
				</form:form>
			</p>

			<p>
				<form:form action="insert" modelAttribute="select">
					<div>
						<a href="insert"><fmt:message key="form.lbl.insert1" /></a>
						

					</div>
				</form:form>
			</p>

		</c:when>
		<c:otherwise>

			<p>
				<form:form action="select" modelAttribute="select">
					<div>
						<a href="select"><fmt:message key="form.lbl.select1" /></a>
						

					</div>
				</form:form>
			</p>

		</c:otherwise>
	</c:choose>

	<div>
		<form:form action="logout" method="post" modelAttribute="logout">
			<button type="submit">
				<fmt:message key="form.lbl.logout" />
				</a>
	</div>
	</form:form>
</body>
</html>
