package controller.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.IController;
import service.ICartService;
import service.impl.CartService;
import view.View;

public class CartAddCtrl implements IController{

	@Override
	public View process(HttpServletRequest req, HttpServletResponse resp) {
		ICartService svc = new CartService();
		try {
			svc.addCart(req, resp);
			req.setAttribute("addResult", "장바구니에 상품을 담았습니다");
		} catch (SQLException e) {
			req.setAttribute("addResult", "장바구니 추가 실패");
			e.printStackTrace(System.out);
		}
		req.setAttribute("returnPage", req.getParameter("return"));
		return new View("/WEB-INF/views/addCartResult.jsp");
	}

}
