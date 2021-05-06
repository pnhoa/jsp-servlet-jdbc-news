package com.nhuhoa.dao.impl;

import java.util.List;

import com.nhuhoa.dao.ICategoryDAO;
import com.nhuhoa.mapper.CategoryMapper;
import com.nhuhoa.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO{
	
	
	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM catgory";
		return query(sql, new CategoryMapper());
	}
	
	
}
