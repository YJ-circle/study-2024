package com.spring.studydb.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("dto")
@Scope("prototype")
public class GoodsDto {
	String goodscd;
	String goodsnm;
	int goodsprice;
	public String getGoodscd() {
		return goodscd;
	}
	public GoodsDto setGoodscd(String goodscd) {
		this.goodscd = goodscd;
		return this;
	}
	public String getGoodsnm() {
		return goodsnm;
	}
	public GoodsDto setGoodsnm(String goodsnm) {
		this.goodsnm = goodsnm;
		return this;
	}
	public int getGoodsprice() {
		return goodsprice;
	}
	public GoodsDto setGoodsprice(int goodsprice) {
		this.goodsprice = goodsprice;
		return this;
	}
	@Override
	public String toString() {
		return "GoodsDto [goodscd=" + goodscd + ", goodsnm=" + goodsnm + ", goodsprice=" + goodsprice + "]";
	}
	
	

}
