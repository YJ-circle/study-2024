package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DynamicMain {
	static final String DB_URL = "jdbc:oracle:thin:@192.168.10.247:1521:xe"; 
	static final String USER = "test"; 
	static final String PASS = "1234"; 
	static final String QUERY = "SELECT * FROM student"; 
	
	public static void main(String[] args) throws SQLException {
		Statement stmt = null;
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			String SQL = "INSERT INTO student  " + 
	                "VALUES (202402004, 1, '홍홍홍', '010-1234-1234')";
			stmt.addBatch(SQL); 
			SQL = "INSERT INTO student  " + 
		                "VALUES (202402006, 1, '홍홍홍', '010-1234-1234')"; 
			stmt.addBatch(SQL); 
			stmt.executeBatch();
			conn.commit();
		} catch (SQLException se) {
			System.out.println("실패!!!");
			conn.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("완료");
		
		

	}
}
