package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import error.AccessViolation;
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
		
		View view = null;
		
		try {
			String rootPath = req.getContextPath();
			req.setAttribute("WEB_ROOT", rootPath);
			req.setAttribute("servlet", req.getServletPath());
			String inPath = req.getPathInfo();
			

			if(inPath == null) {
				resp.sendRedirect(rootPath + req.getServletPath() + "/login");
				return;
			}
			
			IController ctrl = ctrlMap.get(req.getPathInfo());;
			view = ctrl.process(req, resp);
			view.render(req, resp);
		}
		catch (ServletException e) {
			errorHandler(e, req, resp);
			return;
		}
		catch (Exception e) {
			errorHandler(e, req, resp);
			return;
		}
		
		
		

		
	}
	
	private void errorHandler(Exception e, HttpServletRequest req, HttpServletResponse resp) {

		View view = new View("/WEB-INF/views/error.jsp");
		
		if(e instanceof AccessViolation) {
			req.setAttribute("errorMsg", "잘못된 접근입니다.");
		}
		

		if (e instanceof SQLException || e instanceof ServletException) {
			req.setAttribute("errorMsg", "알 수 없는 오류");
		}
		e.printStackTrace(System.out);
		System.out.println("\n\n<========================>\n\n");
		System.out.println("오류 내용: " + e.getClass());
		System.out.println("오류 메시지: "+ e.getMessage());
		
		
		
		
		
		try {
			view.render(req, resp);
		} catch (ServletException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

	
	

}
