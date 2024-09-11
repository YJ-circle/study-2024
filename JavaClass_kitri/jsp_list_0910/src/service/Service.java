package service;

import java.util.List;

import dao.Dao;

public class Service {

	public List<String> getGoods() {
		Dao dao = new Dao();
		List<String> goods = dao.getGoods();
		return goods;
	}
}
