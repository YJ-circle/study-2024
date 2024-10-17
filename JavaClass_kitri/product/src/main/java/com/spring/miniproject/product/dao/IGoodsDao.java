package com.spring.miniproject.product.dao;

import java.util.List;

import com.spring.miniproject.product.dto.GoodsDto;
import com.spring.miniproject.product.dto.OrderCart;
import com.spring.miniproject.product.dto.OrderDto;
import com.spring.miniproject.product.entity.GoodsEntity;


public interface IGoodsDao {

	int insertGoods(GoodsDto goodsDto);

	List<GoodsEntity> getGoodsList();

	GoodsEntity getGoodsById(int id);

	int orderGoods(OrderCart orderCart);

}
