package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.rmi.server.Dispatcher;

@WebServlet("/calcTest")
public class calcTest3 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long i1 = System.currentTimeMillis();
		String s = "hello";
		for(int i=0; i <100000; i++) {
			i++;
			s += "hello";
		}
		long result = System.currentTimeMillis() - i1;
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member_join.jsp");
		req.setAttribute("test", result);
		dispatcher.forward(req, resp);
	}



	
}
