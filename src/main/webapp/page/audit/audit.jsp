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
<title>总经理审核</title>
<style type="text/css">
	#ss{
		color:#780000;	
		font-size:18px;
		text-align:center;
	}
</style>
</head>
<body>
	
<div class="layui-tab layui-tab-brief" lay-filter="test1">
		<ul class="layui-tab-title">
			<li class="layui-this">审核信息</li>
			<li>历史信息</li>
		</ul>
		<div class="layui-tab-content">
			<!-- 审核 -->
			<div class="layui-tab-item layui-show">
				<div class="demoTable">
					搜索关键字：
					<div class="layui-inline">
						<input class="layui-input" name="id3" id="demoReload3" autocomplete="off">
					</div>
					申请时间：
					<div class="layui-inline">
					<input type="text" class="layui-input" id="staEndTime3">
					</div>
					<button class="layui-btn" data-type="reload">搜索</button>
				</div>

				<table class="layui-hide" id="LAY_table_user3" lay-filter="user3"></table>
			</div>
			
			<!-- 审核 -->
			<div class="layui-tab-item">
				<div class="demoTable">
					搜索关键字：
					<div class="layui-inline">
						<input class="layui-input" name="id4" id="demoReload4" autocomplete="off">
					</div>
					审核时间：
					<div class="layui-inline">
					<input type="text" class="layui-input" id="staEndTime4">
					</div>
					<button class="layui-btn" data-type="reload">搜索</button>
				</div>

				<table class="layui-hide" id="LAY_table_user4" lay-filter="user4"></table>
			</div>
		</div>
	</div>
<script>
	var laydate;
	var element;
	var table;
	layui.use([ 'laydate', 'element', 'table' ], function() {
		laydate = layui.laydate;
		element = layui.element;
		table = layui.table;
		/*
		----------------------------------财务支出初始化数据加载
		*/
		//搜索时间范围实例
		laydate.render({
			  elem: '#staEndTime3', //指定元素
			  range: '~' //或 range: '~' 来自定义分割字符
		});
		
		loadIndex = layer.load();//出现加载层
		//方法级渲染
		table.render({
			elem : '#LAY_table_user3',
			url : 'applyasset/showList.action?maxState=1',
			method:'post',
			cols : [ [ {
				field : 'appassSerial',
				title : '编号',
				width : 150,
				fixed : true
			}, {
				field : 'appassApply',
				title : '申请人',
				width : 150
			}, {
				field : 'appassType',
				title : '申请类型',
				width : 140
			}, {
				field : 'state',
				title : '状态',
				width : 140,
				templet : '#state'
			}, {
				field : 'appassTime',
				title : '申请时间',
				width : 190
			}, {
				field : 'appassNum',
				title : '申请金额',
				sort : true,
				width : 120
			}, {
				field : 'remark',
				title : '备注',
				width : 120
			
			}, {
				fixed : 'right',
				title : '操作',
				width : 180,
				align : 'center',
				toolbar : '#barDemo3'
			} ] ],
			id : 'testReload3',
			page : true,
			done : function(res, curr, count) {
				layer.close(loadIndex);//加载层关闭  
			}
		});

		var $ = layui.$, active = {
			reload : function() {
				var demoReload = $('#demoReload3');
				var staEndTime = $("#staEndTime3");
				table.reload('testReload3', {
					where : {
							keyWord : demoReload.val(),
							staEndTime : staEndTime.val()
					}
				});
			}
		};

		$('.demoTable .layui-btn').on('click', function() {
			var type = $(this).data('type');
			active[type] ? active[type].call(this) : '';
		});
		
		//监听工具条
		table.on('tool(user3)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
			var data = obj.data; //获得当前行数据
			var layEvent = obj.event; //获得 lay-event 对应的值
			var tr = obj.tr; //获得当前行 tr 的DOM对象

			if (layEvent === 'detail') { //查看
				$.ajax({
					url :'applyasset/showList.action',
					type:'post',
					data:{},
					async:false,
					cache:false,
					success:function(returnData){
						
					},
					error:function(returnData){
						
					}
				})
			}else if(layEvent === 'record'){
				var url = "auditAction/showListById.action";
				var datas = {
					'purcId' : data.purcId
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
				
			}else if (layEvent === 'edit') {
				var url = "Purchase/showNews.action";
				var datas = {
					'purcId' : data.purcId
				};
				$.post(url, datas, function(returnData) {
					var tabVal = '<div id="ss">查看详情</div>';
					$.each(returnData, function(i, item) {
						tabVal += '' + '<tr>' + '<td>' + item.PURC_NAME
								+ '</td>' + '<td>' + item.RAW_NAME
								+ '</td>' + '<td>' + item.PURC_TIME
								+ '</td>' + '<td>' + item.PURC_TITLE
								+ '</td>' + '<td>' + item.PUR_TOTAL_PRICE
								+ '</td>' + '<td>' + item.PURC_TOTAL_PRICE
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
								+ '<th>采购人</th>' 
								+ '<th>材料</th>'
								+ '<th>采购时间</th>' 
								+ '<th>药物</th>'
								+ '<th>材料单价</th>'
								+ '<th>总价</th>' 
								+ '</tr>' 
								+ '</thead>'
								+ '<tbody>'+ tabVal + '</tbody>'
								+ '</table>',
					});
				})
				
			}else if(layEvent === 'audit'){ //审核
				if(data.state == '3'){
					layer.open({
						type: 1
						,title: false //不显示标题栏
						,btn: ['通过', '打回']
						,btnAlign: 'c'
						,area: ['500px', '300px']
						,moveType: 1 //拖拽模式，0或者1
						,content:'<form class="layui-form" style="margin:20px;" id="duitFeedback">'+
						 '<input type="hidden" name="appassId" value="'+data.appassId+'">'+
						 '<input type="hidden" name="state" value="" id="feedState">'+
						 '<div class="layui-form-item layui-form-text">回馈内容 :'+
						      '<textarea style="margin-right:20px;height:150px;" name="feedBack" placeholder="请输入内容" class="layui-textarea"></textarea>'+
						  '</div>'+
						'<form>'
						,yes: function(index, layero){
							$("#feedState").val("2");
							loadIndex = layer.load();//出现加载层
							$.ajax({
								url :'applyasset/auditFeedback.action',
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
							$("#feedState").val("0");
							$.ajax({
								url :'applyasset/auditFeedback.action',
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
</script>
<script type="text/html" id="state">	
  {{#  if(d.state == 1){ }}
    <span class="layui-badge layui-bg-orange">审核中</span>
  {{#  } else if(d.state == 2) { }}
    <span class="layui-badge layui-bg-green">审核通过</span>
  {{#  } else if(d.state == 3) { }}
    <span class="layui-badge layui-bg-green">待审核</span>
  {{#  } else if(d.state == 0) { }}
    <span class="layui-badge">审核未通过</span>
  {{#  } }}

</script>
<script type="text/html" id="barDemo3">
  <a class="layui-btn layui-btn-mini" lay-event="audit">审核</a>
  <a class="layui-btn layui-btn-mini layui-bg-orange" lay-event="record">记录</a>
  <a class="layui-btn layui-btn-mini" lay-event="edit">查看</a>
</script>
</body>
</html>