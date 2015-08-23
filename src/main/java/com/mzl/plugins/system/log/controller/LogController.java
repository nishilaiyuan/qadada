package com.mzl.plugins.system.log.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mzl.core.base.controller.BaseController;
import com.mzl.plugins.system.log.entity.Log;
import com.mzl.plugins.system.log.service.LogService;
/**
 * 
 * @author maozhanlei
 * @version 1.0v
 */
@Controller
public class LogController extends BaseController<Log>{
	@Autowired
	private LogService logService;
	
	@RequestMapping("/test")
	public void test(Log log) throws Exception{
		logService.getRecordCount(log);
	}
}
