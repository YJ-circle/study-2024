package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ProductDto;
import dto.UserDto;
import service.ILoginService;
import service.IProductSerivce;
import service.impl.LoginService;
import service.impl.ProductSerivice;
import views.View;

public class PurchaseCtrl implements Controller{

	@Override
	public View process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userId = req.getParameter("userId");
		String productCode = req.getParameter("code");
		int price = Integer.parseInt(req.getParameter("price"));
		System.out.println(userId);
		System.out.println(productCode);
		System.out.println(price);
		return new View("/WEB-INF/views/product.jsp");
		
	}

}
