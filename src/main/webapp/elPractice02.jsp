<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
Integer count = (Integer) session.getAttribute("count");
if (count == null) {
	count = 1;
} else {
	count++;
}
session.setAttribute("count", count);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カウントアップ</title>
</head>
<body>


	<div>

		<c:out value="${count}" />

		<form action="elPractice02.jsp" method="post">
			<button type="submit">カウントアップ</button>
		</form>
	</div>
</body>
</html>