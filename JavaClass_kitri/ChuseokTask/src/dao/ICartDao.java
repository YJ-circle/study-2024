package dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import entity.CartEntity;

public interface ICartDao {
	public List<CartEntity> getExitstCart(String method, String id) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException;
	public boolean addCart(CartEntity newCart) throws SQLException;
}
