
package com.example;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOEEclass;
import dto.DTOEEclass;

/**
 * Servlet implementation class DBConnection_JavaEE05
 */
@WebServlet("/DBConnection_JavaEE05")
public class DBConnection_JavaEE05 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DBConnection_JavaEE05() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		System.out.println("doPostが呼び出されました"); // Test

		List<DTOEEclass> resultList = new ArrayList<>();
		DAOEEclass dao = new DAOEEclass();

		try {
			String nameParam = request.getParameter("name");
			String idParam = request.getParameter("id");
			String priceParam = request.getParameter("price");

			String btn = request.getParameter("btn1");

			System.out.println("名前パラメータを受け付けました" + nameParam); // test
			System.out.println("idパラメータを受け付けました" + idParam);//test
			System.out.println("priceパラメータを受け付けました" + priceParam);//test

			int price = 0;
			Integer id = null; // 初期値をnullにしないとぬルポ出るからInteger型に
			if (idParam != null && !idParam.isEmpty()) {//idParamが空じゃない場合は。。。
				id = Integer.parseInt(idParam);//idParamをint型に変換
			}

			if (priceParam != null && !priceParam.isEmpty()) {
				price = Integer.parseInt(priceParam);
			}

			System.out.println("idを変換しました" + idParam); // test
			System.out.println("priceを変換しました" + priceParam); // test

			if ("send".equals(btn)) {
				System.out.println("検索ボタンが押されました");
				resultList = dao.selectByCriteria(id, nameParam, price);
				System.out.println("検索の値をセットしました");

				// ParamUtil.isNullOrEmpty(idParam)) {
			} else if ("upins".equals(btn)) {//ボタンの値がupinsが大枠の前提条件で、①②の条件に入る
				if (id == null) {
					// 新規登録処理
					if (nameParam != null && !nameParam.isEmpty() && price > 0) {//idが空の場合は登録
						dao.insertByCriteria(nameParam, price);
						System.out.println("登録の値をセットしました");
					}
				} else {
					// 更新処理　		id!=null が隠れているが上の条件式でid==nullを指定し、それ以外の条件なので書かなくてもよい
					if (nameParam != null && !nameParam.isEmpty() && price > 0) {//idに何かしら入力値があれば更新処理DAOでidチェックしてるからここではこれだけの条件式でいい
						dao.updateByCriteria(id, nameParam, price);
						System.out.println("更新の値をセットしました");
					}

				}

			} else if ("delete".equals(btn)) {
				if (idParam != null && !idParam.isEmpty()) {
					System.out.println("削除ボタンが押されました");
					resultList = dao.deleteByCriteria(id);
					System.out.println("削除の値をセットしました");
				}
			}

			System.out.println("結果行は " + resultList.size()); // Test
		} catch (SQLException e) {
			System.out.println("SQLExceptionが起きました" + e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentExceptionが起きました" + e.getMessage());
			e.printStackTrace();
		}

		request.setAttribute("resultList", resultList);
		request.getRequestDispatcher("/dbconnection_javaee05.jsp").forward(request, response);
	}

}
