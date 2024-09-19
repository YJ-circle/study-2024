package service;

import java.util.ArrayList;
import java.util.List;

import dao.ProductDao;
import dto.ProductDto;
import entity.ProductEntity;

public class ProductSvc {
	public List<ProductDto> getProduct() {
		List<ProductEntity> entityList = new ProductDao().getProductDao();
		List<ProductDto> dtoList = new ArrayList<>();
		for(ProductEntity e : entityList) { 
			dtoList.add(new ProductDto(e.getName(), e.getType(), e.getPrice(), e.getWeight(), e.getWeightUnit(), e.getMinCount(), e.getMaxCount()));
		}
		return dtoList;
		
		
	}

}
