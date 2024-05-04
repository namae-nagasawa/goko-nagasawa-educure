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
String rs = (String) request.getParameter("clear");

if (rs == null && ps == null) {
	ps = 0;
}

if (ps != null && rs != null) {
	ps =0;
}
ps++;
session.setAttribute("value", ps);
out.println(ps);
%>
	<div>
		<form action="scope02.jsp"method="post">
			<button type="submit">クリック</button>
			<button type="submit" name="clear" value="clear">クリア</button>
		</form>
	</div>

</body>
</html>	