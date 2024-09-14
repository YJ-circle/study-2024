package controller;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDto;
import error.AccessViolation;
import error.login.LoginError;
import service.ILoginService;
import service.impl.LoginService;
import view.View;
import view.ViewMethod;

public class LoginCtrl implements IController{

	@Override
	public View process(HttpServletRequest req, HttpServletResponse resp) throws Exception, IOException{
		HttpSession session = req.getSession();

		System.out.println("로그인 컨트롤러");
		
		String method = req.getMethod();
		
		
		if(isGetRequest(method)) {
			if(isLogin(session)){
				return new View (req.getAttribute("servlet") + "/product", ViewMethod.REDIRECT);
			}
			return loginPage(); }
		
		if(isPostRequest(method)) {
			String inputId = req.getParameter("id");
			String inputPw = req.getParameter("password");
			
			MemberDto memberDto = null;
			ILoginService svc = new LoginService(inputId, inputPw);
			try{ memberDto = svc.login(req, resp);}
			catch(LoginError e) {
				req.setAttribute("loginResult", e.getMessage());
				return loginPage();
			}
			
			session.setAttribute("userId", inputId);
			session.setAttribute("userName", memberDto.getName());
			return new View (req.getAttribute("servlet") + "/product", ViewMethod.REDIRECT);
		}
		throw new AccessViolation("잘못된 접근입니다.");
		
	}

	private View loginPage() {
		return new View("/WEB-INF/views/login_inpage.jsp");
	}

	private boolean isLogin(HttpSession session) {
		return session.getAttribute("userId") != null;
	}

	private boolean isPostRequest(String method) {
		return method.equals("POST");
	}

	private boolean isGetRequest(String method) {
		return method.equals("GET");
	}
}
