package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.IProductDto;
import service.IProductSerivce;
import service.impl.ProductSerivice;
import view.View;

public class ProductDetailCtrl implements IController{

	@Override
	public View process(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, SQLException, Exception {
		IProductSerivce svc = new ProductSerivice();
		IProductDto product = svc.getDetail(req, resp);
		req.setAttribute("item", product);
		return new View("/WEB-INF/views/productDetail.jsp");
	}

}
