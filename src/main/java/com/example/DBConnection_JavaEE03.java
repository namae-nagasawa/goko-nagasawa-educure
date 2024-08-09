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
 * Servlet implementation class DBConnection_JavaEE03
 */
@WebServlet("/DBConnection_JavaEE03")
public class DBConnection_JavaEE03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DBConnection_JavaEE03() {
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
				if (idParam != null) {
					System.out.println("検索ボタンが押されました");
					resultList = dao.selectByCriteria(id, nameParam, price);
					System.out.println("検索の値をセットしました");
				}//OK!
			}
			if ("register".equals(btn)) {
				if (idParam.equals("") && nameParam != null && priceParam != null) {
					System.out.println("登録ボタンが押されました");
					resultList = dao.insertByCriteria(nameParam, price);
					System.out.println("登録の値をセットしました");
				}//OK!!
			}

			 if ("update".equals(btn)) {
				if (idParam != null) {
					System.out.println("更新ボタンが押されました");
					resultList = dao.updateByCriteria(id, nameParam, price);
					System.out.println("更新の値をセットしました");
					//OK!!
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
		request.getRequestDispatcher("/dbconnection_javaee03.jsp").forward(request, response);
	}

}
