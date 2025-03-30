package com.spring.studydb.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.spring.studydb.config.BeanFactory;
import com.spring.studydb.dao.IGoodsDao;
import com.spring.studydb.dao.IGoodsDaoSpring;
import com.spring.studydb.dto.GoodsDto;
import com.spring.studydb.entity.GoodsEntity;


@Component("goodsSvc")
public class GoodsSvcImpl implements IGoodsSvc{
	
	@Autowired
	private IGoodsDaoSpring dao;
	
	@Override
	public List<GoodsEntity> getGoodsList(){
		return dao.getGoodsList();
	}

	@Override
	public int insertGoods(String goodscd, String goodsnm, int goodsprice) throws SQLException {
		 ClassPathXmlApplicationContext ctx = 
	    		   new ClassPathXmlApplicationContext("classpath:/com/spring/studydb/config/config.xml");
		 GoodsDto goodsDto = BeanFactory.getDtoBean();
		 goodsDto.setGoodscd(goodscd);
		 goodsDto.setGoodsnm(goodsnm);
		 goodsDto.setGoodsprice(goodsprice);
	
		return dao.insertGoods(goodsDto);
	}
	
	@Override
	public int updatePriceByName(String name, int price) {
		 GoodsDto goodsDto = BeanFactory.getDtoBean();
		 goodsDto.setGoodsnm(name);
		 goodsDto.setGoodsprice(price);
	
		return dao.updatePriceByName(goodsDto);
	}


	@Override
	public int deleteByName(String name) {
		 GoodsDto goodsDto = BeanFactory.getDtoBean();
		 goodsDto.setGoodsnm(name);
		return dao.deleteByName(goodsDto);
	}

	@Override
	public List<GoodsDto> readByCategory(String category) {
		return dao.readByCategory(category);
	}

	@Override
	public GoodsDto read(String goodsname) {
		return dao.read(goodsname);
	}
	
}
