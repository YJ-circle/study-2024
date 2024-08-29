package dao;

import java.io.*;
import java.util.ArrayList;

import entity.Student;

public class StudentDao {
	public ArrayList<Student> getStduentInfo() throws Exception{
		
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		Student student;
		
		File file = new File("C:/Users/kitri03/Desktop/kitri/Git/JavaClass_Kitri/web/datasources/student1.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String oneLine = "";
	
		while((oneLine = br.readLine())!= null ) {
			String[] studentInfo = oneLine.split(":");
			student = new Student();
			student.setId(studentInfo[0]);
			student.setMajorCode(studentInfo[1]);
			student.setName(studentInfo[2]);
			studentList.add(student);
		}
		return studentList;
		
	}
	

	
}
