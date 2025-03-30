package dao;

import java.util.ArrayList;

import dto.StudentDto;
import entity.StudentInfoEntity;

public interface StudentDao {
	ArrayList<StudentInfoEntity> getStudentInfo();
	StudentInfoEntity addStudent(int stu_id, int stu_major, String stu_name, String stu_phone);

}
