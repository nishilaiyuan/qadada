package com.mzl.plugins.system.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mzl.plugins.system.user.entity.Account;

@Controller
public class UserController {

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
}
