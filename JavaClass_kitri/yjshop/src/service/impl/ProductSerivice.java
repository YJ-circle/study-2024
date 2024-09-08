package service.impl;

import java.util.List;

import dao.ProductDao;
import dto.ProductDto;
import entity.ProductEntity;
import service.IProductSerivce;
import service.IService;

public class ProductSerivice implements IService, IProductSerivce {
	ProductDao dao = new ProductDao();
	
	public List<ProductDto> getProduct(int category){
		return productToDto(dao.getProduct(category));
	}
	
}
