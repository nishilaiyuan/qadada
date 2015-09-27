<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%	   
	   String path = request.getContextPath(); 
        request.setAttribute("path", path);
%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="${path}/common/css/bootstrap.min.css" rel="stylesheet" />
		<link href="${path}/common/css/font-awesome.min.css"  rel="stylesheet"/>
		<link href="${path}/common/css/ace.min.css" rel="stylesheet" />
		<title>Application</title>
	</head>
	<body class="login-layout">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1>
									<i class="icon-leaf green"></i>
									<span class="red">Ace</span>
									<span class="white">Application</span>
								</h1>
								<h4 class="blue">&copy; Company Name</h4>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="icon-coffee green"></i>
												请输入帐号信息
											</h4>

											<div class="space-6"></div>

											<form action="${path}/submitlogin" method="post" id="loginForm" name="loginForm">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" name="account" class="form-control" placeholder="用户名" />
															<i class="icon-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" name="password" class="form-control" placeholder="密码" />
															<i class="icon-lock"></i>
														</span>
													</label>

													<div class="space"></div>

													<div class="clearfix">
														<label class="inline">
															<input type="checkbox" class="ace" />
															<span class="lbl"> 记住我</span>
														</label>
														<input type="submit" class="width-35 pull-right btn btn-sm btn-primary" value="登录"/>
													</div>
													<div class="space-4"></div>
												</fieldset>
											</form>
										</div><!-- /widget-main -->
									</div><!-- /widget-body -->
								</div><!-- /login-box -->
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<script type="text/javascript" src="${path}/common/js/jquery-2.0.3.min.js"></script>
		</body>
</html>