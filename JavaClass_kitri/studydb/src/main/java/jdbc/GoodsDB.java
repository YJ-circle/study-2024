package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.studydb.entity.GoodsEntity;

public class GoodsDB extends Database2<GoodsEntity> {

	@Override
	public GoodsEntity getBean() {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("classpath:/com/spring/studydb/config/config.xml");
		return (GoodsEntity) ctx.getBean("goodsEntity");
	}

	@Override
	public GoodsEntity setEntity(GoodsEntity entity, ResultSet rs) {
	    try {
		    entity.setGoodscd(rs.getString("FACTORY"));
		    entity.setGoodsname(rs.getString("NAME"));
			entity.setGoodsprice(rs.getInt("PRICE"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return entity;
	}


}
