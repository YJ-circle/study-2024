package controller.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.IController;
import dto.IProductDto;
import service.IProductSerivce;
import service.impl.ProductSerivice;
import view.View;


public class ProductMainCtrl implements IController{
	@Override
	public View process(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, SQLException, Exception {

		IProductSerivce svc = new ProductSerivice();
		List<IProductDto> product = svc.getProduct(req, resp);
		req.setAttribute("list", product);
		return new View("/WEB-INF/views/product.jsp");
	}
}
