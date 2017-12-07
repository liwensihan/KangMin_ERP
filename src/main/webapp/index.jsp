<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="res/layui/css/layui.css" media="all">
<script src="res/js/jquery-2.1.3.min.js"></script>
<script src="res/layui/layui.js" charset="utf-8"></script>
<script src="res/js/echarts.js"></script>
</head>
<style>
#title_tu {
	color: 393D49;
	font-size: 28px;
	text-align: center;
}
</style>
<body>
	<p id="title_tu">各分店销售统计图</p>
	<form class="layui-form" style="float: right;">
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">分店:</label>
				<div class="layui-input-inline" style="width: 100px">
					<select name="city" lay-verify="required" lay-search>
						<option value=""></option>
						<option value="0">北京</option>
						<option value="1">上海</option>
						<option value="2">广州</option>
						<option value="3">深圳</option>
						<option value="4">杭州</option>
					</select>
				</div>
				<div class="layui-form-mid">年份:</div>
				<div class="layui-input-inline" style="width: 100px">
					<input class="layui-input" id="test2" type="text">
				</div>
				<div class="layui-form-mid">月份:</div>
				<div class="layui-input-inline" style="width: 100px">
					<input class="layui-input" id="test3" type="text">
				</div>
			</div>
		</div>
	</form>
</body>
<script>
	layui.use([ 'form', 'laydate' ], function() {
		var form = layui.form;
		var laydate = layui.laydate;

		//各种基于事件的操作，下面会有进一步介绍
		var myDate = new Date();
		//年选择器
		laydate.render({ 
		  elem: '#test2'
		  ,type: 'year'
		});
		
		//年月选择器
		laydate.render({ 
		  elem: '#test3'
		  ,type: 'month'
		});
	});
</script>
</html>