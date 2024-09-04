package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberInfoDto;
import entity.MemberInfoEntity;
import service.MemberSvc;

@WebServlet("/addmile")
public class MemberAddMile extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member_addMile.jsp");
		
		String id = req.getParameter("id");
		String mile = req.getParameter("mile");
		
		if(id.length()==12) {
			resp.setStatus(400);
			req.setAttribute("resultCode", 400);
			req.setAttribute("resultMsg", "입력한 id 길이가 유효하지 않습니다.");
			dispatcher.forward(req, resp);
			return;
		} else if (id.length() == 13) {
			id = id.replace("-", "");
		}
		
		int mileCnt = Integer.parseInt(req.getParameter("mile"));
		
		MemberSvc svc = new MemberSvc();
		ArrayList<MemberInfoDto> beforeMemberList = svc.getMember(id);
		ArrayList<MemberInfoDto> afterMemberList = svc.addMile(id, mileCnt);
		if(afterMemberList != null) {
			req.setAttribute("beforeList", beforeMemberList);
			req.setAttribute("afterList", afterMemberList);
		} else {
			resp.setStatus(400);
			req.setAttribute("resultCode", 400);
			req.setAttribute("resultMsg", "등록되지 않은 아이디 입니다.");
			dispatcher.forward(req, resp);
			return;
		}
		dispatcher.forward(req, resp);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}
