package com.spring.miniproject.product.dto;

import java.util.ArrayList;
import java.util.List;

import com.spring.miniproject.product.RunMain;
import com.spring.miniproject.product.dao.IGoodsDao;
import com.spring.miniproject.product.dao.IOrderDao;
import com.spring.miniproject.product.service.IOrderSvc;

public class OrderCart {
	private String userId;
	private List<OrderDto> orderList = new ArrayList<OrderDto>();
	
	private IGoodsDao goodsDao = RunMain.getGoodsDao();

	/***
	 * 상품id와 주문 수량을 인자로 받아 <br/>
	 * OrderDto 객체를 만든 후
	 * OrderCart의 orderList에 추가합니다.
	 * <pre>
	 * cart.addCart(int 상품ID, int 상품수량)
	 * </pre>
	 * @param goodsId 상품id: int
	 * @param qty 주문 수량: int
	 * @author 함예정
	 * @since 2024.10.18
	 * @see IOrderDao#insertOrder(OrderCart)
	 */
	public void addCart(int goodsId, int qty) {
		int stock = getGoodsStock(goodsId);
		if(stock < qty) {
			System.out.println("선택한 상품은 재고가 부족합니다");
			return;
		}
		orderList.add(new OrderDto().setGoodsId(goodsId)
		              				.setQty(qty));
		System.out.println("상품을 장바구니에 담았습니다.");
	}
	
	/***
	 * OrderCart 필드 orderList를 반환합니다 
	 * @return List<OrderDto>
	 * @since 2024.10.18
	 * @author 함예정
	 * @see IOrderDao#insertOrder(OrderCart)
	 */
	public List<OrderDto> getOrderList() {
		return orderList;
	}
	
	public OrderCart setUserId(String userId) {
		this.userId = userId;
		return this;
	}
	public String getUserId() {
		return userId;
	}
	
	
	/***
	 * 상품을 장바구니에 담기 전, 재고를 확인합니다. <br/>
	 * 이 메소드는 GoodsDao를 호출하여, 해당 상품의 재고 수량을 가져옵니다.
	 *
	 * @param goodsId 상품ID: int
	 * @return 상품 재고수량: int
	 * @since 2024.10.18
	 * @author 함예정
	 * @see IGoodsDao#getGoodsById(int)
	 */
	private int getGoodsStock(int goodsId) {
		return goodsDao.getGoodsById(goodsId)
				         .getStock();
	}
}
