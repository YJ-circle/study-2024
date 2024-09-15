package Setting;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionFunc {
	private HttpSession session;
	public SessionFunc(HttpServletRequest req) {
		session = req.getSession();
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
			req.setAttribute("sessionId", session.getId());
			System.out.println("session = " + session.getId());
		} else {
			req.setAttribute("userName", "손님");
		}
	}
	
}
