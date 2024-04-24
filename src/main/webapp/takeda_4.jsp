<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String date = request.getParameter("date");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>takeda</title>
</head>
<body>
<div>

	<form action="uesugi_4.jsp">
	
		<input type ="radio" name="name" value="第一次試合">第一次試合
		<input type ="radio" name="name" value="第二次試合">第二次試合
		<input type ="radio" name="name" value="第三次試合">第三次試合
	
		<button type="submit" value="name">上杉を呼ぶ</button>
	</form>
	
	
</div>

<div>
	
	<p><%= date %>が行われた</p>
	
</div>

</body>
</html>