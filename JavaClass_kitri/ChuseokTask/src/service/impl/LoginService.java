package service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Setting.Database;
import entity.MemberEntity;
import error.login.LoginError;
import service.ILoginService;

public class LoginService implements ILoginService {
	private String inputId;
	private String inputPw;
	private MemberEntity member;

	public LoginService(String inputId) {
		super();
		this.inputId = inputId;
	}

	public LoginService(String inputId, String inputPw) {
		super();
		this.inputId = inputId;
		this.inputPw = inputPw;
	}

	public void login(HttpServletRequest req, HttpServletResponse resp) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		try(Database db = new Database()){
			db.setStatement("SELECT * FROM shopuser WHERE id = ?"); //  WHERE id = ?
			System.out.println("db 연결");
			db.sqlAddString(1, inputId);
			System.out.println("SQL 완성!");
			System.out.println();
			List<MemberEntity> memberList = db.sqlSelectListCount(MemberEntity.class, 1);
			
			if(idError(memberList)) {
				throw new LoginError("등록 되지 않은 사용자 입니다.");
			}
			
			member = memberList.get(0);
			
			if(pwError()) {
				throw new LoginError("비밀번호가 틀렸습니다");
			}
			
			HttpSession session = req.getSession();
			session.setAttribute("loginId", inputId);
			
			return;
		}
	}

	private boolean pwError() {
		return !inputPw.equals(member.getPw());
	}

	private boolean idError(List<MemberEntity> memberList) {
		return memberList.size() == 0;
	}
}
