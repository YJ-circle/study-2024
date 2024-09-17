package dao.impl;

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

	public CartEntity getExistCart(String colum, String findId, String findItem) throws SQLException {
		try (Database db = new Database();) {
			String sql ="SELECT * FROM cart WHERE "
			            + colum + "  = ? "
			            + "goodscode = ?"; 
			db.setStatement(sql);
			db.sqlAddString(1, findId);
			db.sqlAddString(2, findItem);
			db.sqlSelectList(CartEntity.class);
			return null;

		}
	}
}
