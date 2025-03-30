package com.spring.miniproject.product.dto;

import com.spring.miniproject.product.dao.IGoodsDao;
import com.spring.miniproject.product.dao.IOrderDao;
import com.spring.miniproject.product.mybatis.paramdto.GoodsIdDto;

public class OrderCart {
	private static IGoodsDao goodsDao;
	private String userId;
	private int goodsId;
	private int qty;


	
	

	private OrderCart(String userId, int goodsId, int qty) {
		super();
		this.userId = userId;
		this.goodsId = goodsId;
		this.qty = qty;
	}

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
	public static OrderCart addCart(String userId, int goodsId, int qty) {
		
		int stock = getGoodsStock(goodsId);
		if(stock < qty) {
			return null;
		}
		OrderCart order = new OrderCart(userId, goodsId, qty);
		return order;
	}
	
	
	public OrderCart setUserId(String userId) {
		this.userId = userId;
		return this;
	}
	public String getUserId() {
		return userId;
	}
	
	
	public int getGoodsId() {
		return goodsId;
	}

	public int getQty() {
		return qty;
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
	private static int getGoodsStock(int goodsId) {
		return goodsDao.getGoodsById(new GoodsIdDto(goodsId))
				         .getStock();
	}

	public static void setGoodsDao(IGoodsDao goodsDao) {
		OrderCart.goodsDao = goodsDao;
	}
}
