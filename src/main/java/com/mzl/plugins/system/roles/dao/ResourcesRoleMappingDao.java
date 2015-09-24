package com.mzl.plugins.system.roles.dao;

import java.util.List;

import com.mzl.core.base.dao.BaseDao;
import com.mzl.plugins.system.roles.entity.ResourcesRoleMapping;

public interface ResourcesRoleMappingDao extends BaseDao<ResourcesRoleMapping>{

	void deleteBatch(List<ResourcesRoleMapping> list) throws Exception;

	void saveBeatch(List<ResourcesRoleMapping> list) throws Exception;

}
