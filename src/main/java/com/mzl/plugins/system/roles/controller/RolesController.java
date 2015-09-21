package com.mzl.plugins.system.roles.controller;

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
import com.mzl.plugins.system.roles.entity.Roles;
import com.mzl.plugins.system.roles.service.RolesService;

@Controller
public class RolesController extends BaseController<Roles>{

	@Autowired
	private RolesService rolesService;

	@RequestMapping("system/roles/list")
	public ModelAndView list(Roles entity, HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("system/roles/list");
		return mv;
	}
	
	/**
	 * 角色列表数据
	 * @param resources
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("system/roles/grid")
	@ResponseBody
	public Map<String, Object> json(Roles entity, HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = null;
		try {
			map = rolesService.getGrid(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 返回角色列表创建
	 * @param account
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("system/roles/create")
	public ModelAndView create(Roles entity, HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("system/roles/create");
		return mv;
	}
	/**
	 * 保存或更新
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("system/roles/save")
	public ModelAndView save(Roles entity, HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("ok");
		try {
			if("1".equals(entity.getOperator())){
				rolesService.save(entity);
			}else{
				rolesService.update(entity);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("returnurl", "system/roles/list");
		mv.addObject("status", "success");
		return mv;
	}
	
	/**
	 * 修改
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("system/roles/modify")
	public ModelAndView modify(Roles entity, HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("system/roles/modify");
		Roles r = null;
		try {
			r = rolesService.getOne(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("roles",r);
		return mv;
	}
	
	/**
	 * 删除
	 * @param resources
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("system/roles/delete")
	@ResponseBody
	public Map<String, String> delete(Roles entity, HttpServletRequest request,HttpServletResponse response){
		Map<String, String> map = new HashMap<String, String>();
		try {
			rolesService.delete(entity);
			map.put("status", "sucess");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
}
