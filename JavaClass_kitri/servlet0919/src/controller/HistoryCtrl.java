package controller;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.HistoryService;
import view.View;
import view.ViewMethod;

@WebServlet("/click")
public class HistoryCtrl extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("id") == null) {
			req.setAttribute("result", "로그인 후 이용하세요");
			new View("/WEB-INF/views/login.jsp").render(req, resp);
			return;
		}

		HistoryService svc = new HistoryService();
		try {
			svc.add(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		new View("./product", ViewMethod.REDIRECT).render(req, resp);
		
	}


}
