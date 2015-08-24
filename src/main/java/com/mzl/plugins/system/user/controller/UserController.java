package com.mzl.plugins.system.user.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.mzl.plugins.system.user.entity.Account;
import com.mzl.plugins.system.user.service.UserService;
import com.mzl.util.SpringmvcUtils;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	/**
	 * 返回列表界面
	 * @param account
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("system/user/list")
	public ModelAndView list(Account account, HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("system/user/list");
		return mv;
	}
	@RequestMapping("system/user/grid")
	@ResponseBody
	public Map<String, Object> json(Account account, HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = null;
		try {
			map = userService.getGrid(account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
}
