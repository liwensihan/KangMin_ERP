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
							      <input name="keywords" id="keywords" autocomplete="off" class="layui-input" type="tel" placeholder="订单编号/申请人" style="width:150px;">
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
			<button class="layui-btn layui-btn-normal" style="margin-top: 5px;" data-type="reload" id="add">增加</button>
		  </div>
		</div>


<table class="layui-table" lay-data="{height:472,url:'form/findAll.action', page:true, limit: 10,id:'testReload',method:'post'}" lay-filter="demo">
  <thead>
    <tr>
      <th lay-data="{field:'fdproSerial', width:150, align:'center',sort: true, fixed: true}">订单编号</th>
      <th lay-data="{field:'staName', width:80, align:'center'}">申请人</th>
      <th lay-data="{field:'fdproWarecount', width:100, align:'center'}">订单总数量</th>
      <th lay-data="{field:'fdproSumprice', width:100, align:'center'}">订单总价格</th>
      <th lay-data="{field:'fdproTime', width:175, align:'center'}">订单日期</th>
      <th lay-data="{field:'fdproIsva', width:100, align:'center',templet:'#fdproIsva1'}">审核状态</th>
      <th lay-data="{fixed: 'right', width:190, align:'center', toolbar: '#barDemo'}"></th>
    </tr>
  </thead>
</table>


<!-- 判断是否审核 -->
<script type="text/html" id="fdproIsva1">
	  {{#  if(d.fdproIsva==1){ }}
    		<span class="layui-btn layui-btn-small">已审核</span>
  	{{# }else if(d.fdproIsva==0) { }}
    	   <span class="layui-btn layui-btn-danger layui-btn-small">未审核</span>
	{{#  }else if(d.fdproIsva==2) { }}
			<span class="layui-btn layui-btn-warm layui-btn-small">未通过</span>
	{{#  } }}
</script>

<script type="text/javascript">
	
	
	$("#add").click(function(){
		layer.open({
			type:2,
			skin: 'layui-layer-molv',//样式
			content:'page/addFdproform.jsp',
			area: ['70%', '65%'],
			title: '添加采购',
			
		});	
	})
	
	
	
</script>
 
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail">订单详情</a>
  {{#  if(d.fdproIsva==0){ }}
  <a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a>
  {{#  } }}
  <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
</script>
               
          
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
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
      layer.confirm('真的删除行么', function(index){
    	  url="form/deleteFdpro.action";
    	  data={fdproId:data.fdproId}
    	  $.post(url,data,function(m){
    		  
    	  },"json")
        obj.del();
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
    	layer.open({
			type:2,
			skin: 'layui-layer-molv',//样式
			content:'mall/prolistmxsmall2.action?fdproId='+data.fdproId,
			area: ['70%', '65%'],
			title: '订单详情',
			
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

	function quxiao(){
		$("#div1").fadeOut(200);
		$("#div").fadeOut(200);
	}


</script>





<div id="div1" times="1"></div>
<div  id="div" type="dialog" times="4" showtime="0" contype="string">
	<div class="layui-layer-title" style="cursor: move;margin-bottom: 25px;" id="bian">编辑</div>
	<form class="layui-form" action="" id="oneFrom">
	<input type="hidden" id="roleId" name="roleId">
	  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label"><span style="color:red;">*</span>角色名称</label>
      <div class="layui-input-inline">
        <input name="roleName" id="roleName" autocomplete="off" lay-verify="roleName" class="layui-input" type="tel">
      </div>
    </div>
  </div>
    <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">备注信息</label>
    <div class="layui-input-block">
      <textarea placeholder="请输入内容" name="remark" id="remark" class="layui-textarea" style="width:400px;"></textarea>
    </div>
  </div>
  
  
  
    

	<span class="layui-layer-setwin"><a class="layui-layer-ico layui-layer-close layui-layer-close1" href="javascript:quxiao();"></a></span>
	<div class="layui-layer-btn layui-layer-btn-">
	<button class="layui-btn" lay-submit lay-filter="formDemo" id="submit">立即提交</button>
	<button type="reset" class="layui-btn layui-btn-primary">重置</button>
	</div>
	<span class="layui-layer-resize"></span>
	</form>
</div>


</body>
</html>