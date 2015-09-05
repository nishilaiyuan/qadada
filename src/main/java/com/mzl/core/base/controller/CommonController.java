/**
* @author mzl
* Created on 2015-1-20 下午10:08:55
* Copyright 2015 Inc. All rights revserved.
* 
*/
package com.mzl.core.base.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mzl.plugins.system.resources.entity.Resources;
import com.mzl.plugins.system.resources.service.ResourcesService;
import com.mzl.plugins.system.user.entity.Account;
import com.mzl.plugins.system.user.service.UserService;
import com.mzl.util.Common;
import com.mzl.util.PropertiesUtils;


@Controller
public class CommonController{
	
	@Autowired
	private UserService userService;
	@Autowired
	private AuthenticationManager myAuthenticationManager;
	@Autowired
	private ResourcesService resourcesService;
	@RequestMapping("/login")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("/login");
	}
	@RequestMapping("/error")
	public ModelAndView error(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("/error");
	}
	
	@RequestMapping("/main")
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("/main");
	}
	
	@RequestMapping ("submitlogin")
	public String submitlogin(ModelMap model,String username,String password,HttpServletRequest request,RedirectAttributes attr) throws Exception{
		try {
			if (!request.getMethod().equals("POST")) {
				request.setAttribute("error","支持POST方法提交！");
			}
			if (Common.isEmpty(username) || Common.isEmpty(password)) {
				request.setAttribute("error","用户名或密码不能为空！");
				return "redirect:/login";
			}
			// 验证用户账号与密码是否正确
			
			Account users = this.userService.querySingleAccount(username);
			if (users == null) {
//				request.setAttribute("error", "用户或密码不正确！");
				return "redirect:/login";
			}
			else if (users != null && Common.isEmpty(users.getAccount())){
//				request.setAttribute("error", "用户或密码不正确！");
				return "redirect:/login";
			}
//			else if(!Md5Tool.getMd5(password).equals(users.getPassword())){
//				return "redirect:login";
//			}
			Authentication authentication = myAuthenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,users.getPassword()));
			SecurityContext securityContext = SecurityContextHolder.getContext();
			securityContext.setAuthentication(authentication);
			HttpSession session = request.getSession(true);  
		    session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
		    //获得用户资源权限
		    List<Resources> resourcesList = getUserResources(users);
		    // 当验证都通过后，把用户信息放在session里
			request.getSession().setAttribute("userSession", users);
			request.getSession().setAttribute("userSessionId", users.getId());
			request.getSession().setAttribute("resources", resourcesList);
			System.out.println(authentication.getPrincipal().toString());
//			String userId = request.getSession().getAttribute("userSessionId").toString();
//			String userName = users.getName();
//			String ip = Common.toIpAddr(request);
//			UserLogin userLogin = new UserLogin();
//			userLogin.setUserId(Integer.parseInt(userId));
//			userLogin.setUserName(userName);
//			userLogin.setloginIP(ip);
//			userLoginService.add(userLogin);
			//request.getSession().setAttribute("userRole",authentication.getPrincipal());
			request.removeAttribute("error");
		} catch (AuthenticationException ae) {  
//			request.setAttribute("error", "登录异常，请联系管理员！");
			ae.printStackTrace();
			attr.addAttribute("error", "登录异常，请联系管理员！");
			return "redirect:/login";
		}
		return "redirect:/main";
	}
	
	private List<Resources> getUserResources(Account users) throws Exception {
		// TODO Auto-generated method stub
		List<Resources> list = new ArrayList<Resources>();
		if (PropertiesUtils.findPropertiesKey("rootName").equals(Common.findAuthenticatedUsername())){
			list =resourcesService.getAll(new Resources());
		} else {
			list =resourcesService.findAccountResourcess(users);
		}
		return list;
	}
}
