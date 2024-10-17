package com.spring.miniproject.product.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.miniproject.product.entity.OrderEntity;


public class OrderRowMapper implements RowMapper<OrderEntity>{

	@Override
	public OrderEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderEntity entity = new OrderEntity();
		entity.setOrderId(rs.getInt("ORDER_ID"))
	       .setUserId(rs.getString("USER_ID"))
	       .setGoodsId(rs.getInt("GOODSID"))
		   .setQty(rs.getInt("QTY"));
		return entity;
	}

}
