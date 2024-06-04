
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ElPractice_Servlet03
 */
@WebServlet("/ElPractice_Servlet03")
public class ElPractice_Servlet03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ElPractice_Servlet03() {
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
		response.setContentType("text/html; charset=UTF-8");
		String uruu = request.getParameter("uruu");
		String result;
		int year = Integer.valueOf(uruu);
		
		
		if(year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)){
			 result="入力された年は閏年でした。";
		}else{
			result="入力された年は閏年ではありません。";
		}
		
		request.setAttribute("result", result);
		request.getRequestDispatcher("/elPractice_result03.jsp").forward(request, response);
	}

}
