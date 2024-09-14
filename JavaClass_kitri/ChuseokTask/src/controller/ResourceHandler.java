package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import view.View;


@WebServlet("/assert/*")
public class ResourceHandler extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VIEWS_FOLDER = "C:/Users/kitri03/Desktop/kitri/Git/JavaClass_Kitri/ChuseokTask/WebContent/WEB-INF/views";

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("WEB_ROOT", req.getContextPath());
		String path = req.getPathInfo();
		String referer = req.getHeader("Referer");
		System.out.println(referer);
		File file = null;
		
		
		//Referer Check
		if (path.contains("404.css")) {
			resp.setContentType("text/css");
		}

		
		else if (referer == null || !referer.contains("/chu/web")) {
			 errorPage(req, resp); return;
		}
		
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		file = new File(VIEWS_FOLDER + path);
		InputStream inputStream = new FileInputStream(file);
		OutputStream outStream = resp.getOutputStream();
		byte[] buffer = new byte[1024];
		int bytes = -1;
		while((bytes = inputStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytes);
		}
	}


	private void errorPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("errorMsg", "잘못된 접근입니다.");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		new View("/WEB-INF/views/error.jsp").render(req, resp);
	}



}
