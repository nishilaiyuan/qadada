package com.mzl.plugins.system.roles.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mzl.plugins.system.roles.dao.ResourcesRoleMappingDao;
import com.mzl.plugins.system.roles.entity.ResourcesRoleMapping;
import com.mzl.plugins.system.roles.service.ResourcesRoleMappingService;

@Service
public class ResourcesRoleMappingServiceImpl implements ResourcesRoleMappingService{

	@Resource
	private ResourcesRoleMappingDao resourcesRoleMappingDao;
	
	@Override
	public List<ResourcesRoleMapping> getAll(ResourcesRoleMapping t)
			throws Exception {
		// TODO Auto-generated method stub
		return this.resourcesRoleMappingDao.getAll(t);
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
		/**
		 * 1.查询角色的权限
		 * 2.删除角色的权限
		 * 3.批量插入权限
		 */
		List<ResourcesRoleMapping> list = getAll(t);
		if(null != list && list.size()>0){
			deleteBatch(list);
		}
		String ids[] = t.getIds().split(",");
		ResourcesRoleMapping temp = null;
		List<ResourcesRoleMapping> listTemp = new ArrayList<ResourcesRoleMapping>();
		for(int i=0 ;i<ids.length ; i++){
			temp = new ResourcesRoleMapping();
			temp.setRoleID(t.getRoleID());
			temp.setResourcesID(Long.valueOf(ids[i]));
			listTemp.add(temp);
		}
		saveBeatch(listTemp);
	}

	/**
	 * 批量插入
	 * @param listTemp
	 * @throws Exception 
	 */
	private void saveBeatch(List<ResourcesRoleMapping> list) throws Exception {
		// TODO Auto-generated method stub
		this.resourcesRoleMappingDao.saveBeatch(list);
	}

	/**
	 * 批量删除
	 * @param list
	 * @throws Exception 
	 */
	public void deleteBatch(List<ResourcesRoleMapping> list) throws Exception {
		// TODO Auto-generated method stub
		this.resourcesRoleMappingDao.deleteBatch(list);
	}

}
