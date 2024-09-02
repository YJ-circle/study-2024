package dao;

import java.util.ArrayList;

import dto.StudentDto;
import entity.StudentInfoEntity;

public interface StudentDao {
	ArrayList<StudentInfoEntity> getStudentInfo();

}
