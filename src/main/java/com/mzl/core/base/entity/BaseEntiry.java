/**
* @author mzl
* Created on 2015-3-18 下午10:43:15
* Copyright 2015 Inc. All rights revserved.
* 
*/
package com.mzl.core.base.entity;

public class BaseEntiry {

	/**主键ID**/
	private Long id;
	/** 表示请求页码（当前页）的参数名称 */
	private int page;
	/** 表示请求记录数的参数名称 */
	private int rows;
	/** 表示分页起始数的参数名称 **/
	private int start;
	/** 表示分页偏移量 **/
	private int offset;
	
	private String operator;
	
	private String createTime;
	
	private String updateTime;
	/** 唯一标识串 */
	private Long generatedKey;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getStart() {
		this.start = (this.getPage() - 1) * this.getRows();
		return start;
	}
	
	public int getOffset() {
		this.offset = this.getRows();
		return offset;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Long getGeneratedKey() {
		return generatedKey;
	}

	public void setGeneratedKey(Long generatedKey) {
		this.generatedKey = generatedKey;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	
}
