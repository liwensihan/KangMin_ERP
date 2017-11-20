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
		<title>药效管理</title>
		<link rel="stylesheet" href="res/layui/css/layui.css">
		<script src="res/js/jquery-2.1.3.min.js" type="text/javascript" ></script>
		<script src="res/layui/layui.js"></script>
		<style type="text/css">
			body{
				margin: 2%;
			}
		</style>
</head>
<body>
<div class="demoTable">
  <div class="layui-inline" style="margin-left:40%;">
    <input class="layui-input" name="price" id="price" placeholder="编号/名字/备注" autocomplete="off">
  </div>
  <button class="layui-btn" data-type="reload" onclick="solo()">搜索</button>
   <a class="layui-btn" lay-event="edit" onclick="addtype()">增加</a>
</div>
<table class="layui-table" lay-data="{url:'ErpResuitAction/findErpResuitsow.action', page:true, id:'idTest'}" lay-filter="demo">
  <thead>
    <tr>
      <th lay-data="{field:'resId', width:80, sort: true, fixed: true, align:'center'}">序号</th>
      <th lay-data="{field:'resSerial',width:200, sort: true}">编号</th>
      <th lay-data="{field:'resName' ,width:100}">名字</th>
      <th lay-data="{field:'remark' ,width:150, sort: true}">备注</th>
      <th lay-data="{fixed: 'right',width:150, align:'center', toolbar: '#barDemo'}">操作</th>
    </tr>
  </thead>
</table>
	<div id="from-div" style="display: none; margin: 2%;">
		<form class="layui-form layui-form-pane" id="type-from">
	
		       <input type="hidden" name="resId" required id="resId" lay-verify="required"  autocomplete="off" class="layui-input">
			   
		  <div class="layui-form-item">
		    <label class="layui-form-label">药效名</label>
		    <div class="layui-input-inline">
		      <input id="resName" name="resName" lay-verify="required" placeholder="药效名" autocomplete="off" class="layui-input" type="text">
		    </div>
		  </div>
		  <div class="layui-form-item layui-form-text">
		    <label class="layui-form-label">介绍</label>
		    <div class="layui-input-block">
		      <textarea id="remark" placeholder="请输入内容" class="layui-textarea" name="remark"></textarea>
		    </div>
		  </div>
		  <button type="reset" class="layui-btn layui-btn-primary" id="chong" style="display: none;">重置</button>
		</form>
		
	</div>
<!-- 自定义模板  药效-->
<script type="text/html" id="resr">
  {{#  layui.each(d.res, function(index, item){ }}
		{{ item.resName || '' }},
  {{#  }); }}
</script>

<!-- 自定义模板  供应商-->
<script type="text/html" id="lyName">
  {{d.app.applyName}}
</script>
<script type="text/html" id="TypeName">
  {{d.typer.typeName}}
</script>	
<script>
	layui.use('table', function(){
 	 var table = layui.table;
	//监听表格复选框选择
 	 table.on('checkbox(demo)', function(obj){
   		 console.log(obj)
 	 });
  //监听工具条
  table.on('tool(demo)', function(obj){
    var data = obj.data;//得到当前行的数据
   if(obj.event === 'del'){//判断点击的是那个按钮
	   layer.confirm('确定要删除吗？子项也会删除', {icon: 3, title:'提示'}, function(index){//弹出框
        var da = {"resId":data.resId}//把得到的id放进json
        $.post("ErpResuitAction/deleteRes.action",da,function(mes){
        	if(mes.state==1){//真确的样式
         		layer.msg('<i class="layui-icon" style="font-size: 40px; color: #5FB878;">&#xe618;</i>'+mes.mes);
         	}else{
         		layer.msg('<i class="layui-icon" style="font-size: 40px; color: #FF5722;">&#x1006;</i>'+mes.mes);
         	}
        	 ajxaTable();//刷新表格
        });
      });
    } else if(obj.event === 'edit'){
    	$("#resName").val(data.resName);
    	$("#remark").val(data.remark);
    	$("#resId").val(data.resId);
    	layer.open({
    		  type: 1,
    		  title: ['编辑', '<i class="layui-icon" style="color: #5FB878;">&#xe642;</i>'],
    		  content: $('#from-div'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
    		  btn: ['提交', '取消'],
    		  btn1:function(index, layero){
    			    //按钮【按钮1】的回调
    			  var data =$("#type-from").serialize();//表单序列化 
    			  $.post("ErpResuitAction/updateRes.action",data,function(mes){
    				 	if(mes.state==1){//真确的样式
    				 		layer.msg('<i class="layui-icon" style="font-size: 40px; color: #5FB878;">&#xe618;</i>'+mes.mes);
    				 	}else{
    				 		layer.msg('<i class="layui-icon" style="font-size: 40px; color: #FF5722;">&#x1006;</i>'+mes.mes);
    				 	}
    				 	layer.close(index);
    				 	 ajxaTable();//刷新表格
    				 	$("#chong").click();//清空表单
    			  });
    		  },
    		  btn2:function(index, layero){
    			  $("#chong").click();
    		  },
    		  cancel:function(){
    			  $("#chong").click();//清空表单
    		  }
    	});
    }
  });
});
function addtype(){
	layui.use('table', function(){
		  var table = layui.table;
		  layer.open({
			  type: 1,
			  title: ['添加', '<i class="layui-icon" style="color: #5FB878;">&#xe63c;</i>'],
			  content: $('#from-div'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
			  btn: ['提交', '取消'],
			  btn1:function(index, layero){
				    //按钮【按钮1】的回调
				  var data =$("#type-from").serialize();//表单序列化 
				  $.post("ErpResuitAction/insertSelective.action",data,function(mes){
					 	if(mes.state==1){//真确的样式
					 		layer.msg('<i class="layui-icon" style="font-size: 40px; color: #5FB878;">&#xe618;</i>'+mes.mes);
					 	}else{
					 		layer.msg('<i class="layui-icon" style="font-size: 40px; color: #FF5722;">&#x1006;</i>'+mes.mes);
					 	}
					 	layer.close(index);
					 	$("#chong").click();
				  });
				  ajxaTable();//刷新表格
			  },
			  btn2:function(index, layero){
				  $("#chong").click();
			  },
    		  cancel:function(){
    			  $("#chong").click();//清空表单
    		  }
			  
		});
	});
	
}
//刷新表单
function ajxaTable(){
	layui.use('table', function(){ //layui表格操作的基本方法
		  var table = layui.table;
		  table.reload('idTest', {//表格的id
			  url: 'ErpResuitAction/findErpResuitsow.action'//url
			  ,where: {//表格的字段
				  resId:"resId",
				  resSerial:"resSerial",
				  resName:"resName",
				  remark:"remark"
			  }
		  	
		});
	});
}
function solo(){
	var pricer = $("#price").val();
	layui.use('table', function(){ //layui表格操作的基本方法s
		  var table = layui.table;
		  table.reload('idTest', {//表格的id
			  url: 'ErpResuitAction/findDimRew.action'
			  ,where: {//表格的字段
				  resId:"resId",
				  resSerial:"resSerial",
				  resName:"resName",
				  remark:"remark",
				  price:pricer
			  }
		  	, method: 'post'
		});
	});
}
</script>
<!-- 设置工具栏 -->
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-mini" lay-event="edit" >编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
</script>
</body>
</html>