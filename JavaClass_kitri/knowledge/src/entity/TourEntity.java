package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TourEntity implements IEntity {
	int seq;
	String imagename;
	String description;
	String imagepath;

	@Override
	public void setEntity(ResultSet sqlResult) throws SQLException {
		seq = sqlResult.getInt("seq");
		imagename = sqlResult.getString("imagename");
		description = sqlResult.getString("description");
		imagepath = sqlResult.getString("imagepath");

	}

	public int getSeq() {
		return seq;
	}

	public String getImagename() {
		return imagename;
	}

	public String getDescription() {
		return description;
	}

	public String getImagepath() {
		return imagepath;
	}
	
	

}
