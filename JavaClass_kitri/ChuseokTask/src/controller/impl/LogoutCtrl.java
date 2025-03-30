package controller.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.IController;
import view.View;
import view.ViewMethod;

public class LogoutCtrl implements IController{

	@Override
	public View process(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, SQLException, Exception {
		HttpSession session = req.getSession();
		session.invalidate();
		return new View(req.getParameter("requri"), ViewMethod.REDIRECT);
	}

}
