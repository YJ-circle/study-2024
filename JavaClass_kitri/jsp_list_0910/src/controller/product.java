package controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import service.Service;

@WebServlet("/basket")
public class product extends HttpServlet  {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException   {
		Service svc = new Service();
		List<String> list = new ArrayList<String>();
		
 		List<String> goods = svc.getGoods();
		req.setAttribute("goodsList", goods);
		RequestDispatcher disp =  req.getRequestDispatcher("/WEB-INF/basket.jsp");
		disp.forward(req,resp);
	}

	
}
