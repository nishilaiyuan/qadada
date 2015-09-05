package com.mzl.plugins.system.user.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mzl.core.base.dao.CommonDao;
import com.mzl.plugins.system.user.dao.UserDao;
import com.mzl.plugins.system.user.entity.Account;

@Repository
public class UserDaoImpl extends CommonDao<Account> implements UserDao{

	@Override
	public List<Account> getAll(Account t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getPaginatedList(Account t) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList("user.getPaginatedList", t);
	}

	@Override
	public Long getRecordCount(Account t) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne("user.getRecordCount", t);
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
		this.getSqlSession().insert("user.insert", t);
	}

	@Override
	public Account querySingleAccount(String account) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne("user.querySingleAccount", account);
	}
}
