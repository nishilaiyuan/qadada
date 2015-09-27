package com.mzl.plugins.system.account.dao;

import com.mzl.core.base.dao.BaseDao;
import com.mzl.plugins.system.account.entity.Account;

public interface AccountDao extends BaseDao<Account>{

	public Account querySingleAccount(String account) throws Exception;

}
