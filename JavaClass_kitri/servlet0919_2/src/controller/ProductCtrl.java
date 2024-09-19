package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.ProductDto;
import service.ProductSvc;


@WebServlet("/product")
public class ProductCtrl extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
	
			System.out.println(session.getId());
//NULL
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		List<ProductDto> product = new ProductSvc().getProduct();
		req.setAttribute("list", product);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/product.jsp");
		dispatcher.forward(req, resp);  //SESSION CREATED
		session = req.getSession(false);
		System.out.println(session.getId());
	}
	
}
