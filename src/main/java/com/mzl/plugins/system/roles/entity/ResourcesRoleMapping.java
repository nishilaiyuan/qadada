package com.mzl.plugins.system.roles.entity;

import com.mzl.core.base.entity.BaseEntiry;

public class ResourcesRoleMapping extends BaseEntiry{

	private Long roleID;
	
	private Long resourcesID;

	public Long getRoleID() {
		return roleID;
	}

	public void setRoleID(Long roleID) {
		this.roleID = roleID;
	}

	public Long getResourcesID() {
		return resourcesID;
	}

	public void setResourcesID(Long resourcesID) {
		this.resourcesID = resourcesID;
	}
	
}
