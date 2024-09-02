package service;

import java.util.List;

import dao.StudentDao;
import dto.StudentDto;

public class StudentSvc {
	public List<StudentDto> getStudentInfo() {
		StudentDao stuDao = new StudentDao();
		List<StudentDto> stuList = stuDao.getStudentInfo();
		return stuList;
	}

}
