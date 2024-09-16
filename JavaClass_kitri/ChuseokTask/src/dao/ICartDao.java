package dao;

import java.sql.SQLException;
import java.util.List;

import entity.CartEntity;

public interface ICartDao {
	public List<CartEntity> findCartByColum(String colName, String findTarget) throws SQLException;
}
