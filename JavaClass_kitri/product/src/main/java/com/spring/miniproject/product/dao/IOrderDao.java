package com.spring.miniproject.product.dao;

import java.util.List;

import com.spring.miniproject.product.dto.OrderCart;
import com.spring.miniproject.product.entity.OrderEntity;

public interface IOrderDao {
  public int insertOrder(OrderCart orderCart);
  public List<OrderEntity> getOrderByUserId(String userId);
  public List<OrderEntity> getOrderAll();
  
}
