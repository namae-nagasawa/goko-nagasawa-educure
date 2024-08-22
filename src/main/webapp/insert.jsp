<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
    <p>
        登録情報を入力してください<br> <span class="required"></span>は必須です
    </p>

    <p class="error">${requestScope.errormsg}</p>

    <form action="insert" method="post">
        <fieldset class="label-60">
            <div>
                <label class="required">ID</label> <input type="text" name="loginId">
                <span class="error">${requestScope.erloginid}</span>
            </div>
            <div>
                <label class="required">名前</label> <input type="text" name="userName">
                <span class="error">${requestScope.eruserName}</span>
            </div>
            <div>
                <label class="required">TEL</label> <input type="text" name="tel">
                <span class="error">${requestScope.ertel}</span>
            </div>
            <div>
                <label class="required">権限</label> <select name="roleId">
                    <option value="1">${sessionScope.role[0]}</option>
                    <option value="2" selected>${sessionScope.role[1]}</option>
                </select>
            </div>
            <div>
                <label class="required">PASS</label> <input type="password" name="pass">
                <span class="error">${requestScope.erpass}</span>
            </div>
        </fieldset>
        <button type="submit">確認</button>
    </form>
    <div>
        <a href="menu.jsp">メニューに戻る</a>
    </div>
</body>
</html>
