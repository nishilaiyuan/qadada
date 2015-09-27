package com.mzl.plugins.system.account.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mzl.plugins.system.account.entity.Account;
import com.mzl.plugins.system.account.service.AccountService;

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;
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

	/** 
	 * 此方法描述的是： 账号列表json数据
	 * @author: maozhanlei 
	 * @dateTime：2015年9月27日 下午10:06:22
	 */ 
	@RequestMapping("system/user/grid")
	@ResponseBody
	public Map<String, Object> json(Account account, HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = null;
		try {
			map = accountService.getGrid(account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	 
	/** 
	 * 此方法描述的是： 帐号创建界面
	 * @author: maozhanlei 
	 * @dateTime：2015年9月27日 下午10:06:35
	 */ 
	@RequestMapping("system/user/create")
	public ModelAndView create(Account account, HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("system/user/create");
		return mv;
	}
	
	 
	/** 
	 * 此方法描述的是： 保存或更新
	 * @author: maozhanlei 
	 * @dateTime：2015年9月27日 下午10:06:44
	 */ 
	@RequestMapping("system/user/save")
	public ModelAndView save(Account account, HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("ok");
		try {
			if("1".equals(account.getOperator())){
				accountService.save(account);
			}else{
				accountService.update(account);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("returnurl", "system/user/list");
		mv.addObject("status", "success");
		return mv;
	}
	
	 
	/** 
	 * 此方法描述的是： 修改界面
	 * @author: maozhanlei 
	 * @dateTime：2015年9月27日 下午10:06:52
	 */ 
	@RequestMapping("system/user/modify")
	public ModelAndView modify(Account account, HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("system/user/modify");
		Account a = null;
		try {
			a = accountService.getOne(account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("account", a);
		return mv;
	}
	
	 
	/** 
	 * 此方法描述的是： 删除
	 * @author: maozhanlei 
	 * @dateTime：2015年9月27日 下午10:06:59
	 */ 
	@RequestMapping("system/user/delete")
	@ResponseBody
	public Map<String, String> delete(Account account, HttpServletRequest request,HttpServletResponse response){
		Map<String, String> map = new HashMap<String, String>();
		try {
			accountService.delete(account);
			map.put("status", "sucess");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
}
