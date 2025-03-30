package com.spring.studydb.dao;

import java.util.List;

import com.spring.studydb.dto.GoodsDto;
import com.spring.studydb.entity.GoodsEntity;

public interface IGoodsDaoSpring {
	List<GoodsEntity> getGoodsList();

	int insertGoods(GoodsDto goodsDto);

	int updatePriceByName(GoodsDto goodsDto);

	int deleteByName(GoodsDto goodsdto);
	
	List<GoodsEntity> read();
	GoodsDto read(String goodsname);
	List<GoodsDto> readByCategory(String Category);
}
