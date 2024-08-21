package jp.co.sample.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dao1Class;
import dto.dto1Class;

/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	// サーブレットでの修正点（SelectServlet.java）
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 response.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html; charset=UTF-8");

	        String userName = request.getParameter("userName");
	        String telephone = request.getParameter("tel");
	        dao1Class dao = new dao1Class();

	        List<dto1Class> resultList = null;
	        String senigamen = "select.jsp";//コミットした後にフォワードができないので
	      

	        try {
	            if ((userName== null||userName.isEmpty()) && (telephone==null||telephone.isEmpty())) {
	            	
	                resultList = dao.selectAll();
	                
	            } else if (telephone == null ||telephone.isEmpty()){
	            	
	                resultList = dao.selectName(userName);
	                
	            } else if (userName==null||userName.isEmpty()) {
	            	
	                resultList = dao.selectTel(telephone);
	                
	            } else {

	                resultList = dao.selectByNameAndTel(userName, telephone);
	            }

	            
	            //ここで一旦条件式を区切るイメージーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
	            
	            //上のコードはresultListにデータがあるない場合の判断をする条件式で
	            //下のコードはそのデータがあるないに基づいて遷移画面を決める条件処理
	            //だからいったんelse文を使って分離させている
	            
	            
	            if (resultList != null && !resultList.isEmpty()) {
	            	
	            	
	                //resultListに何らかのデータがある場合はselectResult.jspに遷移
	                
	            	
	            	request.setAttribute("resultList", resultList);
	                senigamen = "selectResult.jsp";
	               
	            } else {
	            	
	            	
	                //resultListにデータがない場合はselect.jspに遷移
	            	
	            	
	                String errormsg = "入力されたデータはありませんでした";
	                request.setAttribute("errormsg", errormsg);
	                senigamen = "select.jsp";
	               
	            }

	            request.getRequestDispatcher(senigamen).forward(request, response);

	        } catch (Exception e) {
	            e.printStackTrace();
	           
	        }
	    }

	    /**
	     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	     */
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	 
	    }
	}