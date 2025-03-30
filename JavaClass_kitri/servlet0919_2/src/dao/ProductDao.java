package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.ProductEntity;

public class ProductDao {
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
	
	public List<ProductEntity> getProductDao() {
		
		List<ProductEntity> list = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(DB_URL, DB_ID, DB_PW);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM product09 ";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new ProductEntity(rs.getString("code"), 
										  rs.getString("name"), 
										  rs.getString("type"),
										  rs.getInt("price"),
										  rs.getInt("weight"),
										  rs.getString("weightunit"),
										  rs.getInt("mincount"),
										  rs.getInt("maxcount")));
			}
			
			rs.close();
			stmt.close();
			conn.close();
			return list;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
		
	}

}
