package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.HistoryDao;
import dao.ProductDao;
import dto.HistoryDto;
import entity.HistoryEntity;
import entity.ProductEntity;
import service.IPurchaseService;

public class PurchaseService implements IPurchaseService{
	public ProductEntity purchaseProduct(String code, String id, int count) {
		ProductDao dao = new ProductDao();
		int purchaseCnt = dao.purchaseProduct(code, id, count);
		if(purchaseCnt > 0) {
			return dao.getProductInfo(code);
		}
		return null; 
	}
	
	public List<HistoryDto> getBuyHistory(String id){
		List<HistoryDto> dto = new ArrayList<>();
		List<HistoryEntity> list = new HistoryDao().getBuyHistory(id);
		for(HistoryEntity h : list) {
			dto.add(new HistoryDto(h.getBuyDate(), 
							       h.getImgpath(), 
							       h.getCategory(),
							       h.getName(),
							       h.getQty()));
			
		}
		return dto;
		
	}
	
		
}
