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

public class ProductCtrl implements Controller{

	@Override
	public View process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//로그인 체크
		ILoginService loginSvc = new LoginService();
		if(!loginSvc.isLoginStatus()) {
			return new View("/WEB-INF/views/NoLogin.jsp");
		}
		
		
		UserDto loginUser = loginSvc.getLoginUser();
		String userName = loginUser.getName();
		String userId = loginUser.getId();
		IProductSerivce productSvc = new ProductSerivice();
		List<ProductDto> dto = null;
		String category = req.getParameter("category");
		if( category == null) {
			dto = productSvc.getProduct(0);
		} else {
			dto = productSvc.getProduct(Integer.parseInt(category));
		}
		req.setAttribute("list", dto);
		req.setAttribute("userId", userId);
		req.setAttribute("userName", userName);
		return new View("/WEB-INF/views/product.jsp");
		
	}

}
