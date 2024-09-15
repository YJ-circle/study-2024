package service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.ProductDao;
import dto.IProductDto;
import dto.impl.ProductDto;
import entity.ProductEntity;
import service.IProductSerivce;

public class ProductSerivice implements IProductSerivce {
	
	public List<IProductDto> getProductList(HttpServletRequest req, HttpServletResponse resp) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		List<ProductEntity> productList = null;
		String category = req.getParameter("category");
		if(category == null) {
			productList = new ProductDao().getByAll();
		} else {
			productList = new ProductDao().getByColSetString("c.code", category);
		}
		
		List<IProductDto> dto = new ArrayList<>();
		for(ProductEntity p : productList) {
			IProductDto productDto = new ProductDto();
			productDto.setDto(p);
			dto.add(productDto);
		}
		return dto;
	}


}
