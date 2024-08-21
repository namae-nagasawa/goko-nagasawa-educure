<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録結果確認画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<p>実行者：${sessionScope.userName}</p><!-- xss対策 -->
	<p>正常に登録されました</p>
	<div>
		<a href="menu.jsp">メニューに戻る</a>
	</div>
</body>
</html>
