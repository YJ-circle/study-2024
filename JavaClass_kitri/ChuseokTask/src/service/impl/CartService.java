package service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
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
	public boolean addCart(HttpServletRequest req, HttpServletResponse resp) throws SQLException{
		CartEntity newCart = new CartEntity();

		newCart.setGoodscode(req.getParameter("items"));
		newCart.setUserid((String)req.getAttribute("userId"));
		newCart.setSessionid((String) req.getAttribute("sessionId"));
		newCart.setQty(Integer.parseInt(req.getParameter("qty")));
		
		ICartDao dao = new CartDao();
		return dao.addCart(newCart);
	}
	
	public List<ICartDto> getCart(HttpServletRequest req, HttpServletResponse resp) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException{
		ICartDao dao = new CartDao();
		List<CartEntity> entityList = dao.getExitstCart("userid", (String)req.getAttribute("userId"));
		List<ICartDto> dtoList = new ArrayList<>();
		for(CartEntity e : entityList) {
			ICartDto dto = new CartDto();
			dto.setDto(e);
			dtoList.add(dto);
			
		}
		return dtoList;
		
	}


}
