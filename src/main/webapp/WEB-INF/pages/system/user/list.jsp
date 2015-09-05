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
		var path = "${path}"; //javascript全局变量
		/**加载数据**/
		$(function(){
				$("#userlist").jqGrid({
					url: '${path}/system/user/grid',
					datatype: 'json',
					colNames: [
			                   '',
			                   '帐号',
			                   '密码',
			                   '昵称'
			                   ],
			       colModel: [
			                  {name: 'id',index: 'id',width:'10%',align:'center',hidden: true,sortable: false}, 
			                  {name: 'account',index: 'account',width:'10%',align:'center',hidden: false,sortable: false},
			                  {name: 'password',index: 'password',width:'10%',align:'center',hidden: false,sortable: false},
			                  {name: 'roleName',index: 'roleName',width:'10%',align:'center',hidden: false,sortable: false}
			                  ],
			       styleUI : 'Bootstrap',
			       rowNum:10,   
			       page:1,
			       rowList: [10,15,20,30],
			       pager: '#pagered',
			       height:'300',
			       autowidth: true,
			       viewrecords: false,
			       multiselect: false,
			       rownumbers: true,
			       jsonReader: {
			       	repeatitems: false
			       },
			       toolbar: [false,"top"]
				});
				
				$('#create').bind("click",function(){
					window.location.href = "${path}/system/user/create";
				});
		})
	</script>
</head>
<body>
	<ol class="breadcrumb">
	  <li><a href="#">Home</a></li>
	  <li><a href="#">Library</a></li>
	  <li class="active">Data</li>
	</ol>
	<div class="bar">
		<button type="button" class="btn btn-primary" id="create">创建</button>
	</div>
	<div class="panel panel-primary">
	  <div class="panel-heading">新增用户</div>
	  <div class="panel-body">
	    	<table id="userlist" class="table table-striped"></table>
 			<div id="pagered"></div>
	  </div>
	</div>
</body>
</html>

