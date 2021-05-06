package com.nhuhoa.dao;

import java.util.List;

import com.nhuhoa.model.NewModel;

public interface INewDao extends GenericDAO<NewModel> {
	List<NewModel> findByCategoryId(Long categoryId);
	Long save(NewModel newModel);
	NewModel findOne(Long id);
	void update(NewModel updateNew);
	void delete(Long id);
	List<NewModel> findAll(Integer offset, Integer limit);
	Integer getTotalItem();
}
