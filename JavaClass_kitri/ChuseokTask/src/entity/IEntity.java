package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IEntity {
	void setEntity(ResultSet sqlResult) throws SQLException;
}
