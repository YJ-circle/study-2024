package dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import Setting.Database;
import Setting.SessionFunc;
import dao.ICartDao;
import entity.CartEntity;

public class CartDao implements ICartDao {
	private boolean existOld;
	public List<CartEntity> addCart() throws SQLException {

		// Login User
		try (Database db = new Database();) {
			db.setStatement("SELECT * FROM cart WHERE id = ?"); // WHERE id = ?
//			db.sqlAddString(1, id);
			return null;

		}
	}

	public CartEntity getExistCartItem(CartEntity newCart) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		try (Database db = new Database()) {
			String colum = "userid";
			
			if(newCart.getUserid() == null) {
				colum = "sessionid";
			}
			
			String sql ="SELECT c.goodscode, c.userid, c.qty, p.price, "
					    + "c. active, c.recentdate, ca.name category, p.imgpath "
					    + "FROM cart c, product p, category ca "
					    + "WHERE c." + colum + "  = ? "
			            + "AND c.goodscode = ? "
			            + "AND c.active = 'Y' " 
						+ "AND c.goodscode = p.code "
						+ "AND p.category = ca.code ";
			db.setStatement(sql);
			db.sqlAddString(1, newCart.getUserid());
			db.sqlAddString(2, newCart.getGoodscode());
			List<CartEntity> cartList = db.sqlSelectList(CartEntity.class);
			if(cartList.size() == 1) {
				existOld = true;
				return cartList.get(0);
			}
			return null;

		}
	}
	
	public boolean addCart(CartEntity newCart) throws SQLException {
		try(Database db = new Database()){
			String sql = null;
			if(existOld) {
				sql = "INSERT INTO cart (goodscode, userid, sessionid, qty, active,recentdate) "
					+ "VALUES (?, ?, ?, ?, 'Y', ?) ";
			} else {
				sql = "UPDATE cart "
					+ "SET goodscode = ? ";
				
					//+ "WHERE userid = ? "
					//+ "AND sessionid = ? "
			}
		}
		return false;
	}
}
