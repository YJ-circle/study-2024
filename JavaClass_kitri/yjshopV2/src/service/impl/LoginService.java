package service.impl;

import dao.UserDao;
import dto.UserDto;
import entity.UserEntity;
import service.ILoginService;
import service.IService;

public class LoginService implements IService, ILoginService{
	private static boolean loginStatus = false;
	private static UserDto loginUser;
	@Override
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
					loginUser = userEntityToDto(matchUser);
					return 0;
				}
				else {
					return 1;
				}
			}
		} 
		return 2;
	}
	
	@Override
	public String logout(String id) {
		UserDao dao = new UserDao();
		int result = dao.logout(id);
		if(result > 0 ) {
			loginStatus = false;
			loginUser = null;
			return "로그아웃 성공";
			}
		else { return "로그아웃 실패";}
	}
	
	public boolean isLoginStatus() {
		UserDao dao = new UserDao();
		if (loginUser == null) {
			UserEntity dbLoginUser = dao.isLoginCheck();
			if(dbLoginUser != null) {
				loginStatus = true;
				loginUser = userEntityToDto(dbLoginUser);
			}
		}
		return loginStatus;
	}
	public UserDto getLoginUser() {
		return loginUser;
	}

	
}
