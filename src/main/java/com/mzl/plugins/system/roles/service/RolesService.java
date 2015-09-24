package com.mzl.plugins.system.roles.service;

import java.util.Map;

import com.mzl.core.base.service.BaseService;
import com.mzl.plugins.system.roles.entity.Roles;

public interface RolesService extends BaseService<Roles>{

	public Map<String, Object> getGrid(Roles entity) throws Exception;

}
