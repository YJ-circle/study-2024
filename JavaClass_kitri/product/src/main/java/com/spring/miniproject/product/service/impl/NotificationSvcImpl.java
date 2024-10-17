package com.spring.miniproject.product.service.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.miniproject.product.config.TestUser;
import com.spring.miniproject.product.dao.IGoodsDao;
import com.spring.miniproject.product.dto.OrderCart;
import com.spring.miniproject.product.dto.OrderDto;
import com.spring.miniproject.product.entity.GoodsEntity;
import com.spring.miniproject.product.service.INotificationSvc;
import com.spring.miniproject.product.service.NotificationSetting;

@Component("notiSvc")
public class NotificationSvcImpl implements INotificationSvc, NotificationSetting{
	private static interface NotificationInfo {
		static String END_POINT = "https://api.telegram.org/" + TELEGRAM_BOT_TOKEN  + "/sendMessage";
	}
	
	private static URL endPoint;
	@Autowired
	private IGoodsDao goodsDao;
	public NotificationSvcImpl() throws MalformedURLException {
		endPoint = new URL(NotificationInfo.END_POINT);
	}

	
	@Override
	public boolean sendOrderMsg(OrderCart orderCart) throws IOException {
		String chatId = TestUser.getUser(orderCart.getUserId())
                                .getChatId();

		
		StringBuilder orderMsg = new StringBuilder();
		orderMsg.append(TestUser.getUser(orderCart.getUserId())
				                .getName()
				        + "님 주문해주셔서 감사합니다\n\n");
		orderMsg.append("=== 주문 내역 ===\n");
		
		for(OrderDto order: orderCart.getOrderList()) {
			orderMsg.append("상품번호: ");
			orderMsg.append(order.getGoodsId());
			orderMsg.append(" / 구매수량: ");
			orderMsg.append(order.getQty() + "\n");
		}
		
		return sendMessage(chatId, orderMsg.toString());
	}

	@Override
	public boolean sendLowStock() throws IOException {
		String chatId = "-1002329993155";
		StringBuilder message = new StringBuilder();
		
		List<GoodsEntity> lowStockGoods = goodsDao.getLowStockGoods();
		if(lowStockGoods.size() > 0){
			message.append("품절 임박인 제품이 있어요!\n\n");
			message.append("==== 상품 목록 =====\n");
			for(GoodsEntity e : lowStockGoods) {
				message.append("[" + e.getCategory() +"]");
				message.append(e.getName());
				message.append("(id: ");
				message.append(e.getId() + ")");
				message.append(" / 현재 수량: ");
				message.append(e.getStock() + "\n");
			}
			return sendMessage(chatId, message.toString());
		}
		return false;
	}
	
	private boolean sendMessage(String chatId, String msg) throws IOException {
		boolean result = false;
		HttpURLConnection conn = 
				(HttpURLConnection) endPoint.openConnection(); 
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setDoOutput(true);
		try(OutputStream out = conn.getOutputStream()){
			out.write("{\"chat_id\": \"".getBytes());
			out.write(chatId.getBytes());
			out.write("\", \"text\": \"".getBytes());
			out.write(msg.getBytes());
			out.write("\"}".getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("code = " + conn.getResponseCode());
		if(conn.getResponseCode() == 200) {
			result = true;
		}
		conn.disconnect();
		return result;
	}
	
	


}
