import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessiontest")
public class Session extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(isLogin(session)) {
			mainPage(req, resp);
		} else {
			loginPage(req, resp);			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		if("1234".equals(id)) {
			if("1234".equals(pwd)) {
				HttpSession session = req.getSession();
				session.setAttribute("name", "홍길동");
				mainPage(req, resp);
			} else {
				req.setAttribute("text", "비밀번호 틀림");
				loginPage(req, resp);
			}
		} else {
			req.setAttribute("text", "등록 되지 않은 사용자");
			loginPage(req, resp);
		}
	}
	
	private void loginPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/login.jsp");
		dispatcher.forward(req, resp);
		
	}
	private void mainPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/response.jsp");
		HttpSession session = req.getSession();
		req.setAttribute("name", session.getAttribute("name"));
		dispatcher.forward(req, resp);
		
	}
	
	private boolean isLogin(HttpSession session) {
		return session.getAttribute("name") != null;
	}
	

}
