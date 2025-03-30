package com.kitri.spring.javawebbean.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.kitri.spring.javawebbean.dto.OrderDto;
import com.kitri.spring.javawebbean.rowmapper.OrderRowMapper;

public class OrderDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
		public List<OrderDto> getOrderList(){
			String sql = "select ORDER_ID, USER_ID, GOODSID FROM goodsorder";
			jdbcTemplate.queryForList(sql);
			return jdbcTemplate.query(sql, new OrderRowMapper());
	}

		
}
