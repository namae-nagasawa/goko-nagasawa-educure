<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

String name = request.getParameter("name");


%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>uesugi</title>
</head>
<body>
<div>

	<form action="takeda.jsp">
	<select >
		<option  name="date" value="第一次試合">第一次試合
		<option  name="date" value="第二次試合">第二次試合
		<option  name="date" value="第三次試合">第三次試合
	</select>
		<button type="submit" value="one">武田を呼ぶ</button>
	</form>
	
	
</div>
<div>
	
</div>
<div>
	<p><%= name %>を受け取った</p>
</div>
<div>
<div>
	<form action="takeda.jsp">
		<input type="text" name="name">
		<button type="submit">を送る</button>
	</form>
</div>

</body>
</html>