<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>分店销售订单批发审核</title>
		<link rel="stylesheet" href="res/layui/css/layui.css">
		<script src="res/js/jquery-2.1.3.min.js" type="text/javascript" ></script>
		<script src="res/layui/layui.js"></script>
		<style type="text/css">
			body{
				padding: 10px;
			}
		</style>
	</head>
	<body>
		<div class="layui-inline" id="demoTable">
			<form class="layui-form" id="sousuo" style="float: left;">
				<table>
					<tr>
						<td>
							<input class="layui-input" id="sctockmpData" name="sctockmpData" maxlength="50" placeholder="员工姓名/会员编号" autocomplete="off">
						</td>
						<td>
						    <div class="layui-input-inline" style="margin-left: 5px;">
						      <input type="text" id="saleDate" name="saleDate" placeholder="销售时间" class="layui-input" readonly="readonly">
						    </div>
						</td>
					</tr>
				</table>
			</form>
			<button style="margin-top: 5px;margin-left: 5px;" class="layui-btn layui-btn-small" data-type="reload"><i class="layui-icon">&#xe615;</i> 搜索</button>
		</div>
		<table class="layui-table" lay-data="{height:400,size:'sm',skin:'row ', url:'sctockmp/findAllAudit.action',method:'post',page:true,limit:10, id:'tb'}" lay-filter="tb">
		  <thead>
		    <tr>
		      <th lay-data="{field:'SALE_ID',hidden, sort: true,width:250,align:'left',templet:'#saleIdTpl'}">订单编号</th>
		      <th lay-data="{field:'SALE_DATE', sort: true,width:147,align:'center'}">销售时间</th>
		      <th lay-data="{field:'annex_name', sort: true, width:130}">分店名称</th>
		      <th lay-data="{field:'MEMBER_ID', sort: true,width:140,align:'center',templet:'#memberIdTpl'}">会员编号</th>
		      <th lay-data="{field:'SALE_wholesale_state', sort: true,width:120,align:'center',templet:'#stateTpl'}">审核状态</th>
		      <th lay-data="{field:'sta_name', sort: true,width:110,align:'center'}">员工姓名</th>
		      <th lay-data="{field:'SALE_NUM', sort: true,width:150,align:'center'}">销售总数量</th>
		      <th lay-data="{field:'SALE_MONEY', sort: true,width:160,align:'center'}">原金额(元)</th>
		      <th lay-data="{field:'SALE_DISCOUNT', sort: true,width:100,align:'center',templet:'#discountTpl'}">折扣</th>
		      <th lay-data="{field:'SALE_MONEY1', sort: true,width:140,align:'center'}">应付金额(元)</th>
		      <th lay-data="{field:'SALE_MONEY2', sort: true,width:140,align:'center'}">实付金额(元)</th>
		      <th lay-data="{field:'SALE_MONEY3', sort: true,width:140,align:'center'}">找零(元)</th>
		      <th lay-data="{fixed: 'right', width:240, align:'center', toolbar: '#barDemo1'}">操作</th>
		    </tr>
		  </thead>
		</table>
		<div id="detailList" style="display: none;padding: 5px;">
			<table id="kinList" class="layui-table" lay-size="sm">
			  <thead>
			    <tr>
			      <th colspan="4">商品信息</th>
			      <th colspan="3">价格</th>
			      <th rowspan="2">备注</th>
			    </tr>
			    <tr>
			      <th>商品编码</th>
			      <th>商品名称</th>
			      <th>净含量</th>
			      <th>保质期</th>
			      <th>零售价</th>
			      <th>数量</th>
			      <th>总金额</th>
			    </tr>
			  </thead>
			  <tbody>
			    
			  </tbody>
			  <tfoot>
			  	<tr>
			  		<td colspan="10" align="left">记录数：<span id="showNum">0</span></td>
			  	</tr>
			  </tfoot>
			</table>
		</div>
	</body>	
	<script type="text/html" id="barDemo1">
  		<a class="layui-btn layui-btn-mini" lay-event="show"><i class="layui-icon">&#xe63c;</i>查看明细</a>
		<a class="layui-btn layui-btn-warm layui-btn-mini" lay-event="yes"><i class="layui-icon">&#xe6af;</i>批准</a>
		<a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="no"><i class="layui-icon">&#xe69c;</i>打回</a>
	</script>
	<script type="text/html" id="memberIdTpl">
  		{{#  if(d.MEMBER_ID==""){ }}
    		<span class="layui-badge-rim layui-bg-gray">非会员</span>
		{{#  } else { }}
			{{ d.MEMBER_ID }}
  		{{#  } }}
	</script>
	<script type="text/html" id="stateTpl">
		<span class="layui-badge layui-bg-blue">待审核</span>
	</script>
	<script type="text/html" id="discountTpl">
		{{#  if(d.SALE_DISCOUNT==1) { }}
			<span class="layui-badge-rim layui-bg-gray">不打折</span>
		{{#  } else { }}
			{{ d.SALE_DISCOUNT }}
		{{#  } }}
	</script>
			
	<script type="text/javascript">
		var table;//数据表格
		var loadIndex;//加载层
		var ts;//弹出层
		
		//初始化数据表格
		layui.use('table', function(){
		  table = layui.table;
		  
			//监听工具条
			table.on('tool(tb)', function(obj){//tb是table原始容器的属性 lay-filter="对应的值"
				var formdata = obj.data; //获得当前行数据
				var layEvent = obj.event; //获得 lay-event 对应的值
				if(layEvent === 'show'){ //显示明细
					//查找订单明细
					var url = "sctovkmpDetail/findBySaleId.action";
					var data ={"saleId":formdata.SALE_ID};
					$.post(url,data, function(info){
						$("#detailList tbody").html("");
						$(info).each(function(i,element){
							$("#detailList tbody").append('<tr><td><input type="hidden" value="'+element.KIN_ID+'"/>'+element.KIN_SERIAL+'</td><td>'+element.KIN_NAME+'</td><td>'+element.KIN_CONTENT+'</td><td>'+element.KIN_EXPIRATION+'</td><td>'+element.KMP_PRICE/element.KMP_NUM+'</td><td>'+element.KMP_NUM+'</td><td>'+element.KMP_PRICE+'</td><td>'+element.REMAKE+'</td></tr>');
						});
						$("#showNum").text(info.length);
					});
					//显示明细
					ts =layer.open({
				        type: 1//样式
				        ,area: ['80%', '75%']
				        ,title:"明细订单"//标题
				        ,content: $("#detailList")
				        ,shade: [0.8, '#393D49'] //显示遮罩
				        ,shadeClose:true//点击也能遮罩层关闭
				        ,anim:2//弹出动画
				      });
				}
				if(layEvent === 'yes'){ //审核批准
					layer.confirm('确认是否批准通过？', {icon: 3, title:'温馨提示'}, function(index){
						var url = "sctockmp/updateWholesaleStateAdd.action";
						var data ={"saleId":formdata.SALE_ID};
						$.post(url,data, function(info){
							if(info>0){
								tableReload();//重载表格的方法
								layer.msg('操作成功！');
							}else{
								layer.msg('操作失败！');
							}
						});
					});
				}
				if(layEvent === 'no'){ //审核打回
					layer.prompt({
						  formType: 2,
						  value: '',
						  title: '(打回操作)请输入备注信息',
						  area: ['400px', '150px'] //自定义文本域宽高
					}, function(value, index, elem){
						var url = "sctockmp/updateWholesaleStateZero.action";
						var data ={"saleId":formdata.SALE_ID,"feedBack":value};
						$.post(url,data, function(info){
							if(info>0){
								tableReload();//重载表格的方法
								layer.msg('操作成功！');
							}else{
								layer.msg('操作失败！');
							}
						});
						layer.close(index);
					});
				}
			});
		  
		  //搜索
		  var $ = layui.$, active = {
		    reload: function(){
		    	loadIndex = layer.load();//出现加载层
		    	tableReload();//重载表格的方法
		    	layer.close(loadIndex);//加载层关闭  
		    }
		  };
		  
		  $('#demoTable .layui-btn').on('click', function(){
		    var type = $(this).data('type');
		    active[type] ? active[type].call(this) : '';
		  });
		  
		});
		
		//数据表格重载
		function tableReload(){
			table.reload('tb', {
		        where: {
		        	sctockmpData: $('#sctockmpData').val(),
		        	saleDate:$("#saleDate").val()
		        }
		      });
		}
		
		//日期框
		layui.use('laydate', function(){
		  var laydate = layui.laydate;
		  laydate.render({
		    elem: '#saleDate' //指定元素
		    ,theme: 'molv'//样式
		    ,max: 0//最大日期为今天
		    ,range: true//日期范围
		    ,calendar: true//显示节日
		  });
		});
	</script>
</html>