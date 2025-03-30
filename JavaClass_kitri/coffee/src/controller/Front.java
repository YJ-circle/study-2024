package controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import views.View;

@WebServlet("/front/*")
public class Front extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Ctrl> ctrlMap = new HashMap<>();
	public Front() {
		ctrlMap.put("/1", new MemberList2());
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		System.out.println(ctrlMap.size());
		Ctrl ctrl = ctrlMap.get(req.getPathInfo());
		if(ctrl == null) { resp.setStatus(404); return; }
		else { ctrl.process(req, resp);}
		
		
		
		
		
	}
	

}
