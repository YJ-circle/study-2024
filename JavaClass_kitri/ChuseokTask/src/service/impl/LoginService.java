package service.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ICartDao;
import dao.impl.CartDao;
import dao.impl.MemberDao;
import dto.IMemberDto;
import dto.impl.MemberDto;
import entity.CartEntity;
import entity.MemberEntity;
import error.login.LoginError;
import service.ILoginService;

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

	public IMemberDto login(HttpServletRequest req, HttpServletResponse resp) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException{
		String sessionId = (String) req.getAttribute("sessionId");
		memberInfo = new MemberDao().getMemberInfoById(inputId);
		if(idErrorCheck()) {
			throw new LoginError("등록 되지 않은 사용자 입니다.");
		}
		
		if(pwErrorCheck()) {
			throw new LoginError("비밀번호가 틀렸습니다");
		}
		
		IMemberDto dto = new MemberDto();
		dto.setDto(memberInfo);
		
		return dto;
	}

	private boolean pwErrorCheck() {
		return !inputPassword.equals(memberInfo.getPw());
	}

	private boolean idErrorCheck() {
		return !memberInfo.isinit();
	}
}
