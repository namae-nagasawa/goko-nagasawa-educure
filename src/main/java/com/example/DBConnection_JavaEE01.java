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

		//		int id = 0; //初期化しないと下のsetの際にエラーが出るから0を入れた（初期化）　不安要素としてはここで初期化をしてしまうと入力値が変わってしまうのではないかと思った。
		//		int price = 0;//でも実際に受け取ったパラメータはidparamなので生成した変数idやpriceを初期化してもそこの変数に入力したときに受け取るパラメータを型変換して渡すから影響しない？
		//
		//		if (idparam != null && !idparam.trim().isEmpty()) {
		//			try {
		//				id = Integer.parseInt(idparam);
		//			} catch (NumberFormatException e) { //作った意図　nullが入って状態だと空文字をInteger.parseIntしようとするとNumberFormatExceptionとエラーが出たのでnullが入ってないときに変換しようと思って作成
		//				e.printStackTrace();
		//			}
		//		}
		//
		//		if (priceparam != null && priceparam.trim().isEmpty()) {
		//			try {
		//				price = Integer.parseInt(priceparam);
		//			} catch (NumberFormatException e) {
		//				e.printStackTrace();
		//			}
		//		}
		//
		//		List<DTOEEclass> resultList = new ArrayList<>();
		//		Connection con = null;
		//
		//		DTOEEclass dtoe = new DTOEEclass();
		//		dtoe.setProductId(id); //jspで入力した値の代入
		//		dtoe.setProductName(name); //jspで入力した値の代入
		//		dtoe.setProductPrice(price);//jspで入力した値の代入
		//
		//		try {
		//			Class.forName("org.postgresql.Driver");
		//
		//			con = DriverManager.getConnection("jdbc:postgresql:dbconnection", "hogeuser", "hoge");
		//
		//			String sql = "SELECT * FROM products WHERE 1=1";//常に真のため、プレースホルダーを追加する際に機能する
		//
		//			if (dtoe.getProductId() != 0) {//productオブジェクトの値に基づいて追加されるため検索が可能なようになってる
		//				sql += " AND id = ?";
		//
		//			} else if (dtoe.getProductName() != null && dtoe.getProductName().trim().isEmpty()) {
		//				sql += " AND name =?";
		//
		//			} else if (dtoe.getProductPrice() != 0) {
		//				sql += " AND price = ?";
		//
		//			}
		//
		//			//プレースホルダーありのSQLをもとにそのSQLのためにprepareStatementの作成
		//			PreparedStatement statement = con.prepareStatement(sql);
		//
		//			if (dtoe.getProductId() != 0) {
		//				statement.setInt(1, dtoe.getProductId());
		//			} else if (dtoe.getProductName() != null) {
		//				statement.setString(2, dtoe.getProductName());
		//			} else if (dtoe.getProductPrice() != 0) {
		//				statement.setInt(3, dtoe.getProductPrice());
		//			}
		//
		//			ResultSet rs = statement.executeQuery();
		//
		//			while (rs.next()) {//セットした結果セットし、rs.next()は結果セットに次の行が存在する限りtrueを返すのでデータを取得できる
		//				DTOEEclass dto = new DTOEEclass();
		//				dto.setProductId(rs.getInt("id"));
		//				dto.setProductName(rs.getString("name"));
		//				dto.setProductPrice(rs.getInt("price"));
		//				resultList.add(dto);
		//				System.out.println("データを取得しました");
		//
		//			}
		//
		//			statement.close();
		//			con.close();
		//
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//		}
		request.setAttribute("resultList", resultList);
		request.getRequestDispatcher("dbconnection_javaee01.jsp").forward(request, response);

	}

}
