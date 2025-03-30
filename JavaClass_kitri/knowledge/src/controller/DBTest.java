package controller;

import java.sql.SQLException;
import java.util.List;

import common.database.Database;
import entity.TourEntity;

public class DBTest {
	public static void main(String[] args) throws SQLException {
		
		try(Database<TourEntity> tourdb = new Database<>(TourEntity.class);){
			tourdb.setStatement("SELECT seq, imagenamedwa, description, imagepath FROM imginfo ");
			List<TourEntity> tourList = tourdb.sqlSelectList();
			System.out.println(tourList);
		}
	}

}
