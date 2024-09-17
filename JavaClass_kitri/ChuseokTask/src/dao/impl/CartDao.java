package dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import Setting.Database;
import Setting.SessionFunc;
import dao.ICartDao;
import entity.CartEntity;

public class CartDao implements ICartDao {
	public List<CartEntity> addCart() throws SQLException {

		// Login User
		try (Database db = new Database();) {
			db.setStatement("SELECT * FROM cart WHERE id = ?"); // WHERE id = ?
//			db.sqlAddString(1, id);
			return null;

		}
	}

	public CartEntity getExistCart(String colum, String findId, String findItem) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		try (Database db = new Database();) {
			String sql ="SELECT * "
					    + "FROM cart c, product p "
					    + "WHERE c." + colum + "  = ? "
			            + "AND c.goodscode = ? "
			            + "AND c.active = 'Y' "; 
			db.setStatement(sql);
			db.sqlAddString(1, findId);
			db.sqlAddString(2, findItem);
			List<CartEntity> cartList = db.sqlSelectList(CartEntity.class);
			if(cartList.size() == 1) {
				return cartList.get(0);
			}
			return null;

		}
	}
}
