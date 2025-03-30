package dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import entity.TourEntity;
import setting.Database;

public class TourDao {
	public List<TourEntity> getTour() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		try(Database db = new Database();){
			db.setStatement("SELECT seq, imagename, description, imagepath FROM imginfo ");
			List<TourEntity> tourList = db.sqlSelectList(TourEntity.class);
			return tourList;
			
		}
		
	}
}
