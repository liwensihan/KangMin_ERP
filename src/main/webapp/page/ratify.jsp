<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 		<link rel="stylesheet" href="res/layui/css/layui.css">
		<script src="res/js/jquery-2.1.3.min.js" type="text/javascript" ></script>
		<script src="res/layui/layui.js"></script>
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
  <style>
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
 		width:150px;
	}
	
	#div{
		z-index: 19891015; 
		top:15%;
		left:32%;
		display: none;
		position: fixed;
		background-color: #fff;
		width:550px;
	}
	#div1{
		display: none;
		top: 0;
		left: 0;
		width: 100%;
		height: 100%;
		position: fixed;
		z-index: 19891014; 
		background-color: rgb(0, 0, 0); 
		opacity: 0.3;
	}
  </style>
</head>
<body> 
<div class="demoTable">
		 &nbsp;&nbsp;&nbsp;&nbsp;
		 <div class="layui-inline">
		  	<form class="layui-form" id="sousuo" style="float: left;">
		  		<table>
		  			<tr>
		  				<td>
			  				<div class="layui-inline">
							    <label class="layui-form-label">关键字查询</label>
							    <div class="layui-input-inline">
							      <input name="keywords" id="keywords" autocomplete="off" class="layui-input" type="tel" placeholder="订单编号/申请人/分店名称" style="width:230px;">
							    </div>
							</div>
							<div class="layui-inline">
							    <label class="layui-form-label">价格</label>
							    <div class="layui-input-inline">
							      <input name="min" id="min" autocomplete="off" class="layui-input" type="tel">
							    </div>
							</div>
							<div class="layui-inline">
							    ~~
							    <div class="layui-input-inline">
							      <input name="max" id="max" autocomplete="off" class="layui-input" type="tel">
							    </div>
							</div>
		  				</td>
		  			</tr>
		  		</table>
			</form>
			<button class="layui-btn" style="margin-top: 5px;" data-type="reload">搜索</button>
		  </div>
		</div>


<table class="layui-table" lay-data="{height:472,url:'form/ratifyFindAll.action', page:true, limit: 10,id:'testReload',method:'post'}" lay-filter="demo">
  <thead>
    <tr>
      <th lay-data="{field:'fdproSerial', width:150, align:'center',sort: true, fixed: true}">订单编号</th>
      <th lay-data="{field:'annexName', width:100, align:'center'}">分店名称</th>
      <th lay-data="{field:'staName', width:100, align:'center'}">申请人</th>
      <th lay-data="{field:'fdproWarecount', width:100, align:'center'}">订单总数量</th>
      <th lay-data="{field:'fdproSumprice', width:100, align:'center'}">订单总价格</th>
      <th lay-data="{field:'fdproTime', width:150, align:'center'}">订单日期</th>
      <th lay-data="{field:'fdproIsva', width:100, align:'center',templet:'#fdproIsva1'}">审核状态</th>
      <th lay-data="{fixed: 'right', width:230, align:'center', toolbar: '#barDemo'}"></th>
    </tr>
  </thead>
</table>

<div id="outbank-div" style="padding:2%; display: none; ">
	<!-- 质检表单开始 -->
	<form id="outbank-form">
		<div id="qualit-form-det">
		
		</div>
		<input type="hidden" id="fdproId" name="fdproId">
		<input type="hidden" id="obWarecount" name="obWarecount">
		<div class="layui-form-item layui-form-text">
		    <label class="layui-form-label">备注:</label>
		    <div class="layui-input-block">
		      <textarea name="remark" placeholder="请输入内容" id="wby" class="layui-textarea"></textarea>
		    </div>
		 </div>
		 <input type="reset" style="display:none;" /> 
	 </form>
	  <div id="but-shen"  style=" position:fixed; bottom:6%;width:53.5%; padding-left: 22%;background-color: #f3f5f399;">
				<button class="layui-btn" style="margin-right: 23%;" onclick="yesb()">
				  <i class="layui-icon">&#xe6af;</i>通过
				</button>
				<button class="layui-btn layui-btn-danger" onclick="no()">
				  <i class="layui-icon">&#xe69c;</i>打回
				</button>
		</div>
	<!-- 质检表单结束 -->
