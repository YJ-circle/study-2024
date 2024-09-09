package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.impl.LoginCtrl;
import controller.impl.LogoutCtrl;
import controller.impl.ProductCtrl;
import controller.impl.PurchaseCtrl;
import controller.impl.PurchaseListCtrl;
import views.View;

@WebServlet("/shop/*")
public class FrontCtrl extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private Map<String, IController> ctrlMap = new HashMap<>();
	public FrontCtrl() {
		ctrlMap.put("/login", new LoginCtrl());
		ctrlMap.put("/", new LoginCtrl());
		ctrlMap.put("/product", new ProductCtrl());
		ctrlMap.put("/logout", new LogoutCtrl());
		ctrlMap.put("/purchase", new PurchaseCtrl());
		ctrlMap.put("/purchaseList", new PurchaseListCtrl());
		
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String inPath = req.getPathInfo();
		if(inPath == null) {
			inPath = "/"; 
		}
		IController ctrl = ctrlMap.get(inPath);
		if(ctrl != null) {
			View resultView = ctrl.process(req, resp);
			if(resultView!=null) {
				resultView.render(req, resp);
			} else {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				new View("/WEB-INF/views/error.jsp").render(req, resp); 
				return;
			}
			
		} else {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			new View("/WEB-INF/views/error.jsp").render(req, resp); 
			return;
		}
		
	}
}
