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
	<script language="JavaScript" src="${path}/common/js/jquery.js"></script>
	<script language="JavaScript" src="${path}/common/js/index.js"></script>
	
	<script type="text/javascript">
		var path = "${path}"; //javascript全局变量
	</script>
</head>
<body>
   <div class="top">
        <div class="topright">    
            <ul>
                <li><span><img src="${path}/common/images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
                <li><a href="#">关于</a></li>
                <li><a href="${path}/j_spring_security_logout" target="_parent">退出</a></li>
            </ul>
         
            <div class="user">
                <span>admin</span>
                <i>消息</i>
                <b>5</b>
            </div>    
        
        </div>
    </div>
    <div class="center">
        <div class="left">
            <div class="lefttop"><span></span>通讯录</div>
    
            <dl class="leftmenu">  
            	<c:forEach items="${resources}" var="menu">
		    		<c:if test="${menu.level eq 0}">
		    			<dd>
			    			<div class="title">
			                    <span><img src="${path}/common/images/leftico01.png" /></span>${menu.name}
			                </div>
		                	<ul class="menuson">
			    				<c:forEach items="${resources}" var="k">
			    					<c:if test="${k.parentId eq menu.id}">
			    						<li><cite></cite><a href="${path}/${k.resUrl}" target="content">${k.name}</a><i></i></li>
			    					</c:if>
			    				</c:forEach>
			    			</ul>
		    			</dd>
		    		</c:if>
		    	</c:forEach>
            	<!--   
                <dd>
                    <div class="title">
                        <span><img src="${path}/common/images/leftico01.png" /></span>管理信息
                    </div>
                    <ul class="menuson">
                        <li><cite></cite><a href="login.html" target="rightFrame">首页模版</a><i></i></li>
                        <li class="active"><cite></cite><a href="right.html" target="rightFrame">数据列表</a><i></i></li>
                        <li><cite></cite><a href="imgtable.html" target="rightFrame">图片数据表</a><i></i></li>
                        <li><cite></cite><a href="form.html" target="rightFrame">添加编辑</a><i></i></li>
                        <li><cite></cite><a href="imglist.html" target="rightFrame">图片列表</a><i></i></li>
                        <li><cite></cite><a href="imglist1.html" target="rightFrame">自定义</a><i></i></li>
                        <li><cite></cite><a href="tools.html" target="rightFrame">常用工具</a><i></i></li>
                        <li><cite></cite><a href="filelist.html" target="rightFrame">信息管理</a><i></i></li>
                        <li><cite></cite><a href="tab.html" target="rightFrame">Tab页</a><i></i></li>
                        <li><cite></cite><a href="error.html" target="rightFrame">404页面</a><i></i></li>
                    </ul>    
                </dd>
                <dd>
                    <div class="title">
                        <span><img src="${path}/common/images/leftico02.png" /></span>其他设置
                    </div>
                    <ul class="menuson">
                        <li><cite></cite><a href="#">编辑内容</a><i></i></li>
                        <li><cite></cite><a href="#">发布信息</a><i></i></li>
                        <li><cite></cite><a href="#">档案列表显示</a><i></i></li>
                    </ul>     
                </dd> 
            
            
                <dd>
                    <div class="title">
                        <span><img src="${path}/common/images/leftico03.png" /></span>编辑器
                    </div>
                    <ul class="menuson">
                        <li><cite></cite><a href="#">自定义</a><i></i></li>
                        <li><cite></cite><a href="#">常用资料</a><i></i></li>
                        <li><cite></cite><a href="#">信息列表</a><i></i></li>
                        <li><cite></cite><a href="#">其他</a><i></i></li>
                    </ul>    
                </dd>  
            
            
                <dd>
                    <div class="title">
                        <span><img src="${path}/common/images/leftico04.png" /></span>日期管理
                    </div>
                    <ul class="menuson">
                        <li><cite></cite><a href="#">自定义</a><i></i></li>
                        <li><cite></cite><a href="#">常用资料</a><i></i></li>
                        <li><cite></cite><a href="#">信息列表</a><i></i></li>
                        <li><cite></cite><a href="#">其他</a><i></i></li>
                    </ul>
                </dd> 
                 --> 
            </dl>
        </div>
        <div class="right">
            <iframe src="login.html" width="100%" id="content" name="content" scrolling="no"></iframe>
        </div>
    </div>
</body>
</html>