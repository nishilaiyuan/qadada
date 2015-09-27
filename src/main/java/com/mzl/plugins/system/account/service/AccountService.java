package com.mzl.plugins.system.account.service;

import java.util.Map;

import com.mzl.core.base.service.BaseService;
import com.mzl.plugins.system.account.entity.Account;

public interface AccountService extends BaseService<Account> {

	public Account querySingleAccount(String account) throws Exception;

	public Map<String, Object> getGrid(Account account) throws Exception;

}
