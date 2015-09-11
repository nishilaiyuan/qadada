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
    <script type="text/javascript" src="${path}/common/js/layer/layer.js"></script>
	<script type="text/javascript">
		var path = "${path}"; //javascript全局变量
		/**加载数据**/
		$(function(){
				$("#resourceslist").jqGrid({
					url: '${path}/system/resources/grid',
					datatype: 'json',
					colNames: [
			                   '',
			                   '名称',
			                   '父节点',
			                   '标识',
			                   '链接',
			                   '排序',
			                   '类型',
			                   '操作'
			                   ],
			       colModel: [
			                  {name: 'id',index: 'id',width:'10%',align:'center',hidden: true,sortable: false}, 
			                  {name: 'name',index: 'name',width:'20%',align:'center',hidden: false,sortable: false},
			                  {name: 'parentName',index: 'parentName',width:'20%',align:'center',hidden: false,sortable: false},
			                  {name: 'resKey',index: 'resKey',width:'20%',align:'center',hidden: false,sortable: false},
			                  {name: 'resUrl',index: 'resUrl',width:'20%',align:'center',hidden: false,sortable: false},
			                  {name: 'level',index: 'level',width:'20%',align:'center',hidden: false,sortable: false},
			                  {name: 'type',index: 'type',width:'20%',align:'center',hidden: false,sortable: false,formatter:formatMenuType},
			                  {name:'act',index:'act', width:'15%',align:'center',sortable:false,sortable: false,formatter:initAct}
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
			       loadComplete:function(){
			    	   $('.modify').click(function(){
			    		   var rowid = $(this).attr("rowid");
			    		   window.location.href = "${path}/system/resources/modify?id="+rowid;
			    	   });
			    	   $('.delete').click(function(){
			    		   var rowid = $(this).attr("rowid");
			    		  var index =  layer.confirm('是否确定删除数据?', function(index){
			    			    //do something
			    			    $.ajax({
				   					url:"${path}/system/resources/delete?id="+rowid,
				   					type:'post',
				   					timeout:'60000',
				   					dataType:'json',
				   					success:function(jsonData,status){
				   						if (status == "success"){
				   							$("#resourceslist").trigger("reloadGrid");
				   							layer.close(index);
				   						}
				   					},
				   					error:function(){
				   						layer.close(index);
				   						layer.msg("通讯失败");
				   						
				   					}
				   				});
			    			});
			    	   });
			       },
			       toolbar: [false,"top"]
				});
				//新增按钮
				$('#create').bind("click",function(){
					window.location.href = "${path}/system/resources/create";
				});
				
		})
		
		
		function initAct(cellvalue, options, rowdata){
		    var id = rowdata.id;
			var content = '<button type="button" class="modify btn btn-info btn-xs" rowid='+id+'>修改</button>';
			content+='&nbsp;&nbsp;';
			content+='<button type="button" class="delete btn btn-success btn-xs" rowid='+id+'>删除</button>';
		  	return content;
		}
		
		function formatMenuType(cellvalue, options, rowdata){
		    var type = rowdata.type;
			var content = '';
			if(0==type){
				content="一级菜单";
			}else if(1==type){
				content="二级菜单";
			}else if(2==type){
				content="按钮";
			}else{
				content="";
			}
		  	return content;
		}
	</script>
</head>
<body>
	<ol class="breadcrumb">
	  <li><a href="#">系统管理</a></li>
	  <li><a href="#">资源管理</a></li>
	  <li class="active">资源列表</li>
	</ol>
	<div class="bar">
		<button type="button" class="btn btn-primary" id="create">创建</button>
	</div>
	<div class="panel panel-primary">
	  <div class="panel-heading">资源列表</div>
	  <div class="panel-body">
	    	<table id="resourceslist" class="table table-striped"></table>
 			<div id="pagered"></div>
	  </div>
	</div>
</body>
</html>

