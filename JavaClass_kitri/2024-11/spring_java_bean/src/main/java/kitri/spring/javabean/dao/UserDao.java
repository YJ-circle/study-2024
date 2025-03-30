package kitri.spring.javabean.dao;

import java.util.List;

import kitri.spring.javabean.dto.UserDto;

public class UserDao {
	public List<UserDto> getUserList(){
		return List.of(
				new UserDto("id1", "pwd1", "홍길동"),
				new UserDto("id2", "pwd2", "박길동"));
	}
	
	public void init() {
		System.out.println("User Dao Init");
	}

	public void destroy() {
		System.out.println("User Dao destroy");
	}
}
