package jp.co.axiz;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AccsessModifiers02
 */
@WebServlet("/AccsessModifiers02")
public class AccsessModifiers02 extends HttpServlet {

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	//	public AccsessModifiers02() {
	//	super();
	// TODO Auto-generated constructor stub
	//}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		{

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		{

		}

	}
}

//まずパッケージの宣言がされていない点と、dogetメソッドとdopostメソッドの特徴からして外部からのデータに関与する（データの受け渡し）ため
//アクセス修飾子がprivateになっていると一切の変更ができないとなってしまうため、そこをprotectedにしてあげる（データを受け取れる状態）ことでエラーを消すことができた
//つまり、doget.dopostメソッドのアクセス修飾子をprivateしてしまうと継承することができなくなってしまい、それを防ぐためにjavaの可視性を重視した結果protectedが適切である。