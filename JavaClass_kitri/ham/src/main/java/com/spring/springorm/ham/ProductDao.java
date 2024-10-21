package com.spring.springorm.ham;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("productDao")
public class ProductDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public int create(Product product) {
		return (int) hibernateTemplate.save(product);
	}
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public void update(Product product) {
		hibernateTemplate.update(product);
	}
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public void delete(Product product) {
		hibernateTemplate.delete(product);
	}
	public Product find(int id){
		return hibernateTemplate.get(Product.class, id);
	}
	public List<Product> findAll(){
		return hibernateTemplate.loadAll(Product.class);
	}
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
