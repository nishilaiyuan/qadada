package com.mzl.plugins.system.user.dao;

import com.mzl.core.base.dao.BaseDao;
import com.mzl.plugins.system.user.entity.Account;

public interface UserDao extends BaseDao<Account>{

	public Account querySingleAccount(String username) throws Exception;

}
