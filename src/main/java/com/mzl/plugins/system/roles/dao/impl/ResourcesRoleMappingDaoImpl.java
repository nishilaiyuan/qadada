package com.mzl.plugins.system.roles.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mzl.core.base.dao.CommonDao;
import com.mzl.plugins.system.roles.dao.ResourcesRoleMappingDao;
import com.mzl.plugins.system.roles.entity.ResourcesRoleMapping;
import com.mzl.plugins.system.roles.entity.Roles;

@Repository
public class ResourcesRoleMappingDaoImpl extends CommonDao<Roles> implements ResourcesRoleMappingDao{

	@Override
	public List<ResourcesRoleMapping> getAll(ResourcesRoleMapping t)
			throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList("resourcesRoleMapping.select_all", t);
	}

	@Override
	public List<ResourcesRoleMapping> getPaginatedList(ResourcesRoleMapping t)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getRecordCount(ResourcesRoleMapping t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ResourcesRoleMapping t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ResourcesRoleMapping t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResourcesRoleMapping getOne(ResourcesRoleMapping t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(ResourcesRoleMapping t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)批量删除
	 * @see com.mzl.plugins.system.roles.dao.ResourcesRoleMappingDao#deleteBatch(java.util.List)
	 */
	@Override
	public void deleteBatch(List<ResourcesRoleMapping> list) throws Exception {
		// TODO Auto-generated method stub
		this.getSqlSession().delete("resourcesRoleMapping.delete_batch", list);
	}

	/* (non-Javadoc)批量更新
	 * @see com.mzl.plugins.system.roles.dao.ResourcesRoleMappingDao#saveBeatch(java.util.List)
	 */
	@Override
	public void saveBeatch(List<ResourcesRoleMapping> list) throws Exception {
		// TODO Auto-generated method stub
		this.getSqlSession().insert("resourcesRoleMapping.insert_batch", list);
	}

}
