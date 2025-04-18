package common.database;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.IEntity;

public class Database implements AutoCloseable, DBSetting{
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	private Class type;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	
	public <T extends IEntity> Database(Class<T> entity) {
		this.type = entity;
	}

	public void setStatement(String sql) throws SQLException {
		conn = DriverManager.getConnection(DB_URL, DB_ID, DB_PW);
		pstmt = conn.prepareStatement(sql);
		return;
	}
	
	public void sqlAddString(int index, String input) throws SQLException {
		pstmt.setString(index, input);
		return;
	}
	
	public void sqlAddInt(int index, int input) throws SQLException {
		pstmt.setInt(index, input);
		return;
	}
	
	
	public <T extends IEntity> List<T> sqlSelectList() 
			throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, 
			  	   InvocationTargetException, NoSuchMethodException, SecurityException {
		rs = pstmt.executeQuery();
		List<T> entityList = new ArrayList<>();
		while(rs.next()) {
			T e = (T) type.getConstructor().newInstance();
			e.setEntity(rs);
			entityList.add(e);
		}
		return entityList;
	}
	
	
	public boolean sqlUpdateOnlyOne() throws SQLException {
		conn.setAutoCommit(false);
		int cnt = pstmt.executeUpdate();
		
		if (cnt == 1) {
			conn.commit();
		} else if (cnt > 1) {
			new SQLException("SQL 업데이트 과정에서 행이 2개 이상 바뀌었습니다");
			conn.rollback();
		} else {
			new SQLException("업데이트 된 행이 없습니다");
		}
		
		return true;
		
	}
	public boolean sqlUpdate() throws SQLException {
		conn.setAutoCommit(false);
		pstmt.executeUpdate();
		conn.commit();
		return true;
		
	}
	@Override
	public void close() throws SQLException {
		if(rs!=null) {
			rs.close();	
		}
		
		pstmt.close();
		conn.close();
		
	}
	
	
	private static class DatabaseError extends RuntimeException{
		
		public DatabaseError(String message) {
			super(message);
		}
	}

}
