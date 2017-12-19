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
<style type="text/css">
#ss {
	color: #780000;
	font-size: 18px;
	text-align: center;
}
</style>
<title>分店支出详细</title>

</head>
<body>
	<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
		<ul class="layui-tab-title">
			<li class="layui-this">收入</li>
			<li>支出</li>
		</ul>
		<div class="layui-tab-content" style="height: 100px;">
			<div class="layui-tab-item layui-show">
				<div class="demoTable">
					<div class="layui-inline">
						<input class="layui-input" name="id" id="demoReload"
							autocomplete="off">
					</div>
					<button class="layui-btn" data-type="reload" onclick="sousuo">搜索</button>
				</div>
				<table class="layui-hide" id="LAY_table_user" lay-filter="user"></table>
			</div>
			<div class="layui-tab-item">
				<div class="layui-tab-item layui-show">
					<div class="demoTable">
						<div class="layui-inline">
							<input class="layui-input" name="id2" id="demoReload2"
								autocomplete="off">
						</div>
						<button class="layui-btn" data-type="reload2" onclick="sousuo">搜索</button>
					</div>
					<table class="layui-hide" id="LAY_table_user2" lay-filter="user2"></table>
				</div>
			</div>

		</div>
	</div>
	<script>
			var table;

			layui.use([ 'laydate', 'element', 'table' ], function() {
				table = layui.table;
				//获取hash来切换选项卡，假设当前地址的hash为lay-id对应的值
				//方法级渲染
				table.render({
					elem : '#LAY_table_user',
					url : 'ErpLedgyr/selectAll.action',
					method : 'POST',
					cols : [ [ {
						checkbox : true,
						fixed : true
					}, {
						field : 'GYR_SREIAL',
						title : '支出收入编号',
						width : 180,
						sort : true,
						align : 'center'
					}, {
						field : 'GYR_PRICE',
						title : '支出金额',
						width : 180,
						align : 'center'
					}, {
						field : 'SALE_NUM',
						title : '分店销售数量',
						width : 180,
						align : 'center'
					}, {
						field : 'SALE_MONEY',
						title : '分店销售金额',
						width : 180,
						align : 'center'
					}, {
						field : 'SALE_DATE',
						title : '分店销售时间',
						width : 180,
						align : 'center'
					}, {
						fixed : 'right',
						title : '操作',
						width : 152.5,
						align : 'center',
						toolbar : '#barDemo'
					} ] ],
					id : 'testReload',
					page : true
				});

				table.on('tool(user)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
					var data = obj.data; //获得当前行数据
					var layEvent = obj.event; //获得 lay-event 对应的值
					var tr = obj.tr; //获得当前行 tr 的DOM对象

					if(layEvent === 'edit'){
						//向服务端发送删除指令.
						var url = "ErpLedgyr/CheckDetails.action";//查询详情
						var data2 = {
							'id' : data.GYR_ID
						};
						$.post(url, data2, function(returnData) {
							var tabVal = '<div id="ss">查看详情</div>';
							$.each(returnData, function(i, item) {
								tabVal += '' + '<tr>' + '<td>' + item.GYR_PRICE
										+ '</td>' + '<td>' + item.REMARK
										+ '</td>' + '<td>' + item.SALE_NUM
										+ '</td>' + '<td>' + item.SALE_MONEY
										+ '</td>' + '<td>' + item.SALE_DATE
										+ '</td>' + '</tr>' + '';
							})
							layer.open({
								type : 1,
								title : false, //不显示标题栏
								closeBtn : true,
								area: '600px',//调节宽度，高度自适应
								shade : 0.8,
								id : 'LAY_layuipro', //设定一个id，防止重复弹出
								btnAlign : 'c',
								moveType : 1, //拖拽模式，0或者1
								content : '<table class="layui-table" style="color:#404040">' + '<thead>'
										+ '<tr>' 
										+ '<th>支出金额</th>' 
										+ '<th>备注</th>'
										+ '<th>分店销售数量</th>' 
										+ '<th>分店销售金额</th>'
										+ '<th>分店销售时间</th>'
										+ '</tr>' 
										+ '</thead>'
										+ '<tbody>'+ tabVal + '</tbody>'
										+ '</table>',
							});
						})
					}
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
	<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-mini" lay-event="edit">查看</a>
</script>

	<!-- 支付数据表格初始化 -->
	<script>
			var table;

			layui.use([ 'laydate', 'element', 'table' ], function() {
				table = layui.table;
				//获取hash来切换选项卡，假设当前地址的hash为lay-id对应的值
				//方法级渲染
				table.render({
					elem : '#LAY_table_user2',
					url : 'ErpLedgyr/selectAllzhichu.action',
					method : 'POST',
					cols : [ [ {
						checkbox : true,
						fixed : true
					}, {
						field : 'GYR_SREIAL',
						title : '支出收入编号',
						width : 180,
						sort : true,
						align : 'center'
					}, {
						field : 'GYR_PRICE',
						title : '支出金额',
						width : 180,
						align : 'center'
					}, {
						field : 'FDPRO_WARECOUNT',
						title : '订购商品的总数',
						width : 180,
						align : 'center'
					}, {
						field : 'FDPRO_SUMPRICE',
						title : '订购商品总价',
						width : 180,
						align : 'center'
					}, {
						field : 'FDPRO_TIME',
						title : '订单日期',
						width : 180,
						align : 'center'
					}, {
						fixed : 'right',
						title : '操作',
						width : 170,
						align : 'center',
						toolbar : '#barDemo2'
					} ] ],
					id : 'testReload2',
					page : true
				});

				table.on('tool(user2)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
					var data = obj.data; //获得当前行数据
					var layEvent = obj.event; //获得 lay-event 对应的值
					var tr = obj.tr; //获得当前行 tr 的DOM对象
					if(layEvent === 'edit'){
						//向服务端发送删除指令.
						var url = "ErpLedgyr/CheckDetailss.action";//查询详情
						var data3 = {
							'id' : data.GYR_ID
						};
						$.post(url, data3, function(returnData) {
							var tabVal = '<div id="ss">查看详情</div>';
							$.each(returnData, function(i, item) {
								tabVal += '' + '<tr>' + '<td>' + item.GYR_PRICE
										+ '</td>' + '<td>' + item.FDPRO_WARECOUNT
										+ '</td>' + '<td>' + item.FDPRO_SUMPRICE
										+ '</td>' + '<td>' + item.FDPRO_TIME
										+ '</td>' + '</tr>' + '';
							})
							layer.open({
								type : 1,
								title : false, //不显示标题栏
								closeBtn : true,
								area: '600px',//调节宽度，高度自适应
								shade : 0.8,
								id : 'LAY_layuipro', //设定一个id，防止重复弹出
								btnAlign : 'c',
								moveType : 1, //拖拽模式，0或者1
								content : '<table class="layui-table" style="color:#404040">' + '<thead>'
										+ '<tr>' 
										+ '<th>支出金额</th>' 
										+ '<th>订购商品的总数</th>'
										+ '<th>订购商品总价</th>' 
										+ '<th>订单的日期</th>'
										+ '</tr>' 
										+ '</thead>'
										+ '<tbody>'+ tabVal + '</tbody>'
										+ '</table>',
							});
						})
					}
				});

				//This搜索
				var $ = layui.$, active = {
					reload : function() {
						var demoReload = $('#demoReload2');
						table.reload('testReload2', {
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
	<script type="text/html" id="barDemo2">
			<a class="layui-btn layui-btn-mini" lay-event="edit">查看</a>
</script>
</body>
</html>