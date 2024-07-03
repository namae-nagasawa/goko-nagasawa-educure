<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%String btn = request.getParameter("btn");%>
<%String btn1 = request.getParameter("btn1");%>
<%@ page import="jp.co.sample.pet.Dog"%>
<%@ page import="jp.co.sample.pet.Cat"%>



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
				<th>名前：</th>
				<td><c:choose>
						<c:when test="${requestScope.btn==sessionScope.dog}">
				${sessionScope.dogName}</c:when>

						<c:otherwise>${sessionScope.catName}</c:otherwise>

					</c:choose></td>
			</tr>
			<tr>
				<th>年齢：</th>

				<td><c:choose>
						<c:when test="${requestScope.btn==sessionScope.dog }">
				${sessionScope.dogAge}</c:when>

						<c:otherwise>${sessionScope.catAge}</c:otherwise>

					</c:choose></td>
			</tr>
			<tr>
				<th>体長：</th>
				<td><c:choose>
						<c:when test="${requestScope.btn==sessionScope.dog }">
				${sessionScope.dogHeight}</c:when>

						<c:otherwise>${sessionScope.catHeight}</c:otherwise>

					</c:choose></td>
			</tr>
			<tr>
				<th>体重：</th>
				<td><c:choose>
						<c:when test="${requestScope.btn == sessionScope.dog}">
                            ${sessionScope.dogWeight}
                            <c:if test="${dog.isFat()}">
								<span class="error">太り気味です</span>
							</c:if>
						</c:when>
						<c:otherwise>
                            ${sessionScope.catWeight}
                            <c:if test="${cat.isFat()}">
								<span class="error">太り気味です</span>
							</c:if>
						</c:otherwise>
					</c:choose></td>


			</tr>
			<tr>
				<th>種別：</th>
				<td><c:choose>
						<c:when test="${requestScope.btn == sessionScope.dog}">
                ${sessionScope.dogType}
            </c:when>
						<c:otherwise>
                ${sessionScope.catType}
            </c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<th><c:choose>
						<c:when test="${requestScope.btn == sessionScope.dog}">散歩場所：</c:when>
						<c:otherwise>お気に入り道具：</c:otherwise>
					</c:choose></th>
				<td><c:choose>
						<c:when test="${requestScope.btn == sessionScope.dog}">
                ${sessionScope.dogWalkingPlace}
            </c:when>
						<c:otherwise>
                ${sessionScope.catFavoriteItem}
            </c:otherwise>
					</c:choose></td>
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