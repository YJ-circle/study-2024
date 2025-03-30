package com.kitri.spring.javawebbean.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.kitri.spring.javawebbean.dto.OrderDto;

public class OrderRowMapper implements RowMapper<OrderDto> {

	@Override
	public OrderDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderDto orderDto = new OrderDto();
		orderDto.setOrderId(rs.getString("ORDER_ID"));
		orderDto.setGoodsId(rs.getString("GOODSID"));
		orderDto.setUserId(rs.getString("USER_ID"));
		
		return orderDto;
	}

}
