<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%	   
	  String path = request.getContextPath();     		
       request.setAttribute("path", path);
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link href="${path}/common/css/bootstrap.min.css" rel="stylesheet" />
	<link href="${path}/common/css/font-awesome.min.css"  rel="stylesheet"/>

	<!--[if IE 7]>
	  <link rel="stylesheet" href="${path}/common/css/font-awesome-ie7.min.css" />
	<![endif]-->

	<!-- page specific plugin styles -->

	<link rel="stylesheet" href="${path}/common/css/jquery-ui-1.10.3.full.min.css" />
	<link rel="stylesheet" href="${path}/common/css/datepicker.css" />
	<link rel="stylesheet" href="${path}/common/css/ui.jqgrid.css" />

	<!-- fonts -->

	<!-- ace styles -->

	<link rel="stylesheet" href="${path}/common/css/ace.min.css" />
	<link rel="stylesheet" href="${path}/common/css/ace-rtl.min.css" />
	<link rel="stylesheet" href="${path}/common/css/ace-skins.min.css" />
	<link href="${path}/common/css/tree/bootstrap-treeview.css" rel="stylesheet" type="text/css" />
	<!--[if lte IE 8]>
	  <link rel="stylesheet" href="${path}/common/css/ace-ie.min.css" />
	<![endif]-->

	<!-- inline styles related to this page -->

	<!-- ace settings handler -->
	<script src="${path}/common/js/ace-extra.min.js"></script>

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

	<!--[if lt IE 9]>
	<script src="assets/js/html5shiv.js"></script>
	<script src="assets/js/respond.min.js"></script>
	<![endif]-->
</head>
	<body>
		<div class="main-container" id="main-container">
				<div class="main-content" style="margin-left:0px">
					<div class="breadcrumbs" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="#">系统管理</a>
							</li>
							<li>
								<a href="#">角色管理</a>
							</li>
							<li class="active">角色列表</li>
						</ul>
					</div>

					<div class="page-content">
						<div class="panel panel-default" style="margin-bottom:5px;">
						  <div class="panel-body" style="padding:5px;">
						   	 显示查询
						  </div>
						</div>
						<div class="panel panel-default" style="margin-bottom:5px;">
						  <div class="panel-body"  id="toolbar" style="padding:5px;">
						    <button type="button" class="btn btn-primary btn-xs" id="create">创建</button>
						  </div>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<table id="grid-table"></table>
								<div id="grid-pager"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
<!-- 绑定数据对话框 -->
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">绑定资源</h4>
      </div>
      <div class="modal-body">
        <div id="treeview" />
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="save">保存</button>
      </div>
    </div>
  </div>
