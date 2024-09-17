package service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ICartDao;
import dao.impl.CartDao;
import dto.ICartDto;
import dto.impl.CartDto;
import entity.CartEntity;
import service.ICartService;

public class CartService implements ICartService{
	public boolean addCart(HttpServletRequest req, HttpServletResponse resp) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		CartEntity newCart = new CartEntity();
		// Check already added cart
		String item = req.getParameter("items");
		String userId = (String) req.getAttribute("userId");
		String sessionId = (String) req.getAttribute("sessionId");
		int qty = (int) req.getAttribute("qty");
		
		newCart.setGoodscode(item);
		newCart.setUserid(userId);
		newCart.setSessionid(sessionId);
		
		ICartDao dao = new CartDao();
		CartEntity oldCart = dao.getExistCartItem(newCart);
		
		newCart.oldToNew(oldCart);
		
		return dao.addCart(newCart);		
	}


}
