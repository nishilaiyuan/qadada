package com.mzl.core.base.service;

import java.util.List;

public interface Base<T> {
	
	/**
	 * 返回分页数据
	 * @param t
	 * @return
	 */
	public List<T> getPaginatedList(T t)throws Exception;
	
	/**
	 * 查询记录总条数
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public Long getRecordCount(T t)throws Exception;
	
	/**
	 * 删除记录
	 * @param t
	 * @throws Exception
	 */
	public void delete(T t) throws Exception;
	
	/**
	 * 更新记录
	 * @param t
	 * @throws Exception
	 */
	public void update(T t) throws Exception;
	
	/**
	 * 查询一条记录
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public T getOne(T t) throws Exception;
	
	/**
	 * 增加记录
	 * @param t
	 * @throws Exception
	 */
	public void save(T t) throws Exception;
}
