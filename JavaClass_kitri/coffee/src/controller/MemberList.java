package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberInfoDto;
import service.MemberSvc;

@WebServlet("/getMember")
public class MemberList extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		
		MemberSvc svc = new MemberSvc();
		ArrayList<MemberInfoDto> memberList = null;
	
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member_info.jsp");
		
		if(id == null) { memberList = svc.getMember();} 
		else {
			if(id.length()!=11&&id.length()!=13) {
				resp.setStatus(400);
				req.setAttribute("resultCode", 400);
				req.setAttribute("resultMsg", "입력한 id 길이가 유효하지 않습니다.");
				dispatcher.forward(req, resp);
				return;
			} else if (id.length() == 13) {
				id = id.replace("-", "");
			}
			
			memberList = svc.getMember(id);
			if(memberList.size()==0) {
				req.setAttribute("resultCode", 204);
				req.setAttribute("resultMsg", "일치하는 회원이 없습니다");
				dispatcher.forward(req, resp);
				return;
			}
			
		}
		req.setAttribute("resultCode", 200);
		req.setAttribute("list", memberList);
		dispatcher.forward(req, resp);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}
