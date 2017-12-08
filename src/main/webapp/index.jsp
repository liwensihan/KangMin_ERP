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
	<form class="layui-form" style="float: right;" id="formData">
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">分店:</label>
				<div class="layui-input-inline" style="width: 180px">
					<select id="annexOp" lay-filter="annexOp" name="annexId"
						lay-verify="required" lay-search>
						<option value=""></option>
					</select>
				</div>
				<div class="layui-form-mid">年份:</div>
				<div class="layui-input-inline" style="width: 100px">
					<input class="layui-input" id="test2" type="text" name="year">
				</div>
				<div class="layui-form-mid">月份:</div>
				<div class="layui-input-inline" style="width: 100px">
					<input class="layui-input" id="test3" type="text" name="month">
				</div>
			</div>
		</div>
	</form>
	<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
	<div id="main" style="width: 900px; height: 650px; margin-top:50px;"></div>
	<div id="main2" style="width: 900px; height: 650px;"></div>
</body>
<script>
	var form;
	var laydate;
	layui.use([ 'form', 'laydate' ], function() {
		form = layui.form;
		laydate = layui.laydate;
		//各种基于事件的操作，下面会有进一步介绍
		var myDate = new Date();
		showAnnex();//调用查询分店方法 
		$("#test2").val(myDate.getFullYear());
		showCharts();//初始化加载统计图
		//年选择器
		laydate.render({
			elem : '#test2',
			type : 'year',
			done : function(value, date, endDate) {
				$("#test3").val("");
				$("#test2").val(value);
				showCharts();//初始化加载统计图
			}
		});

		//年月选择器
		laydate.render({
			elem : '#test3',
			type : 'month',
			done : function(value, date, endDate) {
				$("#test2").val("");
				$("#test3").val(value);
				showCharts();//初始化加载统计图
			}
		});
		//监听下拉框选择事件
		form.on('select(annexOp)', function(data) {
			showCharts(data.value);//初始化加载统计图
		})
	});
	//查询分店信息赋值到搜索下拉框
	function showAnnex() {
		loadIndex = layer.load();//出现加载层
		$.ajax({
			url : 'annex/showList.action',
			type : 'POST',
			async : false,
			cache : false,
			contentType : false,
			processData : false,
			success : function(returnData) {
				layer.close(loadIndex);//加载层关闭
				$.each(returnData, function(i, item) {
					$("#annexOp").append(
							"<option value='"+item.annexId+"'>"
									+ item.annexName + "</option>");
				})
				form.render('select');
			},
			error : function(returnData) {
				layer.close(loadIndex);//加载层关闭
			}
		})
	}

	function showCharts(obj) {
		$.ajax({
			url : 'annex/showChar.action',
			type : 'POST',
			data : new FormData($("#formData")[0]),
			async : false,
			cache : false,
			contentType : false,
			processData : false,
			success : function(returnData) {
				var zhichu = [];//支出金额
				
				var annexName = []; //分店名称
				var annex =[];//分店json
				
				/* $.each(returnData.applyAssetList, function(i, item) {
					zhichu.push(item.appassNum);
				})
				$.each(returnData.payList, function(i, item) {
					shouru.push(item.payNum);
				}) */
				//循环遍历分店集合
				$.each(returnData.erpAnnexList,function(i,item){
					var name = item.annexName.substring(item.annexName.length-4,item.annexName.length);
					annexName.push(name);//设置分店名称
					
					
				})
				$.each(returnData.listFour,function(i,item){
					var shouru=[];
					var name;
					$.each(item,function(i2,item2){
						shouru.push(item2.annexNumber);
						name=item2.annexName;
					})
					var dap = {"name":name,"type":"bar","data":shouru};
					annex.push(dap);
				})
				alert(annexName+"         "+JSON.stringify(annex));
				// 基于准备好的dom，初始化echarts实例
				var myChart = echarts.init(document.getElementById('main'));
				var myChart2 = echarts.init(document.getElementById('main2'));
				//分店收入统计
				option = {
					title : {
						text : '分店销售统计'
					},
					tooltip : {
						trigger : 'axis',
						axisPointer : { // 坐标轴指示器，坐标轴触发有效
							type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
						}
					},
					legend : {
						data : annexName
					},
					grid : {
						left : '3%',
						right : '4%',
						bottom : '3%',
						containLabel : true
					},
					xAxis : {
						type : 'category',
						boundaryGap : false,
						data : [ '一月', '二月', '三月', '四月', '五月', '六月', '七月',
								'八月', '九月', '十月', '十一月', '十二月' ]
					},
					yAxis : {
						type : 'value'
					},
					series : annex
				};
				//分店支出统计
				option2 = {
						title : {
							text : '分店支出统计'
						},
						tooltip : {
							trigger : 'axis',
							axisPointer : { // 坐标轴指示器，坐标轴触发有效
								type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
							}
						},
						legend : {
							data : [ '支出啊啊', '收入啊啊' ]
						},
						grid : {
							left : '3%',
							right : '4%',
							bottom : '3%',
							containLabel : true
						},
						xAxis : {
							type : 'category',
							boundaryGap : false,
							data : [ '一月', '二月', '三月', '四月', '五月', '六月', '七月',
									'八月', '九月', '十月', '十一月', '十二月' ]
						},
						yAxis : {
							type : 'value'
						},
						series : [ {
							name : '支出啊啊',
							type : 'bar',
							data : zhichu
						}, {
							name : '收入啊啊',
							type : 'bar',
							data : []
						} ]
					};
				// 使用刚指定的配置项和数据显示图表。
				myChart.setOption(option);
				myChart2.setOption(option2);
			},
			error : function(returnData) {

			}
		})

	}
</script>
</html>