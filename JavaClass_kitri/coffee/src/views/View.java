package views;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class View {
	String viewPath;
	

	public View(String viewPath) {
		this.viewPath = viewPath;
	}


	public void render(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispat = req.getRequestDispatcher(viewPath);
		dispat.forward(req, resp);
	}
	
}
