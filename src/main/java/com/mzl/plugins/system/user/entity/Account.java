package com.mzl.plugins.system.user.entity;

import com.mzl.core.base.entity.BaseEntiry;

public class Account extends BaseEntiry{

	private String account;//账号名
	
	private String roleName;//账号名

	private String password;//密码

	private String description;//说明

	private String state;//账号状态  0 表示停用  1表示启用

	private String createTime; //创建时间


	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	
}
