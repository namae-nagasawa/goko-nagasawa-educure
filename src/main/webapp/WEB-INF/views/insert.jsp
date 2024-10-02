<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
   <p>
		<c:if test="${not empty msg3}">
			<p>${msg3}</p>
		</c:if>
	</p>

    <p class="error">${requestScope.errormsg}</p>

    <form:form action="insert" method="post" modelAttribute="insert">
        <fieldset class="label-60">
            <div>
               <fmt:message key="form.lbl.loginId" /> <input type="text" name="loginId">
                <span class="error">${sessionScope.erloginid}</span>
            </div>
            <div>
               <fmt:message key="form.lbl.name1" /><input type="text" name="userName">
                <span class="error">${sessionScope.eruserName}</span>
            </div>
            <div>
                <fmt:message key="form.lbl.tel1" /> <input type="text" name="tel">
                <span class="error">${sessionScope.ertel}</span>
            </div>
            <div>
               <fmt:message key="form.lbl.grant" /> <select name="roleId">
                    <option value="1">${sessionScope.role[0]}</option>
                    <option value="2" selected>${sessionScope.role[1]}</option>
                </select>
            </div>
            <div>
               <fmt:message key="form.lbl.password" /> <input type="password" name="pass">
                <span class="error">${requestScope.erpass}</span>
            </div>
        </fieldset>
        <button type="submit"><fmt:message key="form.lbl.confirm" /></button>
    </fo
    <div>
    <br>
    <form:form action="menu" modelAttribute="menu">
        <a href="menu"><fmt:message key="form.lbl.menuseni" /></a>
        </form:form>
    </div>
    </form:form>
</body>

</html>
