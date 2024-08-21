<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録確認画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
  <p>これでよろしいですか？</p>

  <p class="error">エラーメッセージ</p>

  <form action="insertResult.jsp" method="post">
    <fieldset class="label-130">
      <div>
        <label>ID</label>
        <input type="text" name="loginId" value="${sessionScope.loginId}" readonly>
      </div>
      <div>
        <label>名前</label>
        <input type="text" name="userName" value="${sessionScope.userName}" readonly>
      </div>
      <div>
        <label>TEL</label>
        <input type="text" name="tel" value="${sessionScope.tel}" readonly>
      </div>
      <div>
        <label>権限</label>
        <input type="text" name="roleName" value="${sessionScope.role[0]}" readonly>
      </div>
      <div>
        <label>PASS（再入力）</label>
        <input type="password" name="rePass">
      </div>
    </fieldset>
    <div>
      <button type="submit">登録</button>
      <button type="button" onclick="location.href='insert.jsp';">戻る</button>
    </div>
  </form>
  <div>
    <a href="menu.jsp">メニューに戻る</a>
  </div>
</body>
</html>
