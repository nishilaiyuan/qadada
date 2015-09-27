package com.mzl.plugins.system.resources.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mzl.core.base.controller.BaseController;
import com.mzl.plugins.system.resources.entity.Resources;
import com.mzl.plugins.system.resources.service.ResourcesService;

 
/** 
 * 此类描述的是： 资源管理类
 * @author: maozhanlei/毛占磊
 * @version: v1.0 
 * @dateTime：2015年9月27日 下午9:58:52
 */ 
@Controller
public class ResourcesColtroller extends BaseController<Resources>{

	@Autowired
	private ResourcesService resourcesService;
	
	 
	/** 
	 * 此方法描述的是： 返回资源管理列表页面
	 * @author: maozhanlei 
	 * @dateTime：2015年9月27日 下午9:59:24
	 */ 
	@RequestMapping("system/resources/list")
	public ModelAndView list(Resources resources, HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("system/resources/list");
		return mv;
	}
	
	 
	/** 
	 * 此方法描述的是： 获得资源管理json数据
	 * @author: maozhanlei 
	 * @dateTime：2015年9月27日 下午9:59:51
	 */ 
	@RequestMapping("system/resources/grid")
	@ResponseBody
	public Map<String, Object> json(Resources resources, HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = null;
		try {
			map = resourcesService.getGrid(resources);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	
	 
	/** 
	 * 此方法描述的是： 资源修改界面
	 * @author: maozhanlei 
	 * @dateTime：2015年9月27日 下午10:00:04
	 */ 
	@RequestMapping("system/resources/modify")
	public ModelAndView modify(Resources resources, HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("system/resources/modify");
		Resources r = null;
		String btree = "";
		try {
			r = resourcesService.getOne(resources);
			btree = resourcesService.getTree();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("resources",r);
		mv.addObject("btree", btree);
		return mv;
	}
	 
	/** 
	 * 此方法描述的是： 保存或更新界面
	 * @author: maozhanlei 
	 * @dateTime：2015年9月27日 下午10:00:15
	 */ 
	@RequestMapping("system/resources/save")
	public ModelAndView save(Resources resources, HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("ok");
		try {
			if("1".equals(resources.getOperator())){
				resourcesService.save(resources);
			}else{
				resourcesService.update(resources);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("returnurl", "system/resources/list");
		mv.addObject("status", "success");
		return mv;
	}
	
	 
	/** 
	 * 此方法描述的是： 删除资源
	 * @author: maozhanlei 
	 * @dateTime：2015年9月27日 下午10:00:26
	 */ 
	@RequestMapping("system/resources/delete")
	@ResponseBody
	public Map<String, String> delete(Resources resources, HttpServletRequest request,HttpServletResponse response){
		Map<String, String> map = new HashMap<String, String>();
		try {
			resourcesService.delete(resources);
			map.put("status", "sucess");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	 
	/** 
	 * 此方法描述的是： 资源创建页面
	 * @author: maozhanlei 
	 * @dateTime：2015年9月27日 下午10:00:40
	 */ 
	@RequestMapping("system/resources/create")
	public ModelAndView create(Resources resources, HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("system/resources/create");
		String btree = "";
		try {
			btree = resourcesService.getTree();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("btree", btree);
		return mv;
	}
}
