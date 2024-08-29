package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.StudentInfoDto;
import service.IStudentInfoSvc;
import service.impl.StudentInfoSvcImpl;


@WebServlet("/getinfo")
public class StudentInfoCtrl extends HttpServlet {
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
		IStudentInfoSvc sis = new StudentInfoSvcImpl();
		List<StudentInfoDto> studentList = sis.getStudentInfo();
		
		
		// 5. JSP 컨테이너 호출
		req.setAttribute("studentlist", studentList);
		RequestDispatcher requestDispatcher =
				req.getRequestDispatcher("/views/studentInfo.jsp");
		requestDispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		doGet(req, resp);
	}

}
