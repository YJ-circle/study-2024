package com.spring.studydb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.studydb.dto.GoodsDto;

public class ProductRowMapper implements RowMapper<GoodsDto>{

	@Override
	public GoodsDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		GoodsDto dto = new GoodsDto();
	    dto.setGoodscd(rs.getString("FACTORY"))
	       .setGoodsnm(rs.getString("NAME"))
	       .setGoodsprice(rs.getInt("PRICE"));
		return dto;
	}

}
