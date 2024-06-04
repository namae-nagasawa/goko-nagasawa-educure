<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メッセージ</title>
</head>
<body>
	<div>
		<p>以下のメッセージが届きました</p>
		<p>
			<c:out value=" ${fn:escapeXml(requestScope.result)}" />
		</p>
	</div>
</body>
</html>