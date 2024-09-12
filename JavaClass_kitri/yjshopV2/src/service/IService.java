package service;

import java.util.ArrayList;
import java.util.List;

import dto.ProductDto;
import dto.UserDto;
import entity.ProductEntity;
import entity.UserEntity;

public interface IService {
	default UserDto userEntityToDto(UserEntity entity){
		return new UserDto(
							entity.getId(),
							entity.getName(),
							entity.getAddress()
							);
	}
	
	default List<ProductDto> productToDto(List<ProductEntity> entity) {
		List<ProductDto> product = new ArrayList<>();
		for(ProductEntity p : entity) {
			product.add(new ProductDto(p.getCode(),
							  		   p.getName(),
							           p.getPrice(),
							           p.getCategory(),
							           p.getImgPath()
				                       )
					    );
		}
		return product;
	}

}
