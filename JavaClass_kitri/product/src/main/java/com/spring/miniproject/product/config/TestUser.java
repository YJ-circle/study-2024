package com.spring.miniproject.product.config;


import java.util.HashMap;
import java.util.Map;

public class TestUser {
	private static Map<String, User> userMap = new HashMap<String, TestUser.User>();
	
	public TestUser(){
		userMap.put("hong", new User("hong", "1234", "홍길동", "id1"));
		userMap.put("park", new User("park", "1234", "박길동", "id2"));
	}
	
	
	public User getUser(String userId) {
		if(userMap.containsKey(userId)) {
			return userMap.get(userId);
		}
		
		return null;
	}
	
	public class User{
		String id;
		String password;
		String name;
		String chatId;
		public User(String id, String password, String name, String chatId) {
			this.id = id;
			this.password = password;
			this.name = name;
			this.chatId = chatId;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getChatId() {
			return chatId;
		}
		public void setChatId(String chatId) {
			this.chatId = chatId;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			
			if (obj == null)
				return false;
			
			if (getClass() != obj.getClass())
				return false;
			
			User other = (User) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}		
		
	}

}
