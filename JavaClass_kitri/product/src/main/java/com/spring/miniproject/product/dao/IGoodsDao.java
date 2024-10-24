package com.spring.miniproject.product.dao;

import java.util.List;

import com.spring.miniproject.product.dto.GoodsDto;
import com.spring.miniproject.product.dto.OrderCart;
import com.spring.miniproject.product.dto.OrderDto;
import com.spring.miniproject.product.entity.GoodsEntity;
import com.spring.miniproject.product.mybatis.paramdto.GoodsIdDto;


public interface IGoodsDao {

	/***
	 * 새로운 상품을 추가합니다.
	 * @param goodsDto: GoodsDto 추가할 상품DTO 객체
	 * @return int 추가된 행 개수
	 */
	int insertGoods(GoodsDto goodsDto);

	/***
	 * 데이터베이스에 저장된 전체 상품 정보를 가져옵니다. 
	 * @return List<GoodsEntity> 전체 상품 목록
	 * @author 함예정
	 * @since 2024.10.18
	 */
	List<GoodsEntity> getGoodsList();

	/***
	 * 데이터베이스에 저장된 전체 상품 목록 중 특정 제품의 정보를 가져옵니다.
	 * @param id: int 제품의 상품ID
	 * @return GoodsEntity 
	 * @author 함예정
	 * @since 2024.10.18
	 */
	GoodsEntity getGoodsById(GoodsIdDto searchDto);

	/***
	 * 주문이 실행이 된 이후, 재고 감소를 수행합니다.
	 * @Todo Transactional을 적용하여 OrderDao로 이동되어야합니다.
	 * @param orderCart: OrderCart
	 * @return int 변경된 행 개수
	 * @author 함예정
	 * @since 2024.10.18
	 */

	
	/***
	 * 주문이 실행된 이후, 부족한 재고 현황을 조회합니다.
	 * @return List<GoodsEntity> 재고가 5개 이하인 상품 정보를 가져옵니다.
	 * @author 함예정
	 * @since 2024.10.18
	 */
	List<GoodsEntity> getLowStockGoods();


}
