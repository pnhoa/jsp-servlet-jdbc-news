package com.nhuhoa.service;

import java.util.List;

import com.nhuhoa.dao.GenericDAO;
import com.nhuhoa.dao.impl.CategoryDAO;
import com.nhuhoa.model.CategoryModel;

public interface ICategoryService extends GenericDAO<CategoryDAO> {
	List<CategoryModel> findAll();
}
