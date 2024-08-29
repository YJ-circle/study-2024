package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.ICompanyGoodsDao;
import dao.impl.CompanyGoodsDaoImpl;
import dto.CompanyGoodsDto;
import entity.CompanyGoodsEntity;
import service.ICompanyGoodsInfoSvc;

public class CompanyGoodsInfoSvcImpl implements ICompanyGoodsInfoSvc {

	@Override
	public List<CompanyGoodsDto> getCompanyGoodsInfo() {
		ICompanyGoodsDao cgsvc = new CompanyGoodsDaoImpl();
		List<CompanyGoodsDto> comGoodsDtoList = new ArrayList<CompanyGoodsDto>();
		CompanyGoodsDto companyGoodsDto = null;

		List<CompanyGoodsEntity> companyGoodsEntityList = cgsvc.getCompanyGoodsInfo();
		for(CompanyGoodsEntity companyGoodsEntity : companyGoodsEntityList) {
			companyGoodsDto = new CompanyGoodsDto();
			companyGoodsDto.setComName(companyGoodsEntity.getCe().getName());
			companyGoodsDto.setRepresentative(companyGoodsEntity.getCe().getRepresentative());
			companyGoodsDto.setCd(companyGoodsEntity.getGe().getCd());
			companyGoodsDto.setGoodsName(companyGoodsEntity.getGe().getName());
			comGoodsDtoList.add(companyGoodsDto);
		}
		
		return comGoodsDtoList;
	}
}
