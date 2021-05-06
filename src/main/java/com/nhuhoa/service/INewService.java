package com.nhuhoa.service;

import java.util.List;

import com.nhuhoa.model.NewModel;

public interface INewService {
	List<NewModel> findByCategoryId(Long categoryId);
	NewModel save(NewModel newModel);
	NewModel update(NewModel updateNew);
	void delete(Long[] ids);
	List<NewModel> findAll(Integer offset, Integer limit);
	Integer getTotalItem();
}
