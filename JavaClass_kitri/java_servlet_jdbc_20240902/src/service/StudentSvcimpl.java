package service;

import java.util.ArrayList;

import dao.StudentDao;
import dao.StudentDaoImpl;
import dto.StudentDto;
import entity.StudentInfoEntity;

public class StudentSvcimpl implements StudentSvc {
	
	public ArrayList<StudentDto> getStudentInfo() {
		ArrayList<StudentDto> stuDto = new ArrayList<StudentDto>();
		StudentDao stuDao = new StudentDaoImpl(); 
		StudentDto stuinfo = null;
		
		ArrayList<StudentInfoEntity> studentList = stuDao.getStudentInfo();
		for(StudentInfoEntity stu : studentList) {
			stuinfo = new StudentDto();
			stuinfo.setStu_id(stu.getStu_id());
			stuinfo.setStu_name(stu.getStu_name());
			stuDto.add(stuinfo);
		}
		return stuDto;
	}

}
