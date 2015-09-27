package com.mzl.plugins.system.account.service.impl;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzl.plugins.system.account.dao.AccountDao;
import com.mzl.plugins.system.account.entity.Account;
import com.mzl.plugins.system.account.service.AccountService;

/**
 * @author Administrator
 *
 */
@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountDao accountDao;
	
	@Override
	public List<Account> getAll(Account t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getPaginatedList(Account t) throws Exception {
		// TODO Auto-generated method stub
		return accountDao.getPaginatedList(t);
	}

	@Override
	public Long getRecordCount(Account t) throws Exception {
		// TODO Auto-generated method stub
		return accountDao.getRecordCount(t);
	}

	@Override
	public void delete(Account t) throws Exception {
		// TODO Auto-generated method stub
		this.accountDao.delete(t);
	}

	@Override
	public void update(Account t) throws Exception {
		// TODO Auto-generated method stub
		this.accountDao.update(t);
	}

	@Override
	public Account getOne(Account t) throws Exception {
		// TODO Auto-generated method stub
		return this.accountDao.getOne(t);
	}

	@Override
	public void save(Account t) throws Exception {
		// TODO Auto-generated method stub
		accountDao.save(t);
	}

	@Override
	public Account querySingleAccount(String account) throws Exception {
		// TODO Auto-generated method stub
		return accountDao.querySingleAccount(account);
	}

	@Override
	public Map<String, Object> getGrid(Account account) throws Exception {
		// TODO Auto-generated method stub
		List<Account> resultList = null;
		Map<String, Object> map = new Hashtable<String, Object>();
		//分页列表
		resultList = this.getPaginatedList(account);
		// 记录数
		long record = this.getRecordCount(account);
		// 页数
		int pageCount = (int) Math.ceil(record / (double) account.getRows());

		map.put("rows", resultList);
		map.put("page", account.getPage());
		map.put("total", pageCount);
		map.put("records", record);
		return map;
	}



}
