package com.spring.miniproject.product.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.miniproject.product.entity.OrderEntity;


public class OrderRowMapper implements RowMapper<OrderEntity>{

	/***
	 * 주문 정보를 데이터베이스에서 가져올 때 데이터를 읽어 Entity 객체의 필드 값을 채웁니다.
	 */
	@Override
	public OrderEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderEntity entity = new OrderEntity();
		entity.setOrderId(rs.getInt("ORDER_ID"))
	       .setUserId(rs.getString("USER_ID"))
	       .setGoodsId(rs.getInt("GOODSID"))
		   .setQty(rs.getInt("QTY"))
		   .setGoodsName(rs.getString("GOODS_NAME"));
		   
		return entity;
	}

}
