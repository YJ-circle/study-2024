package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import common.controller.Controller;
import common.view.View;
import member.service.MemberSvc;
public class LoginCtrl implements Controller{
	private MemberSvc memberSvc;
	
	public LoginCtrl(MemberSvc memberSvc) {
			this.memberSvc = memberSvc;
	}
		
	@Override
	public View process(HttpServletRequest req, HttpServletResponse resp) {
		memberSvc.login("id", "password");
		return null;
	}

}
