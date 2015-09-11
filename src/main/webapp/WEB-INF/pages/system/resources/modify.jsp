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
	
	<script type="text/javascript" src="${path}/common/js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="${path}/common/js/jqGrid/i18n/grid.locale-cn.js"></script>
	<script type="text/javascript" src="${path}/common/js/jqGrid/jquery.jqGrid.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    
	<script type="text/javascript">
		
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
			    <label for="inputName" class="col-sm-2 control-label">帐号</label>
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
			      <input type="text" class="form-control" name="type" id="type"  style="width: 30%;" value="${resources.type}"/>
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