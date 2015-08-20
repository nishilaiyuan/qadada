package com.mzl.core.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;


/**
 * 基本controller类
 * @author Administrator
 * @param <T>
 *
 */
public class BaseController<T> {
	public ModelAndView list(HttpServletRequest request,T t) {
		return null;
	}
}