package dao;

import java.sql.SQLException;
import java.util.List;

import entity.CartEntity;

public interface ICartDao {
	public CartEntity getExistCart(String colum, String findId, String findItem) throws SQLException;
}
