<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>

  <p class="error">${requestScope.erroridpass}</p>

  <form action="login" method="post">
    <fieldset>
      <div>
        <label>ID</label>
        <input type="text" name="loginId">
        <span class="error">${requestScope.errorid}</span>
      </div>
      <div>
        <label>PASS</label>
        <input type="text" name="pass">
        <span class="error">${requestScope.errorpass}</span>
      </div>
    </fieldset>
    <button type="submit" name="btn">ログイン</button>
  </form>
  <div>
    <a href="index.jsp">TOP画面に戻る</a>
  </div>
</body>
</html>
