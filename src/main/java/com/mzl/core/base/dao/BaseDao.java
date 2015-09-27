package com.mzl.core.base.dao;

import java.util.List;

 
/** 
 * 此类描述的是： 基本dao接口
 * @author: maozhanlei/毛占磊
 * @version: v1.0 
 * @dateTime：2015年9月27日 下午10:15:02
 */ 
public interface BaseDao<T> {
	
	/** 
	 * 此方法描述的是： 获得所有的列表数据
	 * @author: maozhanlei 
	 * @dateTime：2015年9月27日 下午10:15:14
	 */ 
	public List<T> getAll(T entity) throws Exception;
	 
	/** 
	 * 此方法描述的是： 获得分页数据
	 * @author: maozhanlei 
	 * @dateTime：2015年9月27日 下午10:15:28
	 */ 
	public List<T> getPaginatedList(T entity) throws Exception;
	
	/** 
	 * 此方法描述的是： 获得记录总数
	 * @author: maozhanlei 
	 * @dateTime：2015年9月27日 下午10:15:39
	 */ 
	public Long getRecordCount(T entity) throws Exception;
	 
	/** 
	 * 此方法描述的是： 删除记录
	 * @author: maozhanlei 
	 * @dateTime：2015年9月27日 下午10:15:54
	 */ 
	public void delete(T entity) throws Exception;
	 
	/** 
	 * 此方法描述的是： 更新记录
	 * @author: maozhanlei 
	 * @dateTime：2015年9月27日 下午10:16:05
	 */ 
	public void update(T entity) throws Exception;
	 
	/** 
	 * 此方法描述的是： 获得一条记录
	 * @author: maozhanlei 
	 * @dateTime：2015年9月27日 下午10:16:14
	 */ 
	public T getOne(T entity) throws Exception;
	
	 
	/** 
	 * 此方法描述的是： 保存记录
	 * @author: maozhanlei 
	 * @dateTime：2015年9月27日 下午10:16:31
	 */ 
	public void save(T entity) throws Exception;
}