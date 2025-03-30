package service;

import java.util.List;

import dto.HistoryDto;
import entity.ProductEntity;

public interface IPurchaseService {
	 ProductEntity purchaseProduct(String code, String id, int count);
	 List<HistoryDto> getBuyHistory(String id);
}
