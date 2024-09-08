package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.UserEntity;
import service.ILoginService;
import service.impl.LoginService;
import views.View;

public class LoginCtrl implements Controller {

	@Override
	public View process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ILoginService svc = new LoginService();
		
		//로그인 상태 체크
		if(svc.isLoginStatus()) {
			return new View("/WEB-INF/views/login_result.jsp");
		}
		
		if(req.getMethod().equals("GET")) {
			//로그인 페이지
			return new View("/WEB-INF/views/login.jsp");
		} else if(req.getMethod().equals("POST")){
			String id = req.getParameter("id");
			String password = req.getParameter("password");
			
			
			int result = svc.login(id, password); // 0: 성공, 1: 비밀번호 틀림, 2: 아이디 없거나 SQL오류
			if(result == 0) {		
				return new View("/WEB-INF/views/login_result.jsp"); 
			} else if (result == 1) {
				req.setAttribute("message", "비밀번호가 틀립니다.");
			} else {
				req.setAttribute("message", "등록되지 않은 사용자입니다."); 
			}
			return new View("/WEB-INF/views/login_result_fail.jsp");
		} else {
			req.setAttribute("errCode", HttpServletResponse.SC_BAD_REQUEST);
		}
		return new View("/WEB-INF/views/error.jsp");
		
	}
	
}
