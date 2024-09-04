package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberInfoDto;
import service.MemberSvc;

@WebServlet("/getMember")
public class MemberList extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		MemberSvc svc = new MemberSvc();
		ArrayList<MemberInfoDto> memberList = null;
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member_info.jsp");
		
		if(id == null) {
			// id 파라미터 값이 없으면 전체 회원 목록을 반환 합니다.
			memberList = svc.getMember();
		}  
		else { //id 파라미터 값이 있으면 id 길이를 검증 합니다.
			
			//id길이가 11, 13이 아니면 길이 오류를 반환해줍니다.
			if(id.length()!=11&&id.length()!=13) {
				resp.setStatus(400); //상태코드 400설정
				req.setAttribute("resultCode", 400); // HTML 출력용 상태코드
				req.setAttribute("resultMsg", "입력한 id 길이가 유효하지 않습니다."); // HTML 출력 메시지
				dispatcher.forward(req, resp);
				return;
				
			/*id 길이가 13인 경우 핸드폰번호에 "-"가 포함될 가능성이 높으므로
			  "-" 를 제거해줍니다. */
				
			} else if (id.length() == 13) {
				id = id.replace("-", "");
			}
			
			//member서비스에서 회원 id로 일치하는 회원 목록을 받아옵니다.
			memberList = svc.getMember(id);
			
			/*List size가 0이면 (일치하는 회원이 없으면)
			  204 : 요청은 받았지만 반환값 없음을 보내줍니다.
			  */
			if(memberList.size()==0) {
				req.setAttribute("resultCode", 204);
				req.setAttribute("resultMsg", "일치하는 회원이 없습니다");
				dispatcher.forward(req, resp);
				return;
			}
			
		}
		
		req.setAttribute("resultCode", 200);
		req.setAttribute("list", memberList);
		dispatcher.forward(req, resp);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}
