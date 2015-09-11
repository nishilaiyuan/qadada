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
 * 资源控制器类
 * @author Administrator
 *
 */
@Controller
public class ResourcesColtroller extends BaseController<Resources>{

	@Autowired
	private ResourcesService resourcesService;
	
	/**
	 * 返回资源列表界面
	 * @param account
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("system/resources/list")
	public ModelAndView list(Resources resources, HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("system/resources/list");
		return mv;
	}
	
	/**
	 * 获得资源列表数据
	 * @param resources
	 * @param request
	 * @param response
	 * @return
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
	 * 修改界面
	 * @param account
	 * @param request
	 * @param response
	 * @return
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
	 * 保存或更新
	 * @param resources
	 * @param request
	 * @param response
	 * @return
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
	 * 删除元素
	 * @param resources
	 * @param request
	 * @param response
	 * @return
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
	 * 返回资源列表创建
	 * @param account
	 * @param request
	 * @param response
	 * @return
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
