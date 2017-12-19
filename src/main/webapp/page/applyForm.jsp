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
<title>编辑页</title>
<link rel="stylesheet" href="res/layui/css/layui.css"
	media="all">
	<script src="<%=basePath%>res/js/jquery-2.1.3.min.js" type="text/javascript"></script>
	<script src="<%=basePath%>res/layui/layui.js"></script>
<style type="text/css">
	body{
		padding: 2%;
	}
</style>
</head>
<body>
	<form class="layui-form" id="formSubmit">



		<input type="hidden" id="applyId" name="applyId"></input>



		<!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
		<div class="layui-form-item">
			<label class="layui-form-label">合法名</label>
			<div class="layui-input-block">
				<input type="text" name="applyName" id="applyName" placeholder="请输入"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">供货商</label>
			<div class="layui-input-block">
				<input type="text" name="applyBoss" id="applyBoss" placeholder="请输入"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">地址</label>
			<div class="layui-input-block">
				<input type="text" name="applyAdr" id="applyAdr" placeholder="请输入"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">联系电话</label>
			<div class="layui-input-block">
				<input type="text" name="applyPhone" id="applyPhone" placeholder="请输入"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">邮编</label>
			<div class="layui-input-block">
				<input type="text" name="applyEmail" id="applyEmail" placeholder="请输入"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="sbt">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
		<!-- 更多表单结构排版请移步文档左侧【页面元素-表单】一项阅览 -->
	</form>

	<script>
	layui.use('form', function() {
		var form = layui.form;
		//监听提交
		form.on('submit(sbt)', function(data) {
			//layer.msg(JSON.stringify(data.field));
			$.ajax({  
		          url: 'EepApplyAction/addOrUpdate.action',  
		          type: 'POST',  
		          data: new FormData($("#formSubmit")[0]),  
		          async: false,  
		          cache: false,  
		          contentType: false,  
		          processData: false,  
		          success: function (returndata) {  
		        	  layer.msg('提交成功');  
		        	  var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			          parent.layer.close(index);
			          parent.table.reload('testReload');
		          },
		          error: function (returndata) {  
		        	  layer.msg('提交失败', {icon: 2}); 
		          }  
		     });
			return false;
		});
	});
	
	//初始化加载信息
	$(function(){
		var id = GetQueryString("id");
		var url = "EepApplyAction/showUpdate.action";
		var data = {"applyId":id}
		if(id!=null & id!=""){
			$.post(url, data, function(mes){
				$("#applyId").val(mes.applyId);
				$("#applyNumber").val(mes.applyNumber);
				$("#applyName").val(mes.applyName);
				$("#applyBoss").val(mes.applyBoss);
				$("#applyAdr").val(mes.applyAdr);
				$("#applyPhone").val(mes.applyPhone);
				$("#applyEmail").val(mes.applyEmail);
			});
		}
		
		function GetQueryString(id){
		     var reg = new RegExp("(^|&)"+ id +"=([^&]*)(&|$)");
		     var r = window.location.search.substr(1).match(reg);
		     if(r!=null)return  unescape(r[2]); return null;
		}
	})
	</script>
</body>
</html>