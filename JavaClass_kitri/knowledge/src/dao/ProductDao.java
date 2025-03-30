package dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import entity.ProductEntity;
import setting.Database;
public class ProductDao{
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<ProductEntity> getProductDao() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		try(Database db = new Database();){
			db.setStatement("SELECT * FROM product09 ");
			List<ProductEntity> productList = db.sqlSelectList(ProductEntity.class);
			return productList;
			
		}
		
	}

}
