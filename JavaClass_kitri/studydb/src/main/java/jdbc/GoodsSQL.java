package jdbc;

public interface GoodsSQL {
	static final String SQL_GET_GOODS_LIST = "SELECT * FROM product ";
	static final String SQL_INSERT_GOODS = "INSERT INTO product (FACTORY, NAME, PRICE) VALUES (?, ?, ?) ";
}
