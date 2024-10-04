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
<title>登録確認画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<p>
		<fmt:message key="form.lbl.kakuninn" />
	</p>

	<p class="error">${sessionScope.errorPass}</p>

	<form action="insertConfirm" method="post">
		<fieldset claass="label-130">
			<div>
				<fmt:message key="form.lbl.loginId" />
				<input type="text" name="loginId" value="${loginId}" readonly>

			</div>
			<div>
				<fmt:message key="form.lbl.name" />
				<input type="text" name="userName" value="${userName}" readonly>

			</div>
			<div>
				<fmt:message key="form.lbl.telephone" />
				<input type="text" name="telephone" value="${telephone}" readonly>

			</div>
			<div>
				<fmt:message key="form.lbl.grant" />
				<input type="text" name="roleId" value="${sessionScope.posi}" readonly>

			</div>
			<div>
				<fmt:message key="form.lbl.repass" />
				<input type="password" name="rePass">
			</div>
		</fieldset>
		<div>
			<button type="submit">
				<fmt:message key="form.lbl.insert1" />
			</button>
			<button type="submit" formaction="insert">
				<!-- コントローラーのメソッド名と連携しているform.actionの部分 -->
				<fmt:message key="form.lbl.back" />
			</button>
		</div>
	</form>
	<div>
		<br> <a href="menu"><fmt:message key="form.lbl.menuseni" /></a>
	</div>

</body>
</html>
