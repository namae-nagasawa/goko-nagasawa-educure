package jp.co.sample.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
				if (passInt == 1234) {

					PetSessionInfo petsessioninfo = new PetSessionInfo();

					HttpSession session = request.getSession();
					session.setAttribute("petsessioninfo", petsessioninfo);
					
			session.getAttribute(petList.get(1);
//
//					HashMap<String, Pet> petList = PetSessionInfo.getPetList();
//					Dog dog = (Dog) petList.get("dog");
//
//					Cat cat = (Cat) petList.get("cat");
//
//					PetSessionInfo.getPetList().put("dog", dog);
//					PetSessionInfo.getPetList().put("cat", cat);
//					session.setAttribute("dog", dog);
//					session.setAttribute("cat", cat);
//
//					//session.setAttribute("dog", petsessioninfo);
//					//session.setAttribute("cat", petsessioninfo);
//
//					//request.setAttribute("dog",petsessioninfo);
//					//request.setAttribute("cat",petsessioninfo);

					request.getRequestDispatcher("petList.jsp").forward(request, response);

				} else {
					error = "暗証番号が違います";

					request.setAttribute("error", error);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			} catch (NumberFormatException e) {
				error = "数値を入力してください";

				request.setAttribute("error", error);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		request.setAttribute("error", error);

		//request.setAttribute("error", error);

		//		String error="暗証番号を入力してください";
		//		
		//		
		//		
		//		 Pattern pattern = Pattern.compile("1234");
		//	        Matcher matcher = pattern.matcher(pass);
		//		
		//	        try {
		//	        	Integer.parseInt(pass);
		//	        }catch(NumberFormatException e) {
		//	        	error="暗証番号は数値でなければならないです";
		//	        	request.setAttribute(error, "暗証番号は数値でなければならないです");
		//	        	response.sendRedirect("index.jsp");
		//	        }
		//		
		//		if(matcher.find()) {
		//			response.sendRedirect("petList.jsp");
		//			
		//		}else {
		//			error = "暗証番号が違います";
		//			request.setAttribute(error, "暗証番号が違います");
		//			response.sendRedirect("index.jsp");
		//		}

		//if (error != null || !error.isEmpty()) {

		//try {
		//int passInt = Integer.parseInt(pass);
		//if (bol==true){
		//		response.sendRedirect("petList.jsp");
		//	} else {
		//	error = "暗証番号が違います";
		//					response.sendRedirect("index.jsp");
		//				}
		//			} catch (NumberFormatException e) {
		//				error = "数値を入力してください";
		//				response.sendRedirect("index.jsp");
		//			}
		//		}

		//request.setAttribute("pass", pass);

		//Integer id2 =Integer.parseInt("id");

		//	if(id2==null) {
		//	boolean isValidated =true;
		//	String error="暗証番号には数値を入力してください";

		//	if(id2!=1234) {
		//	isValidated=false;
		//	error="暗証番号が違います";
		//}

		response.setContentType("text/html; charset=UTF-8");
	}
}
