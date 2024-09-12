package controller;


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
	public View process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();
		if(isLogin(session)){
			
		}
		
		System.out.println("로그인 컨트롤러");
		
		String method = req.getMethod();
		
		if(methodError(method)) { throw new AccessViolation("잘못된 접근입니다."); }
		
		if(isGetRequest(method)) {
			System.out.println("GET");
			return new View("/WEB-INF/login.jsp");
		}
		
		if(isPostRequest(method)) {
			System.out.println("POST");
			String inputId = req.getParameter("id");
			String inputPw = req.getParameter("password");
			ILoginService svc = new LoginService(inputId, inputPw);
			try{ svc.login(req, resp);}
			catch(LoginError e) {
				req.setAttribute("loginResult", e.getMessage());
				return new View("/WEB-INF/login.jsp");
			}
			
		}
		return new View("/product");
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
