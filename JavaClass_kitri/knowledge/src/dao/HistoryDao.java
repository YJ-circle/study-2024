package dao;

import java.sql.SQLException;

import entity.HistoryEntity;
import setting.Database;

public class HistoryDao {
	public void add(HistoryEntity h) throws SQLException {
		try (Database db = new Database();) {
			String sql = "INSERT INTO userclickhistory (id, host, type, clickdate) " + "VALUES (?, ?, ?, SYSDATE) ";
			db.setStatement(sql);
			db.sqlAddString(1, h.getId());
			db.sqlAddString(2, h.getHost());
			db.sqlAddString(3, h.getType());
			db.sqlUpdate();
		}
	}
}
