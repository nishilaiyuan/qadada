<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%	   
	   String path = request.getContextPath(); 
        request.setAttribute("path", path);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="${path}/common/css/login.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${path}/common/js/jquery.js"></script>
	<script type="text/javascript" src="${path}/common/js/login.js" ></script>
		<script type="text/javascript" >
			var path = "${path}";	//javascript全局变量
		</script>
		<title>Ultra-SelfMaintain</title>
	</head>
<body>



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎登录后台管理界面平台</span>    
    <ul>
    <li><a href="#">回首页</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
       
    <div class="loginbox"> 
           <form action="${path}/submitlogin" method="post" id="loginForm" name="loginForm">
            <ul>
            <li><input name="username" type="text" class="loginuser" value="admin" id="username" onclick="JavaScript:this.value=''"/></li>
            <li><input name="password" type="password" class="loginpwd" value="密码" id="password" onclick="JavaScript:this.value=''"/></li>
            <li><input type="button" class="loginbtn" value="登录"  onclick="checkUserForm();" /> <label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="#">忘记密码？</a></label></li>
            </ul>
          </form>
        </div>
    
    </div>
    
    
    
    <div class="loginbm">版权所有  2013  <a href="http://www.mycodes.net">源码之家</a> </div>
	
    
</body>
</html>