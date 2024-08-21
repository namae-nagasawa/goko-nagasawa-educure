<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
    <table>
        <caption>検索結果</caption>
        <thead>
            <tr>
                <th>ID</th>
                <th>名前</th>
                <th>TEL</th>
                <th>権限</th>
            </tr>
        </thead>
        <tbody>
            <c:choose>
                <c:when test="${not empty resultList}">
                    <c:forEach var="item" items="${resultList}">
                        <tr>
                            <td>${item.loginId}</td>
                            <td>${item.userName}</td>
                            <td>${item.telephone}</td>
                            <td>${item.roleName}</td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td colspan="4">${errormsg}</td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </tbody>
    </table>
    <div>
        <a href="menu.jsp">メニューに戻る</a>
    </div>
</body>
</html>
