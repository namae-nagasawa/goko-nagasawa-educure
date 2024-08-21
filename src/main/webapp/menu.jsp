<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<p>${sessionScope.userName}さん、こんにちは</p>


	<c:choose>

		<c:when test="${sessionScope.role_id==1}">
			<p>
				<a href="select.jsp">検索</a>
			</p>


			<p>
				<a href="insert.jsp">登録</a>
			</p>

		</c:when>
		<c:otherwise>

			<p>
				<a href="select.jsp">検索</a>
			</p>

		</c:otherwise>
	</c:choose>


	<!-- 発展課題
    <p>
      <a href="update.html">更新</a>
    </p>
    <p>
      <a href="delete.html">削除</a>
    </p>
-->
	<form action="LogoutServlet" method="post">
		<button type="submit">ログアウト</button>
	</form>
</body>
</html>
