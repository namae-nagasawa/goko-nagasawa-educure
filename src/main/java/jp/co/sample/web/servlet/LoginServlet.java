package jp.co.sample.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.dao1Class;
import dto.dto1Class;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({"/LoginServlet","/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		response.setContentType("text/html; charset=UTF-8");

		String login = request.getParameter("loginId");
		String pass = request.getParameter("pass");

		String errorpass = "";
		String errorid = "";
		String erroridpass = "";

		try {

			dao1Class dao = new dao1Class();

			List<dto1Class> resultList = dao.login(login, pass);
		
			if (!resultList.isEmpty()) {//resultListの中身が空じゃないかつ、user_infoに一致するレコードがある場合

				dto1Class dto = resultList.get(0);

				HttpSession session = request.getSession();

				String userName = dto.getUserName();
				int role_id=dto.getRoleId();

				session.setAttribute("role_id", role_id);
				session.setAttribute("loginName", userName);
				session.setAttribute("role", dao.role());


				System.out.println("セッションスコープに値を保存しました");

				request.getRequestDispatcher("menu.jsp").forward(request, response);

			} else if ((login == null || login.trim().isEmpty()) && (pass == null || pass.trim().isEmpty())) {
				errorid = "IDは必須です";
				errorpass = "passは必須です";
				request.setAttribute("errorid", errorid);
				request.setAttribute("errorpass", errorpass);

				request.getRequestDispatcher("login.jsp").forward(request, response);
			}

			else if (login == null || login.trim().isEmpty()) {
				errorid = "IDは必須です";
				request.setAttribute("errorid", errorid);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}

			else if (pass == null || pass.trim().isEmpty()) {
				errorpass = "passは必須です";
				request.setAttribute("errorpass", errorpass);
				request.getRequestDispatcher("login.jsp").forward(request, response);

			} else if (resultList.isEmpty()) {//user_infpのレコードに一致するデータがない場合
				erroridpass = "IDまたはPASSに誤りがあります";
				request.setAttribute("erroridpass", erroridpass);
				System.out.println("idとpasserrorを出力します");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
