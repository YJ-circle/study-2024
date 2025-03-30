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


public abstract class Database2<T> implements AutoCloseable{
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
	private List<T> list = new ArrayList<>();
	abstract public T getBean();
	
	abstract public T setEntity(T entity, ResultSet rs);
	public void setStatement(String sql)  {
		try {
			conn = DriverManager.getConnection(DB_URL, DB_ID, DB_PW);
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sqlAddString(int index, String input)  {
		try {
			pstmt.setString(index, input);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
	
	public void sqlAddInt(int index, int input)  {
		try {
			pstmt.setInt(index, input);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
	
	
	public List<T> sqlSelectList() {
		
	    
		try {
			rs = pstmt.executeQuery();

			while(rs.next()) {
				T entity = getBean();
				T result = setEntity(entity, rs);
				list.add(result);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	

	public int sqlUpdate()  {
		try {
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		
	}
	@Override
	public void close() {

		try {
			if(rs!=null) {
			rs.close();
			pstmt.close();
			conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
}
