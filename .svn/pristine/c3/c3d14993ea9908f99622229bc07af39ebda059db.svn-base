<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台登录</title>
<link rel="stylesheet" type="text/css" href="res/css/styles_login.css">
<link rel="stylesheet" href="res/layui/css/layui.css">
		<script src="res/js/jquery-2.1.3.min.js" type="text/javascript" ></script>
		<script src="res/layui/layui.js"></script>
<script type="text/javascript">
	$(function(){
		$("#sub").click(function(){
			url="staff/login.action";
			data=$("#oneFrom").serialize();
			$.post(url,data,function(m){
				if(m.mes=="ok"){
					window.location.href="staff/findAllModel.action"
				}else{
					layui.use('layer', function(){
						  var layer = layui.layer;
						  
						  layer.msg('该用户不存在');
						});                
				}
			})
		})
	})
</script>
</head>
<body>


<div class="wrapper">

	<div class="container">
		<!-- <h1>E货源后台管理系统</h1> -->
		<form class="form" id = "oneFrom">
			<input placeholder="用户名" type="text" name="staEmail">
			<input placeholder="密码" type="password" name="staPwd">
			<button type="button"  id="sub">登录</button>
		</form>
	</div>
	
	<ul class="bg-bubbles">
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>
	
</div>




</body></html>