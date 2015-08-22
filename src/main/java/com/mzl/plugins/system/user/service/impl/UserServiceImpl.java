package com.mzl.plugins.system.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzl.plugins.system.user.dao.UserDao;
import com.mzl.plugins.system.user.entity.Account;
import com.mzl.plugins.system.user.service.UserService;

/**
 * @author Administrator
 *
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<Account> getAll(Account t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getPaginatedList(Account t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getRecordCount(Account t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Account t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Account t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account getOne(Account t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Account t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account querySingleAccount(String username) throws Exception {
		// TODO Auto-generated method stub
		return userDao.querySingleAccount(username);
	}



}
