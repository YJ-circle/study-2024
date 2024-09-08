package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ILoginService;
import service.impl.LoginService;
import views.View;

public class ProductCtrl implements Controller{

	@Override
	public View process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//로그인 체크
		ILoginService loginSvc = new LoginService();
		
		return null;
	}

}
