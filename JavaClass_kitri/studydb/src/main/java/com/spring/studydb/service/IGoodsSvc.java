package com.spring.studydb.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.studydb.dto.GoodsDto;
import com.spring.studydb.entity.GoodsEntity;

public interface IGoodsSvc {

	int insertGoods(String goodscd, String goodsnm, int goodsprice) throws SQLException;

	List<GoodsEntity> getGoodsList();

	int updatePriceByName(String name, int price);

	int deleteByName(String string);
	
	public List<GoodsDto> readByCategory(String category);
	
	public GoodsDto read(String goodsname);
	public List<GoodsDto> read();
	
	

}
