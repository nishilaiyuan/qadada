package com.mzl.core.base.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;

public class CommonDao<T> {
	@Resource
    private SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
}
