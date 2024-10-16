package com.spring.studydb.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.studydb.entity.GoodsEntity;

public interface IGoodsDao {

	int insertGoods(String goodscd, String goodsnm, int goodsprice) throws SQLException;

	List<GoodsEntity> getGoodsList() throws SQLException;

}
