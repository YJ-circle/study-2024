package com.spring.miniproject.product.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.miniproject.product.dao.IGoodsDao;
import com.spring.miniproject.product.dto.GoodsDto;
import com.spring.miniproject.product.entity.GoodsEntity;
import com.spring.miniproject.product.mybatis.paramdto.GoodsIdDto;
import com.spring.miniproject.product.mybatis.paramdto.StockLimit;


@Component("goodsDao")
public class GoodsDaoMybatis implements IGoodsDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	GoodsEntity goodsEntity;

	
	@Override
	public List<GoodsEntity> getGoodsList(){
		return sqlSessionTemplate.selectList("goods.findGoodsAll");
	}
	
	@Override
	public GoodsEntity getGoodsById(GoodsIdDto searchDto){
		return sqlSessionTemplate.selectOne("goods.findGoodsId", searchDto);
	}
	
	
	@Override
	public int insertGoods(GoodsDto goodsDto) {
		return sqlSessionTemplate.insert("goods.addGoods", goodsDto);
	}
	
	@Override
	 public List<GoodsEntity> getLowStockGoods(){
		StockLimit limit = new StockLimit(5);
		return sqlSessionTemplate.selectList("goods.getLowStock", limit);
	 }
}