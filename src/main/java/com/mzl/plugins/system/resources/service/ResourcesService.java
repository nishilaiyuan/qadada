package com.mzl.plugins.system.resources.service;

import java.util.List;

import com.mzl.core.base.service.BaseService;
import com.mzl.plugins.system.resources.entity.Resources;
import com.mzl.plugins.system.user.entity.Account;

public interface ResourcesService extends BaseService<Resources> {

	public List<Resources> findAccountResourcess(Account account);

}