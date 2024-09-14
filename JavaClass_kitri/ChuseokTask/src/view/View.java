package view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class View {
	private String viewPath;
	private ViewMethod method;
	
	public View(String viewPath) {
		this.viewPath = viewPath;
		this.method = ViewMethod.DISPATCHER;
	}
	
	public View(String viewPath, ViewMethod method) {
		this.viewPath = viewPath;
		this.method = method;
	}

	
	public void render(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		if (method == ViewMethod.REDIRECT) {
			resp.sendRedirect(viewPath);
			return;
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
		dispatcher.forward(req, resp);
		
	}
}
