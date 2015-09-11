package com.mzl.plugins.system.resources.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.mzl.plugins.system.resources.dao.ResourcesDao;
import com.mzl.plugins.system.resources.entity.Resources;
import com.mzl.plugins.system.resources.service.ResourcesService;
import com.mzl.plugins.system.user.entity.Account;

/**
 * @author Administrator
 *
 */
@Service
public class ResourcesServiceImpl implements ResourcesService{

	@Autowired
	private ResourcesDao resourcesDao;
	
	@Override
	public List<Resources> getAll(Resources t) throws Exception {
		// TODO Auto-generated method stub
		return resourcesDao.getAll(t);
	}

	@Override
	public List<Resources> getPaginatedList(Resources t) throws Exception {
		// TODO Auto-generated method stub
		return resourcesDao.getPaginatedList(t);
	}

	@Override
	public Long getRecordCount(Resources t) throws Exception {
		// TODO Auto-generated method stub
		return resourcesDao.getRecordCount(t);
	}

	@Override
	public void delete(Resources t) throws Exception {
		// TODO Auto-generated method stub
		this.resourcesDao.delete(t);
	}

	@Override
	public void update(Resources t) throws Exception {
		// TODO Auto-generated method stub
		this.resourcesDao.update(t);
	}

	@Override
	public Resources getOne(Resources t) throws Exception {
		// TODO Auto-generated method stub
		return resourcesDao.getOne(t);
	}

	@Override
	public void save(Resources t) throws Exception {
		// TODO Auto-generated method stub
		this.resourcesDao.save(t);
	}

	@Override
	public List<Resources> findAccountResourcess(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getGrid(Resources resources) throws Exception {
		// TODO Auto-generated method stub
		List<Resources> resultList = null;
		Map<String, Object> map = new Hashtable<String, Object>();
		//分页列表
		resultList = this.getPaginatedList(resources);
		// 记录数
		long record = this.getRecordCount(resources);
		// 页数
		int pageCount = (int) Math.ceil(record / (double) resources.getRows());

		map.put("rows", resultList);
		map.put("page", resources.getPage());
		map.put("total", pageCount);
		map.put("records", record);
		return map;
	}

	@Override
	public String getTree() throws Exception {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = this.getTreeList();
		if (list == null) {
			list = new ArrayList<Map<String, Object>>();
		}
		String treeStr = JSONArray.toJSONString(list);
		return treeStr;
	}

	private List<Map<String, Object>>  getTreeList() throws Exception {
		// TODO Auto-generated method stub
		List<Resources> resourcesList = this.getAll(null);
		// 合成树形数据
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		if (resourcesList != null) {
			for (Resources resources : resourcesList) {
				// 树形参数
				if("0".equals(resources.getLevel()+"")){
					map.put("text", resources.getName());
					map.put("id", resources.getId());
					ArrayList<Map<String,Object>> nodesList = new ArrayList<Map<String,Object>>();
					Map<String, Object> nodeMap = null;
					for (Resources rr : resourcesList) {
						nodeMap = new Hashtable<String, Object>();
						if(resources.getId().equals(rr.getParentId())){
							nodeMap.put("text", rr.getName());
							nodeMap.put("id", rr.getId());
							nodesList.add(nodeMap);
						}
					}
					map.put("nodes", nodesList);
				}
			}
			// 清空LIST
			resourcesList = null;
			list.add(map);
		}
		return list;
	}


}
