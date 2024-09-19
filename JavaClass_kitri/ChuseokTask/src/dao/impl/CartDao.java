package dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import commonFunc.Database;
import commonFunc.SessionFunc;
import dao.ICartDao;
import entity.CartEntity;
import error.LoginError;

public class CartDao implements ICartDao {
	public List<CartEntity> addCart() throws SQLException {

		// Login User
		try (Database db = new Database();) {
			db.setStatement("SELECT * FROM cart WHERE id = ?"); // WHERE id = ?
//			db.sqlAddString(1, id);
			return null;

		}
	}

	public List<CartEntity> getExitstCart(String method, String id) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		try (Database db = new Database()) {
			String colum = method;
			
			String sql ="SELECT c.goodscode, c.userid, c.sessionid, c.qty, p.price, "
					    + "c.active, c.recentdate, ca.name category, p.imgpath, "
					    + "p.name goodsname "
					    + "FROM cart c, product p, category ca "
					    + "WHERE c." + colum + "  = ? "
			            + "AND c.active = 'Y' " 
						+ "AND c.goodscode = p.code "
						+ "AND p.category = ca.code ";
			db.setStatement(sql);
			db.sqlAddString(1, id);
			return db.sqlSelectList(CartEntity.class);

		}
	}
	

	
	public boolean addCart(CartEntity newCart) throws SQLException {
		try(Database db = new Database()){
			String id = null;
			String columSet = null;
			
			LocalDateTime dateTime = LocalDateTime.now();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"); 
			String datetime = dateTime.format(format);
			String goodsCode = newCart.getGoodscode();
			int qty = newCart.getQty();
			
			if(newCart.getUserid()!= null) {
				columSet = "userid";
				id = newCart.getUserid();
			} else {
				columSet = "sessionid";
				id = newCart.getSessionid();
			}
			
			String sql = "MERGE INTO cart "
						+ "USING DUAL "
						+ "  ON (" + columSet + " = ? AND active = 'Y' AND goodscode = ?) "
						+ "  WHEN MATCHED THEN "
						+ "    UPDATE SET qty = (SELECT qty "
						+ "                     FROM cart "
						+ "                     WHERE goodscode = ? "
						+ "                     AND " + columSet + "= ? "
						+ "                     AND active ='Y') + ?, "
						+ "                recentdate = '" + datetime
						+ "'   WHERE goodscode = ? "
						+ "    AND " + columSet + "= ? "
						+ "    AND active = 'Y' "
						+ "  WHEN NOT MATCHED THEN "
						+ "    INSERT (goodscode, " + columSet + ", qty, active, recentdate) "
						+ "    VALUES (?, ?, ?, 'Y', '" + datetime + "')";
			
			db.setStatement(sql);
			db.sqlAddString(1, id);
			db.sqlAddString(2,goodsCode);
			db.sqlAddString(3, goodsCode);
			db.sqlAddString(4, id);
			db.sqlAddInt(5, qty);			
			db.sqlAddString(6, goodsCode);
			db.sqlAddString(7, id);
			db.sqlAddString(8, goodsCode);
			db.sqlAddString(9, id);
			db.sqlAddInt(10, qty);
			return db.sqlUpdateOnlyOne();
		}
	}
	
	public boolean changeQty(CartEntity newCart) {
		return false;
	}
}
