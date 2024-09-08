package service;

import dto.UserDto;

public interface ILoginService {
	int login(String id, String password);
	String logout(String id);
	boolean isLoginStatus();
	UserDto getLoginUser();
}
