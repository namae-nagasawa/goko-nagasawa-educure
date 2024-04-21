<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
String param = request.getParameter("param");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<p>
<%

if(param != null){
	switch(param){
	case "0":
		out.println("赤ですね。進んではいけません。");
		break;
	
	case "1":
		out.println("黄ですね。止まってください。");
		break;
	
	case "2":
		out.println("青ですね。進んでください。");
		break;
	default:
		out.println("赤、青、黄のいずれかを選択してください。");
		break;

	}
}
	
%>
</p>
	<form action="switchPractice01.jsp" method="post">
		<input type="radio" name="param" value="0" checked>赤
		<input type="radio" name="param" value="1">黄
		<input type="radio" name="param" value="2">青
	<button type="submit">チェック </button>
	</form>
</div>
</body>
</html>
