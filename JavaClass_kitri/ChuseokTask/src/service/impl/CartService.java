package service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ICartDao;
import dao.impl.CartDao;
import dto.ICartDto;
import service.ICartService;

public class CartService implements ICartService{
	public List<ICartDto> addCartSession(HttpServletRequest req, HttpServletResponse resp) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		// Check already added cart
		String item = req.getParameter("items");
		String id = (String) req.getAttribute("userId");
		String colName = "userId";
		
		if(id == null) {
			id = (String) req.getAttribute("sessionId");
			colName = "sessionId";
		}
		
		ICartDao dao = new CartDao();
		dao.getExistCart(colName, id, item);
		return null;
		
	}


}
