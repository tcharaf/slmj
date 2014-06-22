package com.ct.salmjareb.service;

import java.util.List;

import com.ct.salmjareb.domain.Category;

public interface CategoryService {
	
	public Category addOrUpdate(Category category);
	public Boolean remove(Long categoryId);
	public Category getOne(Long categoryId);
	public List<Category> getAll(Integer start, Integer limit);
	public Long countAll();

}
