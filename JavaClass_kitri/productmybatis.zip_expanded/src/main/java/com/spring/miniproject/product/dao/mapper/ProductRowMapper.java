package com.spring.miniproject.product.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.miniproject.product.entity.GoodsEntity;


public class ProductRowMapper implements RowMapper<GoodsEntity>{

	@Override
	public GoodsEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		GoodsEntity entity = new GoodsEntity();
		entity.setId(rs.getInt("ID"))
	       .setName(rs.getString("NAME"))
	       .setCategory(rs.getString("CATEGORY"))
	       .setPrice(rs.getInt("PRICE"))
		   .setStock(rs.getInt("STOCK"));
		return entity;
	}

}
