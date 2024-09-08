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
	private static final long serialVersionUID = 1L;
	private Map<String, Controller> ctrlMap = new HashMap<>();
	public FrontCtrl() {
		ctrlMap.put("/login", new LoginCtrl());
		ctrlMap.put("/", new LoginCtrl());
		ctrlMap.put("/product", new ProductCtrl());
		ctrlMap.put("/logout", new LogoutCtrl());
		ctrlMap.put("/purchase", new PurchaseCtrl());
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String inPath = req.getPathInfo();
		if(inPath == null) {
			inPath = "/"; 
		}
		Controller ctrl = ctrlMap.get(inPath);
		if(ctrl != null) {
			View resultView = ctrl.process(req, resp);
			resultView.render(req, resp);
		} else {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
	}
}
