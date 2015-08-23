package com.mzl.plugins.system.log.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mzl.core.base.dao.CommonDao;
import com.mzl.plugins.system.log.dao.LogDao;
import com.mzl.plugins.system.log.entity.Log;

@Repository
public class LogDaoImpl extends CommonDao<Log> implements LogDao{

	@Override
	public List<Log> getAll(Log t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Log> getPaginatedList(Log t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getRecordCount(Log t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Log t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Log t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Log getOne(Log t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Log t) throws Exception {
		// TODO Auto-generated method stub
		
	}


}