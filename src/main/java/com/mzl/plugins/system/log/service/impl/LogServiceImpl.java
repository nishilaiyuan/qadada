package com.mzl.plugins.system.log.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzl.plugins.system.log.dao.LogDao;
import com.mzl.plugins.system.log.entity.Log;
import com.mzl.plugins.system.log.service.LogService;

@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private LogDao logDao;
	
	@Override
	public List<Log> getPaginatedList(Log t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getRecordCount(Log t) throws Exception {
		// TODO Auto-generated method stub
		//return logDao.getRecordCount(t);
		return logDao.getRecordCount(t);
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

	@Override
	public List<Log> getAll(Log t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
