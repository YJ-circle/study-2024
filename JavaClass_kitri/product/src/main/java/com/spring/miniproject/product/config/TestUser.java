package com.spring.miniproject.product.config;


import java.util.HashMap;
import java.util.Map;

public class TestUser {
	private static TestUser testUser;
	private static Map<String, User> userMap = new HashMap<String, TestUser.User>();
	
	private TestUser(){
		userMap.put("hong", new User("hong", "1234", "홍길동", "5355679001"));
		userMap.put("park", new User("park", "1234", "박길동", "5355679001"));
	}
	
	public static TestUser getInstance() {
		if(testUser == null) {
			testUser = new TestUser();
		}
		return testUser;
	}
	public User getUser(String userId) {
		if(userMap.containsKey(userId)) {
			return userMap.get(userId);
		}
		
		return null;
	}
	
	public static class User{
		private String id;
		private String password;
		private String name;
		private String chatId;
		
		public User(String id, String password, String name, String chatId) {
			this.id = id;
			this.password = password;
			this.name = name;
			this.chatId = chatId;
		}
		
		public String getId() {
			return id;
		}
		
		public String getPassword() {
			return password;
		}
		
		public String getName() {
			return name;
		}
		
		public String getChatId() {
			return chatId;
		}		
		
	}

}
