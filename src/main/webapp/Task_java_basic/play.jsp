<%@page import="Task_java_basic1.Utility"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//残数の更新処理(残数の取得、更新、保存など) 
// 残数用の変数。仮で25をセットしている。必要に応じて変更

Integer totalNum = (Integer) session.getAttribute("totalNum");
int number = 0;

String num = (String) request.getParameter("num");

if (num == null) {
	totalNum = 25;
} else {
	number = Integer.parseInt(num);

}

totalNum = totalNum - number;

// 残数が0以下の場合、結果ページへ遷移
// (responseオブジェクトのsendRedirectメソッドを使用する)
session.setAttribute("totalNum", totalNum);

if (totalNum <= 0) {

	response.sendRedirect("finish.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java基礎課題</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
	<h1>石取りゲーム</h1>

	<div class="info">
		<h2>






			残り<%=totalNum%>個


		</h2>
		<p class="stone">
			<%
			if (totalNum > 0) {
				String[] a = Utility.getStoneDisplayHtml(totalNum);

				for (int j = 0; j < totalNum; j++) {
					out.println(a[j]);
				}

			}
			%>
		</p>
	</div>
	<div class="info">
		<h2>

			<%
			//プレイヤーの切替処理(プレイヤーの取得、切替、保存など)
			// プレイヤー用の変数。仮で"A"をセットしている。必要に応じて変更

			String player = (String) session.getAttribute("player");

			boolean flg = Utility.change(player);

			if (flg == true) {
				out.println("プレイヤーAの番");
				player = "A";

			} else {
				out.println("プレイヤーBの番");
				player = "B";
			}

			session.setAttribute("player", player);
			%>




		</h2>

		<form action="play.jsp">
			<p>
				石を <input type="number" name="num" min="1" max="3"> 個取る<br>
				※1度に3個取れます。
			</p>
			<button class="btn" type="submit" value="value">決定</button>
		</form>
	</div>
</body>
</html>