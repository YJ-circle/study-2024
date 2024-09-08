package service.impl;

import dao.UserDao;
import entity.UserEntity;
import service.ILoginService;
import service.IService;

public class LoginService implements IService, ILoginService{
	private static boolean loginStatus = false;
	private static UserEntity loginUser;
	public int login(String id, String password) {
		UserDao dao = new UserDao();
		UserEntity matchUser = dao.getUserFromId(id);
		if(matchUser!=null) {
			if(matchUser.getId().equals(id)) {
				if(matchUser.getPassword().equals(password)) {
					if(dao.sqlInsertLoginId(id) == -1) {
						return 2;
					}
					loginStatus = true;
					loginUser = matchUser;
					return 0;
				}
				else {
					return 1;
				}
			}
		} 
		return 2;
	}
	public boolean isLoginStatus() {
		return loginStatus;
	}
	public UserEntity getLoginUser() {
		return loginUser;
	}
	
}
