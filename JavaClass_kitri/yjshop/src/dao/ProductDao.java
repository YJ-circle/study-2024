package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.ProductEntity;
import entity.UserEntity;

public class ProductDao {
	private static Connection conn = null;
	
	public ProductDao() {}
	
	public List<ProductEntity> getProduct(int category) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if (conn == null) {
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.247:1521:xe", "coffee", "1234");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		List<ProductEntity> product = sqlGetProduct(category);
		return product;
	}

	private List<ProductEntity> sqlGetProduct(int category) {
		List<ProductEntity> product = new ArrayList<>();
		String sql = "SELECT p.code, p.name, p.price, p.factory, "
				+ "       p.category as categorycode, p.imgpath, "
				+ "       c.name as category "
				+ "FROM product p, category c "
				+ "WHERE p.category = c.code ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			if (category != 0) {
				sql+= "AND p.category = ? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, category);
			}
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				product.add(new ProductEntity(
								rs.getInt("code"),
								rs.getString("name"),
								rs.getInt("price"),
								rs.getString("factory"),
								rs.getInt("categorycode"),
								rs.getString("category"),
								rs.getString("imgpath")
								));
				}
			rs.close();
			pstmt.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return product;
	}

}