</div>
<input type="hidden" id="param">
		<script type="text/javascript" src="${path}/common/js/jquery-2.0.3.min.js"></script>
		<script src="${path}/common/js/bootstrap.min.js"></script>
		<script src="${path}/common/js/typeahead-bs2.min.js"></script>

		<!-- page specific plugin scripts -->

		<script src="${path}/common/js/date-time/bootstrap-datepicker.min.js"></script>
		<script src="${path}/common/js/jqGrid/jquery.jqGrid.min.js"></script>
		<script src="${path}/common/js/jqGrid/i18n/grid.locale-en.js"></script>

		<!-- ace scripts -->

		<script src="${path}/common/js/ace-elements.min.js"></script>
		<script src="${path}/common/js/ace.min.js"></script>
		<script type="text/javascript" src="${path}/common/js/layer/layer.js"></script>
		<script src="${path}/common/js/tree/bootstrap-treeview.js"></script>
		<!-- inline scripts related to this page -->

		<script type="text/javascript">
			jQuery(function($) {
				jQuery("#grid-table").jqGrid({
					url: '${path}/system/roles/grid',
					datatype: 'json',
					height: 300,
					colNames:[
							'',
							'角色名',
							'角色唯一标识',
							'描述',
							'操作' 
					],
					colModel:[
					          {name: 'id',index: 'id',width:'10%',align:'center',hidden: true,sortable: false}, 
			                  {name: 'name',index: 'name',width:'20%',align:'center',hidden: false,sortable: false},
			                  {name: 'roleKey',index: 'roleKey',width:'20%',align:'center',hidden: false,sortable: false},
			                  {name: 'description',index: 'description',width:'20%',align:'center',hidden: false,sortable: false},
			                  {name:'act',index:'act', width:'15%',align:'left',sortable:false,sortable: false,formatter:initAct}
					], 
					viewrecords : true,
					rowNum:10,
					rowList:[10,20,30],
					pager : "#grid-pager",
					altRows: true,
					multiselect: true,
			        multiboxonly: true,
					loadComplete : function() {
						var table = this;
						setTimeout(function(){
							updatePagerIcons(table);
						}, 0);
						$('.modify').click(function(){
				    		   var rowid = $(this).attr("rowid");
				    		   window.location.href = "${path}/system/roles/modify?id="+rowid;
				    	   });
				    	   $('.delete').click(function(){
				    		   var rowid = $(this).attr("rowid");
				    		   var index =  layer.confirm('是否确定删除数据?', function(index){
				    			    //do something
				    			    $.ajax({
					   					url:"${path}/system/roles/delete?id="+rowid,
					   					type:'post',
					   					timeout:'60000',
					   					dataType:'json',
					   					success:function(jsonData,status){
					   						if (status == "success"){
					   							$("#list").trigger("reloadGrid");
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
					caption: "角色列表",
					autowidth: true
				});
				
				function initAct(cellvalue, options, rowdata){
				    var id = rowdata.id;
				    var content = "";
				    content +='<button type="button" class="bindres btn btn-info btn-xs" rowid='+id+' data-toggle="modal" data-target="#myModal" id="binddata">绑定资源</button>';
					content+='&nbsp;';
				    content +='<button type="button" class="modify btn btn-info btn-xs" rowid='+id+'>修改</button>';
					content+='&nbsp;';
					content+='<button type="button" class="delete btn btn-success btn-xs" rowid='+id+'>删除</button>';
				  	return content;
				}
				
				function updatePagerIcons(table) {
					var replacement = 
					{
						'ui-icon-seek-first' : 'icon-double-angle-left bigger-140',
						'ui-icon-seek-prev' : 'icon-angle-left bigger-140',
						'ui-icon-seek-next' : 'icon-angle-right bigger-140',
						'ui-icon-seek-end' : 'icon-double-angle-right bigger-140'
					};
					$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
						var icon = $(this);
						var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
						
						if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
					})
				}
				//新增按钮
				$('#create').bind("click",function(){
					window.location.href = "${path}/system/roles/create";
				});
				
			});
			var array = new Array();
			var $checkableTree = $('#treeview').treeview({
				  showIcon: true,
		          showCheckbox: true,
		          data: eval('('+'${btree}'+')'),
		          onNodeChecked: function(event, node) {
		        	  array.push(node.id);
		          },
		          onNodeUnchecked: function (event, node) {
		        	  if(array.in_array(node.id)){
		        		  array.remove(node.id);
		        	  }
		        	  
		          }
	        });
			Array.prototype.in_array = function(e){  
				for(i=0;i<this.length && this[i]!=e;i++);  
				return !(i==this.length);  
			}  
			Array.prototype.indexOf = function(val) {
	            for (var i = 0; i < this.length; i++) {
	                if (this[i] == val) return i;
	            }
	            return -1;
	        };
			Array.prototype.remove = function(val) {
	            var index = this.indexOf(val);
	            if (index > -1) {
	                this.splice(index, 1);
	            }
	        };
			$('#myModal').on('show.bs.modal', function (e) {
			})
			$('#myModal').on('hidden.bs.modal', function (e) {
				  $checkableTree.treeview('uncheckAll', { silent: $('#chk-check-silent').is(':checked') });
				  console.log(array);
			})
			$("#save").click(function(){
				$('#myModal').modal('hide');
				var index = layer.open({type: 3});
				var  rowid = $('#binddata').attr("rowid");
				$.ajax({
   					url:"${path}/system/roles/savemapping",
   					type:'post',
   					timeout:'60000',
   					dataType:'json',
   					data:{roleID:rowid,ids:array.join(",")},
   					success:function(jsonData,status){
   						if (status == "success"){
   							layer.close(index);
   						}
   					},
   					error:function(){
   						layer.close(index);
   						layer.msg("通讯失败");
   					}
   				});
			})
		</script>
</body>
</html>