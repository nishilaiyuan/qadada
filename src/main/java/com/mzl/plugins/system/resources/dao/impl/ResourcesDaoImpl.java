package com.mzl.plugins.system.resources.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mzl.core.base.dao.CommonDao;
import com.mzl.plugins.system.resources.dao.ResourcesDao;
import com.mzl.plugins.system.resources.entity.Resources;

@Repository
public class ResourcesDaoImpl extends CommonDao<Resources> implements ResourcesDao{

	@Override
	public List<Resources> getAll(Resources t)
			throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList("resources.select",t);
	}

	@Override
	public List<Resources> getPaginatedList(
			Resources t)
			throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList("resources.getPaginatedList", t);
	}

	@Override
	public Long getRecordCount(
			Resources t)
			throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne("resources.getRecordCount", t);
	}

	@Override
	public void delete(Resources t)
			throws Exception {
		// TODO Auto-generated method stub
		this.getSqlSession().delete("resources.delete", t);
	}

	@Override
	public void update(Resources t)
			throws Exception {
		// TODO Auto-generated method stub
		this.getSqlSession().update("resources.update", t);
	}

	@Override
	public Resources getOne(Resources t)
			throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne("resources.select_one", t);
	}

	@Override
	public void save(Resources t)
			throws Exception {
		// TODO Auto-generated method stub
		this.getSqlSession().insert("resources.insert", t);
	}


}
