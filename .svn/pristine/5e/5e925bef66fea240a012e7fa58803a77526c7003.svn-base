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

<title>采购订单表</title>
</head>
<body>

	<div class="demoTable">
		搜索
		<div class="layui-inline">
			<input class="layui-input" name="id" id="demoReload"
				autocomplete="off">
		</div>
		<button class="layui-btn" data-type="reload" onclick="sousuo">搜索</button>
		<button data-type="auto" class="layui-btn layui-btn-normal"
			onclick="add('')">采购</button>
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
				url : 'Purchase/showAll.action',
				method : 'POST',
				cols : [ [ {
					checkbox : true,
					fixed : true
				}, {
					field : 'purcSerial',
					title : '采购编号',
					width : 180,
					sort : true,
					fixed : true,
					align : 'center'
				}, {
					field : 'purcTitle',
					title : '采购标题',
					width : 180,
					sort : true,
					align : 'center'
				}, {
					field : 'purcName',
					title : '采购人',
					width : 180,
					align : 'center'
				}, {
					field : 'state',
					title : '采购状态',
					width : 180,
					sort : true,
					align : 'center',
					templet : '#state'
				}, {
					fixed : 'right',
					title : '操作',
					width : 180,
					align : 'center',
					toolbar : '#barDemo'
				} ] ],
				id : 'testReload',
				page : true,
				height : 315
			});

			table.on('tool(user)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
				var data = obj.data; //获得当前行数据
				var layEvent = obj.event; //获得 lay-event 对应的值
				var tr = obj.tr; //获得当前行 tr 的DOM对象

				if (layEvent === 'del') { //删除
					layer.confirm('真的删除行么', function(index) {
						obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
						layer.close(index);
						//向服务端发送删除指令.
						var url = "Purchase/delete.action";
						var data2 = {
							'purcId' : data.purcId
						};
						$.post(url, data2, function() {

						})
					});
				}
				//else if (layEvent === 'edit') {
				//var title = '编辑采购表';
				//addOrUpdata(title, data.purcId);
				//}
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

		function addOrUpdata(title, purcId) {
			layer.open({
				type : 2,
				content : 'page/purchaseForm.jsp?id=' + purcId,
				area : [ '600px', '400px' ],
				title : title,
				cancel : function(index, layero) {

					layer.confirm('是否关闭?', {
						icon : 3,
						title : '提示'
					}, function(index2) {
						//do something

						layer.close(index);
						layer.close(index2);
					});
					return false;
				}
			});
		}

		function add(obj) {
			var addCen = layer.open({
				id : "purcFrom",
				type : 2 //Page层类型
				,
				skin : 'layui-layer-molv'//样式
				,
				area : [ '75%', '85%' ],
				title : '点击增加',
				shade : [ 0.8, '#393D49' ] //显示遮罩
				,
				maxmin : true //允许全屏最小化
				,
				anim : 2 //0-6的动画形式，-1不开启
				,
				shadeClose : true//点击也能遮罩层关闭
				,
				content : "page/purchaseForm.jsp?purcId=" + obj.purcId
						+ "&stId=" + obj.stId
			});
		}
	</script>
	<!-- <a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a> -->
	<script type="text/html" id="state">	
  {{#  if(d.state == 1){ }}
    <span class="layui-badge layui-bg-orange">审核中</span>
  {{#  } else if(d.state == 2) { }}
    <span class="layui-badge layui-bg-green">审核通过</span>
  {{#  } else if(d.state == 0) { }}
    <span class="layui-badge">审核未通过</span>
  {{#  } }}

</script>
	<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-mini" lay-event="audit">审核</a>
  <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>

</script>
</body>
</html>