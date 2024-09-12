package controller.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.IController;
import dto.HistoryDto;
import dto.UserDto;
import service.ILoginService;
import service.IPurchaseService;
import service.impl.LoginService;
import service.impl.PurchaseService;
import views.View;

public class PurchaseListCtrl implements IController {

	@Override
	public View process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ILoginService loginSvc = new LoginService();
		UserDto loginUser = loginSvc.getLoginUser();
		if(loginUser == null) {
			if(!loginSvc.isLoginStatus()) {
				return new View("/WEB-INF/views/NoLogin.jsp");
			} else {
				loginUser = loginSvc.getLoginUser();
			}
		}
		String userId = loginUser.getId();
		IPurchaseService svc = new PurchaseService();
		List<HistoryDto> history = svc.getBuyHistory(userId);
		req.setAttribute("history", history);
		req.setAttribute("userId", userId);
		return new View("/WEB-INF/views/purchaseList.jsp");
	}

}
