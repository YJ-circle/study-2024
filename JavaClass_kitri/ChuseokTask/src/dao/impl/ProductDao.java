package dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import Setting.Database;
import dao.Dao;
import entity.IEntity;
import entity.MemberEntity;
import entity.ProductEntity;

public class ProductDao implements Dao {

	@Override
	public List<ProductEntity> getByIndex(String id) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		return null;
	}

	@Override
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

	@Override
	public List<ProductEntity> getByColSetString(String columName, String targetName)
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
	
	@Override
	public List<ProductEntity> getByColSetInt(String columName, int targetInt)
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
			db.sqlAddInt(1, targetInt);
			System.out.println(sql);
			List<ProductEntity> productList = db.sqlSelectList(ProductEntity.class);
			return productList;
		}
	}
	
	public List<ProductEntity> customSql(String sql, Map<String, Object> joinMap)
			throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		try(Database db = new Database();){
			db.setStatement(sql);
			int count = 1;
			for(String s : joinMap.keySet()) {
				Object mapValue = joinMap.get(s);
				if(mapValue instanceof String) {
					db.sqlAddString(count++, (String)mapValue);
				}
				if(mapValue instanceof Integer) {
					db.sqlAddInt(count++, (int)mapValue);
				}
				
			}

			List<ProductEntity> productList = db.sqlSelectList(ProductEntity.class);
			return productList;
		}
	}

}
