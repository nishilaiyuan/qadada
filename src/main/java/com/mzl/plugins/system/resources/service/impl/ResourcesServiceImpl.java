package com.mzl.plugins.system.resources.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzl.plugins.system.resources.dao.ResourcesDao;
import com.mzl.plugins.system.resources.entity.Resources;
import com.mzl.plugins.system.resources.service.ResourcesService;
import com.mzl.plugins.system.user.entity.Account;

/**
 * @author Administrator
 *
 */
@Service
public class ResourcesServiceImpl implements ResourcesService{

	@Autowired
	private ResourcesDao resourcesDao;
	
	@Override
	public List<Resources> getAll(Resources t) throws Exception {
		// TODO Auto-generated method stub
		return resourcesDao.getAll(t);
	}

	@Override
	public List<Resources> getPaginatedList(Resources t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getRecordCount(Resources t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Resources t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Resources t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Resources getOne(Resources t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Resources t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Resources> findAccountResourcess(Account account) {
		// TODO Auto-generated method stub
		return null;
	}


}
