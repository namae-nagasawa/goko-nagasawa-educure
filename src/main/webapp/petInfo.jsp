<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%String error = (String) request.getAttribute("error");%>
<%String btn = request.getParameter("btn"); %>
<%String dog = (String) session.getAttribute("dogName");%>
<%String cat = (String) session.getAttribute("catName");%>
<%error="太り気味です"; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java応用課題</title>
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<h1>ペット情報管理</h1>
	<div class="info">
		<h2>ペット情報</h2>

		<table class="petInfoTable">
			<tr>
				<th>名前：
				<c:choose>
				<c:when test="${requestScope.value==sessionScope.dog}">
				${sessionScope.dogName}</c:when>
				
				<c:otherwise>${sessionScope.catName}</c:otherwise>
				
				</c:choose>
				
				
				</th>
				<td></td>
			</tr>
			<tr>
				<th>年齢：${dogAge} ${catAge}</th>
				<td></td>
			</tr>
			<tr>
				<th>体長：${dogHeight} ${catHeight}</th>
				<td></td>
			</tr>
			<tr>
				<th>体重：${dogWeight} ${catWeight}</th>
				<td><span class="error"><%=error %></span></td>
			</tr>
			<tr>
				<th>種別：${dogType}${catType }</th>
				<td></td>
			</tr>
			<tr>
				<th>散歩場所:</th>
				<td></td>
			</tr>
		</table>
	</div>

	<form action="petList.jsp">
		<button class="btn" type="submit">戻る</button>
	</form>

	<form action="index.jsp">
		<button class="btn" type="submit">先頭に戻る</button>
	</form>
</body>
</html>