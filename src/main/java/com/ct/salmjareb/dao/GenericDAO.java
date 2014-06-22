package com.ct.salmjareb.dao;

import java.util.List;


public interface GenericDAO<T> {
	public T add(T t);
	public T update(T t);
	public Boolean remove(Long id);
	public T findOne(Long id);
	public List<T> findAll(Integer start, Integer limit);
	public Long countAll();
}
