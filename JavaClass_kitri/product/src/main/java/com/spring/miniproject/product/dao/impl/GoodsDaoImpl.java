package com.spring.miniproject.product.dao.impl;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring.miniproject.product.dao.IGoodsDao;
import com.spring.miniproject.product.dao.mapper.ProductRowMapper;
import com.spring.miniproject.product.dao.sql.GoodsSQL;
import com.spring.miniproject.product.dto.GoodsDto;
import com.spring.miniproject.product.dto.OrderCart;
import com.spring.miniproject.product.dto.OrderDto;
import com.spring.miniproject.product.entity.GoodsEntity;


@Component("goodsDao")
public class GoodsDaoImpl implements IGoodsDao, GoodsSQL{
	
	@Autowired
	private JdbcTemplate jdbc;

	GoodsEntity goodsEntity;

	@Override
	public int insertGoods(GoodsDto goodsDto) {
			return jdbc.update(SQL_INSERT_GOODS, 
					           goodsDto.getName(), 
					           goodsDto.getCategory(), 
					           goodsDto.getPrice(),
							   goodsDto.getStock());
	}
	
	
	@Override
	public List<GoodsEntity> getGoodsList(){
		String sql= "SELECT * FROM goods ";
		return jdbc.query(sql, new ProductRowMapper());
	}
	
	
	@Override
	public GoodsEntity getGoodsById(int id){
	
		
		String sql= "SELECT * FROM goods"
				+ "  WHERE id = ? ";
		return jdbc.queryForObject(sql, new ProductRowMapper(), id);
	}
	
	@Override
	public int orderGoods(OrderCart orderCart){
		List<OrderDto> orderList = orderCart.getOrderList();
		int[][] intArrays = jdbc.batchUpdate(SQL_ORDER_GOODS,
						orderList,
						orderList.size(),
						(PreparedStatement ps, OrderDto dto) -> {
							ps.setInt(1, dto.getQty());
							ps.setInt(2, dto.getGoodsId());
							ps.setInt(3, dto.getGoodsId());
							
						});
		
		int orderResult = 0;
		for(int[] i : intArrays) {
			System.out.println("i = " + i);
			for(int j : i) {
				orderResult++;
			}
		}
		return orderResult;
		 
	}
	
	
	
	 public List<GoodsEntity> getLowStockGoods(){
		 int lowStockInt = 5;
		 return jdbc.query(SQL_LOW_STOCK_GOODS, new ProductRowMapper(), lowStockInt);
	 }
}