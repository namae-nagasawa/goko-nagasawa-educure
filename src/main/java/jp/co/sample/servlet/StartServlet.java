package jp.co.sample.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sample.pet.Cat;
import jp.co.sample.pet.Dog;

/**
 * Servlet implementation class StartServlet
 */
@WebServlet("/StartServlet")
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public StartServlet() {
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
		String pass = request.getParameter("pass");
		String error = request.getParameter("error");

		if (pass == null || pass.isEmpty()) {
			error = "暗証番号を入力してください";
			request.setAttribute("error", error);
			request.getRequestDispatcher("index.jsp").forward(request, response);

		} else {
			try {
				int passInt = Integer.parseInt(pass);
				if (passInt != 1234) {
					error = "暗証番号が違います";

					request.setAttribute("error", error);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				if (passInt == 1234) {

					PetSessionInfo petsessioninfo = new PetSessionInfo();

					HttpSession session = request.getSession();
					session.setAttribute("petsessioninfo", petsessioninfo);

					Dog dog = (Dog) PetSessionInfo.getPetList().get("dog");
					Cat cat = (Cat) PetSessionInfo.getPetList().get("cat");

					if (dog != null) {
						session.setAttribute("dogName", dog.getName());
					}
					if (cat != null) {
						session.setAttribute("catName", cat.getName());

						request.getRequestDispatcher("petList.jsp").forward(request, response);

					}
				}
			} catch (NumberFormatException e) {
				error = "数値を入力してください";

				request.setAttribute("error", error);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}

		response.setContentType("text/html; charset=UTF-8");

	}
}
