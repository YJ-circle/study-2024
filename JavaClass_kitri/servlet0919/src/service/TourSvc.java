package service;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import dao.TourDao;
import dto.TourDto;
import entity.TourEntity;

public class TourSvc {
	public TourDto getTour(int select) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		List<TourEntity> entityList = new TourDao().getTour();
		TourEntity selectTour = entityList.get(select);
		TourDto dto = new TourDto(selectTour.getImagename(),
				                  selectTour.getDescription(),
				                  selectTour.getImagepath());
		return dto;
	}
}
