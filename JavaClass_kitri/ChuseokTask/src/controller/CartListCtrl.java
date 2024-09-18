package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ICartDto;
import service.ICartService;
import service.impl.CartService;
import view.View;

public class CartListCtrl implements IController{

	@Override
	public View process(HttpServletRequest req, HttpServletResponse resp) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		ICartService svc = new CartService();
		List<ICartDto> list = svc.getCart(req, resp);
		for(ICartDto dto:list) {
			System.out.println(dto);
		}
		req.setAttribute("cart", list);
		return new View("/WEB-INF/views/cartList.jsp");
	}

}
