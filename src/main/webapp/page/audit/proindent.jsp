<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单管理</title>
	<link rel="stylesheet" href="<%=basePath%>res/layui/css/layui.css" media="all">
	<script src="<%=basePath%>res/js/jquery-2.1.3.min.js" type="text/javascript"></script>
	<script src="<%=basePath%>res/layui/layui.js" charset="utf-8"></script>

  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
  <style type="text/css">
  	.layui-table-view {
	    margin: 10px 18px;
	    overflow: hidden;
	}
	body{
		padding: 10px;
	}

	#sousuo td{
		padding-right: 5px;
		padding-top: 5px;
	}
	#sousuo .layui-input {
 		height: 40px;
	}
	#ss{
		color:#780000;	
		font-size:18px;
		text-align:center;
	}
  </style>
</head>
<body> 

<div class="demoTable">
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div class="layui-inline">
		  	<form class="layui-form" id="sousuo" style="float: left;">
		  		<table>
		  			<tr>
		  				<td>
		  				    <input class="layui-input" name="key" id="key" maxlength="50" placeholder="关键字" autocomplete="off">
		  				</td>
		  				<td>
			  				<select id="indentUrgency" name="indentUrgency" lay-verify="" width="50px">
							  <option value="">是否紧急</option>
							   <option value="1">是</option>
							    <option value="0">否</option>
							</select>
		  				</td>
		  				<td>
			  				<select id="state" name="state" lay-verify="" width="50px">
							  <option value="">审核状态</option>
							   <option value="2">已审核</option>
							    <option value="1">未审核</option>
							</select>
		  				</td>
		  				<td>
			  				<select id="indentState" name="indentState" lay-verify="" width="50px">
							  <option value="">订单生产状态</option>
							   <option value="1">订单开始</option>
							    <option value="2">订单生产中</option>
							      <option value="3">订单已完成</option>
							</select>
		  				</td>
		  			</tr>
		  		</table>
			</form>
			<button class="layui-btn" style="margin-top: 5px;" data-type="reload"><i class="layui-icon">&#xe615;</i>搜索</button>
		  </div>
		</div>



<table class="layui-table" lay-data="{width: 1010, height:495, url:'dent/showList.action', page:true,id:'testReload',method:'post'}" lay-filter="demo">
  <thead>
    <tr>
      <th lay-data="{field:'indentId', width:140, sort: true, fixed: true},hidden:'true'">ID</th>
      <th lay-data="{field:'indentNumber', width:160}">生产订单编号</th>
   	  <th lay-data="{field:'indentMoney', width:150}">生产订单金额</th>
      <th lay-data="{field:'indentCount', width:130}">生产订单数量</th>
   	  <th lay-data="{field:'indentUrgency', width:100,templet:'#urg', align:'center'}">是否紧急</th>
   	  <th lay-data="{field:'state', width:100,templet:'#state1'}">审核状态</th>
   	  <th lay-data="{field:'indentState', width:140, align:'center',templet:'#zt'}">订单生产状态</th>
   	  <th lay-data="{field:'remark', width:140, align:'center'}">备注</th>
   	  <th lay-data="{field:'indentEmetime', width:200, sort: true}">生产订单生成时间</th>
   	  <th lay-data="{field:'indentWorktime', width:200, sort: true}">本次订单需要花费的时间</th>
   	  <th lay-data="{field:'indentEndtime', width:200, sort: true}">预计完成时间</th>
      <th lay-data="{fixed: 'right', width:230, align:'center', toolbar: '#barDemo'}"></th>
    </tr>
  </thead>
</table>

