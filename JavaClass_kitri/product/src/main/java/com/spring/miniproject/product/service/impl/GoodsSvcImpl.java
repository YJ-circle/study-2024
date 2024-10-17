package com.spring.miniproject.product.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.miniproject.product.dao.IGoodsDao;
import com.spring.miniproject.product.dto.GoodsDto;
import com.spring.miniproject.product.entity.GoodsEntity;
import com.spring.miniproject.product.service.IGoodsSvc;
import com.spring.miniproject.product.service.INotificationSvc;

@Component("goodsSvc")
public class GoodsSvcImpl implements IGoodsSvc {
	
	@Autowired
	private IGoodsDao goodsDao;

	private INotificationSvc notiSvc;

	@Override
	public boolean insertGoods(String goodsName, String goodsCategory, 
			                   int goodsPrice, int goodsStock) {		
		int insertResult = goodsDao.insertGoods(
										new GoodsDto()
											.setName(goodsName)
											.setCategory(goodsCategory)
											.setPrice(goodsPrice)
											.setStock(goodsStock)
									);
		
		if (insertResult == 1) {
			return true;
		}
		return false;
	}
	
	@Override
	public List<GoodsDto> getGoodsAll(){
		List<GoodsEntity> entityList = goodsDao.getGoodsList();
		List<GoodsDto> dtoList = new ArrayList<GoodsDto>();
		for(GoodsEntity e: entityList) {
			dtoList.add(convertToDto(e));
		}
		return dtoList;
	}

	private GoodsDto convertToDto(GoodsEntity entity) {
		return new GoodsDto()
				.setId(entity.getId())
				.setName(entity.getName())
				.setCategory(entity.getCategory())
				.setPrice(entity.getPrice())
				.setStock(entity.getStock());
	}

	@Override
	public GoodsDto getGoodsById(int goodsId) {
		GoodsEntity entity = goodsDao.getGoodsById(goodsId);
		return convertToDto(entity);
	}
}
