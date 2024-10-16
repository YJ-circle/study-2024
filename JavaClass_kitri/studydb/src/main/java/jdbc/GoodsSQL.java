package jdbc;

public interface GoodsSQL {
	static final String SQL_GET_GOODS_LIST = "SELECT * FROM product ";
	static final String SQL_INSERT_GOODS = "INSERT INTO product (FACTORY, NAME, PRICE) VALUES (?, ?, ?) ";
	static final String SQL_UPDATE_GOODS = "UPDATE product SET price = ? "
			                             	  + "WHERE NAME = ? ";
	static final String SQL_DELETE_GOODS = "DELETE FROM product "
											  + "WHERE NAME = ? ";
}
