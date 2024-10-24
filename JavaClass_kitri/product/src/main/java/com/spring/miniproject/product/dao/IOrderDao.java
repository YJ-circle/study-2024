package com.spring.miniproject.product.dao;

import java.util.List;

import com.spring.miniproject.product.dto.OrderCart;
import com.spring.miniproject.product.entity.OrderEntity;
import com.spring.miniproject.product.mybatis.paramdto.GoodsIdDto;
import com.spring.miniproject.product.mybatis.paramdto.UserIdDto;

public interface IOrderDao {
 /***
  * OrderCart 객체 안에 담긴 List를 참조하여 <br/>
  * 주문 정보를 데이터베이스에 저장합니다 <br/>
  * @param orderCart 상품이 추가되어있는 장바구니 객체
  * @return int 추가된 행 개수
  * @since 2024.10.18
  * @see OrderCart#addCart(int goodsId, int qty)
  */
  public int insertOrder(List<OrderCart> orderList);
  
  /***
   * 데이터베이스에 저장되어있는 주문 목록 중 특정 사용자의 주문 내역만 가져옵니다.
   * @param userId 사용자id: String
   * @return List<OrderEntity> 인자에 입력된 사용자의 주문 내역
   * @author 함예정
   * @since 2024.10.18
   * 
   */
  public List<OrderEntity> getOrderByUserId(UserIdDto dto);
  
  /***
   * 데이터베이스에 저장되어있는 전체 주문 목록을 가져옵니다.
   * @return List<OrderEntity> 전체 주문 내역
   * @author 함예정
   * @since 2024.10.18
   */
  public List<OrderEntity> getOrderAll();
  
}