</div>
<!-- 判断是否审核 -->
<script type="text/html" id="fdproIsva1">
	  {{#  if(d.fdproIsva==1){ }}
    		<span class="layui-btn layui-btn-small">已审核</span>
  	{{# }else if(d.fdproIsva==0) { }}
    	   <span class="layui-btn layui-btn-danger layui-btn-small">未审核</span>
	{{#  }else if(d.fdproIsva==2) { }}
			<span class="layui-btn layui-btn-warm layui-btn-small">未通过</span>
	{{#  }else if(d.fdproIsva==3) { }}
			<span class="layui-btn layui-btn-primary layui-btn-mini">出库中</span>
	{{#  }else if(d.fdproIsva==4) { }}
			<span class="layui-btn layui-btn-primary layui-btn-mini">已出库</span>
	{{#  } }}
</script>

<script type="text/javascript">
	
	
	
	
	
</script>
 
<script type="text/html" id="barDemo">
	{{#  if(d.fdproIsva==0){ }}
   		<a class="layui-btn layui-btn-mini" lay-event="edit">审核</a>
	{{# }else if(d.fdproIsva==1){ }}
		<a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">提交到总店</a>
	{{#  } }}
  	<a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail">订单详情</a>
</script>
               
          
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>

function yesb(){
		var data =$("#outbank-form").serialize();//表单序列化
	  	  $.post("ErpOutbankAction/insertSelective.action",data,function(mes){
		  		if(mes.state==1){//真确的样式
		  			layer.closeAll('page'); //关闭所有页面层
	         		//刷新页面
		  		 	table.reload('tableQuali', {
		  		 		where: { //设定异步数据接口的额外参数，任意设
		  	  				'price':$("#seleAi").val()
	         			}
					});
		  		 	layer.msg('<i class="layui-icon" style="font-size: 40px; color: #5FB878;">&#xe618;</i>'+mes.mes);
	         	}else{
	         		layer.msg('<i class="layui-icon" style="font-size: 40px; color: #FF5722;">&#x1006;</i>'+mes.mes);
	         	}
	  	  });
	}
var table;
layui.use(['table','form'], function(){
 table = layui.table;
 var form = layui.form;
  //监听表格复选框选择
  table.on('checkbox(demo)', function(obj){
    console.log(obj)
  });
  
   
  
 
  
  //监听工具条
  table.on('tool(demo)', function(obj){
    var data = obj.data;
    if(obj.event === 'detail'){
    	layer.open({
			type:2,
			skin: 'layui-layer-molv',//样式
			content:'mall/prolistmxsmall.action?fdproId='+data.fdproId,
			area: ['70%', '65%'],
			title: '订单详情',
			
		});	
    } else if(obj.event === 'del'){
    	var da = {"fdproId":data.fdproId};
    	
    	$.post('mall/selectBankNew.action',da,function(yi){
    		$("#fdproId").val(data.fdproId);
    		var h = 0;
    		$.each(yi,function(i,b){
    			 $("#qualit-form-det").append("<div class='layui-form-item'> <input type='hidden' name='kinId' value='"+b.kinId+"'>"+
    	  				   " <div class='layui-inline'><label class='layui-form-label'>"+b.kinName+":</label><div class='layui-input-inline' style='width: 100px;'>"+
    	  		       " <input name='invedetNum' onkeyup='this.value=this.value.replace(/\D/g,'')' onafterpaste='this.value=this.value.replace(/\D/g,'')' autocomplete='off' class='layui-input'  type='text' value='"+b.fdprolistmxCount+"' readonly>"+
    	  		      "</div></div></div>");
    			 h+=b.fdprolistmxCount;
    		});
    		
    		$("#obWarecount").val(h);
    	});
    	
    	layer.open({
	  		  type: 1,
	  		  title: ['出库单'],
	  		  content: $('#outbank-div'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
	  		 // btn: ['确定'], //可以无限个按钮
	  		  area: ['80%','70%'],
	  		  cancel:function(){
	  			$("#qualit-form-det").html("");
	  		  }
	  		  
	    });
    } else if(obj.event === 'edit'){
    	
    	layer.open({
    		  content: '审核订单'
    		  ,btn: ['通过', '不通过', '取消']
    		  ,yes: function(index, layero){
    			  
    		  	url = "form/updateThrough.action";
    		  	data = {fdproId:data.fdproId,fdproSumprice:data.fdproSumprice};
    		    $.post(url,data,function(m){
    		    	layer.close(index);
    		    	$(".layui-laypage-skip .layui-laypage-btn",window.document).click();
    		    	parent.layer.msg('审核通过');
    		    },"json")
    		    
    		  }
    		  ,btn2: function(index, layero){
    			
    			url = "form/noThrough.action";
    			data = {fdproId:data.fdproId};
      		    $.post(url,data,function(m){
      		    	layer.close(index);
      		    	$(".layui-laypage-skip .layui-laypage-btn",window.document).click();
      		    	parent.layer.msg('审核不通过');
      		    },"json")
    		  }
    		  ,cancel: function(){ 
    		    //右上角关闭回调
    		    
    		    //return false 开启该代码可禁止点击该按钮关闭
    		  }
    		});
    }
  });
  
  
  
  var $ = layui.$, active = {
		    reload: function(){
		      var demoReload = $('#keywords');
		      var demoReload1 = $('#min');
		      var demoReload2 = $('#max');
		      table.reload('testReload', {
		        where: {
		         
		        	keywords: demoReload.val(),
		        	min: demoReload1.val(),
		        	max: demoReload2.val()
		        }
		      });
		    }
		  };
  
  $('.demoTable .layui-btn').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });
});



</script>





</body>
</html>


