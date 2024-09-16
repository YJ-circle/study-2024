package dto.impl;

import dto.ICartDto;
import entity.CartEntity;
import entity.IEntity;
import error.DtoConvertError;

public class CartDto implements ICartDto {
	String goodscode;
	String userid;
	int qty;
	int cartPrice;
	String active;
	String recentdate;
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
		this.userid = cart.getUserid();
		this.qty = cart.getQty();
		this.cartPrice = cart.getCartPrice();
		this.active = cart.getActive();
		this.recentdate = cart.getRecentdate();
		this.category = cart.getCategory();
		this.imgPath = cart.getImgPath();
	}

	public String getGoodscode() {
		return goodscode;
	}

	public String getUserid() {
		return userid;
	}

	public int getQty() {
		return qty;
	}

	public int getCartPrice() {
		return cartPrice;
	}

	public String getActive() {
		return active;
	}

	public String getRecentdate() {
		return recentdate;
	}

	public String getCategory() {
		return category;
	}

	public String getImgPath() {
		return imgPath;
	}

	@Override
	public String toString() {
		return "CartDto [goodscode=" + goodscode + ", userid=" + userid + ", qty=" + qty + ", cartPrice=" + cartPrice
				+ ", active=" + active + ", recentdate=" + recentdate + ", category=" + category + ", imgPath="
				+ imgPath + "]";
	}

}
