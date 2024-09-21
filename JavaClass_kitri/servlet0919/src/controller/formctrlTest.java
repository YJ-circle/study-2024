package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
public class formctrlTest extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("id") == null) {
			req.setAttribute("result", "로그인 후 이용하세요");
			new View("/WEB-INF/views/login.jsp").render(req, resp);
			return;
		}
		
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
		String[] orderItem = req.getParameterValues("items");
		String boxingType = req.getParameter("boxing");
		String name = req.getParameter("name");
		String addr = req.getParameter("addr");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		
		if(orderItem != null && boxingType != null & name != null & addr != null & phone != null) {
			Map<String, String> saved = new HashMap<>();
			
			for(String s : orderItem) {
				saved.put(s, "checked");
			}
			saved.put(boxingType, "checked");
			saved.put("name", name);
			saved.put("addr", addr);
			saved.put("email", email);
			saved.put("phone", phone);
			
			HttpSession session = req.getSession();
			session.setAttribute("saved", saved);
			
		} else {
			
		}
		
		new View("/servlet0919/form", ViewMethod.REDIRECT).render(req, resp);

		
	}
	
}
