package com.nhuhoa.dao;

import java.util.List;

import com.nhuhoa.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel> {
	List<CategoryModel> findAll();
}
