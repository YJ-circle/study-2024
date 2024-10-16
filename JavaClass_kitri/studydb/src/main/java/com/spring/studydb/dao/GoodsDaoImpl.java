package com.spring.studydb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.spring.studydb.entity.GoodsEntity;

import jdbc.Database;
import jdbc.Database2;
import jdbc.GoodsDB;
import jdbc.GoodsSQL;


public class GoodsDaoImpl implements IGoodsDao, GoodsSQL{
	

	GoodsEntity goodsEntity;

	@Override
	public int insertGoods(String goodscd, String goodsnm, int goodsprice) throws SQLException {
		try(Database db = new Database()){
			db.setStatement(SQL_INSERT_GOODS);
			db.sqlAddString(1, goodscd);
			db.sqlAddString(2, goodsnm);
			db.sqlAddInt(3, goodsprice);
			return db.sqlUpdate();
		}
	}
	
	@Override
	public List<GoodsEntity> getGoodsList(){
		try(GoodsDB db = new GoodsDB()){
			db.setStatement(SQL_GET_GOODS_LIST);
			return db.sqlSelectList();
		}
	}




}
