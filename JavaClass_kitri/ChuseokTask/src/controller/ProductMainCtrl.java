package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Setting.SessionFunc;
import dto.ProductDto;
import service.IProductSerivce;
import service.impl.ProductSerivice;
import view.View;


public class ProductMainCtrl implements IController{
	private static final long serialVersionUID = 1L;

	@Override
	public View process(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, SQLException, Exception {
		// 로그인 체크
		

//		IProductSerivce productSvc = new ProductSerivice();
//		List<ProductDto> dto = null;
//		String category = req.getParameter("category");
//		if( category == null) {
//			dto = productSvc.getProduct(0);
//		} else {
//			dto = productSvc.getProduct(Integer.parseInt(category));
//		}
//		req.setAttribute("list", dto);
//		req.setAttribute("userId", userId);
//		req.setAttribute("userName", userName);
		return new View("/WEB-INF/views/product.jsp");
	}


	
}
