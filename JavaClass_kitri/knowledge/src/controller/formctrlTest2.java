package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import view.View;
import view.ViewMethod;

@WebServlet("/form")
public class formctrlTest2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		if(session.getAttribute("saved") != null ){
			req.setAttribute("saved","disabled");
			@SuppressWarnings("unchecked")
			Map<String, String> saved = (Map<String, String>)session.getAttribute("saved");
			for(String s : saved.keySet()) {
				req.setAttribute(s, saved.get(s));
			}
		}
		
		new View("/WEB-INF/views/index05.jsp").render(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		if(isRemoveMethod(req)) {
			session.invalidate();
			new View("/servlet0919/form", ViewMethod.REDIRECT).render(req, resp);
			return;
		}
		
		if(isAddMethod(req)) {
			String[] orderItem = req.getParameterValues("items");
			String boxingType = req.getParameter("boxing");
			String name = req.getParameter("name");
			String addr = req.getParameter("addr");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			
			if(isContainNull(orderItem, boxingType, name, addr, phone)) {
				Map<String, String> saved = new HashMap<>();
				
				for(String s : orderItem) {
					saved.put(s, "checked");
				}
				saved.put(boxingType, "checked");
				saved.put("name", name);
				saved.put("addr", addr);
				saved.put("email", email);
				saved.put("phone", phone);
				session.setAttribute("saved", saved);
		}

			
		} 
		
		new View("/servlet0919/form", ViewMethod.REDIRECT).render(req, resp);

		
	}


	private boolean isRemoveMethod(HttpServletRequest req) {
		return req.getParameter("method") != null && req.getParameter("method").equals("remove");
	}


	private boolean isContainNull(String[] orderItem, String boxingType, String name, String addr, String phone) {
		return orderItem != null && boxingType != null & name != null & addr != null & phone != null;
	}


	private boolean isAddMethod(HttpServletRequest req) {
		return req.getParameter("method") != null && req.getParameter("method").equals("add");
	}
	
}
