package service.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Setting.Database;
import dao.Dao;
import dao.IMemberDao;
import dao.impl.MemberDao;
import entity.MemberEntity;
import error.login.LoginError;
import service.ILoginService;
import view.View;

public class LoginService implements ILoginService {
	private String inputId;
	private String inputPassword;
	private MemberEntity memberInfo;
	

	public LoginService() {}
	public LoginService(String id, String pw) {
		super();
		this.inputId = id;
		this.inputPassword = pw;
	}

	public void login(HttpServletRequest req, HttpServletResponse resp) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException{
		
		IMemberDao dao = new MemberDao();
		memberInfo = dao.login(inputId, inputPassword);
		
		if(idErrorCheck()) {
			throw new LoginError("등록 되지 않은 사용자 입니다.");
		}
		
		if(pwErrorCheck()) {
			throw new LoginError("비밀번호가 틀렸습니다");
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("loginId", inputId);
		resp.sendRedirect(req.getAttribute("WEB_ROOT") + "/product");
		return;
	}

	private boolean pwErrorCheck() {
		return !inputPassword.equals(memberInfo.getPw());
	}

	private boolean idErrorCheck() {
		return !memberInfo.isinit();
	}
}
