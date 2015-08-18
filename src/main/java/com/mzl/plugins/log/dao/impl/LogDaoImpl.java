package com.mzl.plugins.log.dao.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mzl.plugins.log.dao.LogDao;

@Repository
public class LogDaoImpl implements LogDao{

	@Resource
    private SqlSession sqlSession;

}
