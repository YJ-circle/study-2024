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
		RequestDispatcher dispatcher = null;
		System.out.println(session.getAttribute("name"));
		System.out.println(session.getId());
		if(session.getAttribute("name") == null) {
			dispatcher = req.getRequestDispatcher("/views/login.jsp");
		} else {
			req.setAttribute("name", session.getAttribute("name"));
			dispatcher = req.getRequestDispatcher("/views/response.jsp");
		}
		dispatcher.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		if("1234".equals(id)) {
			if("1234".equals(pwd)) {
				HttpSession session = req.getSession();
				session.setAttribute("name", "홍길동");
				dispatcher = req.getRequestDispatcher("/views/response.jsp");
			} else {
				req.setAttribute("text", "비밀번호 틀림");
				dispatcher = req.getRequestDispatcher("/views/login.jsp");
			}
		} else {
			req.setAttribute("text", "등록 되지 않은 사용자");
			dispatcher = req.getRequestDispatcher("/views/login.jsp");
		}
		dispatcher.forward(req, resp);
	}
	

}
