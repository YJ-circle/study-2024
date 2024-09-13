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

import view.View;


public class ProductMainCtrl implements IController{
	private static final long serialVersionUID = 1L;

	@Override
	public View process(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, SQLException, Exception {
		// 접속주소 체크
		System.out.println(req.getRequestURL());
		if(isLoginPage(req)) {
			
			
		}
		
		
		return new View("/WEB-INF/views/product.jsp");
	}

	private boolean isLoginPage(HttpServletRequest req) {
		return "/product".equals(req.getAttribute("inPath"));
	}

	
}
