package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.HistoryEntity;
import entity.ProductEntity;

public class HistoryDao {
	private static Connection conn = null;
	public HistoryDao() {}
	
	public List<HistoryEntity> getBuyHistory(String id){
		List<HistoryEntity> history = new ArrayList<>();
		connectionLoad();
		oracleDriverLoad();
		String sql = "SELECT h.sn, h.productcode, " 
			       + "p. name, p.price, "
			       + "h.userid, h.buydate, h.qty, "
			       + "p.imgpath, c.name category "
			       + "FROM buyhistory h, product p, category c "
			       + "WHERE h.userid = ? "
			       + "AND h.productcode = p.code "
			       + "AND p.category = c.code "
			       + "ORDER BY buydate ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				history.add(new HistoryEntity(rs.getInt("sn"),
											rs.getString("productcode"),
											rs.getString("name"),
											rs.getInt("price"),
											rs.getString("userId"),
											rs.getString("buyDate"),
											rs.getInt("qty"),
											rs.getString("imgpath"),
											rs.getString("category")
								));
				}
			return history;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
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
	
	private void oracleDriverLoad() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
