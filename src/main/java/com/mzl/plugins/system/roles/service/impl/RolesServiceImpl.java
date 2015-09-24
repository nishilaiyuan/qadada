package com.mzl.plugins.system.roles.service.impl;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzl.plugins.system.roles.dao.RolesDao;
import com.mzl.plugins.system.roles.entity.ResourcesRoleMapping;
import com.mzl.plugins.system.roles.entity.Roles;
import com.mzl.plugins.system.roles.service.RolesService;

@Service
public class RolesServiceImpl implements RolesService{

	@Autowired
	private RolesDao rolesDao;
	
	@Override
	public List<Roles> getAll(Roles t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Roles> getPaginatedList(Roles t) throws Exception {
		// TODO Auto-generated method stub
		return rolesDao.getPaginatedList(t);
	}

	@Override
	public Long getRecordCount(Roles t) throws Exception {
		// TODO Auto-generated method stub
		return rolesDao.getRecordCount(t);
	}

	@Override
	public void delete(Roles t) throws Exception {
		// TODO Auto-generated method stub
		rolesDao.delete(t);
	}

	@Override
	public void update(Roles t) throws Exception {
		// TODO Auto-generated method stub
		rolesDao.update(t);
	}

	@Override
	public Roles getOne(Roles t) throws Exception {
		// TODO Auto-generated method stub
		return rolesDao.getOne(t);
	}

	@Override
	public void save(Roles t) throws Exception {
		// TODO Auto-generated method stub
		rolesDao.save(t);
	}

	@Override
	public Map<String, Object> getGrid(Roles entity) throws Exception {
		// TODO Auto-generated method stub
		List<Roles> resultList = null;
		Map<String, Object> map = new Hashtable<String, Object>();
		//分页列表
		resultList = this.getPaginatedList(entity);
		// 记录数
		long record = this.getRecordCount(entity);
		// 页数
		int pageCount = (int) Math.ceil(record / (double) entity.getRows());

		map.put("rows", resultList);
		map.put("page", entity.getPage());
		map.put("total", pageCount);
		map.put("records", record);
		return map;
	}

}
