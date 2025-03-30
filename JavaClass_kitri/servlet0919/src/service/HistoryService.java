package service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.HistoryDao;
import entity.HistoryEntity;

public class HistoryService {
	public void add(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		HistoryEntity entity = new HistoryEntity(id,
												req.getRemoteHost(),
				                                 req.getParameter("type"));
		new HistoryDao().add(entity);
		
	}

}
