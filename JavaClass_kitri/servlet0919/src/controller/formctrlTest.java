package controller;

import java.io.IOException;

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
		String[] checkedItem = (String[])session.getAttribute("checkedItems");
		if( checkedItem != null) {
			for(String s : checkedItem) {
				System.out.println(s);
				switch(s) {
				case "p3":
					req.setAttribute("checkTypeP3", "checked");
					break;
				case "p5":
					req.setAttribute("checkTypeP5", "checked");
					break;
				case "h3":
					req.setAttribute("checkTypeH3", "checked");
					break;
				case "h5":
					req.setAttribute("checkTypeH5", "checked");
					break;
				}
			}
			
		}
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		new View("/WEB-INF/views/index05.jsp").render(req, resp);
		
	}
	
	@Override
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] checkitems = req.getParameterValues("items");
		
		HttpSession session = req.getSession();
		session.setAttribute("checkedItems", checkitems);
		new View("/servlet0919/form", ViewMethod.REDIRECT).render(req, resp);
		SaveForm saveform = new SaveForm();
		
	}
	
	private class SaveForm{
		private boolean p3;
		private boolean p4;
		private boolean h3;
		private boolean h5;
		private int select;
		private String name;
		private String addr;
		private String email;
		private String phone;
		public boolean isP3() {
			return p3;
		}
		public void setP3(boolean p3) {
			this.p3 = p3;
		}
		public boolean isP4() {
			return p4;
		}
		public void setP4(boolean p4) {
			this.p4 = p4;
		}
		public boolean isH3() {
			return h3;
		}
		public void setH3(boolean h3) {
			this.h3 = h3;
		}
		public boolean isH5() {
			return h5;
		}
		public void setH5(boolean h5) {
			this.h5 = h5;
		}
		public int getSelect() {
			return select;
		}
		public void setSelect(int select) {
			this.select = select;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddr() {
			return addr;
		}
		public void setAddr(String addr) {
			this.addr = addr;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		
		
	}
	
	
}
