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
 * Servlet implementation class DBConnection_JavaEE01
 */
@WebServlet("/DBConnection_JavaEE01")
public class DBConnection_JavaEE01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DBConnection_JavaEE01() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost method called");//test
		List<DTOEEclass> resultList = new ArrayList<>();
		DAOEEclass dao = new DAOEEclass();

		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			
			System.out.println("Received id: " + id);//test
			System.out.println("Received name: " + name);//test
			System.out.println("Received price: " + price);//test

			resultList = dao.selectByCriteria(id, name, price);
			
			System.out.println("ResultList size: " + resultList.size());//test
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException: " + e.getMessage());//test
			// id または price の変換エラー処理
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());//test
			e.printStackTrace();
		}

		request.setAttribute("resultList", resultList);
		request.getRequestDispatcher("/dbconnection_javaee01.jsp").forward(request, response);
		//		int id = Integer.parseInt(request.getParameter("id"));
		//		String name = request.getParameter("name");
		//		int price = Integer.parseInt(request.getParameter("price"));
		//		DAOEEclass dao = new DAOEEclass();
		//
		//		List<DTOEEclass> resultList = null;
		//
		//		try {
		//			if (id == 101 && name.equals("鉛筆") && price == 50) {
		//				resultList = dao.selectOne();
		//			} else if (id == 102 && name.equals("消しゴム") && price == 100) {
		//				resultList = dao.selectTwo();
		//			} else if (id == 103 && name.equals("地球儀") && price == 5000) {
		//				resultList = dao.selectThree();
		//			} else {
		//				// 条件に合致しない場合の処理
		//				resultList = new ArrayList<>(); // 空のリストを返す
		//			}
		//		} catch (SQLException e) {
		//			e.printStackTrace();
		//
		//		}
		//
		//		request.setAttribute("resultList", resultList);
		//		request.getRequestDispatcher("/dbconnection_javaee01.jsp").forward(request, response);

	}

}
