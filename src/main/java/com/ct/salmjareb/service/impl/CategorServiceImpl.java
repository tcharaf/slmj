package com.ct.salmjareb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.salmjareb.dao.CategoryDAO;
import com.ct.salmjareb.domain.Category;
import com.ct.salmjareb.service.CategoryService;

@Service
public class CategorServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Override
	public Category addOrUpdate(Category category) {
		if(category.getCategoryId() == null){
			return categoryDAO.add(category);
		}
		return categoryDAO.update(category);
	}

	@Override
	public Boolean remove(Long categoryId) {
		return categoryDAO.remove(categoryId);
	}

	@Override
	public Category getOne(Long categoryId) {
		return categoryDAO.findOne(categoryId);
	}

	@Override
	public List<Category> getAll(Integer start, Integer limit) {
		return categoryDAO.findAll(start, limit);
	}

	@Override
	public Long countAll() {
		return categoryDAO.countAll();
	}

}
