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

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		DAOEEclass dao = new DAOEEclass();

		List<DTOEEclass> resultList = null;

		try {
			if (id == 101 && name.equals("鉛筆") && price == 50) {
				resultList = dao.selectOne();
			} else if (id == 102 && name.equals("消しゴム") && price == 100) {
				resultList = dao.selectTwo();
			} else if (id == 103 && name.equals("地球儀") && price == 5000) {
				resultList = dao.selectThree();
			} else {
		        // 条件に合致しない場合の処理
		        resultList = new ArrayList<>(); // 空のリストを返すなど
		    }
		} catch (SQLException e) {
			e.printStackTrace();
			 System.err.println("SQLState: " + e.getSQLState());  // SQLStateを出力
			    System.err.println("Error Code: " + e.getErrorCode());  // エラーコードを出力
			    System.err.println("Message: " + e.getMessage());  // エラーメッセージを出力
			
		}

		request.setAttribute("resultList", resultList);
		request.getRequestDispatcher("/dbconnection_javaee01.jsp").forward(request, response);

	}

}
