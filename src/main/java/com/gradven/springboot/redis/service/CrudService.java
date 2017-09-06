package com.gradven.springboot.redis.service;

import com.gradven.springboot.redis.model.Paging;

/**
 *
 * @author liuhangjun
 *
 */
public interface CrudService<T> {
	
	T get(Long id);
	
	T get(T model);
	
	Paging<T> getPaging(T model);
	
	void add(T model);
	
	void update(T model);
	
	void delete(Long id);
	
	void delete(T model);

}
