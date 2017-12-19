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
<title>分店库存管理</title>
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
		  				 <select name=annexName id="annexName" lay-verify="required" lay-search="">
				          	<option value="">请选择分店名称</option>
				       
				        </select>
		  				</td>
		  				<td>
		  					<select id="kinName" name="kinName" lay-verify="required" lay-search="" width="50px">
							  <option value="">请选择商品</option>
							</select>
		  				</td>
		  			</tr>
		  		</table>
			</form>
			<button class="layui-btn" style="margin-top: 5px;" data-type="reload"><i class="layui-icon">&#xe615;</i>搜索</button>
		  </div>
		</div>



<table class="layui-table" lay-data="{width: 1090 , height:495, url:'sumstock/showList.action', page:true,id:'testReload',method:'post'}" lay-filter="demo">
  <thead>
    <tr>
      <th lay-data="{field:'STOCK_ID', width:140, sort: true, fixed: true},hidden:'true'">ID</th>
      <th lay-data="{field:'ANNEX_NAME', width:180}">分店名称</th>
   	  <th lay-data="{field:'KIN_NAME', width:150}">商品名称</th>
      <th lay-data="{field:'KIN_SERIAL', width:200}">商品编码</th>
   	  <th lay-data="{field:'KIN_BARCODE', width:200}">商品条形码</th>
   	  <th lay-data="{field:'STOCK_SUOUNT', width:150, sort: true}">库存数量</th>
      <th lay-data="{fixed: 'right', width:200, align:'center', toolbar: '#barDemo'}"></th>
    </tr>
  </thead>
</table>


<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
</script>

         
<script type="text/javascript">
$(function(){
	var url = 'ErpKindsAction/showListAjax.action';
	$.post(url,null,function(m){
		for(i=0;i<m.length;i++){	
			$("#kinName").append("<option value='"+m[i].kinId+"'>"+m[i].kinName+"</option>");
		}
	},"json")
	
	
	var url = 'annex/showList.action';
	$.post(url,null,function(m){
		for(i=0;i<m.length;i++){	
			$("#annexName").append("<option value='"+m[i].annexId+"'>"+m[i].annexName+"</option>");
		}
	},"json")
})
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
      layer.confirm('真的删除行么', function(index){
    	 obj.del();
        layer.close(index);
        url = "sumstock/delete.action?stockId="+data.STOCK_ID;
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
     
	} else if(obj.event === 'edit'){
		layer.open({
			type:2,
			skin: 'layui-layer-molv',//样式
			content:'page/Sumstockupdate.jsp?STOCK_ID='+data.STOCK_ID,
			area: ['500px', '220px'],
			title: '编辑仓库',
		});	

    }
  });
  
 
  var $ = layui.$, active = {
		    reload: function(){
		      var demoReload = $('#key');
			  var demoReload1 = $('#annexName');
		      var demoReload2 = $('#kinName');
		      table.reload('testReload', {
		        where: {
		         
		        	key: demoReload.val(),
		        	annexName:demoReload1.val(),
		        	kinName:demoReload2.val()
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