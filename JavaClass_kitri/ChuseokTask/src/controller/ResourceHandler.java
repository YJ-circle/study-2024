package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import view.View;


@WebServlet("/assert/*")
public class ResourceHandler extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("assert 서블릿");
		req.setAttribute("WEB_ROOT", req.getContextPath());
		String path = req.getPathInfo();
		String page = "";
		System.out.println(path);
		String referer = req.getHeader("Referer");
		System.out.println(referer);
		View view = null;
		
		if (referer == null) {
			 page = "/WEB-INF/views/error.jsp";
		}
		
		else if (path.contains("404.css")) {
			resp.setContentType("text/css");
			page = "/WEB-INF/views"+ path;
		}
		
		else if(referer.contains("/chu/web")) {
			System.out.println("refer통과");
			page = "/WEB-INF/views"+ path;
			
		}
		
		else {
			resp.setContentType("text/html");
			page = "/WEB-INF/views/error.jsp";
		}
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(page);
		dispatcher.forward(req, resp);
		

	}

	private View printAssert(String path) {
		View view;
		view = new View("/WEB-INF/views"+ path);
		return view;
	}

	private View errorPage(HttpServletRequest req) {
		View view;
		req.setAttribute("errorMsg", "잘못된 접근입니다.");
		view = new View("/WEB-INF/views/error.jsp");
		return view;
	}



}
