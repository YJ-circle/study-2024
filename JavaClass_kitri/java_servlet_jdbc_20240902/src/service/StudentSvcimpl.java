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
	
	public ArrayList<StudentDto> addStudent(int stu_id, int stu_major, String stu_name, String stu_phone){
		
		ArrayList<StudentDto> stuDto = new ArrayList<StudentDto>();
		StudentDao stuDao = new StudentDaoImpl(); 
		StudentDto stuinfo = null;
		
		StudentInfoEntity addedStuInfo = stuDao.addStudent(stu_id, stu_major, stu_name, stu_phone);
		if(addedStuInfo != null) {
			stuinfo = new StudentDto();
			stuinfo.setStu_id(addedStuInfo.getStu_id());
			stuinfo.setStu_name(addedStuInfo.getStu_name());
			stuDto.add(stuinfo);
		}
		return stuDto;
	}

}
