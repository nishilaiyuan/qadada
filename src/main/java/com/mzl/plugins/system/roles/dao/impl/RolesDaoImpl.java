package com.mzl.plugins.system.roles.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mzl.core.base.dao.CommonDao;
import com.mzl.plugins.system.roles.dao.RolesDao;
import com.mzl.plugins.system.roles.entity.Roles;

@Repository
public class RolesDaoImpl extends CommonDao<Roles> implements RolesDao {

	@Override
	public List<Roles> getAll(Roles t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Roles> getPaginatedList(Roles t) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList("roles.getPaginatedList", t);
	}

	@Override
	public Long getRecordCount(Roles t) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne("roles.getRecordCount", t);
	}

	@Override
	public void delete(Roles t) throws Exception {
		// TODO Auto-generated method stub
		this.getSqlSession().delete("roles.delete", t);
	}

	@Override
	public void update(Roles t) throws Exception {
		// TODO Auto-generated method stub
		this.getSqlSession().update("roles.update", t);
	}

	@Override
	public Roles getOne(Roles t) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne("roles.select_one", t);
	}

	@Override
	public void save(Roles t) throws Exception {
		// TODO Auto-generated method stub
		this.getSqlSession().insert("roles.insert", t);
	}

}
