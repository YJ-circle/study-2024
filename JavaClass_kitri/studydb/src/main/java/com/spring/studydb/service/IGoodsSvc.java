package com.spring.studydb.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.studydb.entity.GoodsEntity;

public interface IGoodsSvc {

	int insertGoods(String goodscd, String goodsnm, int goodsprice) throws SQLException;

	List<GoodsEntity> getGoodsList() throws SQLException;

}
