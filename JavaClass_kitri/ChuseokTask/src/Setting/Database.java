package Setting;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.IEntity;
import entity.MemberEntity;

public class Database implements AutoCloseable{
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
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
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
	
	
	public <T extends IEntity> List<T> sqlSelectList(Class<T> entity) 
			throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, 
			  	   InvocationTargetException, NoSuchMethodException, SecurityException {
		rs = pstmt.executeQuery();
		System.out.println("SQL실행 못해!!!!");
		List<T> entityList = new ArrayList<>();
		int count = 1;
		while(rs.next()) {
			System.out.println(count++);
			System.out.println(rs.getString("id"));
			T e = entity.getConstructor().newInstance();
			e.setEntity(rs);
			System.out.println(e);
			entityList.add(e);
		}
		System.out.println(entityList.size());
		for(T e : entityList) {
			System.out.println("제너릭 안에서");
			e.getClass();
			System.out.println("조회");
		}
		return entityList;
	}
	
	
	public <T extends IEntity> List<T> sqlSelectListCount(Class<T> entity, int count) 
			throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException 
			 {
		rs = pstmt.executeQuery();
		
		List<T> entityList = new ArrayList<>();
		int rowCount = 0;
		while(rs.next()) {
			rowCount++;
			if (rowCount > count) {
				break;
			}
			T e = entity.getConstructor().newInstance();
			e.setEntity(rs);
			entityList.add(e);
		}
		return entityList;
	}

	@Override
	public void close() throws SQLException {
		System.out.println("클로즈");
		rs.close();
		pstmt.close();
		conn.close();
		
	}
	
	
}
