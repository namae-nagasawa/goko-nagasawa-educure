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

@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public InsertServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String loginId = request.getParameter("loginId");
        String userName = request.getParameter("userName");
        String tel = request.getParameter("tel");
        String pass = request.getParameter("pass");
        String roleId = request.getParameter("roleId");

        String erloginid = "";
        String eruserName = "";
        String ertel = "";
        String erpass = "";
        String errormsg = "";

        HttpSession session = request.getSession();

        dao1Class dao = new dao1Class();

        boolean hasError = false;
        try {
            List<dto1Class> resultList = dao.selectId(loginId);
            
            if (roleId.equals("1")) {
                roleId = "管理者";
            } else {
                roleId = "一般";
            }
            
            if (loginId == null || loginId.trim().isEmpty()) {
                erloginid = "IDは必須です";
                hasError = true;
            }
            if (userName == null || userName.trim().isEmpty()) {
                eruserName = "名前は必須です";
                hasError = true;
            }
            if (tel == null || tel.trim().isEmpty()) {
                ertel = "TELは必須です";
                hasError = true;
            }
            if (pass == null || pass.trim().isEmpty()) {
                erpass = "PASSは必須です";
                hasError = true;
            }

            if (hasError) {
                request.setAttribute("erloginid", erloginid);
                request.setAttribute("eruserName", eruserName);
                request.setAttribute("ertel", ertel);
                request.setAttribute("erpass", erpass);
                request.setAttribute("errormsg", errormsg);
                request.getRequestDispatcher("insert.jsp").forward(request, response);
            } else if (resultList.isEmpty()) {
                session.setAttribute("loginId", loginId);
                session.setAttribute("userName", userName);
                session.setAttribute("tel", tel);
                session.setAttribute("pass", pass);
                session.setAttribute("role_id", roleId);
                
                request.getRequestDispatcher("insertConfirm.jsp").forward(request, response);
            } else {
                errormsg = "IDが重複しています";
                
                request.setAttribute("errormsg", errormsg);
                request.getRequestDispatcher("insert.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