<!-- 判断是否审核 -->
<script type="text/html" id="state1">
	{{#  if(d.state == 1){ }}
     <span class="layui-badge layui-bg-orange">审核中</span>
  	{{#  } else if(d.state == 2) { }}
   	 <span class="layui-badge layui-bg-green">审核通过</span>
  	{{#  } else if(d.state == 0) { }}
  	  <span class="layui-badge">审核未通过</span>
  	{{#  } }}
</script>

<!-- 判断是否紧急 -->
<script type="text/html" id="urg">
	  {{#  if(d.indentUrgency==1){ }}
    		<span class="layui-btn layui-btn-warm layui-btn-small">紧急</span>
  	{{# }else if(d.indentUrgency==0) { }}
    	   <span class="layui-btn layui-btn-normal layui-btn-small">不紧急</span>
	{{#  } }}
</script>

<!-- 判断订单生产状态 -->
<script type="text/html" id="zt">
	{{#  if(d.indentState==1){ }}
    		<span class="layui-btn layui-btn-primary layui-btn-small">订单开始</span>
  	{{# }else if(d.indentState==2) { }}
    	   <span class="layui-btn layui-btn-warm layui-btn-small">订单生产中</span>
	{{# }else if(d.indentState==3) { }}
    	   <span class="layui-btn layui-btn-normal layui-btn-small">订单已完成</span>
	{{# }else if(d.indentState==4) { }}
			<span class="layui-btn layui-btn-danger layui-btn-small">申请配料中</span>
	{{#  } }}
</script>

<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-mini" lay-event="audit">审核</a>
  <a class="layui-btn layui-btn-mini layui-bg-orange" lay-event="record">记录</a>
<a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="show">查看</a>
</script>

         
          
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
var table;
layui.use('table', function(){
  table = layui.table;
  //监听表格复选框选择
  table.on('checkbox(demo)', function(obj){
    console.log(obj)
  });
  //监听工具条
  table.on('tool(demo)', function(obj){
    var data = obj.data;
    if(obj.event === 'detail'){
      layer.msg('ID：'+ data.id + ' 的查看操作');
    } else if(obj.event === 'del'){
    	if(data.indentState==4){
    	layer.confirm('真的删除行么', function(index){
    	 obj.del();
        layer.close(index);
        url = "dent/delete.action?indentId="+data.indentId;
        $.post(url,null,function(mes){
        	table.reload('testReload');
        	
        	if(mes.state==1){
				layer.msg(mes.mes);
				tableReload();//重载表格的方法
			}else{
				layer.msg(mes.mes);
			}
        	
            
        },"json")
      
      });
    	}else{
			layer.msg("订单生产中,不能删除！！！");
		} 
     
	}else  if(obj.event==='show'){
    	layer.open({
			type:2,
			skin: 'layui-layer-molv',//样式
			content:'page/proindentupdateshow.jsp?indentId='+data.indentId,
			area: ['80%', '80%'],
			title: '查看订单',
		});	
    }else if(obj.event === 'record'){
		var url = "auditAction/showListById.action";
		var datas = {
			'purcId' : data.indentId
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
		
	}else if(obj.event === 'audit'){
		if(data.state == '1'){
			layer.open({
				type: 1
				,title: false //不显示标题栏
				,btn: ['通过', '打回']
				,btnAlign: 'c'
				,area: ['500px', '300px']
				,moveType: 1 //拖拽模式，0或者1
				,content:'<form class="layui-form" style="margin:20px;" id="duitFeedback">'+
				 '<input type="hidden" name="indentId" value="'+data.indentId+'">'+
				 '<input type="hidden" name="state" value="" id="feedState">'+
				 '<div class="layui-form-item layui-form-text">回馈内容 :'+
				      '<textarea style="margin-right:20px;height:150px;" name="feedBack" placeholder="请输入内容" class="layui-textarea"></textarea>'+
				  '</div>'+
				'<form>'
				,yes: function(index, layero){
					$("#feedState").val("2");
					loadIndex = layer.load();//出现加载层
					$.ajax({
						url :'dent/auditPpoindent.action',
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
							if(returnData == 102){
								layer.msg("余额不足!");
							}else{
								layer.msg("提交成功");
							}
						},
						error:function(returnData){
							layer.close(loadIndex);//加载层关闭
							layer.msg("数据异常!");
						}
					})
				}
				,btn2:function(index,layero){
					$("#feedState").val("0");
					loadIndex = layer.load();//出现加载层
					$.ajax({
						url :'Purchase/auditPurchase.action',
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
  
 
  var $ = layui.$, active = {
		    reload: function(){
		      var demoReload = $('#key');
			  var demoReload1 = $('#indentUrgency');
		      var demoReload2 = $('#state');
		      var demoReload3 = $('#indentState');
		      table.reload('testReload', {
		        where: {
		         
		        	key: demoReload.val(),
		        	indentUrgency:demoReload1.val(),
		        	state:demoReload2.val(),
		        	indentState :demoReload3.val()
		        }
		      });
		    }
		  };
  
  $('.demoTable .layui-btn').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });
});

function add(){
	
	layer.open({
		type:2,
		skin: 'layui-layer-molv',//样式
		content:'page/Logadd.jsp',
		area: ['98%', '80%'],
		title: '增加会员',
	});

}


</script>

</body>
</html>