package dto.impl;

import java.text.NumberFormat;

import dto.IProductDto;
import entity.IEntity;
import entity.ProductEntity;
import error.DtoConvertError;

public class ProductDto implements IProductDto{
	String code;
	String name;
	int price;
	String category;
	String imgPath;
	String detail;
	@Override
	public <E extends IEntity> void setDto(E entity) {
		if(!(entity instanceof ProductEntity)) {
			throw new DtoConvertError("DTO 변환 실패: 타입 불일치", entity);
		}
		ProductEntity product = (ProductEntity) entity;
		this.code = product.getCode();
		this.name = product.getName();
		this.price = product.getPrice();
		this.category = product.getCategory();
		this.imgPath = product.getImgPath();
		this.detail = product.getDetail();
	}
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public String getCategory() {
		return category;
	}
	public String getImgPath() {
		return imgPath;
	}
	
	public String getDetail() {
		return detail;
	}
	@Override
	public String priceToString() {
		return NumberFormat.getInstance().format(price);
	}
	public String nameTwoLine() {
		return name.replace("]", "] <br />");
	}
}
