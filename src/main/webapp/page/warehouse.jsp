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

<title>仓库表</title>
</head>
<body>
	<div class="layui-tab">
	  <ul class="layui-tab-title">
	    <li class="layui-this">药品仓库</li>
	    <li>原材料仓库</li>
	  </ul>
	  <div class="layui-tab-content" style="height: 100px;">
	    <div class="layui-tab-item layui-show">
		    <div class="demoTable">
				字段搜索
				<div class="layui-inline">
					<input class="layui-input" name="id" id="demoReload"
						autocomplete="off">
				</div>
				<button class="layui-btn" data-type="reload" onclick="sousuo">搜索</button>
				
			</div>
			
			<table class="layui-hide" id="LAY_table_user" lay-filter="kindswar">
		
		
			</table>
	    </div>
	    <div class="layui-tab-item">
		    <table class="layui-table"  lay-skin="nob" id="LAY_table_raw">
				
			</table>
	    	
	    </div>
	    
	  </div>
	</div> 
	
	<script>
	layui.use('element', function(){
		  var $ = layui.jquery
		  ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
		  
		  //触发事件
		  var active = {
		   tabChange: function(){
		      //切换到指定Tab项
		      element.tabChange('demo', '22'); //切换到：用户管理
		    }
		  };
		  
		  
		});
		var table;

		layui.use('table', function() {
			table = layui.table;
			//工具条
			//监听工具条
			  table.on('tool(kindswar)', function(obj){
			    var data = obj.data;//得到当前行的数据
			   if(obj.event === 'buredit'){//判断点击的是那个按钮
				   var da = {"kinId":data.kinId};
				   $.post("ErpKindsAction/selectByPrimaryNewKinId.action",da,function(kin){
			  	      	
				   });
			    }
			  });
			//方法级渲染
			table.render({
				elem : '#LAY_table_user',
				url : 'Warehouse/showListKin.action',
				method : 'POST',
				cols : [ [ {
					checkbox : true,
					fixed : true
				}, {
					field : 'kinName',
					title : '药品名',
					width : 180,
					align : 'center'
				}, {
					field : 'wareNum',
					title : '库存量',
					width : 180,
					sort : true,
					align : 'center'
				}
				,{
					field : 'kinPrice',
					title : '单价',
					width : 180,
					align : 'center'
				}
				,{
					field : 'createtime',
					title : '创建时间',
					width : 180,
					align : 'center'
				}
				,{
					field : 'remark',
					title : '备注',
					width : 300,
					align : 'center'
				}
				,{
					toolbar: '#barDemo',
					title : '操作',
					width : 180,
					//align : 'center',
					sort: true, 
					fixed: 'right'
				}
				
				] ],
				
				page : true,
				height : 315
				
			});
			//方法级渲染
			table.render({
				elem : '#LAY_table_raw',
				url : 'Warehouse/selectAllRaw.action',
				method : 'POST',
				cols : [ [ {
					checkbox : true,
					fixed : true
				}, {
					field : 'rawName',
					title : '原材料名',
					width : 180,
					align : 'center'
				}, {
					field : 'wareNum',
					title : '库存量',
					width : 180,
					sort : true,
					align : 'center'
				}
				,{
					field : 'rawPrice',
					title : '单价',
					width : 180,
					align : 'center'
				}
				,{
					field : 'createtime',
					title : '创建时间',
					width : 180,
					align : 'center'
				}
				,{
					field : 'remark',
					title : '备注',
					width : 300,
					align : 'center'
				}
				,{
					toolbar: '#rawDemo',
					title : '操作',
					width : 180,
					//align : 'center',
					sort: true, 
					fixed: 'right'
				}
				
				] ],
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
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-mini" lay-event="buredit" >查看详情</a>
</script>
<script type="text/html" id="rawDemo">
  <a class="layui-btn layui-btn-mini" lay-event="buredit" >查看详情</a>
</script>
</body>
</html>