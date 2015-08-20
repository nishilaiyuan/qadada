package com.mzl.plugins.system.resources.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mzl.core.base.controller.BaseController;
import com.mzl.plugins.system.resources.entity.Resources;
import com.mzl.plugins.system.resources.service.ResourcesService;

/**
 * 资源控制器类
 * @author Administrator
 *
 */
@Controller
public class ResourcesColtroller extends BaseController<Resources>{

	@Autowired
	private ResourcesService resourcesService;
	
	public void test(Resources t) throws Exception{
		resourcesService.getOne(t);
	}
}
