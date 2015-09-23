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
	<link href="${path}/common/css/bootstrap.min.css" rel="stylesheet" />
	<link href="${path}/common/css/tree/bootstrap-treeview.css" rel="stylesheet" type="text/css" />
	
	<script src="${path}/common/js/jquery-2.0.3.min.js" type="text/javascript" ></script>
	<script src="${path}/common/js/bootstrap.min.js" type="text/javascript" ></script>
    <script src="${path}/common/js/tree/bootstrap-treeview.js"></script>
	<script type="text/javascript">
	</script>
</head>
<body>
	<ol class="breadcrumb">
	  <li><a href="#">系统管理</a></li>
	  <li><a href="#">角色管理</a></li>
	  <li class="active">修改角色</li>
	</ol>
	<div class="panel panel-primary">
	  <div class="panel-heading">修改角色</div>
	  <div class="panel-body">
	    	<form class="form-horizontal" action="${path}/system/roles/save" method="post">
	    	  <input type="hidden" name="operator" value="2"/>
	    	  <input type="hidden" name="id" value="${roles.id}"/>
			  <div class="form-group">
			    <label for="inputEmail3" class="col-sm-2 control-label">角色名：</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="name" id="name" placeholder="角色名" value="${roles.name}" style="width: 30%;" />
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">角色标识</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="roleKey" id="roleKey" placeholder="角色表示roleKey" value="${roles.roleKey}" style="width: 30%;" />
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputEmail3" class="col-sm-2 control-label">角色说明：</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="description" id="description" placeholder="角色说明" value="${roles.description}" style="width: 30%;" />
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