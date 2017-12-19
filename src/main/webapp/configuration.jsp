<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>系统配置</title>
		<link rel="stylesheet" href="res/layui/css/layui.css">
		<script src="res/js/jquery-2.1.3.min.js" type="text/javascript" ></script>
		<script src="res/layui/layui.js"></script>
		
	</head>
	<body>
		<div class="layui-tab">
		  <ul class="layui-tab-title">
		    <li class="layui-this">首页轮播图片</li>
		    <li>用户管理</li>
		    <li>权限分配</li>
		    <li>商品管理</li>
		    <li>订单管理</li>
		  </ul>
		  <div class="layui-tab-content">
		    <div class="layui-tab-item layui-show">
		      
		    </div>
		    <div class="layui-tab-item">内容2</div>
		    <div class="layui-tab-item">内容3</div>
		    <div class="layui-tab-item">内容4</div>
		    <div class="layui-tab-item">内容5</div>
		  </div>
		</div>
	</body>
	
</html>