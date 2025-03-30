package com.spring.miniproject.product.service;

import java.io.IOException;
import java.util.List;

import com.spring.miniproject.product.dto.OrderCart;

public interface INotificationSvc {

	boolean sendOrderMsg(List<OrderCart> orderList) throws IOException;

	boolean sendLowStock() throws IOException;

}
