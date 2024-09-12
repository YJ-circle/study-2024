package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import error.login.LoginError;
import view.View;


@WebServlet("/web/*")
public class MainController extends HttpServlet{
	private static final long serialVersionUID = 1L; 
	private Map<String, IController> ctrlMap = new HashMap<>();
	
	public MainController(){
		ctrlMap.put("/login", new LoginCtrl());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		
		
		try {
			View view = null;
			System.out.println("hello Srvlet");
			String rootPath = req.getContextPath() + req.getServletPath();
			String inPath = req.getPathInfo();
			System.out.println("root = " + rootPath);

			if(inPath == null) {
				resp.sendRedirect(rootPath + "/login");
				return;
			}
			
			IController ctrl = ctrlMap.get(req.getPathInfo());
			view = ctrl.process(req, resp);
			view.render(req, resp);
			
		}
		catch (LoginError e) {
			System.out.println("로그인 오류!");
		}
		
		catch (Exception e) {
			System.out.println("죄송합니다. 서비스에 오류가 발생했어요 빨리 해결할게요");
			e.printStackTrace(System.out);
			return;
		}

		
	}

	
	

}
