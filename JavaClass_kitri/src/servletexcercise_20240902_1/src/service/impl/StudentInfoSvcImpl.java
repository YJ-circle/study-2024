package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.IStudentInfoDao;
import dao.impl.StudentInfoDaoImpl;
import dto.StudentInfoDto;
import entity.StudentInfoEntity;
import service.IStudentInfoSvc;

public class StudentInfoSvcImpl implements IStudentInfoSvc {
	
	@Override
	public List<StudentInfoDto> getStudentInfo() {
		List<StudentInfoDto> studDtoList = new ArrayList<StudentInfoDto>();
		IStudentInfoDao studDao = new StudentInfoDaoImpl();
		
		StudentInfoDto sidto = null;
		
		List<StudentInfoEntity> studentList = studDao.getStudentInfo();
		for(StudentInfoEntity se:studentList) {
			sidto = new StudentInfoDto();
			sidto.setId(se.getId());
			sidto.setName(se.getName());
			sidto.setAddress(se.getAddress());
			studDtoList.add(sidto);
		}
		return studDtoList;
	}

}
