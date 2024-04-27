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
		out.println("東京まで有楽町を通過します");
		break;
	
	case "1":
		out.println("東京まで 新橋 有楽町 を通過します");
		break;
	
	case "2":
		out.println("東京まで浜松町 新橋 有楽町 を通過します");
		break;
	case "3":
			out.println("東京まで田町 浜松町 新橋 有楽町 を通過します");
			break;
	}
}
%>
</p>
	<p>現在地を選択してください。</p>
	<form action="switchPractice02.jsp" method="post">
		<input type="radio" name="param" value="0" checked>新橋
		<input type="radio" name="param" value="1">浜松町
		<input type="radio" name="param" value="2">田町
		<input type="radio" name="param" value="3">品川
	<button type="submit">決定</button>
	</form>
</div>
</body>
</html>
