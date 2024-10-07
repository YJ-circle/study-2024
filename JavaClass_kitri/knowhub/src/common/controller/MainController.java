package common.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import member.controller.LoginCtrl;
import member.service.MemberSvcImpl;

@WebServlet("/*")
public class MainController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static Map<String, Controller> ctrlMap = new HashMap<>();
	
	MainController(){
		ctrlMap.put("/login", new LoginCtrl(new MemberSvcImpl()));
		
	}
	
}
