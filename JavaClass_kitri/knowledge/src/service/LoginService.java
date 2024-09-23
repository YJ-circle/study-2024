package service;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import entity.UserEntity;

public class LoginService {

	public boolean login(HttpServletRequest req, HttpServletResponse resp) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		String id = req.getParameter("id");
		UserEntity user = loginUser(id);
		if(user == null) {
			req.setAttribute("result", "등록되지 않은 사용자입니다");
			
			return false;
		}
		
		if(!req.getParameter("password").equals(user.getPassword())){
			req.setAttribute("result", "패스워드 불일치입니다.");
			return false;
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("id", id);
		return true;
		
		
	}

	private UserEntity loginUser(String id) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		return new UserDao().getUserFromId(id);
	}
	
}
