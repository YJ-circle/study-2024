package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService;
import view.View;
import view.ViewMethod;

@WebServlet("/login")
public class LoginCtrl extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("id") != null) {
			new View("./product", ViewMethod.REDIRECT).render(req, resp);
			return;
		}
		
		new View("/WEB-INF/views/login.jsp").render(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			if(tryLogin(req, resp)) {
				new View("./product", ViewMethod.REDIRECT).render(req, resp);
				return;
			}
		} catch (Exception	e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new View("/WEB-INF/views/login.jsp").render(req, resp);
		
		
	}

	private boolean tryLogin(HttpServletRequest req, HttpServletResponse resp) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		return new LoginService().login(req, resp);
	}
	
	
}
