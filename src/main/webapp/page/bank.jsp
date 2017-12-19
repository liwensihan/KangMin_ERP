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
			#ss{
				color:#780000;	
				font-size:18px;
				text-align:center;
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
		       <option value="1" selected>待审核</option>
		       <option value="2">通过</option>
		       <option value="3">打回</option>
		       <option value="4">已入库</option>
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
		var index;
		layui.use('table', function() {
			table = layui.table;

			//方法级渲染
			table.render({
				elem : '#LAY_table_user',
				url : 'Bank/selectAll.action',
				where: { //设定异步数据接口的额外参数，任意设
	  				'price':1
	  			},
				method : 'POST',
				cols : [ [  {
					field : 'bankNumber',
					title : '入库编号',
					width : 180,
					align : 'center'
				}, {
					field : 'bankCount',
					title : '入库数量',
					width : 100,
					align : 'center'
				},  {
					field : 'bankIsva',
					title : '入库状态',
					width : 100,
					align : 'center',
					templet: '#ivsaBank'
				}
				, {
					field : 'staName',
					title : '创建人',
					width : 100,
					align : 'center'
				}
				, {
					field : 'reaark',
					title : '备注',
					width : 180,
					align : 'center'
				}
				
				,{
					toolbar: '#barDemo',
					title : '操作',
					width : 200,
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
			     var da = {'bankId':data.bankId};
				 if(obj.event === 'edit' || obj.event === 'editxq'){//判断点击的是那个按钮
					 if(obj.event === 'editxq'){
						 $("#but-shen").hide();
					 }else{
						 $("#but-shen").show();
					 }
				 	 
					 $.post('Bank/selectByPrimaryKey.action',da,function(bri){
						   var a = bri.reaark;
						   if(a==null){//备注为空就等于“”
							   a="";
						   }
						   var wah = bri.bankTime;
						   if(wah==null){//备注为空就等于“”
							   wah="";
						   }
						 	$("#bankIda").val(bri.bankId);//赋值
						   $("#xq-purSkin").html("<tr><td>入库单号:</td>"
									+"<td>"+bri.bankNumber+"</td><td>创建人:</td><td>"+bri.staName+"</td></tr><tr><td>入库总数:</td><td>"+bri.bankCount+"</td><td>创建时间:</td><td id='qNum'>"+bri.createtime+"</td></tr><tr>"
									+"<td>入库时间:</td><td>"+wah+"</td>"
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
				 }else if(obj.event === 'record'){
						var url = "auditAction/showListById.action";
						var datas = {
							'purcId' : data.bankId
						};
						$.post(url, datas, function(returnData) {
							var tabVal = '<div id="ss">审核记录</div>';
							$.each(returnData, function(i, item) {
								var state ;
								if(item.state == 0){
									state='<span class="layui-badge">审核未通过</span>';
								}else{
									state='<span class="layui-badge layui-bg-green">审核已通过<span>';
								}
								tabVal += '' + '<tr>' + '<td>' + item.audName
										+ '</td>' + '<td>' + item.audTime
										+ '</td>' + '<td>' + state
										+ '</td>' + '<td>' + item.feedBack
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
										+ '<th>审核人</th>' 
										+ '<th>审核时间</th>'
										+ '<th>状态</th>' 
										+ '<th>回馈信息</th>' 
										+ '</tr>' 
										+ '</thead>'
										+ '<tbody>'+ tabVal + '</tbody>'
										+ '</table>',
							});
						})
						
					}else if(obj.event === 'audit'){ //审核
						if(data.bankIsva == '1'){
							layer.open({
								type: 1
								,title: false //不显示标题栏
								,btn: ['通过', '打回']
								,btnAlign: 'c'
								,area: ['500px', '300px']
								,moveType: 1 //拖拽模式，0或者1
								,content:'<form class="layui-form" style="margin:20px;" id="duitFeedback">'+
								 '<input type="hidden" name="bankId" value="'+data.bankId+'">'+
								 '<input type="hidden" name="state" value="" id="feedState">'+
								 '<div class="layui-form-item layui-form-text">回馈内容 :'+
								      '<textarea style="margin-right:20px;height:150px;" name="feedBack" placeholder="请输入内容" class="layui-textarea"></textarea>'+
								  '</div>'+
								'<form>'
								,yes: function(index, layero){
									$("#feedState").val("2");
									loadIndex = layer.load();//出现加载层
									$.ajax({
										url :'Bank/auditFeedback.action',
										type:'POST',
										data:new FormData($("#duitFeedback")[0]),
										async: false,  
								        cache: false,  
								        contentType: false,  
								        processData: false,  
										success:function(returnData){
											layer.close(index);
											layer.close(loadIndex);//加载层关闭
											$(".layui-laypage-skip .layui-laypage-btn",window.document).click();//刷新父页面数据表格的当前页
											layer.msg("提交成功!");
										},
										error:function(returnData){
											layer.close(loadIndex);//加载层关闭
											layer.msg("数据异常!");
										}
									})
								}
								,btn2:function(index,layero){
									$("#feedState").val("3");
									$.ajax({
										url :'Bank/auditFeedback.action',
										type:'POST',
										data:new FormData($("#duitFeedback")[0]),
										async: false,  
								        cache: false,  
								        contentType: false,  
								        processData: false,  
										success:function(returnData){
											layer.close(index);
											layer.close(loadIndex);//加载层关闭
											$(".layui-laypage-skip .layui-laypage-btn",window.document).click();//刷新父页面数据表格的当前页
											layer.msg("提交成功!");
										},
										error:function(returnData){
											layer.close(loadIndex);//加载层关闭
											layer.msg("数据异常!");
										}
									})
								}
							}); 
						}else{
							layer.msg("该数据已审核,请勿重复审核");
						}
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
			var data = {"bankId":$("#bankIda").val()};//取出出库数据
			$.post('ErpInvedetAction/selectByPrimaryKey.action',data,function(mes){
				if(mes.state==1){//真确的样式
			 		layer.msg('<i class="layui-icon" style="font-size: 40px; color: #5FB878;">&#xe618;</i>'+mes.mes);
			 	}else{
			 		layer.msg('<i class="layui-icon" style="font-size: 40px; color: #FF5722;">&#x1006;</i>'+mes.mes);
			 	}
				table.reload('tableBank', {
		  	 		where: { //设定异步数据接口的额外参数，任意设
		  				'price':$("#seleAi").val()
		  			}
		  		});
			 	layer.close(index);
			});
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
  {{#  if(d.bankIsva === 1 || d.bankIsva===3 || d.bankIsva === 4 ){ }}
		<a class="layui-btn layui-btn-mini layui-bg-gray" lay-event="editxq" >入库详情</a>
		<a class="layui-btn layui-btn-mini" lay-event="audit">审核</a>
  		<a class="layui-btn layui-btn-mini layui-bg-orange" lay-event="record">记录</a>
  {{# }else if(d.bankIsva === 2 ) { }}
		<a class="layui-btn layui-btn-mini layui-bg-red" lay-event="edit" >入库</a>
		<a class="layui-btn layui-btn-mini layui-bg-gray" lay-event="editxq" >入库详情</a>
  		<a class="layui-btn layui-btn-mini layui-bg-orange" lay-event="record">记录</a>
  {{#  } }}
</script>
<script type="text/html" id="ivsaBank">
  {{#  if(d.bankIsva === 1){ }}
    	<span class="layui-badge layui-bg-gray">待审核</span>	
  {{# }else if(d.bankIsva === 2 ) { }}
		<span class="layui-badge layui-bg-green">通过</span>
  {{# }else if(d.bankIsva === 3 ) { }}
		<span class="layui-badge layui-bg-red">打回</span>
  {{# }else if(d.bankIsva === 4 ) { }}
		<span class="layui-badge layui-bg-orange">已入库</span>
  {{#  } }}
</script>
<script id="IvsaKr" type="text/html">
  {{#  if(d.kinsName === null || d.kinsName === ""){ }}
    	{{ d.rawName }}
  {{#  } else { }}
   		{{ d.kinsName }}
  {{#  } }}
</script>
</body>
</html>