package com.spring.miniproject.product.service;

import java.io.IOException;

import com.spring.miniproject.product.dto.OrderCart;

public interface INotificationSvc {

	boolean sendOrderMsg(OrderCart orderCart) throws IOException;

	boolean sendLowStock() throws IOException;

}
