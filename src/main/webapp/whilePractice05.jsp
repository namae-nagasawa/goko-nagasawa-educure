<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String[]param=request.getParameterValues("param");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div> 
<%
int i = 0;
int answer = 0;
int nums = 0;

if (param != null) {
	while (i < param.length) {
		nums = Integer.parseInt(param[i]);
		answer += nums;
		i++;

	}
	out.println("合計金額 " + answer);
}
%>
		<p>購入する商品を選択してください</p>
		<form action="whilePractice05.jsp" method="post">
			<input type="checkbox" name="param" value="120">ニンジン（１２０円）<br>
			<input type="checkbox" name="param" value="198">玉ねぎ（１９８円）<br>
			<input type="checkbox" name="param" value="198">ジャガイモ（１９８円）<br>
			<input type="checkbox" name="param" value="266">豚肉（２６６円）<br>
			<input type="checkbox" name="param" value="189">鶏肉（１８９円）<br>
			<input type="checkbox" name="param" value="398">牛肉（３９８円）<br>
			<input type="checkbox" name="param" value="156">カレールー（１５８円）<br>
			<button type="submit">決定</button>
		</form>
	</div>
</body>
</html>