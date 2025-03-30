package dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import dao.ICompanyGoodsDao;
import entity.CompanyEntity;
import entity.CompanyGoodsEntity;
import entity.GoodsEntity;

public class CompanyGoodsDaoImpl implements ICompanyGoodsDao {

	@Override
	public List<CompanyGoodsEntity> getCompanyGoodsInfo() {
		
		List<CompanyGoodsEntity> comgoodsEntityList = new ArrayList<CompanyGoodsEntity>();
		CompanyGoodsEntity companyGoodsEntity = null;
		CompanyEntity comEntity = null;
		GoodsEntity goodsEntity = null;
		
		File comFile = new File("D:/eclipse-jee-2020-12-R-win32-x86_64/workspace/servletexcercise_20240902_2/web/datasources/company.txt");
		File goodsFile = new File("D:/eclipse-jee-2020-12-R-win32-x86_64/workspace/servletexcercise_20240902_2/web/datasources/goods.txt");
		try {
			FileReader comFr = new FileReader(comFile);
			FileReader goodsFr = new FileReader(goodsFile);
			BufferedReader comBr = new BufferedReader(comFr);
			BufferedReader goodsBr = new BufferedReader(goodsFr);
			String comOneLine = "";
			String goodsOneLine = "";

			while( ((comOneLine = comBr.readLine()) != null) && 
					((goodsOneLine = goodsBr.readLine()) != null) ) {
				companyGoodsEntity = new CompanyGoodsEntity();
				comEntity = new CompanyEntity();
				String[] comElements = comOneLine.split(":");
				comEntity.setCd(comElements[0]);
				comEntity.setTel(comElements[1]);
				comEntity.setName(comElements[2]);
				comEntity.setRepresentative(comElements[3]);
				comEntity.setAddress(comElements[4]);

				goodsEntity = new GoodsEntity();
				String[] goodsElements = goodsOneLine.split(":");
				goodsEntity.setCd(goodsElements[0]);
				goodsEntity.setName(goodsElements[1]);
				goodsEntity.setAddress(goodsElements[2]);
				goodsEntity.setTel(goodsElements[3]);
				
				companyGoodsEntity.setCe(comEntity);
				companyGoodsEntity.setGe(goodsEntity);
				comgoodsEntityList.add(companyGoodsEntity);
			}
			
			comBr.close();
			goodsBr.close();
			comFr.close();
			goodsFr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return comgoodsEntityList;
	}
}
