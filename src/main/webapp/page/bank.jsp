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
		<title>入库管理</title>
		<link rel="stylesheet" href="res/layui/css/layui.css" media="all">
		<script src="res/js/jquery-2.1.3.min.js"></script>
		<script src="res/layui/layui.js" charset="utf-8"></script>
		<script src="res/js/echarts.js"></script>
		<style type="text/css">
			body{
				margin: 2%;
			}
			.bode{
				border-bottom: 1px solid #5FB878;
				width: 20%;
				float: left; 
			}
			.forzi{
				width: 8%;
				float: left;
			}
		</style>
</head>
<body>
<!-- 搜索开始 -->
<table>
		<tr>
		<td style="width: 8%;">
		<form class="layui-form" >
			<select lay-filter="aihao" id="seleAi">
		       <option value="1" selected>待审核</option>
		       <option value="2">通过</option>
		       <option value="3">打回</option>
		       <option value="4">入库</option>
		    </select>
		</form>
		</td>
		<td style="width:3%;"></td>
		<td>
			<div class="layui-inline" >
	   		 <input class="layui-input" name="price" id="price" placeholder="请输入" autocomplete="off">
	  	</div>
		  <button class="layui-btn" data-type="reload" onclick="solo()">搜索</button>
		</td>
	</tr>
	
</table>
<!-- 搜索结束 -->

	<table class="layui-hide" id="LAY_table_user" lay-filter="user">


	</table>
	<!-- 入库详情 -->
	<div id="xq-div" style="display: none; margin: 3%;"> 
		<table class="layui-table"  lay-skin="nob" >
		  <tbody id="xq-purSkin">
		  </tbody>
		</table>
		<table class="layui-table"  lay-skin="nob" id="xq-proTab">
		  
		</table>
		 <div id="but-shen"  style=" position:fixed; bottom:6%;width:53.5%; padding-left: 22%;background-color: #f3f5f399;">
				<button class="layui-btn" style="margin-right: 23%;" onclick="yesb()">
				  <i class="layui-icon">&#xe6af;</i>入库
				</button>
				<button class="layui-btn layui-btn-danger" onclick="nob()">
				  <i class="layui-icon">&#xe69c;</i>取消
				</button>
		</div>
	</div>
	<!-- 入库结束 end！！ -->
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
				},  {
					field : 'bankIsva',
					title : '入库状态',
					width : 180,
					align : 'center',
					templet: '#ivsaBank'
				}
				, {
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
				id : 'tableBank',
				page : true,
				height : 315
			});
			table.on('tool(user)', function(obj){
			     var data = obj.data;//得到当前行的数据
			     var da = {'bankId':data.bankId};
				 if(obj.event === 'edit'){//判断点击的是那个按钮
					 $.post('Bank/selectByPrimaryKey.action',da,function(bri){
						   var a = bri.reaark;
						   if(a==null){//备注为空就等于“”
							   a="";
						   }
						   var b = bri.bankTime;
						   if(b==null){//备注为空就等于“”
							   b="";
						   }
						   $("#xq-purSkin").html("<tr><td>入库单号:</td>"
									+"<td>"+bri.bankNumber+"</td><td>创建人:</td><td>"+bri.staName+"</td></tr><tr><td>入库总数:</td><td>"+bri.bankCount+"</td><td>创建时间:</td><td id='qNum'>"+bri.createtime+"</td></tr><tr>"
									+"<td>入库时间:</td><td>"+bri.bankTime+"</td>"
									+"</tr><tr><td>备注:</td><td>"+b+"</td></tr>"
							);
						   table.render({
								elem : '#xq-proTab',
								data: bri.det,
								cols : [ [ {
									field : 'data',
									title : '材料',
									width : 180,
									align : 'center',
									templet: '#IvsaKr'
								}, {
									field : 'invedetNum',
									title : '数量',
									width : 100,
									sort : true,
									align : 'center'
								}
								
								] ],
								width : 283
							});
						   layer.open({
						  		  type: 1,
						  		  title: ['详情'],
						  		  content: $('#xq-div'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
						  		 // btn: ['确定'], //可以无限个按钮
						  		  area: ['80%','90%']
						    });
					 },'json');
				 }else if(obj.event === 'rkedit'){
					 
				 }
			});
		});
		//下拉框的刷新表格方法
		var form;
		layui.use('form', function(){
			form = layui.form;
			  form.on('select(aihao)', function(data){
				  table.reload('tableBank', {
			  	 		where: { //设定异步数据接口的额外参数，任意设
			  				'price':data.value
			  			}
			  		});
			});
			
		});
		//取消的方法
		function nob(){
			layer.close(index);
		}
	</script>
<!-- 设置工具栏 -->
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-mini layui-bg-gray" lay-event="edit" >入库详情</a>
</script>
<script type="text/html" id="ivsaBank">
  {{#  if(d.bankIsva === 1){ }}
    	<span class="layui-badge layui-bg-gray">待审核</span>	
  {{# }else if(d.bankIsva === 2 ) { }}
		<span class="layui-badge layui-bg-green">通过</span>
  {{# }else if(d.bankIsva === 3 ) { }}
		<span class="layui-badge layui-bg-red">打回</span>
  {{#  } }}
</script>
<script id="IvsaKr" type="text/html">
  {{#  if(d.kindName === null || d.kindName === ""){ }}
    	{{ d.rawName }}
  {{# }else if(d.rawName ===null || d.rawName === "") { }}
		{{ d.kinsName }}
  {{#  } }} 
</script>
</body>
</html>