package com.spring.miniproject.product.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.spring.miniproject.product.dao.IOrderDao;
import com.spring.miniproject.product.dto.OrderCart;
import com.spring.miniproject.product.entity.OrderEntity;
import com.spring.miniproject.product.mybatis.paramdto.UserIdDto;

@Component("orderDao")
public class OrderDaoImpl implements IOrderDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	@Transactional
	public int insertOrder(List<OrderCart> orderList) {
		int updateRow = 0;

		for(OrderCart order: orderList) {
			//주문 기록
			updateRow += sqlSessionTemplate.insert("order.addOrder", order);
			//재고 감소
			updateRow += sqlSessionTemplate.update("goods.goodsDecrease", order);
		}
		return updateRow;
	}

	@Override
	public List<OrderEntity> getOrderByUserId(UserIdDto dto) {
		return sqlSessionTemplate.selectList("order.findOrderId", dto);
	}

	@Override
	public List<OrderEntity> getOrderAll() {
		return sqlSessionTemplate.selectList("order.findOrderAll");
	}

}
