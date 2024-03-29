package com.mzl.plugins.system.resources.service;

import java.util.List;
import java.util.Map;

import com.mzl.core.base.service.BaseService;
import com.mzl.plugins.system.account.entity.Account;
import com.mzl.plugins.system.resources.entity.Resources;

public interface ResourcesService extends BaseService<Resources> {

	public List<Resources> findAccountResourcess(Account account);

	public Map<String, Object> getGrid(Resources resources) throws Exception;

	public String getTree() throws Exception;

}
