package service;

import java.util.ArrayList;

import dao.MajorDao;
import dao.StudentDao;
import dto.Dto;
import entity.Major;
import entity.Student;


public class InfoSvc {
	
	public ArrayList<Dto> getStudentInfo() {
		ArrayList<Dto> studDtoList = new ArrayList<Dto>();
		StudentDao studentDao = new StudentDao();
		MajorDao majorDao = new MajorDao();
		
		Dto dto = null;
		
		ArrayList<Student> studentList;
		ArrayList<Major> majorList;
		try {
			studentList = studentDao.getStduentInfo();
			majorList = majorDao.getMajorInfo();
			for(Student s:studentList) {
				dto = new Dto();
				dto.setId(s.getId());
				dto.setMajorCode(s.getMajorCode());
				dto.setName(s.getName());

				for(Major m: majorList) {
					if(dto.getMajorCode().equals(m.getMajorCode())) {
						dto.setMajorName(m.getMajorName());
					}
				}
				studDtoList.add(dto);
			}
			
			

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return studDtoList;
	}

}
