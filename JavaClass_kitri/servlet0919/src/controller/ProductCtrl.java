package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.ProductDto;
import service.ProductSvc;
import view.View;


@WebServlet("/product")
public class ProductCtrl extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("id") == null) {
			req.setAttribute("result", "로그인 후 이용하세요");
			new View("/WEB-INF/views/login.jsp").render(req, resp);
			return;
		}
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		List<ProductDto> product;
		try {
			product = new ProductSvc().getProduct();
			req.setAttribute("list", product);
			new View("/WEB-INF/views/product.jsp").render(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
}
