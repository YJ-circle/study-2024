package com.spring.miniproject.product.dao.sql;

public interface GoodsSQL {
	static final String SQL_GET_GOODS_LIST = "SELECT * FROM goods ";
	static final String SQL_INSERT_GOODS = "INSERT INTO goods (ID, NAME, CATEGORY, PRICE, STOCK) VALUES (goodsid.NEXTVAL, ?, ?, ?, ?) ";
	static final String SQL_UPDATE_GOODS = "UPDATE product SET price = ? "
			                             	  + "WHERE NAME = ? ";
	static final String SQL_DELETE_GOODS = "DELETE FROM goods "
											  + "WHERE NAME = ? ";
	static final String SQL_ORDER_GOODS = "UPDATE goods "
			                             + "SET STOCK = "
			                                   + "(SELECT stock - ? "
			                                    + "FROM goods "
			                                    + "WHERE id = ? ) "
			                             + "WHERE id = ? ";
	static final String SQL_LOW_STOCK_GOODS = "SELECT * FROM goods "
			                                + "WHERE stock <= ? ";
}
