package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import views.View;

@WebServlet("/shop/*")
public class FrontCtrl extends HttpServlet{
	private Map<String, Controller> ctrlMap = new HashMap<>();
	public FrontCtrl() {
		ctrlMap.put("/login", new LoginCtrl());
		ctrlMap.put("/", new LoginCtrl());
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getPathInfo());
		System.out.println(req.getMethod());
		Controller ctrl = ctrlMap.get(req.getPathInfo());
		if(ctrl != null) {
			View resultView = ctrl.process(req, resp);
			resultView.render(req, resp);
		} else {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
	}
}
