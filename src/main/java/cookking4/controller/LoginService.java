package cookking4.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cookking4.model.DAO;
import cookking4.model.VO;

// �α��� ����

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String Log_id = request.getParameter("Log_id");
		String pw = request.getParameter("pw");
	
		VO mvo = new VO();
		mvo.setLog_id(Log_id);
		mvo.setPw(pw);

		DAO dao = new DAO();
		VO result = dao.Login(mvo);
		
		String nextpage = null;
		if(result == null) {
			System.out.println("�α��� ����");			
			nextpage = "index.jsp";			
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("mvo", result);
			nextpage = "main.jsp";
		}
		response.sendRedirect(nextpage);	
				
	}

}
