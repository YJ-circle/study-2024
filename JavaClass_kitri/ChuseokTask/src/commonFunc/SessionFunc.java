package commonFunc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionFunc {
	private HttpSession session;
	public SessionFunc(HttpServletRequest req) {
		session = req.getSession();
//		session.setMaxInactiveInterval(5);
//		System.out.println("세션시간 5초로 설정됨");
//		System.out.println(session.getId());
	}
	
	public String getUserId() {
		return (String) session.getAttribute("userId");
	}
	
	public String getUserName() {
		return (String) session.getAttribute("userName");
	}
	
	public boolean isLogin() {
		return session.getAttribute("userId") != null;
	}
	
	public void setReqAttr(HttpServletRequest req) {
		if(isLogin()) {
			req.setAttribute("userId", getUserId());
			req.setAttribute("userName", getUserName());
		} else {
			req.setAttribute("userName", "손님");
		}

		req.setAttribute("sessionId", session.getId());
	}
	
}
