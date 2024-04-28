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
for (int year = 1800; year <= 2000; year++) {
	if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) {
		out.println(year + "年はうるう年");
	}
}
%>
</body>
</html>