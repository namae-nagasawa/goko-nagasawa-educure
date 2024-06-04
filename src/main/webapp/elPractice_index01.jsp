<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>入力画面</title>
</head>
<body>
	<div>
		<form action="ElPractice_Servlet01" method="post">
			<div>生まれた年を西暦で表してください。</div>
			<input type="text" name="year">
			<div>
				<button type="submit">決定</button>
			</div>
		</form>
	</div>
</body>
</html>