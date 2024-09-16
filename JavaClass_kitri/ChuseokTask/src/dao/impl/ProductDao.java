package dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import Setting.Database;
import dao.Dao;
import dao.IProductDao;
import dto.IProductDto;
import entity.IEntity;
import entity.MemberEntity;
import entity.ProductEntity;

public class ProductDao implements IProductDao {

	public List<ProductEntity> getByAll() throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		try(Database db = new Database();){
			String sql = "SELECT p.code, p.name, p.price, p.factory, "
					+ "       p.category as categorycode, p.imgpath, "
					+ "       c.name as category "
					+ "FROM product p, category c "
					+ "WHERE p.category = c.code "; 
			db.setStatement(sql);
			List<ProductEntity> productList = db.sqlSelectList(ProductEntity.class);
			return productList;
		}
	}

	public List<ProductEntity> getByCategory(String columName, String targetName)
			throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		try(Database db = new Database();){
			String sql = "SELECT p.code, p.name, p.price, p.factory, "
					+ "p.category as categorycode, p.imgpath, "
					+ "c.name as category "
					+ "FROM product p, category c "
					+ "WHERE p.category = c.code "
					+ "AND " + columName +  "= ?";
			db.setStatement(sql);
			db.sqlAddString(1, targetName);
			System.out.println(sql);
			List<ProductEntity> productList = db.sqlSelectList(ProductEntity.class);
			return productList;
		}
	}
	


}
