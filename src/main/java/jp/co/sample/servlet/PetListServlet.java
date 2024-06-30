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
 * Servlet implementation class PetListServlet
 */
@WebServlet("/PetListServlet")

public class PetListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PetListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String btn = request.getParameter("btn");
		String btn1 = request.getParameter("btn1");

		request.setAttribute("btn", btn);
		request.setAttribute("btn1", btn1);

		PetSessionInfo petsessioninfo = new PetSessionInfo();

		HttpSession session = request.getSession();
		session.setAttribute("petsessioninfo", petsessioninfo);
		Dog dog = (Dog) PetSessionInfo.getPetList().get("dog");
		Cat cat = (Cat) PetSessionInfo.getPetList().get("cat");

		if (dog != null) {
			session.setAttribute("dogAge", dog.getAge());
			session.setAttribute("dogHeight", dog.getHeight());
			session.setAttribute("dogWeight", dog.getWeight());
			session.setAttribute("dogWalkingPlace", dog.getWalkingPlace());
			session.setAttribute("dogType", dog.getType());
		}
		if (cat != null) {
			session.setAttribute("catAge", cat.getAge());
			session.setAttribute("catHeight", cat.getHeight());
			session.setAttribute("catWeight", cat.getWeight());
			session.setAttribute("catFavoriteItem", cat.getFavoriteItem());
			session.setAttribute("catType", cat.getType());

			request.setAttribute("dog", dog);
			request.setAttribute("cat", cat);
			request.getRequestDispatcher("petInfo.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//		// TODO Auto-generated method stub

		//
		

	}
}

//}
