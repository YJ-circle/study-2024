package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserEntity implements IEntity{
	String id;
	String password;
	public UserEntity() {}
	public UserEntity(String id, String password) {
		this.id = id;
		this.password = password;
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
	@Override
	public void setEntity(ResultSet sqlResult) throws SQLException {
		id = sqlResult.getString("id");
		password = sqlResult.getString("pw");		
	}
}
