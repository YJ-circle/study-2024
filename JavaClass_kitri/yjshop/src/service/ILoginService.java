package service;

import entity.UserEntity;

public interface ILoginService {
	int login(String id, String password);
	boolean isLoginStatus();
	UserEntity getLoginUser();
}
