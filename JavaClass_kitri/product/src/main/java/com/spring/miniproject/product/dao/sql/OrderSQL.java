package com.spring.miniproject.product.dao.sql;

public interface OrderSQL {
	static final String SQL_GET_ORDER_LIST = 
			"SELECT * FROM goodsorder ";
	static final String SQL_INSERT_ORDER = 
			"INSERT INTO goodsorder (ORDER_ID, USER_ID, GOODSID, QTY) "
			+ "VALUES (ORDERID.NEXTVAL, ?, ?, ?) ";
}
