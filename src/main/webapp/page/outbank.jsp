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
		<title>出库管理</title>
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
		<td style="width: 15%;">
		<form class="layui-form" >
			<select lay-filter="aihao" id="seleAi">
		       <option value="2" selected>等待出库</option>
		       <option value="3">打回</option>
		       <option value="4">已出库</option>
		       <option value="5">库存不足</option>
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
		<input type="hidden" id="bankIda">
		<table class="layui-table"  lay-skin="nob" >
		  <tbody id="xq-purSkin">
		  </tbody>
		</table>
		<table class="layui-table"  lay-skin="nob" id="xq-proTab">
		  
		</table>
		 <div id="but-shen"  style=" position:fixed; bottom:6%;width:53.5%; padding-left: 22%;background-color: #f3f5f399;">
				<button class="layui-btn" style="margin-right: 23%;" onclick="yesb()">
				  <i class="layui-icon">&#xe6af;</i> 出库
				</button>
				<button class="layui-btn layui-btn-danger" onclick="nob()">
				  <i class="layui-icon">&#xe69c;</i>取消
				</button>
		</div>
	</div>
	<!-- 入库结束 end！！ -->
	<script>
		var table;
		var index;
		layui.use('table', function() {
			table = layui.table;

			//方法级渲染
			table.render({
				elem : '#LAY_table_user',
				url : 'ErpOutbankAction/selectAll.action',
				where: { //设定异步数据接口的额外参数，任意设
	  				'price':2
	  			},
				method : 'POST',
				cols : [ [  {
					field : 'obNumber',
					title : '出库编号',
					width : 180,
					align : 'center'
				}, {
					field : 'obWarecount',
					title : '出库数量',
					width : 100,
					align : 'center'
				},  {
					field : 'obBusibess',
					title : '出库状态',
					width : 100,
					align : 'center',
					templet: '#ivsaBank'
				}
				, {
					field : 'staName',
					title : '创建人',
					width : 120,
					align : 'center'
				}
				, {
					field : 'remark',
					title : '备注',
					width : 160,
					align : 'center'
				}
				
				,{
					toolbar: '#barDemo',
					title : '操作',
					width : 160,
					//align : 'center',
					sort: true, 
					fixed: 'right'
				}
				
				] ],
				id : 'tableBank',
				page : true
			});
			
			table.on('tool(user)', function(obj){
			     var data = obj.data;//得到当前行的数据
			     var da = {'obId':data.obId};
				 if(obj.event === 'edit' || obj.event === 'editxq'){//判断点击的是那个按钮
					 if(obj.event === 'editxq'){
						 $("#but-shen").hide();
					 }else{
						 $("#but-shen").show();
					 }
				 	 
					 $.post('ErpOutbankAction/selectByPrimaryKey.action',da,function(bri){
						   var a = bri.remark;
						   if(a==null){//备注为空就等于“”
							   a="";
						   }
						   var wah = bri.obTime;
						   if(wah==null){//备注为空就等于“”
							   wah="";
						   }
						 	$("#bankIda").val(bri.obId);//赋值
						   $("#xq-purSkin").html("<tr><td>出库单号:</td>"
									+"<td>"+bri.obNumber+"</td><td>创建人:</td><td>"+bri.staName+"</td></tr><tr><td>出库总数:</td><td>"+bri.obWarecount+"</td><td>创建时间:</td><td id='qNum'>"+bri.createtime+"</td></tr><tr>"
									+"<td>出库时间:</td><td>"+wah+"</td>"
									+"</tr><tr><td>备注:</td><td>"+a+"</td></tr>"
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
						   index = layer.open({
						  		  type: 1,
						  		  title: ['详情'],
						  		  content: $('#xq-div'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
						  		 // btn: ['确定'], //可以无限个按钮
						  		  area: ['80%','90%']
						    });
					 },'json');
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
		function yesb(){
			var data = {"obId":$("#bankIda").val()};//取出出库数据
			$.post('ErpInvedetAction/selectByPrimary.action',data,function(mes){
				if(mes=="1"){
					layer.msg('<i class="layui-icon" style="font-size: 40px; color: #5FB878;">&#xe618;</i>出库成功');
				}else{
					layer.msg('<i class="layui-icon" style="font-size: 40px; color: #5FB878;">&#xe618;</i>'+mes);
				}
				table.reload('tableBank', {
		  	 		where: { //设定异步数据接口的额外参数，任意设
		  				'price':$("#seleAi").val()
		  			}
		  		});
			 	layer.close(index);
			},'json');
		}
		//搜索的方法
		function solo(){
			table.reload('tableBank', {
	  	 		where: { //设定异步数据接口的额外参数，任意设
	  				'price':$("#seleAi").val(),
	  				'prie':$("#price").val()
	  			}
	  		});
			
		}
	</script>
<!-- 设置工具栏 -->
<script type="text/html" id="barDemo">
  {{#  if(d.obBusibess === 1 || d.obBusibess===3 || d.obBusibess === 4 ){ }}
		<a class="layui-btn layui-btn-mini layui-bg-gray" lay-event="editxq" >出库详情</a>
  {{# }else if(d.obBusibess === 2 ||  d.obBusibess===5) { }}
		<a class="layui-btn layui-btn-mini layui-bg-red" lay-event="edit" >出库</a>
		<a class="layui-btn layui-btn-mini layui-bg-gray" lay-event="editxq" >出库详情</a>
  {{#  } }}
</script>
<script type="text/html" id="ivsaBank">
  {{#  if(d.obBusibess === 1){ }}
    	<span class="layui-badge layui-bg-gray">待审核</span>	
  {{# }else if(d.obBusibess === 2 ) { }}
		<span class="layui-badge layui-bg-green">通过</span>
  {{# }else if(d.obBusibess === 3 ) { }}
		<span class="layui-badge layui-bg-red">打回</span>
  {{# }else if(d.obBusibess === 4 ) { }}
		<span class="layui-badge layui-bg-orange">已出库</span>
  {{# }else if(d.obBusibess === 5 ) { }}
		<span class="layui-badge layui-bg-orange">材料不足</span>
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