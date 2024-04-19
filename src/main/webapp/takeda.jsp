<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String name = request.getParameter("name");
String date = request.getParameter("date");



%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>takeda</title>
</head>
<body>

<form action="uesugi.jsp">
	<button >上杉を呼ぶ</button>
</form>

<div>
	<p><%= name %>を受け取った</p>
	<p><%= date %>が行われた</p>
	
</div>

<div>
	<form action="uesugi.jsp">
		<input type="text" name="name">
		<button type="submit">を送る</button>
		
	</form>

</div>
</body>
</html>