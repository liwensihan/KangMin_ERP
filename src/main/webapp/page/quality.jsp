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
		<title>生产审核</title>
		<link rel="stylesheet" href="res/layui/css/layui.css">
		<script src="res/js/jquery-2.1.3.min.js" type="text/javascript" ></script>
		<script src="res/layui/layui.js"></script>
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
<div class="demoTable">
  <div class="layui-inline" style="margin-left:40%;">
    <input class="layui-input" name="price" id="price" placeholder="编号/名字/备注" autocomplete="off">
  </div>
  <button class="layui-btn" data-type="reload" onclick="solo()">搜索</button>
   <a class="layui-btn" lay-event="edit" onclick="addtype()">增加</a>
</div>
<table class="layui-table" lay-data="{url:'dent/showPro.action', page:true, id:'idTest'}" lay-filter="demo">
  <thead>
    <tr>
      <th lay-data="{field:'indentId', width:80, sort: true, fixed: true, align:'center'},hidden:'true'"></th>
      <th lay-data="{field:'indentNumber', width:200, sort: true, fixed: true, align:'center'}">编号</th>
      <th lay-data="{field:'indentCount' ,width:100}">数量</th>
      <th lay-data="{field:'indentEmetime' ,width:200, sort: true}">开始时间</th>
      <th lay-data="{field:'indentEndtime' ,width:200, sort: true}">完成时间</th>
      <th lay-data="{fixed: 'right',width:150, align:'center', toolbar: '#barDemo'}">操作</th>
    </tr>
  </thead>
</table>
	<div id="from-div" style="display: none; margin: 2%;">
		<table class="layui-table"  lay-skin="nob" id="proTab">
		  
		</table>   
		<table class="layui-table">
		  <thead>
		    <tr>
		      <th>药品名</th>
		      <th>生产总数量</th>
		      <th>完成数量</th>
		      <th>备注</th>
		    </tr> 
		  </thead>
		  <tbody>
		    <tr>
		      <td>贤心</td>
		      <td>2016-11-29</td>
		      <td>人生就像是一场修行</td>
		      <td>人生就像是一场修行</td>
		    </tr>
		  </tbody>
		</table>
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
    if(obj.event === 'edit'){
    	layer.open({
    		  type: 1,
    		  title: ['编辑', '<i class="layui-icon" style="color: #5FB878;">&#xe642;</i>'],
    		  content: $('#from-div'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
    		 // btn: ['提交', '取消'],	
    		  area: ['80%', '75%'],
    		  btn1:function(index, layero){
    			 
    		  },
    		  btn2:function(index, layero){
    			  $("#chong").click();
    		  },
    		  cancel:function(){
    			  $("#chong").click();//清空表单
    		  }
    	});
    	var da = {"indentId":data.indentId}
    	 $.post("dent/selectByPrimaryProid.action",da,function(dent){
    		 	var den = dent[0];
			 	$("#proTab").val("<tbody> <tr> <td width='100px'>订单编号:</td> <td colspan='5'>"+den.KIN_SERIAL+"</td></tr>"+
					    "<tr> <td  width='100px'> 创建时间:</td> <td>1234567</td><td  width='100px'>结束时间:</td>"+
					      "<td colspan='3'>1234567</td></tr><tr><td  width='100px'>订单总数量:</td><td>123456</td>"+
					      " <td  width='100px'>订单总价格:</td><td>123456</td><td  width='100px'>订单创建人:</td>"+
					      "<td>1234</td></tr><tr><td  width='100px'>订单备注:</td><td colspan='5'>1234567890</td></tr> </tbody>");
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
  <a class="layui-btn layui-btn-mini" lay-event="edit" >查看详情</a>
</script>
</body>
</html>