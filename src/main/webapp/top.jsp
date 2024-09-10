<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JavaEE</title>
</head>
<body>
	<p>
		<b>検索条件、または、登録情報を入力してください</b>
	</p>
	<form:form action="result" modelAttribute="index">
		<div>
			name
			<form:input path="input" />
		</div>
		<div>
			price

			<form:input path="input" />
		</div>
		<br>

		<form:button name="param1">検索</form:button>
		<form:button name="param2">登録</form:button>
</body>
</html>