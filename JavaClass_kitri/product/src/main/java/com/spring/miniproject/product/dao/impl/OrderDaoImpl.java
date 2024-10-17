package com.spring.miniproject.product.dao.impl;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring.miniproject.product.dao.IGoodsDao;
import com.spring.miniproject.product.dao.IOrderDao;
import com.spring.miniproject.product.dao.mapper.OrderRowMapper;
import com.spring.miniproject.product.dao.mapper.ProductRowMapper;
import com.spring.miniproject.product.dao.sql.OrderSQL;
import com.spring.miniproject.product.dto.OrderCart;
import com.spring.miniproject.product.dto.OrderDto;
import com.spring.miniproject.product.entity.GoodsEntity;
import com.spring.miniproject.product.entity.OrderEntity;

@Component("orderDao")
public class OrderDaoImpl implements IOrderDao, OrderSQL{

	@Autowired
	private JdbcTemplate jdbc;
	
	@Autowired
	private IGoodsDao goodsDao;
	
	@Override
	public int insertOrder(OrderCart orderCart) {
		List<OrderDto> orderList = orderCart.getOrderList();
		int[][] intArrays = jdbc.batchUpdate(SQL_INSERT_ORDER,
						orderList,
						orderList.size(),
						(PreparedStatement ps, OrderDto dto) -> {
							ps.setString(1, orderCart.getUserId());
							ps.setInt(2, dto.getGoodsId());
							ps.setInt(3, dto.getQty());
						});
		
		int orderResult = 0;
		for(int[] i : intArrays) {
			for(int j : i) {
				orderResult++;
			}
		}
		
		orderResult += goodsDao.orderGoods(orderCart);
		
		List<GoodsEntity> lowStockGoods = goodsDao.getLowStockGoods();
		if(lowStockGoods.size() > 0) {
			
		}
		
		return orderResult;
	}

	@Override
	public List<OrderEntity> getOrderByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderEntity> getOrderAll() {
		return jdbc.query(SQL_GET_ORDER_LIST, 
				          new OrderRowMapper());
	}

}
