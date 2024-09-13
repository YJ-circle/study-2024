package controller;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import error.AccessViolation;
import error.login.LoginError;
import service.ILoginService;
import service.impl.LoginService;
import view.View;

public class LoginCtrl implements IController{

	@Override
	public View process(HttpServletRequest req, HttpServletResponse resp) throws Exception, IOException{
		HttpSession session = req.getSession();
		if(isLogin(session)){
			
		}
		
		System.out.println("로그인 컨트롤러");
		
		String method = req.getMethod();
		
		
		if(isGetRequest(method)) {
			System.out.println("GET");
			return loginPage(); }
		
		if(isPostRequest(method)) {
			System.out.println("POST");
			String inputId = req.getParameter("id");
			String inputPw = req.getParameter("password");
			ILoginService svc = new LoginService(inputId, inputPw);
			try{ svc.login(req, resp);
				 return null;}
			catch(LoginError e) {
				req.setAttribute("loginResult", e.getMessage());
				return loginPage();
			}
			
		}
		throw new AccessViolation("잘못된 접근입니다.");
		
	}

	private View loginPage() {
		return new View("/WEB-INF/views/login.jsp");
	}

	private boolean isLogin(HttpSession session) {
		return session.getAttribute("loginId") != null;
	}

	private boolean isPostRequest(String method) {
		return method.equals("POST");
	}

	private boolean isGetRequest(String method) {
		return method.equals("GET");
	}
	
	private boolean methodError(String method) {
		return !(isGetRequest(method)||method.equals("POST"));
	}
}
