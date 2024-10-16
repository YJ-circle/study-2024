package com.spring.studydb.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.studydb.dao.IGoodsDao;
import com.spring.studydb.entity.GoodsEntity;


@Component("goodsSvc")
public class GoodsSvcImpl implements IGoodsSvc{
	
	@Autowired
	private IGoodsDao dao;
	
	@Override
	public List<GoodsEntity> getGoodsList() throws SQLException{
		return dao.getGoodsList();
	}

	@Override
	public int insertGoods(String goodscd, String goodsnm, int goodsprice) throws SQLException {
		return dao.insertGoods(goodscd, goodsnm, goodsprice);
	}

}
