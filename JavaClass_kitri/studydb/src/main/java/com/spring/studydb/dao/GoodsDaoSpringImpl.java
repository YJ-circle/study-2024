package com.spring.studydb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring.studydb.dto.GoodsDto;
import com.spring.studydb.entity.GoodsEntity;

import jdbc.GoodsDB;
import jdbc.GoodsSQL;


@Component("dao")
public class GoodsDaoSpringImpl implements IGoodsDaoSpring, GoodsSQL{
	
	@Autowired
	private JdbcTemplate jdbc;

	@Autowired
	GoodsEntity goodsEntity;

	@Override
	public int insertGoods(GoodsDto goodsDto) {
			return jdbc.update(SQL_INSERT_GOODS, 
					           goodsDto.getGoodscd(), 
					           goodsDto.getGoodsnm(), 
					           goodsDto.getGoodsprice());
	}
	
	@Override
	public int updatePriceByName(GoodsDto goodsDto) {
		return jdbc.update(SQL_UPDATE_GOODS, 
						   goodsDto.getGoodsprice(), 
				           goodsDto.getGoodsnm());
	}
	
	@Override
	public int deleteByName(GoodsDto goodsDto) {
		return jdbc.update(SQL_DELETE_GOODS,  
				   			goodsDto.getGoodsnm());
	}
	
	@Override
	public List<GoodsEntity> getGoodsList(){
		try(GoodsDB db = new GoodsDB()){
			db.setStatement(SQL_GET_GOODS_LIST);
			
			return db.sqlSelectList();
		}
	}
}
