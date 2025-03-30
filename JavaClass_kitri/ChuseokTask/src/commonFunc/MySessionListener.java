package commonFunc;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("세션 죽는다!!!!!!");
		System.out.println(se.getSession().getId());
	}

}
