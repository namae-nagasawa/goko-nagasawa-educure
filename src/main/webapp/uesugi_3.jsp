<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String name=request.getParameter("name");
    String push =request.getParameter("push");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<p><%= push %>を受け取った</p>
</div>

<div>
	<form action="takeda_3.jsp">
		<input type="text" name="name">
		<button type="submit">を送る</button>
	</form>
</div>



</body>
</html>