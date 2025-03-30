package dto.impl;

import java.text.NumberFormat;

import dto.ICartDto;
import entity.CartEntity;
import entity.IEntity;
import error.DtoConvertError;

public class CartDto implements ICartDto {
	String goodscode;
	String goodsname;
	int qty;
	int cartPrice;
	String category;
	String imgPath;

	public CartDto() {
	}

	@Override
	public <E extends IEntity> void setDto(E entity) {
		if (!(entity instanceof CartEntity)) {
			throw new DtoConvertError("DTO 변환 실패: 타입 불일치", entity);
		}
		CartEntity cart = (CartEntity) entity;
		this.goodscode = cart.getGoodscode();
		this.goodsname = cart.getGoodsName();
		this.qty = cart.getQty();
		this.cartPrice = cart.getPrice();
		this.category = cart.getCategory();
		this.imgPath = cart.getImgPath();
	}

	
	public String getGoodscode() {
		return goodscode;
	}

	public String getGoodsname() {
		return goodsname;
	}
	public int getQty() {
		return qty;
	}

	public String getCartPrice() {
		return NumberFormat.getInstance().format(cartPrice);
	}
	
	public String getCartTotalPrice() {
		return NumberFormat.getInstance().format(cartPrice*qty);
	}

	public String getCategory() {
		return category;
	}

	public String getImgPath() {
		return imgPath;
	}

	@Override
	public String toString() {
		return "CartDto [goodscode=" + goodscode + ", qty=" + qty + ", cartPrice=" + cartPrice + ", category="
				+ category + ", imgPath=" + imgPath + "]";
	}

	@Override
	public int getCatPriceInt() {
		return cartPrice;
	}



}
