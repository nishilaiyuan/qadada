package com.mzl.plugins.system.account.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mzl.core.base.dao.CommonDao;
import com.mzl.plugins.system.account.dao.AccountDao;
import com.mzl.plugins.system.account.entity.Account;

@Repository
public class AccountDaoImpl extends CommonDao<Account> implements AccountDao{

	@Override
	public List<Account> getAll(Account t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getPaginatedList(Account t) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList("account.getPaginatedList", t);
	}

	@Override
	public Long getRecordCount(Account t) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne("account.getRecordCount", t);
	}

	@Override
	public void delete(Account t) throws Exception {
		// TODO Auto-generated method stub
		this.getSqlSession().delete("account.delete", t);
	}

	@Override
	public void update(Account t) throws Exception {
		// TODO Auto-generated method stub
		this.getSqlSession().update("account.update", t);
	}

	@Override
	public Account getOne(Account t) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne("account.select_one", t);
	}

	@Override
	public void save(Account t) throws Exception {
		// TODO Auto-generated method stub
		this.getSqlSession().insert("account.insert", t);
	}

	@Override
	public Account querySingleAccount(String account) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne("account.querySingleAccount", account);
	}
}
