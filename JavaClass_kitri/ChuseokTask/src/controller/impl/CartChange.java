package controller.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.Normalizer.Form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.env.IModule.IService;

import controller.IController;
import error.AccessViolation;
import service.impl.CartService;
import view.View;

public class CartChange implements IController{

	@Override
	public View process(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, SQLException, Exception {

//		int method = Integer.parseInt(req.getParameter("method")); 
		// json이면
		
		BufferedReader read = req.getReader();
		StringBuilder str = new StringBuilder();
		String line = null;
		while((line = read.readLine()) !=null) {
			System.out.println(str);
			str.append(line);
		}
		
		
		
//		if(method == 1) { // 수량 변경
//			req.setAttribute("addResult", "장바구니에 상품을 담았습니다");
//			req.setAttribute("returnPage", req.getParameter("return"));
//			
//			return new View("/WEB-INF/views/addCartResult.jsp");
//		} else if(method == 2) { //삭제
//			
//		} else {
//			throw new AccessViolation("잘못된 접근입니다");
//		}
		return new View("/WEB-INF/views/addCartResult.jsp");
	}
	

}
