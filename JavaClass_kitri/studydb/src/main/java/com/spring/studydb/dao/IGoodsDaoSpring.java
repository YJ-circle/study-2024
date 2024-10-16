package com.spring.studydb.dao;

import java.util.List;

import com.spring.studydb.dto.GoodsDto;
import com.spring.studydb.entity.GoodsEntity;

public interface IGoodsDaoSpring {
	public List<GoodsEntity> getGoodsList();

	public int insertGoods(GoodsDto goodsDto);

	public int updatePriceByName(GoodsDto goodsDto);

	int deleteByName(GoodsDto goodsdto);
	
}
