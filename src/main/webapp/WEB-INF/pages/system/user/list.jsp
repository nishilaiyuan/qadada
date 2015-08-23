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
	<link href="${path}/common/css/style.css" rel="stylesheet" type="text/css" />
	<link href="${path}/common/css/select.css" rel="stylesheet" type="text/css" />

	<script type="text/javascript" src="${path}/common/js/jquery.js"></script>
	<script type="text/javascript" src="${path}/common/js/index.js"></script>
	<script type="text/javascript" src="${path}/common/js/jquery.idTabs.min.js"></script>
	<script type="text/javascript" src="${path}/common/js/select-ui.min.js"></script>
	
	<script type="text/javascript">
		var path = "${path}"; //javascript全局变量
	</script>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="javascript:;;">首页</a></li>
			<li><a href="javascript:;;">系统设置</a></li>
			<li><a href="javascript:;;">用户管理</a></li>
		</ul>
	</div>

	<div class="formbody">


		<div id="usual1" class="usual">

			<div id="tab2" class="tabson">


				<ul class="seachform">

					<li><label>综合查询</label><input name="" type="text"
						class="scinput" /></li>
					<li><label>指派</label>
						<div class="vocation">
							<select class="select3">
								<option>全部</option>
								<option>其他</option>
							</select>
						</div></li>

					<li><label>重点客户</label>
						<div class="vocation">
							<select class="select3">
								<option>全部</option>
								<option>其他</option>
							</select>
						</div></li>

					<li><label>客户状态</label>
						<div class="vocation">
							<select class="select3">
								<option>全部</option>
								<option>其他</option>
							</select>
						</div></li>

					<li><label>&nbsp;</label><input name="" type="button"
						class="scbtn" value="查询" /></li>

				</ul>


				<table class="tablelist">
					<thead>
						<tr>
							<th><input name="" type="checkbox" value=""
								checked="checked" /></th>
							<th>编号<i class="sort"><img src="${path}/common/images/px.gif" /></i></th>
							<th>标题</th>
							<th>用户</th>
							<th>籍贯</th>
							<th>发布时间</th>
							<th>是否审核</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input name="" type="checkbox" value="" /></td>
							<td>20130908</td>
							<td>王金平幕僚：马英九声明字字见血 人活着没意思</td>
							<td>admin</td>
							<td>江苏南京</td>
							<td>2013-09-09 15:05</td>
							<td>已审核</td>
							<td><a href="#" class="tablelink">查看</a> <a href="#"
								class="tablelink"> 删除</a></td>
						</tr>

						<tr>
							<td><input name="" type="checkbox" value="" /></td>
							<td>20130907</td>
							<td>温州19名小学生中毒流鼻血续：周边部分企业关停</td>
							<td>uimaker</td>
							<td>山东济南</td>
							<td>2013-09-08 14:02</td>
							<td>未审核</td>
							<td><a href="#" class="tablelink">查看</a> <a href="#"
								class="tablelink">删除</a></td>
						</tr>

						<tr>
							<td><input name="" type="checkbox" value="" /></td>
							<td>20130906</td>
							<td>社科院:电子商务促进了农村经济结构和社会转型</td>
							<td>user</td>
							<td>江苏无锡</td>
							<td>2013-09-07 13:16</td>
							<td>未审核</td>
							<td><a href="#" class="tablelink">查看</a> <a href="#"
								class="tablelink">删除</a></td>
						</tr>

						<tr>
							<td><input name="" type="checkbox" value="" /></td>
							<td>20130905</td>
							<td>江西&quot;局长违规建豪宅&quot;：局长检讨</td>
							<td>admin</td>
							<td>北京市</td>
							<td>2013-09-06 10:36</td>
							<td>已审核</td>
							<td><a href="#" class="tablelink">查看</a> <a href="#"
								class="tablelink">删除</a></td>
						</tr>

						<tr>
							<td><input name="" type="checkbox" value="" /></td>
							<td>20130907</td>
							<td>温州19名小学生中毒流鼻血续：周边部分企业关停</td>
							<td>uimaker</td>
							<td>山东济南</td>
							<td>2013-09-08 14:02</td>
							<td>未审核</td>
							<td><a href="#" class="tablelink">查看</a> <a href="#"
								class="tablelink">删除</a></td>
						</tr>

					</tbody>
				</table>
				<div class="pagin">
			        <div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
			        <ul class="paginList">
			        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
			        <li class="paginItem"><a href="javascript:;">1</a></li>
			        <li class="paginItem current"><a href="javascript:;">2</a></li>
			        <li class="paginItem"><a href="javascript:;">3</a></li>
			        <li class="paginItem"><a href="javascript:;">4</a></li>
			        <li class="paginItem"><a href="javascript:;">5</a></li>
			        <li class="paginItem more"><a href="javascript:;">...</a></li>
			        <li class="paginItem"><a href="javascript:;">10</a></li>
			        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
			        </ul>
			    </div>
			</div>

		</div>
<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
</script>
	</div>

</body>
</html>