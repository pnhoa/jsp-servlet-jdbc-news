package com.nhuhoa.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.nhuhoa.dao.INewDao;
import com.nhuhoa.model.NewModel;
import com.nhuhoa.service.INewService;

public class NewService implements INewService{
	@Inject
	private INewDao newDao;

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		return newDao.findByCategoryId(categoryId);
	}

	@Override
	public NewModel save(NewModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		newModel.setCreatedBy("");
		Long newId = newDao.save(newModel);
		return newDao.findOne(newId);
	}
 
	@Override
	public NewModel update(NewModel updateNew) {
		NewModel  oldNew = newDao.findOne(updateNew.getId());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		updateNew.setModifiedBy("");
		newDao.update(updateNew);
		return newDao.findOne(updateNew.getId());
	}

	@Override
	public void delete(Long[] ids) {
		// TODO Auto-generated method stub
		for(Long id : ids) {
			newDao.delete(id);
		}
		
	}

	@Override
	public List<NewModel> findAll(Integer offset,Integer limit) {
		return newDao.findAll(offset,limit);
	}

	@Override
	public Integer getTotalItem() {
		return newDao.getTotalItem();
	}

}
