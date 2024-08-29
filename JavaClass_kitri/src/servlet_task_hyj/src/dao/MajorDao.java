package dao;

import java.io.*;
import java.util.ArrayList;

import entity.Major;
import entity.Student;

public class MajorDao {
	public ArrayList<Major> getMajorInfo() throws Exception{
		
		
		ArrayList<Major> majorList = new ArrayList<Major>();
		Major major;
		
		File file = new File("C:/Users/kitri03/Desktop/kitri/Git/JavaClass_Kitri/web/datasources/student2.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String oneLine = "";
	
		while((oneLine = br.readLine())!= null ) {
			String[] majorInfo = oneLine.split(":");
			major = new Major();
			major.setMajorCode(majorInfo[0]);
			major.setMajorName(majorInfo[1]);
			majorList.add(major);
		}
		return majorList;
		
	}
	

	
}
