package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dao {

	public List<String> getGoods() {
		List<String> goods = new ArrayList<>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.247:1521:xe", "coffee", "1234");
			String sql = "SELECT * FROM basket ";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				goods.add(rs.getString("goodsname"));
			}
			stmt.close();
			conn.close();

		}
		catch (Exception e) {
			
		}
		return goods;
	}

}
