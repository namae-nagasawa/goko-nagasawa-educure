<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String push =request.getParameter("push");
    String name=request.getParameter("name");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<div>
	<p><%= name %>を受け取った</p>
</div>

<div>
	<form action="uesugi_3.jsp">
		<input type="text" name="push">
		<button type="submit">を送る</button>
	</form>
</div>

</body>
</html>