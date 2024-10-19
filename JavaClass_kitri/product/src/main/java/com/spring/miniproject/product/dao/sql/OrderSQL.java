package com.spring.miniproject.product.dao.sql;

public interface OrderSQL {
	static final String SQL_GET_ORDER_LIST_ALL = 
			"SELECT o.order_id, o.user_id, "
			+ "     g.name GOODS_NAME, o.qty, "
			+ "     o.goodsid "
			+ " FROM goodsorder o, goods g "
		  + " WHERE o.goodsid = g.id ";
	static final String SQL_GET_ORDER_LIST_USERID = 
			"SELECT o.order_id, o.user_id, "
			+ "     g.name GOODS_NAME, o.qty, "
			+ "     o.goodsid "
			+ "FROM goodsorder o, goods g "
		  + " WHERE o.user_id = ? "
		  + "AND o.goodsid = g.id";
	static final String SQL_INSERT_ORDER = 
			"INSERT INTO goodsorder (ORDER_ID, USER_ID, GOODSID, QTY) "
			+ "VALUES (ORDERID.NEXTVAL, ?, ?, ?) ";
}
