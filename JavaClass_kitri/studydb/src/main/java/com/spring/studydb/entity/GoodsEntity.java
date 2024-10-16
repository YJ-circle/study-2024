package com.spring.studydb.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("goodsEntity")
@Scope("prototype")
public class GoodsEntity {
	String goodscd;
	String goodsname;
	int goodsprice;
	
	public GoodsEntity() {
	}
	public GoodsEntity(String goodscd, String goodsname, int goodsprice) {
		super();
		this.goodscd = goodscd;
		this.goodsname = goodsname;
		this.goodsprice = goodsprice;
	}
	public String getGoodscd() {
		return goodscd;
	}
	public void setGoodscd(String goodscd) {
		this.goodscd = goodscd;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public int getGoodsprice() {
		return goodsprice;
	}
	public void setGoodsprice(int goodsprice) {
		this.goodsprice = goodsprice;
	}
	
	
	@Override
	public String toString() {
		return "GoodsEntity [goodscd=" + goodscd + ", goodsname=" + goodsname + ", goodsprice=" + goodsprice + "]\n";
	}
	
	

}
