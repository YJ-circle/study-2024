package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.StudentDto;
import entity.StudentInfoEntity;
import service.StudentSvcimpl;

@WebServlet("/addstudent")
public class StudentAdd2 extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/studentadd.jsp");
		dispatcher.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		
		int stu_id = Integer.parseInt(req.getParameter("stu_id"));
		int stu_major = Integer.parseInt(req.getParameter("stu_major"));
		String stu_phone = req.getParameter("stu_phone");
		String stu_name = req.getParameter("stu_name");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/addResult.jsp");
		
		StudentSvcimpl svc = new StudentSvcimpl();
		ArrayList<StudentDto> studentList = svc.addStudent(stu_id, stu_major, stu_name, stu_phone);
		if (studentList.size() != 0) {
			req.setAttribute("list", studentList);
			req.setAttribute("result", "입력  성공!");
			dispatcher.forward(req, resp);
		} else {
			req.setAttribute("result", "SQL 실행 오류");
			dispatcher.forward(req, resp);
		}

		
	}

	
}
