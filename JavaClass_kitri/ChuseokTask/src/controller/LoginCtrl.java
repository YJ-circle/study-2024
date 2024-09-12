package controller;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import Setting.Database;
import entity.MemberEntity;
import error.login.LoginError;
import view.View;

public class LoginCtrl implements IController{

	@Override
	public View process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("로그인 컨트롤러");
		HttpSession session = req.getSession();
		
		if(invalidMethod(req)) { throw new LoginError("잘못된 접근입니다."); }
		
		System.out.println(session);
		String id = "1234";//req.getParameter("id");
		List<MemberEntity> memberList = null;
		try(Database db = new Database();)
		
			{db.setStatement("SELECT * FROM shopuser WHERE id = ?");
			System.out.println("db 연결");
			 db.sqlAddString(1, id);
			 System.out.println("SQL 완성!");
			 System.out.println();
			List<MemberEntity> mebmberList = db.sqlSelectList(MemberEntity.class);			
			System.out.println(memberList);
			
			}
		
		
		
		
//		
//		
//		try(Database db = new Database();){
//			
//			List<MemberEntity> memberList = db.sqlSelect(MemberEntity.class,"SELECT * FROM shopuser");
//			for(MemberEntity m : memberList) {
//				System.out.println(m.getName());
//			}
//		}
		return new View("/WEB-INF/login.jsp");
	}
	
	private boolean invalidMethod(HttpServletRequest req) {
		return !req.getMethod().equals("GET");
	}
}
