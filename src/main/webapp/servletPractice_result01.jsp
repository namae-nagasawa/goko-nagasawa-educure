<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String year = (String) request.getAttribute("year");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結果表示</title>
</head>
<body>
	入力された年は<%=year%>でした。
</body>
</html>