package common;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import entity.IEntity;

public class Database<T extends IEntity> implements AutoCloseable{
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	private static final String DB_URL = "jdbc:oracle:thin:@192.168.10.247:1521:xe";
	private static final String DB_ID = "coffee";
	private static final String DB_PW = "1234";
	private Class<T> entityClass;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	public Database(Class<T> entityClass){
		this.entityClass = entityClass;
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
	
	
	public List<T> sqlSelectList(){
		List<T> entityList = new ArrayList<>();
		try{
			rs = pstmt.executeQuery();
			while(rs.next()) {
				T e = entityClass.getConstructor().newInstance();
				e.setEntity(rs);
				entityList.add(e);
			}
		} catch (Exception e) {
			exceptionHandler(e);
		}
		
		return entityList;
	}
	
	public Map<String, T> sqlSelectMap(String keyColum) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Map<String, T> entityMap = new TreeMap<>();
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				T e = entityClass.getConstructor().newInstance();
				e.setEntity(rs);
				String key = rs.getString(keyColum);
				entityMap.put(key, e);
			}					
		} catch (Exception e) {
			exceptionHandler(e);
		}
		return entityMap;
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
	
	private void exceptionHandler(Exception e) {
		e.printStackTrace(System.out);
		System.out.println("<< 오류 >>");
		if(e instanceof SQLException) {
			System.out.println("오류명: SQL 오류");
			System.out.println("오류메시지: " + e.getMessage());
		}
	}
	@Override
	public void close() throws SQLException {
		if(rs!=null) {
			rs.close();	
		}
		
		pstmt.close();
		conn.close();
		
	}
	
	
}
