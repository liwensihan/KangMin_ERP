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
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="<%=basePath%>res/layui/css/layui.css"
	media="all">
<script src="<%=basePath%>res/js/jquery-2.1.3.min.js"
	type="text/javascript"></script>
<script src="<%=basePath%>res/layui/layui.js" charset="utf-8"></script>

<title>入库单表</title>
</head>
<body>

	<div class="demoTable">
		字段搜索
		<div class="layui-inline">
			<input class="layui-input" name="id" id="demoReload"
				autocomplete="off">
		</div>
		<button class="layui-btn" data-type="reload" onclick="sousuo">搜索</button>
		
	</div>

	<table class="layui-hide" id="LAY_table_user" lay-filter="user">


	</table>
	<script>
		var table;

		layui.use('table', function() {
			table = layui.table;

			//方法级渲染
			table.render({
				elem : '#LAY_table_user',
				url : 'Bank/selectAll.action',
				method : 'POST',
				cols : [ [  {
					field : 'bankNumber',
					title : '入库编号',
					width : 180,
					align : 'center'
				}, {
					field : 'bankCount',
					title : '入库数量',
					width : 180,
					align : 'center'
				}, {
					field : 'reaark',
					title : '备注',
					width : 180,
					align : 'center'
				},{
					toolbar: '#barDemo',
					title : '操作',
					width : 200,
					//align : 'center',
					sort: true, 
					fixed: 'right'
				}
				
				] ],
				id : 'testReload',
				page : true,
				height : 315
			});


			//This搜索
			var $ = layui.$, active = {
				reload : function() {
					var demoReload = $('#demoReload');
					table.reload('testReload', {
						where : {
							keywords : demoReload.val(),
						}
					});
				}
			};

			$('.demoTable .layui-btn').on('click', function() {
				var type = $(this).data('type');
				active[type] ? active[type].call(this) : '';
			});
		});

	</script>
<!-- 设置工具栏 -->
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-mini" lay-event="edit" >详情</a>
</script>
</body>
</html>