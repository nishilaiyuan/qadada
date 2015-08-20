package com.mzl.plugins.system.resources.entity;

import com.mzl.core.base.entity.BaseEntiry;

public class Resources extends BaseEntiry{

	private String name;
	private Integer parentId; //父类Id
	private String resKey;//这个权限KEY是唯一的，新增时要注意，
	private String resUrl;//URL地址．例如：/videoType/query　　不需要项目名和http://xxx:8080
	private Integer level;//级别 菜单的顺序
	private String type;//类型，目录　菜单  按扭．．在spring security3安全权限中，涉及精确到按扭控制
	private String description;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getResKey() {
		return resKey;
	}
	public void setResKey(String resKey) {
		this.resKey = resKey;
	}
	public String getResUrl() {
		return resUrl;
	}
	public void setResUrl(String resUrl) {
		this.resUrl = resUrl;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
