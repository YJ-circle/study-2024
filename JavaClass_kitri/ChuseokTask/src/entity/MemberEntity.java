package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberEntity implements IEntity {
	private boolean init;
	private String id;
	private String pw;
	private String name;
	private String address;
	
	
	public MemberEntity() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public void setEntity(ResultSet sqlResult) throws SQLException {
			id = sqlResult.getString("id");
			pw = sqlResult.getString("pw");
			name = sqlResult.getString("name");
			address = sqlResult.getString("address");
			init = true;
		}
	
	public boolean isinit() {
		return init;
	}
	
}
