package dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import dao.IStudentInfoDao;
import entity.StudentInfoEntity;

public class StudentInfoDaoImpl implements IStudentInfoDao {

	@Override
	public List<StudentInfoEntity> getStudentInfo() {
		List<StudentInfoEntity> studentEntityList = new ArrayList<StudentInfoEntity>();
		StudentInfoEntity sentity;
		
		File file = new File("C:/Users/kitri03/Desktop/kitri/Git/JavaClass_Kitri/web/datasources/student.txt");
		FileReader fr;
		try {
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String oneLine = "";
//			A01:홍길동1:서울시1:02-222-2222:h1@daum.net
			while( (oneLine = br.readLine()) != null) {
				String[] studInfo =  oneLine.split(":");
				sentity = new StudentInfoEntity();
				sentity.setId(studInfo[0]);
				sentity.setName(studInfo[1]);
				sentity.setAddress(studInfo[2]);
				sentity.setTel(studInfo[3]);
				sentity.setMail(studInfo[4]);
				studentEntityList.add(sentity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return studentEntityList;
	}

}
