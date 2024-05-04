<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Integer ps = (Integer) session.getAttribute("value");
if (ps == null) {
	ps = 0;
} else {
	ps++;
}
session.setAttribute("value", ps);
out.println(ps);
%>
	<div>
		<form action="scope01.jsp"method="post">
			<button type="submit">クリック</button>
		</form>
	</div>
</body>
</html>