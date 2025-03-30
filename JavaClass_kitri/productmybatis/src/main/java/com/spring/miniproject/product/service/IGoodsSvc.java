package com.spring.miniproject.product.service;

import java.util.List;

import com.spring.miniproject.product.dto.GoodsDto;

public interface IGoodsSvc {
	boolean insertGoods(String goodsName, String goodsCategory, int goodsPrice, int goodsStock);
	public List<GoodsDto> getGoodsAll();
	GoodsDto getGoodsById(int goodsId);
}
