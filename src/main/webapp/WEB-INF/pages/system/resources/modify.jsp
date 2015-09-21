<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%	   
	  String path = request.getContextPath();     		
       request.setAttribute("path", path);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="${path}/common/css/index.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" />
	<link href="${path}/common/css/jqGrid/ui.jqgrid-bootstrap.css" rel="stylesheet" type="text/css" />
	<link href="${path}/common/css/bootstrap/bootstrap-treeview.css" rel="stylesheet" type="text/css" />
	
	<script type="text/javascript" src="${path}/common/js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="${path}/common/js/jqGrid/i18n/grid.locale-cn.js"></script>
	<script type="text/javascript" src="${path}/common/js/jqGrid/jquery.jqGrid.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${path}/common/js/bootstrap/bootstrap-treeview.js"></script>
    
	<script type="text/javascript">
	 $(function(){
		 $('#tree').treeview({
			  data: eval('('+'${btree}'+')'),
			  levels:1,
			  showIcon:true,
			  onNodeSelected: function(event, data) {
				    $('#tree').css("display","none");
				    $('#parentName').val(data.text);
				    $('#parentId').val(data.id);
				},    
			});
		 $('#parentName').click(function(){
			 $('#tree').css("display","block");
		 });
	 })
	</script>
</head>
<body>
	<ol class="breadcrumb">
	  <li><a href="#">系统管理</a></li>
	  <li><a href="#">菜单管理</a></li>
	  <li class="active">修改菜单</li>
	</ol>
	<div class="panel panel-primary">
	  <div class="panel-heading">修改菜单</div>
	  <div class="panel-body">
	    	<form class="form-horizontal" action="${path}/system/resources/save" method="post" id="resourcesForm">
	    		<input type="hidden" name="id" value="${resources.id}"/>
	    	  <input type="hidden" name="operator" value="2"/>
	    	  <div class="form-group">
			    <label for="parentId" class="col-sm-2 control-label">父节点</label>
			    <div class="col-sm-10">
			      <input type="text" readonly="readonly" class="form-control" name="parentName" id="parentName" style="width: 30%;" value="${resources.parentName}" />
			      <input type="hidden" class="form-control" name="parentId" id="parentId" style="width: 30%;"  />
			      <div id="tree" style="width: 30%;display:none;position: absolute;z-index: 9999;height: 200px;overflow: auto;"></div>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputName" class="col-sm-2 control-label">名称</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="name" id="name"  style="width: 30%;" value="${resources.name}"/>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="resKey" class="col-sm-2 control-label">标识</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="resKey" id="resKey"  style="width: 30%;" value="${resources.resKey}"/>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="resUrl" class="col-sm-2 control-label">链接</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="resUrl" id="resUrl"  style="width: 30%;" value="${resources.resUrl}"/>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="level" class="col-sm-2 control-label">排序</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="level" id="resUrl"  style="width: 30%;" value="${resources.level}"/>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="type" class="col-sm-2 control-label">类型</label>
			    <div class="col-sm-10">
			    	<select name="type" id="type" style="width: 30%;" class="form-control">
			    		<option value="">--请选择--</option>
			    		<option value="1" <c:if test="${resources.type==1}">selected="selected"</c:if>>导航</option>
			    		<option value="2" <c:if test="${resources.type==2}">selected="selected"</c:if>>按钮</option>
			    	</select>
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			    	<input type="submit" class="btn btn-primary" value="保存"/>
			        &nbsp;&nbsp;&nbsp;
			        <input type="submit" class="btn btn-default" value="返回" onclick="history.go(-1)"/>
			    </div>
			  </div>
			</form>
	  </div>
	</div>
</body>
</html>