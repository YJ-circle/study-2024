package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.CompanyGoodsDto;
import service.ICompanyGoodsInfoSvc;
import service.impl.CompanyGoodsInfoSvcImpl;

@WebServlet("/getcomgoodslist")
public class ComGoodsCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		// 1. 다국어 지원
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		// 2. 출력객체(PrintWriter) 얻어오기
		
		// 3. 파라메터 수신
		
		// 4. 데이터 처리
		ICompanyGoodsInfoSvc sis = new CompanyGoodsInfoSvcImpl();
		List<CompanyGoodsDto> comGoodsDtoList = sis.getCompanyGoodsInfo();
		
		// 5. JSP 컨테이너 호출
		req.setAttribute("comGoodsDtoList", comGoodsDtoList);
		RequestDispatcher requestDispatcher =
				req.getRequestDispatcher("/views/comGoodsInfo.jsp");
		requestDispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		doGet(req, resp);
	}

}
