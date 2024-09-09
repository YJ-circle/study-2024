package controller.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.IController;
import service.ILoginService;
import service.impl.LoginService;
import views.View;

public class LogoutCtrl implements IController{

	@Override
	public View process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		ILoginService svc = new LoginService();
		req.setAttribute("result", svc.logout(userId));
		return new View("/WEB-INF/views/logout_result.jsp");
	}
	

}
