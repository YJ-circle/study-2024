package com.kitri.springboot;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDao extends CrudRepository<Post, Integer>{
	
	List<Post> findAll();
}
