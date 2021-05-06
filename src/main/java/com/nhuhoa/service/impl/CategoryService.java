package com.nhuhoa.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.nhuhoa.dao.ICategoryDAO;
import com.nhuhoa.dao.impl.AbstractDAO;
import com.nhuhoa.dao.impl.CategoryDAO;
import com.nhuhoa.model.CategoryModel;
import com.nhuhoa.service.ICategoryService;

public class CategoryService extends AbstractDAO<CategoryDAO> implements ICategoryService {
	@Inject
	private ICategoryDAO categoryDao;

	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}

}
