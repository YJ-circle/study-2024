package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import view.View;
import view.ViewMethod;

@WebServlet("/form2")
public class formctrlTest extends HttpServlet{
	private final String PATH = "C:/Users/kitri03/Desktop/kitri/Git/JavaClass_Kitri/servlet0919/WebContent/WEB-INF/views/";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		
		if(session != null && session.getAttribute("saved") != null) {
			String path = ((String)session.getAttribute("saved")).split("WEB-INF")[1];
			new View("/WEB-INF"+path).render(req, resp);
			return;
		}


		new View("/WEB-INF/views/form2.jsp").render(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		if(isRemoveMethod(req)) {
			File file = new File((String) session.getAttribute("saved"));
			file.delete();
			session.invalidate();
			new View("/servlet0919/form2", ViewMethod.REDIRECT).render(req, resp);
			return;
		}
		
		if(isAddMethod(req)) {
			
			String orderItem = req.getParameterValues("items").toString();
			String boxingType = req.getParameter("boxing");
			String name = req.getParameter("name");
			String addr = req.getParameter("addr");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			
			File form = new File(PATH + "form2.jsp");
			FileReader fr = new FileReader(form);
			BufferedReader br = new BufferedReader(fr);
			String line;
			
			
			File saveFile = new File(PATH  + session.getId() + ".jsp");
			FileWriter fw = new FileWriter(saveFile);
			
			
			StringBuilder output = new StringBuilder();
			while((line = br.readLine()) != null) {
				
				//상품 선택 처리
				if(line.contains("p3") && orderItem.contains("p3")){
					line = line.replace("/>", " checked disabled />");
				}
				
				if(line.contains("p5") && orderItem.contains("p5")){
					line = line.replace("/>", " checked disabled />");
				}
				
				if(line.contains("h3") && orderItem.contains("h3")){
					line = line.replace("/>", " checked disabled />");
				}
				
				if(line.contains("h5") && orderItem.contains("h5")){
					line = line.replace("/>", " checked disabled />");
				}
				
				//포장 선택 처리
				if(line.contains("p1") && boxingType.equals("p1")){
					line = line.replace("/>", " checked disabled />");
				}

				if(line.contains("p2") && boxingType.equals("p2")){
					line = line.replace("/>", " checked disabled />");
				}
				
				//텍스트 입력 처리
				if(line.contains("이름: ")){
					line = line.replace("value=\"", " value=\"" + name);
				}
				
				if(line.contains("배송주소: ")){
					line = line.replace("value=\"", " value=\"" + addr);
				}
				
				if(line.contains("이메일: ")){
					line = line.replace("value=\"", " value=\"" + email);
				}
				
				if(line.contains("연락처: ")){
					line = line.replace("value=\"", " value=\"" + phone);
				}
				output.append(line+"\n");

			}
			
			fw.write(output.toString());
			fw.close();
			br.close();
			fr.close();
			
			session.setAttribute("saved", saveFile.getAbsolutePath());
			
			

			
		} 
		
		new View("/servlet0919/form2", ViewMethod.REDIRECT).render(req, resp);

		
	}


	private boolean isRemoveMethod(HttpServletRequest req) {
		return req.getParameter("method") != null && req.getParameter("method").equals("remove");
	}

	private boolean isAddMethod(HttpServletRequest req) {
		return req.getParameter("method") != null && req.getParameter("method").equals("add");
	}
	
}
