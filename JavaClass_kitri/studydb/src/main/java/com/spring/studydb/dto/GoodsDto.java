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
	public void setGoodscd(String goodscd) {
		this.goodscd = goodscd;
	}
	public String getGoodsnm() {
		return goodsnm;
	}
	public void setGoodsnm(String goodsnm) {
		this.goodsnm = goodsnm;
	}
	public int getGoodsprice() {
		return goodsprice;
	}
	public void setGoodsprice(int goodsprice) {
		this.goodsprice = goodsprice;
	}

}
