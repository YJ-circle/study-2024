package controller.impl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.IController;
import dto.ProductDto;
import dto.UserDto;
import entity.ProductEntity;
import service.ILoginService;
import service.IProductSerivce;
import service.IPurchaseService;
import service.impl.LoginService;
import service.impl.ProductSerivice;
import service.impl.PurchaseService;
import views.View;

public class PurchaseCtrl implements IController{

	@Override
	public View process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userId = req.getParameter("userId");
		if(userId == null) {
			return new ProductCtrl().process(req, resp);
		}
		String productCode = req.getParameter("code");
		int count = 1;
		IPurchaseService svc = new PurchaseService();
		ProductEntity buyProduct = svc.purchaseProduct(productCode, userId, count);
		if(buyProduct != null ) {
			req.setAttribute("product", buyProduct);
			req.setAttribute("buyCnt", count);
			req.setAttribute("userId", userId);
			return new View("/WEB-INF/views/purchase_success.jsp");
		} else {
			return new View("/WEB-INF/views/purchase_fail.jsp");
		}
	}

}
