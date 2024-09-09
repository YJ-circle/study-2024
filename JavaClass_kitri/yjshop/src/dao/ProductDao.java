package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entity.ProductEntity;

public class ProductDao {
	private static Connection conn = null;
	
	public ProductDao() {}
	
	public int purchaseProduct(String code, String id, int count) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 hh시 mm분");
		String dateTime = now.format(format);
		
		oracleDriverLoad();
		connectionLoad();
		int sqlResultCnt = sqlPurchase(code, id, count, dateTime);
		return sqlResultCnt;
	}

	public ProductEntity getProductInfo(String code) {

		String sql = "SELECT p.code, p.name, p.price, p.factory, "
				+ "       p.category as categorycode, p.imgpath, "
				+ "       c.name as category "
				+ "FROM product p, category c "
				+"WHERE p.category = c.code "
				+"AND p.code = ?";
		oracleDriverLoad();
		connectionLoad();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return new ProductEntity(rs.getString("code"),
										rs.getString("name"),
										rs.getInt("price"),
										rs.getString("factory"),
										rs.getInt("categorycode"),
										rs.getString("category"),
										rs.getString("imgpath")
										);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	private int sqlPurchase(String code, String id, int count, String dateTime) {
		connectionLoad();
		String sql = "INSERT INTO buyhistory(SN, PRODUCTCODE, USERID, BUYDATE, qty) "
				   + "VALUES (SEQBUY.NEXTVAL, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			pstmt.setString(2, id);
			pstmt.setString(3, dateTime);
			pstmt.setInt(4, count);
			int result = pstmt.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	private void connectionLoad() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.247:1521:xe", "coffee", "1234");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<ProductEntity> getProduct(int category) {
		oracleDriverLoad();
		connectionLoad();
		List<ProductEntity> product = sqlGetProduct(category);
		return product;
	}

	private void oracleDriverLoad() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
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
								rs.getString("code"),
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
