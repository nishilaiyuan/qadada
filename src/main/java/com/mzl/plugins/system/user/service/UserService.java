package com.mzl.plugins.system.user.service;

import com.mzl.core.base.service.BaseService;
import com.mzl.plugins.system.user.entity.Account;

public interface UserService extends BaseService<Account> {

	public Account querySingleAccount(String username) throws Exception;

}
