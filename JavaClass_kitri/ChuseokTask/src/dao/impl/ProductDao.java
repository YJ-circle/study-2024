package dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import Setting.Database;
import dao.IProductDao;
import entity.ProductEntity;

public class ProductDao implements IProductDao {

	public List<ProductEntity> getByAll() throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		try(Database db = new Database();){
			String sql = "SELECT p.code, p.name, p.price, p.factory, "
					+ "       p.category as categorycode, p.imgpath, p.detail, "
					+ "       c.name as category "
					+ "FROM product p, category c "
					+ "WHERE p.category = c.code "; 
			db.setStatement(sql);
			List<ProductEntity> productList = db.sqlSelectList(ProductEntity.class);
			return productList;
		}
	}

	public List<ProductEntity> getByCategory(String category)
			throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		try(Database db = new Database();){
			String sql = "SELECT p.code, p.name, p.price, p.factory, "
					+ "p.category as categorycode, p.imgpath, p.detail, "
					+ "c.name as category "
					+ "FROM product p, category c "
					+ "WHERE p.category = c.code "
					+ "AND c.code = ? ";
			db.setStatement(sql);
			db.sqlAddString(1, category);
			List<ProductEntity> productList = db.sqlSelectList(ProductEntity.class);
			return productList;
		}
	}
	
	public List<ProductEntity> getByItem(String itemId)
			throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		try(Database db = new Database();){
			String sql = "SELECT p.code, p.name, p.price, p.factory, "
					+ "p.category as categorycode, p.imgpath, p.detail, "
					+ "c.name as category "
					+ "FROM product p, category c "
					+ "WHERE p.category = c.code "
					+ "AND p.code = ? ";
			db.setStatement(sql);
			db.sqlAddString(1, itemId);
			List<ProductEntity> productList = db.sqlSelectList(ProductEntity.class);
			return productList;
		}
	}
	


}
