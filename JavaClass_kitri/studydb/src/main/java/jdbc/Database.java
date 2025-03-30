package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.studydb.entity.GoodsEntity;
import com.spring.studydb.service.IGoodsSvc;


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
	
	
	public List<Object> sqlSelectList(String beanName, Function<ResultSet, Object> entitySet) throws SQLException {
		
	    
		rs = pstmt.executeQuery();
		List<Object> list = new ArrayList<>();
		while(rs.next()) {
			Object obj = entitySet.apply(rs);
			list.add(obj);
		}
		return list;
	}
	

	public int sqlUpdate() throws SQLException {
		return pstmt.executeUpdate();
		
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
