package test;

import java.io.IOException;

import module.WebContainer;

public class RunMain {

	public static void main(String[] args) throws Exception {
		System.out.println("<<HTML>>");
		System.out.println("CRP 오류");
		System.out.println("===");
		String requestHtml01 = "test/test2.html";
		if(requestHtml01.endsWith(".html")) {
			new WebContainer().read(requestHtml01);
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println("정상");
		System.out.println("===");
		String requestHtml02 = "resource/test.html";
		if(requestHtml02.endsWith(".html")) {
			new WebContainer().read(requestHtml02);
		}
		
		System.out.println();
		System.out.println();
		System.out.println("파일명 오류");
		System.out.println("===");		
		String requestHtml03 = "resource/test2.html";
		if(requestHtml03.endsWith(".html")) {
			new WebContainer().read(requestHtml03);

		}
		
		System.out.println();
		System.out.println();
		System.out.println("<<jsp>>");
		System.out.println("CRP 오류");
		System.out.println("===");
		String requestjsp01 = "test/test2.jsp";
		if(requestjsp01.endsWith(".jsp")) {
			new WebContainer().read(requestjsp01);
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println("정상");
		System.out.println("===");
		String requestjsp02 = "resource/test.jsp";
		if(requestjsp02.endsWith(".jsp")) {
			new WebContainer().read(requestjsp02);
		}
		
		System.out.println();
		System.out.println();
		System.out.println("파일명 오류");
		System.out.println("===");		
		String requestjsp03 = "resource/test2.jsp";
		if(requestjsp03.endsWith(".jsp")) {
			new WebContainer().read(requestjsp03);

		}
		
		System.out.println();
		System.out.println();
		System.out.println("<<서블릿>>");
		System.out.println("CRP 오류");
		System.out.println("===");
		String request01 = "test/TestCtrl";
		if(request01.endsWith("")) {
			new WebContainer().read(request01);
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println("정상");
		System.out.println("===");
		String request02 = "resource/TestCtrl";
		if(request02.endsWith("")) {
			new WebContainer().read(request02);
		}
		
		System.out.println();
		System.out.println();
		System.out.println("파일명 오류");
		System.out.println("===");		
		String request03 = "resource/TestCtrl2";
		if(request03.endsWith("")) {
			new WebContainer().read(request03);

		}
//		String requestJsp = "/test/test.jsp";
//		String requestSvc = "/test/test";
		

	}

}
