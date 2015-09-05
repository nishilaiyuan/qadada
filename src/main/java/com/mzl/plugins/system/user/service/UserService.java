package com.mzl.plugins.system.user.service;

import java.util.Map;

import com.mzl.core.base.service.BaseService;
import com.mzl.plugins.system.user.entity.Account;

public interface UserService extends BaseService<Account> {

	public Account querySingleAccount(String account) throws Exception;

	public Map<String, Object> getGrid(Account account) throws Exception;

}
