package com.mzl.plugins.system.roles.entity;

import java.util.HashSet;
import java.util.Set;

import com.mzl.core.base.entity.BaseEntiry;
import com.mzl.plugins.system.resources.entity.Resources;

public class Roles extends BaseEntiry{

	private String name;
	private String roleKey;//唯一,新境时,需要判断
	private String description;
	private Set<Resources> resources = new HashSet<Resources>(0);
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoleKey() {
		return roleKey;
	}
	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
	}
	public Set<Resources> getResources() {
		return resources;
	}
	public void setResources(Set<Resources> resources) {
		this.resources = resources;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
