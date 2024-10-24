package com.spring.miniproject.product.service.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.miniproject.product.config.NotificationSetting;
import com.spring.miniproject.product.config.TestUser;
import com.spring.miniproject.product.dao.IGoodsDao;
import com.spring.miniproject.product.dto.OrderCart;
import com.spring.miniproject.product.dto.OrderDto;
import com.spring.miniproject.product.entity.GoodsEntity;
import com.spring.miniproject.product.service.INotificationSvc;

@Component("notiSvc")
public class NotificationSvcImpl implements INotificationSvc, NotificationSetting{
	static String END_POINT = "https://api.telegram.org/" + TELEGRAM_BOT_TOKEN  + "/sendMessage";
	private static URL endPoint;
	private static TestUser testUser = TestUser.getInstance();
	@Autowired
	private IGoodsDao goodsDao;
	
	public NotificationSvcImpl() throws MalformedURLException {
		endPoint = new URL(END_POINT);
	}

	
	@Override
	public boolean sendOrderMsg(List<OrderCart> orderList) throws IOException {
		String userId = orderList.get(0).getUserId();
		String chatId = testUser.getUser(userId)
                                .getChatId();

		
		StringBuilder orderMsg = new StringBuilder();
		orderMsg.append(testUser.getUser(userId)
				                .getName()
				        + "님 주문해주셔서 감사합니다\n\n");
		orderMsg.append("=== 주문 내역 ===\n");
		
		for(OrderCart order: orderList) {
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
		String jsonPayload = String.format("{\"chat_id\": \"%s\", \"text\": \"%s\"}", 
							 chatId, msg);
		try(OutputStream out = conn.getOutputStream()){
			out.write(jsonPayload.getBytes("UTF-8"));
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(conn.getResponseCode() == 200) {
			result = true;
		} else {
			System.out.println("code = " + conn.getResponseCode());
			System.out.println(conn.getResponseMessage());
		}
		conn.disconnect();
		return result;
	}
	
	


}
