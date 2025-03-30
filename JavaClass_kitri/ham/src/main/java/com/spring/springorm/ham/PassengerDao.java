package com.spring.springorm.ham;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("passengerDao")
public class PassengerDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public int create(Passenger passenger) {
		return (int) hibernateTemplate.save(passenger);
	}
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public void update(Passenger passenger) {
		hibernateTemplate.update(passenger);
	}
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public void delete(Passenger passenger) {
		hibernateTemplate.delete(passenger);
	}
	public Passenger find(int id){
		return hibernateTemplate.get(Passenger.class, id);
	}
	public List<Passenger> findAll(){
		return hibernateTemplate.loadAll(Passenger.class);
	}
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
