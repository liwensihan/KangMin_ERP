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
<script src="res/layui/layui.js" charset="utf-8"></script>
<script src="res/js/echarts.js"></script>
<script src="res/js/jquery-2.1.3.min.js"></script>
<title>部门信息审核信息</title>
</head>
<body>
	<div class="demoTable">
		搜索ID：
		<div class="layui-inline">
			<input class="layui-input" name="id" id="demoReload"
				autocomplete="off">
		</div>
		<button class="layui-btn" data-type="reload">搜索</button>
		<button class="layui-btn" onclick="addDepa(this)"><i class="layui-icon">&#xe608;</i>添加部门</button>
	</div>
	<table class="layui-hide" id="LAY_table_user" lay-filter="user"></table>

<script>

	//数据加载方法
	layui.use(['table','form'], function(){
	  var table = layui.table;
	  var form = layui.form;
	  loadIndex = layer.load();//出现加载层
	  //方法级渲染
	  table.render({
	    elem: '#LAY_table_user'
	    ,url: 'depaAction/depaFindList.action'
	    ,method:"POST"
	    ,cols: [[
	      {checkbox: true, fixed: true}
	      ,{field:'depaName', title: '部门名称', width:140, fixed: true}
	      ,{field:'depaSerial', title: '部门编号', width:140}
	      ,{field:'depaPhone', title: '部门电话', width:140}
	      ,{field:'depaRemark', title: '备注', width:180}
	      ,{fixed: 'right',title: '操作栏', width:200, align:'center', toolbar: '#barDemo'}
	    ]]
	    ,id: 'testReload'
	    ,page: true
	    ,height: 413
	    ,done: function(res, curr, count){
	    	layer.close(loadIndex);//加载层关闭  
	    }
	  });
	  
	//监听工具条
	  table.on('tool(user)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
	    var data = obj.data; //获得当前行数据
	    var layEvent = obj.event; //获得 lay-event 对应的值
	    var tr = obj.tr; //获得当前行 tr 的DOM对象
	   
	    if(layEvent === 'del'){ //删除
	      layer.confirm('真的删除行么', function(index){
	        
	        layer.close(index);
	        //向服务端发送删除指令
	        loadIndex = layer.load();//出现加载层
	        $.post("depaAction/deleteByDepaId.action",{'depaId':data.depaId},function(returnData){
	        	layer.close(loadIndex);//加载层关闭  
	        	if(returnData.state>0){
	        		obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
	        		layer.msg(returnData.mes);//提示框
	        	}else{
	        		layer.msg(returnData.mes);//提示框
	        	}
	        })
	      });
	    } else if(layEvent === 'edit'){ //编辑
	      //do something
	    	$.post("depaAction/showUpdate.action",{'depaId':data.depaId},function(returnData){
	    		showOpenWo(returnData);
	    	})
	    }
	  });
	  
	  //监听搜索提交事件
	  var $ = layui.$, active = {
	    reload: function(){
	      var demoReload = $('#demoReload');
	      
	      table.reload('testReload', {
	        where: {
	            key: demoReload.val()
	        }
	      });
	    }
	  };
	  
	  $('.demoTable .layui-btn').on('click', function(){
	    var type = $(this).data('type');
	    active[type] ? active[type].call(this) : '';
	  });
	  
	  
	  
	//表单验证方法
		form.verify({
			depaName: function(value, item){ //value：表单的值、item：表单的DOM对象
			 	if(value==null || value==""){
			 		return "部门名称不能为空!";
			 	}   
			},
			depaSerial: function(value,item){
				if(value==null || value==""){
					return "部门编号不能为空!" ;
				}
			},depaPhone: function(value,item){
				var re = /^(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}$/; //电话正则表达式
				if(value==null || value==""){
					return "部门电话不能为空!" ;
				}
				if(re.test(value)){
					return null;
				}else{
					return "请输入正确的电话!";
				}
			}
		});      
		
		//表单提交方法
		form.on('submit(formDemo)', function(data){
			  console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
			  console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
			  console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
			  var url = "depaAction/addOrUpdate.action";
			  var data2 = $("#sss").serialize();
			  $.post(url,data2,function(returnData){
				  if(returnData.state>0){
					  
		        	  layer.close(layer.index);
		        	  table.reload('testReload');
					  layer.msg(returnData.mes);//提示框
					  
				  }else{
					  layer.msg(returnData.mes);
				  }
			  },'json')
			  return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
		});
	  
	});
	
	

	
		
	
	//js事件
	
	//显示增加or修改弹出层
	function addDepa(obj){
		var data = {'depaId':'','depaName':'','depaSerial':'','depaPhone':'','depaRemark':''}
		showOpenWo(data);
	}
	
	//显示弹出层
	function showOpenWo(data){
		var specificationForm = '<div style="margin-top: 20px; margin-right: 20px;">'+
	      '<form class="layui-form" id="sss">'+
	      	  '<input type="hidden" name="depaId" id="sptId" value="'+data.depaId+'">'+
		      '<div class="layui-form-item">'+
		      '<label class="layui-form-label">名&nbsp;&nbsp;&nbsp;称</label>'+
		      '<div class="layui-input-block">'+
		        '<input type="text" name="depaName" value="'+data.depaName+'" required  lay-verify="depaName" placeholder="请输入部门名称" autocomplete="off" class="layui-input">'+
		      '</div>'+
		    '</div>'+
		    '<div class="layui-form-item">'+
		      '<label class="layui-form-label">编&nbsp;&nbsp;&nbsp;号</label>'+
		      '<div class="layui-input-block">'+
		        '<input type="text" name="depaSerial" value="'+data.depaSerial+'" required  lay-verify="depaSerial" placeholder="请输入部门编号" autocomplete="off" class="layui-input">'+
		      '</div>'+
		    '</div>'+
		    '<div class="layui-form-item">'+
		      '<label class="layui-form-label">电&nbsp;&nbsp;&nbsp;话</label>'+
		      '<div class="layui-input-block">'+
		        '<input type="text" name="depaPhone" value="'+data.depaPhone+'" required  lay-verify="depaPhone" placeholder="请输入部门电话" autocomplete="off" class="layui-input">'+
		      '</div>'+
		    '</div>'+
		    '<div class="layui-form-item">'+
		      '<label class="layui-form-label">备&nbsp;&nbsp;&nbsp;注</label>'+
		      '<div class="layui-input-block">'+
		        '<input type="text" name="depaRemark" value="'+data.depaRemark+'" required  lay-verify="depaRemark" placeholder="备注信息" autocomplete="off" class="layui-input">'+
		      '</div>'+
		    '</div>'+
		    '<div class="layui-form-item">'+
			    '<div class="layui-input-block">'+
			      '<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>'+
			    '</div>'+
			'</div>'+
	      '</form>'+
	      '</div>';
		
		layer.open({
		  type: 1,
		  title:'部门信息编辑',
		  area: ['75%', '80%'],
		  shadeClose:true,
		  content:specificationForm
  		});
	}
</script>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
</script>
</body>
</html>