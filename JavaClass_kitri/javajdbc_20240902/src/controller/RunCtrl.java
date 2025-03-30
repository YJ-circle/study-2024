package controller;

import java.util.List;

import dto.StudentDto;
import service.StudentSvc;

public class RunCtrl {
	public static void main(String[] args) {
		StudentSvc memberSvc = new StudentSvc();
		List<StudentDto> studentList = memberSvc.getStudentInfo();
		System.out.println("   학번      이름");
		System.out.println("==================");
		for(StudentDto s : studentList) {
			System.out.print(s.getStu_id()+"   ");
			System.out.println(s.getStu_name());
		}
		
	}
	
	

}
