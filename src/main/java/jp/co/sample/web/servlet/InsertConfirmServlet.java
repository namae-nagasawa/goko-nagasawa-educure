package jp.co.sample.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.dao1Class;

/**
 * Servlet implementation class InsertConfirmServlet
 */
@WebServlet({"/InsertConfirmServlet","/insertConfirm"})
public class InsertConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertConfirmServlet() {
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
		String loginId = request.getParameter("loginId");
		String userName = request.getParameter("userName");
		String tel = request.getParameter("tel");
		String roleName = request.getParameter("roleName"); // ここで文字列として受け取る
		String rePass = request.getParameter("rePass");

		HttpSession session = request.getSession();
		
//		String roleId2=(String) session.getAttribute("role_id");
//		
//		System.out.println("取得しました"+roleId2);

		dao1Class dao = new dao1Class();

		boolean hasError = false;

		// セッションからデータを取得
		String pass = (String) session.getAttribute("pass");

		try {
			if (rePass == null || !rePass.equals(pass)) {
				String errorPass = "前画面で入力したパスワードと一致しません";
				System.out.println(errorPass + "と入れました");

				session.setAttribute("errorPass", errorPass);
			} else {
				System.out.println("パスワードが一致しました");
				int roleId;
				if ("管理者".equals(roleName)) {
					roleId = 1; // "管理者"の場合は 1 
				} else {
					roleId = 2; // "一般"の場合は 2 
				}
				dao.insert(loginId, userName, tel, roleId, rePass);
				hasError = true;
			}

			if (hasError) {
				request.getRequestDispatcher("insertResult.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("insertConfirm.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
