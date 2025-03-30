package service;

import java.util.List;

import dto.ProductDto;

public interface IProductSerivce {
	List<ProductDto> getProduct(int category);
}
